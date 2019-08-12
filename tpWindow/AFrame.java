package tpWindow;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

/**
 * @author Pierre-Louis
 * @version 1.0
 */

public class AFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * @throws HeadlessException
	 */
	public AFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public AFrame(GraphicsConfiguration arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @throws HeadlessException
	 */
	public AFrame(String nom) throws HeadlessException {
		super(nom);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public AFrame(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
	}

}
