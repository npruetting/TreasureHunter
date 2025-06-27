package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Heart extends Entity{

	public OBJ_Heart(GamePanel gp) {
		super(gp);
		type = type_item;
		name = "heart";
		direction = "default";
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
	}
}
