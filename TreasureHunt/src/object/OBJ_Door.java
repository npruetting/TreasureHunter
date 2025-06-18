package object;

import entity.Entity;
import main.GamePanel;

/**
 * Class for the door object.
 */
public class OBJ_Door extends Entity{

	/**
	 * Constructs the door object.
	 * 
	 * @param gp - the game panel
	 */
	public OBJ_Door(GamePanel gp) {
		super(gp);
		name = "door";
		direction = "default";
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
		collision = true;
	}
}
