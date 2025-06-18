package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Coin extends Entity{

	public OBJ_Coin(GamePanel gp) {
		super(gp);
		type = type_item;
		name = "coin";
		direction = "default";
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
	}
	
}
