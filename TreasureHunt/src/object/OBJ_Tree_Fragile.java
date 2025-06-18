package object;

import java.awt.Color;

import entity.Entity;
import main.GamePanel;

public class OBJ_Tree_Fragile extends Entity{

	public OBJ_Tree_Fragile(GamePanel gp) {
		super(gp);
		name = "tree_fragile";
		collision = true;
		direction = "down";
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
		health = 2;
	}
	
	public Color getParticleColor() {
		return new Color(65, 50, 30);
	}
	
	public int getParticleSize() {
		return 8;
	}
	
	public int getParticleSpeed() {
		return 1;
	}
	
	public int getParticleMaxHealth() {
		return 20;
	}
}
