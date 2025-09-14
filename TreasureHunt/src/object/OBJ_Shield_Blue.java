package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Shield_Blue extends Entity{

	public OBJ_Shield_Blue(GamePanel gp) {
		super(gp);
		type = type_shield;
		name = "shield_blue";
		direction = "down";
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
		defenseValue = 2;
		description = "[Blue Shield]\nA shiny blue shield.\nAbsorbs more damage.";
		price = 20;
		forSale = true;
	}
}
