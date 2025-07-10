package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Iron_Scrap extends Entity{

	public OBJ_Iron_Scrap(GamePanel gp) {
		super(gp);
		type = type_item;
		name = "iron_scrap";
		direction = "default";
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
	}
}
