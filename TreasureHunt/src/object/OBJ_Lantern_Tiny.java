package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Lantern_Tiny extends Entity{

	public OBJ_Lantern_Tiny(GamePanel gp) {
		super(gp);
		type = type_item;
		name = "lantern_tiny";
		direction = "default";
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
		description = "[Tiny Lantern]\nA gift from the old man,\nnecessary for the dark.";
		price = 0;
		forSale = false;
	}

}
