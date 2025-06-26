package object;

import entity.Entity;
import main.GamePanel;

/**
 * Class for the boots object.
 */
public class OBJ_Boots extends Entity{

	/**
	 * Constructs the boots object.
	 * 
	 * @param gp - the game panel
	 */
	public OBJ_Boots(GamePanel gp) {
		super(gp);
		type = type_item;
		name = "boots";
		direction = "default";
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
		description = "[Boots]\nGives a temporary\nspeed boost.";
		price = 20;
		forSale = true;
	}
	
	/**
	 * Called when player uses this item.
	 * 
	 * @param itemIndex - index of item being used
	 */
	public void use(int itemIndex) {
		gp.playSE(2);
		gp.dialogueState = true;
		gp.isViewingStatus = false;
		gp.ui.currentDialogue = "Speed boost for 30 seconds!";
		gp.player.speed += 2;
		// Used to track how long player is sped up
		gp.player.isFast = true;
		gp.player.counter = 0;
		gp.player.inventory.remove(itemIndex);
	}
}
