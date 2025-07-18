package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Ancient_Scroll extends Entity{

	public OBJ_Ancient_Scroll(GamePanel gp) {
		super(gp);
		type = type_item;
		name = "ancient_scroll";
		direction = "default";
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
		description = "[Ancient Scroll]\n. . .";
		price = -3;
		forSale = false;
	}

}
