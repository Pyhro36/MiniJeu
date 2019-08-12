package tpCalculator;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Classe de constrcution de la fenetre de la calculatrice avec tous les elements qui la compose et les evenements lies aux boutons
 * 
 * @author Pierre-Louis
 * @version 1.0
 */

public class FrameCalculator extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JButton[] numPad = new JButton[10];
	private JButton plusButton = new JButton("+"), minusButton = new JButton("-"), timesButton = new JButton("*"), divideButton = new JButton("/"),
	        acButton = new JButton("AC"), cButton = new JButton("C"), equalButton = new JButton("="), plusMinusButton = new JButton("+/-"),
	        comaButton = new JButton(".");
	
	private JPanel jPanelResult = new JPanel(), jPanelACCEqual = new JPanel();
	private JPanel[] jPanelNumPad = new JPanel[4];
	private JTextField jResult = new JTextField(20);
	
	/**
	 * Contructeur par defaut de la fenetre : un calculatrice sans nom
	 * 
	 * @throws HeadlessException
	 */
	
	public FrameCalculator() throws HeadlessException {
	
		super();
		
		// definition des proprietes du champ d'affichage
		this.jResult.setEditable(false);
		this.jResult.setHorizontalAlignment(0);
		
		// I. gestion de la grille principale
		for (int i = 0; i < numPad.length; i++)
			numPad[i] = new JButton(String.valueOf(i));
		
		this.jPanelResult.setLayout(new FlowLayout());
		this.jPanelACCEqual.setLayout(new GridLayout(1, 3));
		
		for (int i = 0; i < 4; i++) {
			
			this.jPanelNumPad[i] = new JPanel();
			this.jPanelNumPad[i].setLayout(new GridLayout(1, 4));
		}
		
		this.getContentPane().setLayout(new GridLayout(6, 1));
		this.setSize(new Dimension(400, 300));
		
		// II. création des panels bien configurés pour chacune des rangées du panel principal
		this.jPanelResult.add(this.jResult);
		this.jPanelACCEqual.add(this.acButton);
		this.jPanelACCEqual.add(this.cButton);
		this.jPanelACCEqual.add(this.equalButton);
		this.jPanelNumPad[0].add(this.numPad[7]);
		this.jPanelNumPad[0].add(this.numPad[8]);
		this.jPanelNumPad[0].add(this.numPad[9]);
		this.jPanelNumPad[0].add(this.divideButton);
		this.jPanelNumPad[1].add(this.numPad[4]);
		this.jPanelNumPad[1].add(this.numPad[5]);
		this.jPanelNumPad[1].add(this.numPad[6]);
		this.jPanelNumPad[1].add(this.timesButton);
		this.jPanelNumPad[2].add(this.numPad[1]);
		this.jPanelNumPad[2].add(this.numPad[2]);
		this.jPanelNumPad[2].add(this.numPad[3]);
		this.jPanelNumPad[2].add(this.plusButton);
		this.jPanelNumPad[3].add(this.numPad[0]);
		this.jPanelNumPad[3].add(this.comaButton);
		this.jPanelNumPad[3].add(this.plusMinusButton);
		this.jPanelNumPad[3].add(this.minusButton);
		
		// et rangement dans le panel principal
		this.getContentPane().add(this.jPanelResult);
		this.getContentPane().add(this.jPanelACCEqual);
		for (int i = 0; i < 4; i++)
			this.getContentPane().add(this.jPanelNumPad[i]);
		
		// affichage de la fenetre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		// III. gestion des événements: "addActionListener"
		
		this.acButton.addActionListener(new GestionBouton());
		this.cButton.addActionListener(new GestionBouton());
		this.comaButton.addActionListener(new GestionBouton());
		this.plusButton.addActionListener(new GestionBouton());
		this.divideButton.addActionListener(new GestionBouton());
		this.minusButton.addActionListener(new GestionBouton());
		this.plusMinusButton.addActionListener(new GestionBouton());
		this.equalButton.addActionListener(new GestionBouton());
		this.timesButton.addActionListener(new GestionBouton());
		for (int i = 0; i <= 9; i++)
			this.numPad[i].addActionListener(new GestionBouton());
		
	}
	
	/**
	 * Constructeur parametre de la fenetre de la calculatrice
	 * 
	 * @param nom
	 *            le nom de la fenetre
	 * @throws HeadlessException
	 */
	
	public FrameCalculator(String nom) throws HeadlessException {
	
		super(nom);
		
		this.jResult.setEditable(false);
		this.jResult.setHorizontalAlignment(0);
		
		// I. gestion de la grille principale
		for (int i = 0; i < numPad.length; i++)
			numPad[i] = new JButton(String.valueOf(i));
		
		this.jPanelResult.setLayout(new FlowLayout());
		this.jPanelACCEqual.setLayout(new GridLayout(1, 3));
		
		for (int i = 0; i < 4; i++) {
			
			this.jPanelNumPad[i] = new JPanel();
			this.jPanelNumPad[i].setLayout(new GridLayout(1, 4));
		}
		
		this.getContentPane().setLayout(new GridLayout(6, 1));
		this.setSize(new Dimension(400, 300));
		
		// II. création des panels bien configurés pour chacune des rangées du panel principal
		this.jPanelResult.add(this.jResult);
		this.jPanelACCEqual.add(this.acButton);
		this.jPanelACCEqual.add(this.cButton);
		this.jPanelACCEqual.add(this.equalButton);
		this.jPanelNumPad[0].add(this.numPad[7]);
		this.jPanelNumPad[0].add(this.numPad[8]);
		this.jPanelNumPad[0].add(this.numPad[9]);
		this.jPanelNumPad[0].add(this.divideButton);
		this.jPanelNumPad[1].add(this.numPad[4]);
		this.jPanelNumPad[1].add(this.numPad[5]);
		this.jPanelNumPad[1].add(this.numPad[6]);
		this.jPanelNumPad[1].add(this.timesButton);
		this.jPanelNumPad[2].add(this.numPad[1]);
		this.jPanelNumPad[2].add(this.numPad[2]);
		this.jPanelNumPad[2].add(this.numPad[3]);
		this.jPanelNumPad[2].add(this.plusButton);
		this.jPanelNumPad[3].add(this.numPad[0]);
		this.jPanelNumPad[3].add(this.comaButton);
		this.jPanelNumPad[3].add(this.plusMinusButton);
		this.jPanelNumPad[3].add(this.minusButton);
		
		// et rangement dans le panel principal
		this.getContentPane().add(this.jPanelResult);
		this.getContentPane().add(this.jPanelACCEqual);
		for (int i = 0; i < 4; i++)
			this.getContentPane().add(this.jPanelNumPad[i]);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		// III. gestion des événements: "addActionListener"
		
		this.acButton.addActionListener(new GestionBouton());
		this.cButton.addActionListener(new GestionBouton());
		this.comaButton.addActionListener(new GestionBouton());
		this.plusButton.addActionListener(new GestionBouton());
		this.divideButton.addActionListener(new GestionBouton());
		this.minusButton.addActionListener(new GestionBouton());
		this.plusMinusButton.addActionListener(new GestionBouton());
		this.equalButton.addActionListener(new GestionBouton());
		this.timesButton.addActionListener(new GestionBouton());
		for (int i = 0; i <= 9; i++)
			this.numPad[i].addActionListener(new GestionBouton());
	}
	
	/**
	 * Classe interne d'écoute des evenements de clics sur les boutons
	 * 
	 * @author Pierre-Louis
	 */
	
	public class GestionBouton implements ActionListener {
		
		/**
		 * methode herite de ActionListener.actionPerformed pour la definition des actions a effectuer pour chaque evenement
		 */
		
		public void actionPerformed(ActionEvent e) {
		
			if (e.getSource() == plusButton) {
				// code à réaliser en reaction au clic sur le bouton “+”
				Calcul.opManage(CodeOp.PLUS, jResult);
			}
			else if (e.getSource() == minusButton) {
				// code à réaliser en reaction au clic sur le bouton “-”
				Calcul.opManage(CodeOp.MINUS, jResult);
			}
			else if (e.getSource() == timesButton) {
				// code à réaliser en reaction au clic sur le bouton “X”
				Calcul.opManage(CodeOp.TIMES, jResult);
			}
			else if (e.getSource() == divideButton) {
				// code à réaliser en reaction au clic sur le bouton “/”
				Calcul.opManage(CodeOp.DIVIDE, jResult);
			}
			else if (e.getSource() == equalButton) {
				// code à réaliser en reaction au clic sur le bouton “=”
				Calcul.opManage(CodeOp.EQUAL, jResult);
			}
			else if (e.getSource() == acButton) {
				// code à réaliser en reaction au clic sur le bouton “AC”
				Calcul.reinit(jResult);
			}
			else if (e.getSource() == cButton) {
				// code à réaliser en reaction au clic sur le bouton “AC”
				Calcul.backspace(jResult);
			}
			else if (e.getSource() == plusMinusButton) {
				// code à réaliser en reaction au clic sur le bouton “+/-”
				Calcul.invertSign(jResult);
			}
			else if (e.getSource() == comaButton) {
				// code à réaliser en reaction au clic sur le bouton “.”
				if (!jResult.getText().contains("."))
				    Calcul.numberManage('.', jResult);
			}
			else {
				// code à réaliser en reaction au clic sur un bouton du pavé {0,1,2..9}
				int i = 0;
				while (e.getSource() != numPad[i])
					i++;
				Calcul.numberManage((char) (i + 48), jResult);
			}
		}
	}
	
}
