package spaceInvader;

import java.awt.Rectangle;

/**
 * @author Pierre-Louis
 * @version 1.0
 */

public class Navire extends Objet {
	
	private static String nomImage = "Navire.png";
	
	/**
	 * 
	 */
	
	public Navire() {
	
		super();
	}
	
	/**
	 * @param x
	 * @param y
	 * @param dx
	 * @param dy
	 * @param vitesse
	 * @param NomImage
	 * @param frame
	 * @param nom
	 */
	
	public Navire(Rectangle frame, String nom) {
	
		super((frame.width / 2) - 13, frame.height - 80, 0, 0, 10, nomImage, frame, nom);
	}
	
	/*
	 * (non-Javadoc)
	 * @see spaceInvader.Objet#move(long)
	 */
	
	@Override
	public void move(long t) {
	
		this.x = this.x + (int) (this.vitesse * this.dx);
		this.y = this.y + (int) (this.vitesse * this.dy);
		
		if (this.x < this.limitesFrame.x) this.x = this.limitesFrame.x;
		else if (this.x + l > this.limitesFrame.x + this.limitesFrame.width)
		    this.x = this.limitesFrame.x + this.limitesFrame.width - 1;
		
		if (this.y < this.limitesFrame.y) this.y = this.limitesFrame.y;
		else if (this.y + this.h > this.limitesFrame.y + this.limitesFrame.height)
		    this.y = this.limitesFrame.y + this.limitesFrame.height - this.h;
		
		limites.setLocation(x, y);
	}
	
}
