package object;

import entity.Entity;
import main.GamePanel;

/**
 * Class for the key object.
 */
public class OBJ_Dungeon_Key extends Entity{
	
	/**
	 * Constructs the key object.
	 * 
	 * @param gp - the game panel
	 */
	public OBJ_Dungeon_Key(GamePanel gp) {
		super(gp);
		type = type_item;
		name = "dungeon_key";
		direction = "default";
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
		description = "[Dungeon Key]\nUsed to open the door\nto the dungeon.";
		price = -1;
		forSale = false;
	}
	
	/**
	 * Called when player uses this item.
	 * 
	 * @param itemIndex - index of item being used
	 */
	public void use(int itemIndex) {
		if (gp.ui.messages.contains("Needs dungeon key. . .")) {
			gp.playSE(3);
			gp.obj[gp.player.doorIndex] = null;
			gp.ui.messages.remove("Needs dungeon key. . .");
			gp.dialogueState = true;
			gp.isViewingStatus = false;
			gp.ui.currentDialogue = "Door to the dungeon unlocked!";
			gp.player.inventory.remove(itemIndex);
		}
	}
}
