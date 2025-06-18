package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Dungeon_Coin extends Entity{

	public OBJ_Dungeon_Coin(GamePanel gp) {
		super(gp);
		type = type_item;
		name = "dungeon_coin";
		direction = "default";
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
		price = 0;
		forSale = false;
	}
	
}
