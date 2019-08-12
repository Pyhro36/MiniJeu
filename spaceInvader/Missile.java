package spaceInvader;

import java.awt.Rectangle;

/**
 * @author PL
 * @version 1.0
 */

public class Missile extends Objet {
	
	final static String nomImage = "Missile.png";
	
	/**
	 * 
	 */
	
	public Missile() {
	
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
	
	public Missile(int x, int y, Rectangle frame) {
	
		super(x, y, 0, -1, 10, nomImage, frame, "Missile");
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see spaceInvader.Objet#move(long)
	 */
	
	@Override
	public void move(long t) {
	
		y = y + (int) (vitesse * dy);
		
		if (y + h < this.limitesFrame.y) actif = false;
	}
}
