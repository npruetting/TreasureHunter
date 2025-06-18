package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Table extends Entity {

	public OBJ_Table(GamePanel gp) {
		super(gp);
		name = "table";
		collision = true;
		direction = "down";
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
	}
}
