package environment;

import java.awt.Graphics2D;

import main.GamePanel;

public class EnvironmentManager {

	private GamePanel gp;
	private Lighting lighting;
	public boolean bigLanternEquipped;
	
	public EnvironmentManager(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setup(int circleSize) {
		lighting = new Lighting(gp, circleSize);
	}
	
	public void draw(Graphics2D g2) {
		lighting.draw(g2);
	}
}
