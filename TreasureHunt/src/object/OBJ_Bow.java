package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Bow extends Entity{

	public OBJ_Bow(GamePanel gp) {
		super(gp);
		type = type_bow;
		name = "bow";
		direction = "default";
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
		description = "[Bow]\nShoots arrows, good\nchoice for fighting\nskeletons.";
		price = 40;
		forSale = true;
	}

}
