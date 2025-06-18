package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Class that handles if the mouse is pressed.
 */
public class MouseHandler implements MouseListener {

	private GamePanel gp;

	/**
	 * Constructs a mouse handler with access to the game panel.
	 * 
	 * @param gp - the game panel
	 */
	public MouseHandler(GamePanel gp) {
		this.gp = gp;
	}

	/**
	 * Unused.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	/**
	 * Method that handles the mouse being pressed.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		gp.player.attacking = true;
	}

	/**
	 * Unused.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
	}

	/**
	 * Unused.
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	/**
	 * Unused.
	 */
	@Override
	public void mouseExited(MouseEvent e) {
	}

}
