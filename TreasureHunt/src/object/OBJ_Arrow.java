package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Arrow extends Entity{

	public OBJ_Arrow(GamePanel gp) {
		super(gp);
		type = type_item;
		name = "arrow";
		direction = "default";
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
		description = "[Arrows]\nBought in packs\nof 15. Necessary\nfor using the bow.";
		price = 5;
	}
}
