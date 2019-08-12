package batailleNavale;

/**
 * @author PL
 * @version 1.0
 */

public abstract class Bateau {
	
	protected static int count;
	protected Case[] elementBateau;
	protected String nom;
	
	public Bateau(int nbreCasesBateau, char typeBateau, String nom) {
	
		count++;
		this.nom = nom + " " + count;
		elementBateau = new Case[nbreCasesBateau];
		
		for (int i = 0; i < nbreCasesBateau; i++) {
			
			this.elementBateau[i] = new Case(typeBateau);
		}
	}
	
	public void placeSurPlateau(int x, int y, boolean estVertical, PlateauBatailleNavale plateau) {
	
		boolean placeValide = true;
		int i = 0;
		
		if (estVertical) {
			
			while (placeValide && i < this.elementBateau.length) {
				
				placeValide = (plateau.getCases()[x][y + i].typeCase == ' ' || plateau.getCases()[x][y + i].typeCase == 'O');
				i++;
			}
			
			if (placeValide) for (i = 0; i < this.elementBateau.length; i++) {
				
				plateau.getCases()[x][y + i] = this.elementBateau[i];
			}
			
			else System.out.println("Place déjà prise, impossible de placer le bateau ici");
			
		} else {
			
			while (placeValide && i < this.elementBateau.length) {
				
				placeValide = (plateau.getCases()[x + i][y].typeCase == ' ' || plateau.getCases()[x + i][y].typeCase == 'O');
				i++;
			}
			
			if (placeValide) for (i = 0; i < this.elementBateau.length; i++) {
				
				plateau.getCases()[x + i][y] = this.elementBateau[i];
			}
			
			else System.out.println("Place déjà prise, impossible de placer le bateau ici");
		}
		
	}
	
	/**
	 * 
	 */
	
	public boolean estCoule() {
	
		for (int i = 0; i < elementBateau.length; i++) {
			
			if (elementBateau[i].typeCase != 'X') return false;
		}
		
		return true;
	}
	
	public String toString() {
	
		return this.nom;
	}
	
}
