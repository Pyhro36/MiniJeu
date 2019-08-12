package spaceInvader;

import java.awt.Rectangle;

/**
 * @author PL
 * @version 1.0
 */

public class Bombe extends Objet {
	
	static String nomImage = "Bombe.png";
	
	/**
	 * 
	 */
	
	public Bombe() {
		
		super();
	}
	
	/**
	 * @param x
	 * @param y
	 * @param dx
	 * @param dy
	 * @param vitesse
	 * @param nomImage
	 * @param frame
	 * @param nom
	 */
	
	public Bombe(int x, int y, Rectangle frame) {
	
		super(x, y, 0, 1, 10, nomImage, frame, "BOMBE");
	}
	
	/* (non-Javadoc)
	 * @see spaceInvader.Objet#move(long)
	 */
	
	@Override
	public void move(long t) {
		
		x = x + (int) (vitesse*dx) ;
		y = y + (int) (vitesse*dy) ;
		limites.setLocation(x,y);
	}
	
}
