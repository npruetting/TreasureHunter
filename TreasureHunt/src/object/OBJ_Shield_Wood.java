package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Shield_Wood extends Entity{

	public OBJ_Shield_Wood(GamePanel gp) {
		super(gp);
		type = type_shield;
		name = "shield_wood";
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
		defenseValue = 1;
		description = "[Wooden Shield]\nA shield made from wood.";
		price = 20;
		forSale = true;
	}
}
