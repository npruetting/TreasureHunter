package object;

import java.awt.Rectangle;

import entity.Entity;
import main.GamePanel;

/**
 * Class for the chest object.
 */
public class OBJ_Chest_Final extends Entity{

	/**
	 * Constructs the chest object.
	 * 
	 * @param gp - the game panel
	 */
	public OBJ_Chest_Final(GamePanel gp) {
		super(gp);
		name = "chest_final";
		direction = "default";
		collision = true;
		down1 = setup("/objects/chest_final_closed", gp.tileSize * 2, gp.tileSize * 2);
		health = 0;
		this.solidArea = new Rectangle(0, 0, gp.tileSize * 2, gp.tileSize * 2);
	}
}
