package spaceInvader;

import java.awt.*;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * @author Pierre-Louis
 * @version 1.0
 */

public abstract class Objet {
	
	protected int x, y;
	protected int h, l;
	protected float dx, dy;
	protected float vitesse;
	protected Image image;
	protected Rectangle limites, limitesFrame;
	protected String nom_objet;
	protected boolean actif;
	
	/**
	 * 
	 */
	
	public Objet() {
		
		this.actif = true;
		this.x = 0;
		this.y = 0;
		this.h = 0;
		this.l = 0;
		this.dx = 0;
		this.dy = 0;
		this.vitesse = 0;
		this.image = null;
		this.limites = null;
		this.limitesFrame = null;
		this.nom_objet = "";
	}
	
	public Objet(int x, int y, float dx, float dy, float vitesse, String nomImage, Rectangle frame, String nom) {
		
		this.actif = true;
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.vitesse = vitesse;
		
		try {
			
			image = ImageIO.read(new File(nomImage));
			
		} catch (Exception err) {
			
			System.out.println(nomImage + " introuvable !");
			System.out.println("Mettre les images dans le repertoire :" + getClass().getClassLoader().getResource(nomImage));
			System.exit(0);
		}
		// récupère une fois pour toute la hauteur et largeur de l'image
		this.h = image.getHeight(null);
		this.l = image.getWidth(null);
		// définir les limites de l'objet pour les collisions et les sorties
		limites = new Rectangle(x, y, this.l, this.h);
		this.limitesFrame = frame;
		this.nom_objet = nom;
	}
	
	public void draw(long t, Graphics g) {
		
		g.drawImage(image, x, y, null);
	}
	
	public boolean collision(Objet e) {
		
		return limites.intersects(e.limites);
	}
	
	public abstract void move(long t);
}
