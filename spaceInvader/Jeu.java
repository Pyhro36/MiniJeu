package spaceInvader;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import java.io.File;

import java.util.LinkedList;

import javax.swing.Timer;
import javax.swing.JFrame;

public class Jeu extends JFrame {
	
	private static final long serialVersionUID = 1L;
	Timer timer;
	long temps;
	BufferedImage arrierePlan;
	Graphics buffer;
	boolean tHaut;
	boolean tBas;
	boolean tGauche;
	boolean tDroite;
	boolean tEspace;
	boolean TEnter;
	boolean TEscape;
	Rectangle ecran;
	Navire vaisseau;
	int score;
	boolean finjeu;
	int nombreAliensVivants;
	int nombreViesRestantes;
	// Liste de tous les objets du jeu (missiles, bombes, aliens)
	LinkedList<Objet> objets;
	LinkedList<Alien> aliens;
	
	public Jeu() {
		setSize(700, 480);
		setResizable(false);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		temps = 0;
		tHaut = false;
		tBas = false;
		tGauche = false;
		tDroite = false;
		ecran = new Rectangle(getInsets().left, getInsets().top, getSize().width - getInsets().right - getInsets().left, getSize().height -
		        getInsets().bottom - getInsets().top);
		arrierePlan = new BufferedImage(getSize().width, getSize().height,
		        BufferedImage.TYPE_INT_RGB);
		this.addKeyListener(new Jeu_this_keyAdapter());
		buffer = arrierePlan.getGraphics();
		nombreAliensVivants = 5 * 12;
		nombreViesRestantes = 3;
		score = 0;
		finjeu = false;
		
		objets = new LinkedList<Objet>();
		
		vaisseau = new Navire(ecran, "SERENITY");
		objets.add(vaisseau);
		
		// Création des Aliens avec des scores différents suivant le type d'alien
		int sc = 0;
		String nomImage = "";
		for (int y = 0; y < 5; y++) {
			switch (y) {
				case 0 :
					nomImage = Alien.type3;
					sc = 40;
					break;
				case 1 :
				case 2 :
					nomImage = Alien.type2;
					sc = 20;
					break;
				case 3 :
				case 4 :
					nomImage = Alien.type1;
					sc = 10;
					break;
			}
			for (int x = 0; x < 12; x++) {
				Objet alien = new Alien(100 + x * 50, 50 + y * 30, sc, nomImage, ecran);
				objets.add(alien);
			}
		}
		
		timer = new Timer(100, new TimerAction());
		timer.setDelay(40);
		timer.start();
	}
	
	public void paint(Graphics g) {
		// remplir le buffer de noir
		buffer.setColor(Color.black);
		buffer.fillRect(ecran.x, ecran.y, ecran.x + ecran.width, ecran.y + ecran.height);
		// dessine TOUS les objets dans le buffer
		for (int k = 0; k < objets.size(); k++) {
			Objet O = (Objet) objets.get(k);
			O.draw(temps, buffer);
		}
		buffer.setColor(Color.white);
		buffer.drawString("Nbr de vies : " + nombreViesRestantes, ecran.width / 2, ecran.height - 20);
		buffer.drawString("Points de swag : " + this.temps, 50, ecran.height - 20);
		// on dessine l'image associée au buffer dans le JFrame
		g.drawImage(arrierePlan, 0, 0, this);
	}
	
	private class TimerAction implements ActionListener {
		
		// ActionListener appelee toutes les 100 millisecondes
		public void actionPerformed(ActionEvent e) {
			boucle_principale_jeu();
			temps++;
		}
	}
	
