package environment;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Lighting {

	public BufferedImage darknessFilter;

	public Lighting(GamePanel gp, int circleSize) {
		// Create a buffered image
		darknessFilter = new BufferedImage(gp.screenWidth, gp.screenHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D) darknessFilter.getGraphics();

		// Get the center x and y of the light circle
		int centerX = gp.player.screenX + (gp.tileSize) / 2;
		int centerY = gp.player.screenY + (gp.tileSize) / 2;

		// Create a gradation effect
		Color color[] = new Color[12];
		float fraction[] = new float[12];

		color[0] = new Color(0, 0, 0.01f, 0.3f);
		color[1] = new Color(0, 0, 0.01f, 0.45f);
		color[2] = new Color(0, 0, 0.01f, 0.55f);
		color[3] = new Color(0, 0, 0.01f, 0.63f);
		color[4] = new Color(0, 0, 0.01f, 0.7f);
		color[5] = new Color(0, 0, 0.01f, 0.76f);
		color[6] = new Color(0, 0, 0.01f, 0.82f);
		color[7] = new Color(0, 0, 0.01f, 0.87f);
		color[8] = new Color(0, 0, 0.02f, 0.91f);
		color[9] = new Color(0, 0, 0.03f, 0.94f);
		color[10] = new Color(0, 0, 0.04f, 0.96f);
		color[11] = new Color(0, 0, 0, 1f);

		fraction[0] = 0.2f;
		fraction[1] = 0.4f;
		fraction[2] = 0.5f;
		fraction[3] = 0.6f;
		fraction[4] = 0.65f;
		fraction[5] = 0.7f;
		fraction[6] = 0.75f;
		fraction[7] = 0.8f;
		fraction[8] = 0.85f;
		fraction[9] = 0.9f;
		fraction[10] = 0.95f;
		fraction[11] = 1f;

		// Create a gradation paint settings
		RadialGradientPaint gPaint = new RadialGradientPaint(centerX, centerY, (circleSize / 2), fraction, color);

		// Set the gradient data on g2
		g2.setPaint(gPaint);

		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

		g2.dispose();
	}

	public void draw(Graphics2D g2) {
		g2.drawImage(darknessFilter, 0, 0, null);
	}

}
