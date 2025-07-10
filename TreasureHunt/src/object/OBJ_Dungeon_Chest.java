package object;

import entity.Entity;
import main.GamePanel;

/**
 * Class for the dungeon chest object.
 */
public class OBJ_Dungeon_Chest extends Entity{

	/**
	 * Constructs the dungeon chest object.
	 * 
	 * @param gp - the game panel
	 */
	public OBJ_Dungeon_Chest(GamePanel gp) {
		super(gp);
		name = "dungeon_chest";
		direction = "default";
		collision = true;
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
		health = 0;
	}
}
