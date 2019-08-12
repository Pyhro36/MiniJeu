package batailleNavale;

import jeu.Get;

/**
 * @author PL
 * @version 1.0
 */

public class JoueurBN extends PlayableBN {
	
	/**
	 * 
	 */
	
	public JoueurBN() {
		super();
		
		this.listeBateaux = new Bateau[4];
		System.out.println("choisissez les coordonnées de vos bateaux");
		System.out.println();
	}
	
	public void joue(){
		
		System.out.println("");
	}
	
}
