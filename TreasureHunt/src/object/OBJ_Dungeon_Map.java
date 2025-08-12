package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Dungeon_Map extends Entity{

	public OBJ_Dungeon_Map(GamePanel gp) {
		super(gp);
		type = type_item;
		name = "dungeon_map";
		direction = "default";
		down1 = setup("/objects/ancient_scroll", gp.tileSize, gp.tileSize);
	}
}
