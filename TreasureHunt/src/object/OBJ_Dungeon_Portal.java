package object;

import entity.Entity;
import main.GamePanel;

/**
 * Class for the boots object.
 */
public class OBJ_Dungeon_Portal extends Entity{

	/**
	 * Constructs the portal object.
	 * 
	 * @param gp - the game panel
	 */
	public OBJ_Dungeon_Portal(GamePanel gp) {
		super(gp);
		name = "dungeon_portal";
		direction = "default";
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
	}
}
