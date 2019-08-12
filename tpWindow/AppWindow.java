package tpWindow;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * @author Pierre-Louis
 * @version 1.0
 */

public class AppWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel affichage;
	private JTextField champA, champB;
	private JButton boutonPlus;
	private JButton boutonQuitter;

	/**
	 * @throws HeadlessException
	 */

	public AppWindow() throws HeadlessException {

	}

	/**
	 * @param arg0
	 */

	public AppWindow(GraphicsConfiguration arg0) {

		super(arg0);
	}

	/**
	 * @param arg0
	 * @throws HeadlessException
	 */

	public AppWindow(String name) throws HeadlessException {

		super(name);
		this.affichage = new JLabel("ici s’affichera le resultat");
		this.champA = new JTextField(20);
		this.champB = new JTextField(20);
		this.boutonPlus = new JButton("+");
		this.boutonQuitter = new JButton("Quitter");

		JPanel cadre = new JPanel();
		cadre.setLayout(new FlowLayout());
		cadre.add(this.champA);
		cadre.add(this.champB);
		cadre.add(this.affichage);
		cadre.add(this.boutonPlus);
		cadre.add(this.boutonQuitter);
		this.setContentPane(cadre);

		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		this.boutonQuitter.addActionListener(new GestionQuitter());
		this.boutonPlus.addActionListener(new GestionPlus());

	}

	/**
	 * @param arg0
	 * @param arg1
	 */

	public AppWindow(String arg0, GraphicsConfiguration arg1) {

		super(arg0, arg1);
	}

	public class GestionQuitter implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			System.exit(0);
		}
	}

	public void afficher(String texte) {

		this.affichage.setText(texte);
	}

	public class GestionPlus implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			afficher(champA.getText() + champB.getText());
		}
	}

}
