package batailleNavale;

import jeu.Plateau;

/**
 * @author PL
 * @version 1.0
 */

public class PlateauBatailleNavale extends Plateau {
	
	private final int TAILLE = 10;
	private Case[][] cases = new Case[TAILLE][TAILLE];
	
	/**
	 * 
	 */
	
	public PlateauBatailleNavale() {
	
		for (int i = 0; i < TAILLE; i++) {
			for (int j = 0; j < TAILLE; j++) {
				
				this.cases[i][j] = new Case();
			}
		}
	}
	
	public Case[][] getCases(){
		
		return cases;
	}
	
	@Override
	public void afficher() {
	
		for (int i = 0; i < TAILLE + 1; i++) System.out.print("----");
		System.out.print("\n ");
		for (int i = 0; i < TAILLE; i++) System.out.print(" | " + (i + 1));
		System.out.println("|");
		for (int i = 0; i < TAILLE + 1; i++) System.out.print("----");
		System.out.print("\n");
		
		for (int i = 0; i < TAILLE; i++) {
			
			System.out.print((char)((int)'A'+i)+ " ");
			for (int j = 0; j < TAILLE; j++)
				System.out.print("| " + this.cases[j][i] + " ");
			System.out.println("|");
			for (int j = 0; j < TAILLE + 1; j++)
				System.out.print("----");
			System.out.print("\n");
		}
	}
}
