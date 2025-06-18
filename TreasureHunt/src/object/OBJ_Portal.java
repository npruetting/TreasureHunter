package object;

import entity.Entity;
import main.GamePanel;

/**
 * Class for the boots object.
 */
public class OBJ_Portal extends Entity{

	/**
	 * Constructs the portal object.
	 * 
	 * @param gp - the game panel
	 */
	public OBJ_Portal(GamePanel gp) {
		super(gp);
		name = "portal";
		direction = "default";
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
	}
}
