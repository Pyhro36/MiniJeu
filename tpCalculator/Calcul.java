package tpCalculator;

/**
 * Classe contenant les methodes de calcul à effectuer et l'affichage pour chaque bouton de la calculette, ainsi que les donnees de calcul a
 * enregistrer
 * 
 * @author Pierre-Louis
 * @version 1.0
 */

import javax.swing.JTextField;

public class Calcul {
	
	private static String chain = new String("");
	private static double currentValue = 0.0;
	private static double value1 = 0.0;
	private static CodeOp operand = CodeOp.EQUAL;
	
	/**
	 * Methode de gestion de l'ajout de nombre appelee par le clic sur les boutons du pave numerique
	 * 
	 * @param number
	 *            le numero du bouton appuye
	 * @param jResult
	 *            le champ d'affichage de la calculatrice
	 */
	
	public static void numberManage(char number, JTextField jResult) {
	
		chain += number;
		jResult.setText(chain);
		currentValue = Double.parseDouble(chain);
		
	}
	
	/**
	 * methode de gestion des operations appelee par le clic sur un operateur (+,-,/,*,=)
	 * 
	 * @param codeOp
	 *            le code de l'operateur
	 * @param jResult
	 *            le champ d'affichage de la calculatrice
	 */
	
	public static void opManage(CodeOp codeOp, JTextField jResult) {
	
		if (codeOp != operand) // permet de prendre un appui mutliple sur un operateur comme une seule information
		    switch (operand) { // realisation du calcul precedemment enregistre suite au clic sur un nouvel operateur
		    
				case PLUS :
					currentValue = currentValue + value1;
					
					break;
				case MINUS :
					currentValue = value1 - currentValue;
					
					break;
				case TIMES :
					currentValue = currentValue * value1;
					
					break;
				case DIVIDE :
					currentValue = value1 / currentValue;
					
					break;
				default :
					break;
			}
		
		// mise a jour des donnees de calcul : prochain operateur, valeur en memoire, caleur courante, affichage
		
		operand = codeOp;
		value1 = currentValue;
		chain = "";
		jResult.setText(String.valueOf(value1));
	}
	
	/**
	 * Methode de reinitialisation des donnees de la calculatrice appelee par le clic sur AC
	 * 
	 * @param jResult
	 *            le champ d'afichage de la calculatrice
	 */
	
	public static void reinit(JTextField jResult) {
	
		value1 = 0.0;
		currentValue = 0.0;
		chain = "";
		jResult.setText("");
		operand = CodeOp.EQUAL;
		
	}
	
	/**
	 * methode de suppression du dernier chiffre ajoute, appelee par le clic sur C
	 * 
	 * @param jResult
	 *            le champ d'affichage de la calculatrice
	 */
	
	public static void backspace(JTextField jResult) {
	
		chain = chain.substring(0, chain.length() - 1);
		currentValue = Double.parseDouble(chain);
		jResult.setText(chain);
		
	}
	
	/**
	 * Methode d'inversion du signe de la valeur courante affichee, appelee par le clic sur +/-
	 * 
	 * @param jResult
	 *            le champ d'affichage de la calculatrice
	 */
	
	public static void invertSign(JTextField jResult) {
	
		currentValue = -currentValue;
		chain = String.valueOf(currentValue);
		jResult.setText(chain);
	}
	
}
