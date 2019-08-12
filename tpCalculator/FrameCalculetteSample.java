package tpCalculator;

import java.awt.Dimension;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameCalculetteSample extends JFrame {

private static final long serialVersionUID = 1L;

	// grille principale
    private GridLayout gridLayoutPrincipal;

// grille de placement de la zone de texte de r�sultat
    private FlowLayout flowLayoutResultat;
    private JPanel jPanelResultat;
	
// grille de placement de la 1ere rang�e de boutons AC, C et =    
    private GridLayout gridLayoutAc_C_Egal;
    private JPanel jPanelAC_C_Egal;

// grille de placement de la seconde rang�e de boutons 7,8,9,/    
    private GridLayout gridLayout7_8_9;
    private JPanel jPanel7_8_9;

// grille de placement de la 3�me rang�e de boutons 4,5,6,*    
    private GridLayout gridLayout4_5_6;
    private JPanel jPanel4_5_6;
	
// grille de placement de la 4�me rang�e de boutons 1,2,3,+    
    private GridLayout gridLayout1_2_3;
    private JPanel jPanel1_2_3;
	
// grille de placement de la 5�me rang�e de boutons 0,.,+/-,-
    private GridLayout gridLayout0_signe;
    private JPanel jPanel0_signe;
	    
    public FrameCalculetteSample() {

    // I. gestion de la grille principale
	gridLayoutPrincipal = new GridLayout(6,1);
	this.getContentPane().setLayout(gridLayoutPrincipal);
	this.setSize( new Dimension(400, 300) );
	this.setTitle( "Calculette  rapide" );               
	
	
    // II. cr�ation des panels bien configur�s pour chacune des rang�es du panel principale
    // et rangement dans le panel principal

    // III. gestion des �v�nements: "addActionListener"

    }
    //classe interne d'�coute
    public class GestionBouton implements ActionListener { 
	public void actionPerformed(ActionEvent e) { 
	    // test des valeur de e.getSource()
    }
 }
}