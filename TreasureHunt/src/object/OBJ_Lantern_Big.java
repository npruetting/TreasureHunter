package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Lantern_Big extends Entity{

	public OBJ_Lantern_Big(GamePanel gp) {
		super(gp);
		type = type_item;
		name = "lantern_big";
		direction = "default";
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
		description = "[Big Lantern]\nHelps you see better\nin the dark.";
		price = 40;
		forSale = false;
	}

}
