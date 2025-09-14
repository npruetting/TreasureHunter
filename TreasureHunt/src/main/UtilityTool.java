package main;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Class used to house methods that act as utilities for the game.
 */
public class UtilityTool {
	
	/**
	 * Method that scales the image as the tile is created to improve rendering
	 * performance.
	 * 
	 * @param original - original image
	 * @param width    - width of original image
	 * @param height   - height of original image
	 * @return the scaled image
	 */
	public BufferedImage scaleImage(BufferedImage original, int width, int height) {
		BufferedImage scaledImage = new BufferedImage(width, height, original.getType());
		Graphics2D g2 = scaledImage.createGraphics();
		g2.drawImage(original, 0, 0, width, height, null);
		g2.dispose();

		return scaledImage;
	}
	
	/**
	 * Changes the alpha depending on the given value.
	 * 
	 * @param g2         - graphics
	 * @param alphaValue - value from 0.0f to 1.0f
	 */
	public void changeAlpha(Graphics2D g2, float alphaValue) {
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
	}
}
