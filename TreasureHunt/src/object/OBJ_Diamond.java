package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Diamond extends Entity{

	public OBJ_Diamond(GamePanel gp) {
		super(gp);
		type = type_item;
		name = "diamond";
		direction = "down";
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
		description = "[Diamond]\nBring 3 of these to the\ndungeon merchant. . .";
		forSale = false;
	}
}
