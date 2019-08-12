package spaceInvader;

import java.awt.Rectangle;

/**
 * @author PL
 * @version 1.0
 */

public class Alien extends Objet {
	
	final static String type1 = "Alien1a.png";
	final static String type2 = "Alien2a.png";
	final static String type3 = "Alien3a.png";
	int score;
	
	/**
	 * 
	 */
	
	public Alien() {
	
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
	
	public Alien(int x, int y, int score, String nomImage, Rectangle frame) {
	
		super(x, y, +1, 0, 3, nomImage, frame, "Alien");
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see spaceInvader.Objet#move(long)
	 */
	
	@Override
	public void move(long t) {
	
		x = x + (int) (vitesse * dx);
		y = y + (int) (vitesse * dy);
		if (t % 20 == 0) dx = -dx;
		
		if (t % 60 == 0) dy = +1;
		else dy = 0;
		
		limites.setLocation(x, y);
	}
	
}
