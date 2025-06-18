package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Axe extends Entity{

	public OBJ_Axe(GamePanel gp) {
		super(gp);
		type = type_axe;
		name = "axe";
		direction = "down";
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
		attackArea.width = 36;
		attackArea.height = 36;
		attackValue = 2;
		description = "[Woodcutter's Axe]\nUseful for cutting\ntrees.";
		price = 50;
		forSale = true;
	}
}
