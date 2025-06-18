package object;

import entity.Entity;
import main.GamePanel;

/**
 * Class for the dungeon door object.
 */
public class OBJ_Dungeon_Door extends Entity{

	/**
	 * Constructs the dungeon door object.
	 * 
	 * @param gp - the game panel
	 */
	public OBJ_Dungeon_Door(GamePanel gp) {
		super(gp);
		name = "dungeon_door";
		direction = "default";
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
		collision = true;
	}
}