	public void boucle_principale_jeu() {
		if (tGauche) {
			vaisseau.dx = -1;
			vaisseau.dy = 0;
		}
		else if (tDroite) {
			vaisseau.dx = +1;
			vaisseau.dy = 0;
		}
		else if (tHaut) {
			vaisseau.dx = 0;
			vaisseau.dy = -1;
		}
		else if (tBas) {
			vaisseau.dx = 0;
			vaisseau.dy = +1;
		}
		else {
			vaisseau.dx = 0;
			vaisseau.dy = 0;
		}
		if (tEspace) {
			Missile m = new Missile(vaisseau.x + vaisseau.l / 2, vaisseau.y, ecran);
			objets.add(m);
		}
		// déplace tous les objets par Polymorphisme
		for (int k = 0; k < objets.size(); k++) {
			Objet O = (Objet) objets.get(k);
			O.move(temps);
		}
		
		int t = (int) (0);
		if (t <= 2) t = 2;
		// on va simplifier le jeu en lançant un missile au hasard du haut du frame
		if (temps % (t) == 0) {
			Bombe b = new Bombe((int) (Math.random() * ecran.width), 0, ecran);
			objets.add(b);
		}
		
		for (int k1 = 0; k1 < objets.size(); k1++) {
			Objet O1 = (Objet) objets.get(k1);
			if ((O1.actif) && (O1.nom_objet == "Missile"))
			    for (int k2 = 0; k2 < objets.size(); k2++) {
				    Objet O2 = (Objet) objets.get(k2);
				    if ((O2.actif) && (O2.nom_objet == "Alien"))
				        if (O1.collision(O2)) {
					        if (nombreAliensVivants > 0) nombreAliensVivants--;
					        else finjeu = true;
					        // mis a jour du score
					    score += ((Alien) O2).score;
					    // on supprimera plus tard ces objets
					    O1.actif = false;
					    O2.actif = false;
				    }
			    }
		}
		
		// accélère le jeu toutes les 10 secondes
		if (temps % 100 == 0) timer.setDelay((int) (timer.getDelay() * 0.9));
		
		// vérifions le collision entre une bombe alien active et le navire
		for (int k = 0; k < objets.size(); k++) {
			Objet O = (Objet) objets.get(k);
			if (O.nom_objet == "Bombe")
			    if ((O.actif) && (vaisseau.collision(O))) {
				    O.actif = false;
				    // rendre la bombe inactive
				if (nombreViesRestantes > 0) nombreViesRestantes--;
				else finjeu = true;
			}
		}
		
		// vérifie qu'un alien actif ne touche pas le vaisseau
		for (int k1 = 0; k1 < objets.size(); k1++) {
			Objet O1 = (Objet) objets.get(k1);
			if ((O1.actif) && (O1.nom_objet == "Alien"))
			    if (O1.collision(vaisseau)) finjeu = true;
		}
		
		if (finjeu) {
			timer.stop();
			// effectuer le message que vous voulez
			// si (nombreAliensVivants==0) alors le joueur a gagné sinon il a perdu
			repaint();
			// forcer le rafraîchissement de l'écran
		}
		
		// balaye la liste et supprime tous les objets inactifs
		// c'est le "gabrbage collector" du jeu
		for (int k = 0; k < objets.size(); k++) {
			Objet O = (Objet) objets.get(k);
			if (O.actif == false) {
				objets.remove(k);
				k--; // parceque la liste s'est déplacée pour boucher le trou
			}
		}
		
		// force le rafraîchissement de l'image et le dessin de l'objet
		repaint();
	}
	
	public static void main(String[] args) {
		Jeu monjeu = new Jeu();
	}
	
	private class Jeu_this_keyAdapter extends KeyAdapter {
		
		public void keyPressed(KeyEvent e) {
			int code = e.getKeyCode();
			setTitle("Code clavier : " + Integer.toString(code));
			switch (code) {
			
				case KeyEvent.VK_SPACE :
					tEspace = true;
					break;
				
				case KeyEvent.VK_LEFT :
					tGauche = true;
					break;
				
				case KeyEvent.VK_RIGHT :
					tDroite = true;
					break;
				
				case KeyEvent.VK_UP :
					tHaut = true;
					break;
				
				case KeyEvent.VK_DOWN :
					tBas = true;
					break;
				
				case KeyEvent.VK_ENTER :
					if (timer.isRunning()) timer.stop();
					else timer.start();
					break;
				
				case KeyEvent.VK_ESCAPE :
					System.exit(0);
					break;
				
				default :
					break;
			}
		}
		
		public void keyReleased(KeyEvent e) {
			int code = e.getKeyCode();
			switch (code) {
			
				case KeyEvent.VK_SPACE :
					tEspace = false;
					break;
				
				case KeyEvent.VK_LEFT :
					tGauche = false;
					break;
				
				case KeyEvent.VK_RIGHT :
					tDroite = false;
					break;
				
				case KeyEvent.VK_UP :
					tHaut = false;
					break;
				
				case KeyEvent.VK_DOWN :
					tBas = false;
					break;
				
				default :
					break;
			}
		}
	}
}
