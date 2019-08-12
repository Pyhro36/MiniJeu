package batailleNavale;

/**
 * @author PL
 * @version 1.0
 */

public abstract class PlayableBN {
	
	PlateauBatailleNavale plateau;
	Bateau[] listeBateaux;
	PlateauBatailleNavale plateauAdverse;
	
	PlayableBN() {
	
		this.plateau = new PlateauBatailleNavale();
		this.plateauAdverse = new PlateauBatailleNavale();
		this.plateauAdverse.afficher();
		this.plateau.afficher();
	}
	
	public void joue(PlateauBatailleNavale plateauAdverse, int x, int y) {
	
		if (plateauAdverse.getCases()[x][y].typeCase == ' ' || plateauAdverse.getCases()[x][y].typeCase == 'O') {
			
			plateauAdverse.getCases()[x][y].typeCase = 'O';
			this.plateauAdverse.getCases()[x][y].typeCase = 'O';
			
		} else {
			
			plateauAdverse.getCases()[x][y].typeCase = 'X';
			this.plateauAdverse.getCases()[x][y].typeCase = 'X';
		}
		
		this.plateauAdverse.afficher();
	}
}
