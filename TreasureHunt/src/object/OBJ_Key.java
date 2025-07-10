 package object;

import entity.Entity;
import main.GamePanel;

/**
 * Class for the key object.
 */
public class OBJ_Key extends Entity{
	
	/**
	 * Constructs the key object.
	 * 
	 * @param gp - the game panel
	 */
	public OBJ_Key(GamePanel gp) {
		super(gp);
		type = type_item;
		name = "key";
		direction = "default";
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
		description = "[Key]\nUsed to open doors.";
		price = 10;
		forSale = true;
	}
	
	/**
	 * Called when player uses this item.
	 * 
	 * @param itemIndex - index of item being used
	 */
	public void use(int itemIndex) {
		if (gp.ui.messages.contains("Need a key. . .")) {
			gp.playSE(3);
			gp.obj[gp.player.doorIndex] = null;
			gp.ui.messages.remove("Need a key. . .");
			gp.dialogueState = true;
			gp.isViewingStatus = false;
			gp.ui.currentDialogue = "Door unlocked!";
			gp.player.inventory.remove(itemIndex);
		}
	}
}
