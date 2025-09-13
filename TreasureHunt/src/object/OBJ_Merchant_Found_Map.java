package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Merchant_Found_Map extends Entity{

	public OBJ_Merchant_Found_Map(GamePanel gp) {
		super(gp);
		type = type_item;
		name = "merchant_found_map";
		direction = "default";
		down1 = setup("/objects/green_exclamation", gp.tileSize, gp.tileSize);
	}

}
