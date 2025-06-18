package object;

import entity.Entity;
import main.GamePanel;

/**
 * Class for the chest object.
 */
public class OBJ_Chest extends Entity{

	/**
	 * Constructs the chest object.
	 * 
	 * @param gp - the game panel
	 */
	public OBJ_Chest(GamePanel gp) {
		super(gp);
		name = "chest";
		direction = "default";
		collision = true;
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
		health = 0;
	}
}
