package object;

import entity.Entity;
import main.GamePanel;

/**
 * Class for the door object.
 */
public class OBJ_Iron_Gate extends Entity{

	/**
	 * Constructs the door object.
	 * 
	 * @param gp - the game panel
	 */
	public OBJ_Iron_Gate(GamePanel gp) {
		super(gp);
		name = "iron_gate";
		direction = "default";
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
		collision = true;
	}
}
