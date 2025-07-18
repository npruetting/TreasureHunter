package object;

import entity.Entity;
import main.GamePanel;

/**
 * Class for the key object.
 */
public class OBJ_Iron_Gate_Key extends Entity{
	
	/**
	 * Constructs the key object.
	 * 
	 * @param gp - the game panel
	 */
	public OBJ_Iron_Gate_Key(GamePanel gp) {
		super(gp);
		type = type_item;
		name = "iron_gate_key";
		direction = "default";
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
		description = "[Iron Gate Key]\nUsed to open iron gates.";
		price = -2;
		forSale = false;
	}
	
	/**
	 * Called when player uses this item.
	 * 
	 * @param itemIndex - index of item being used
	 */
	public void use(int itemIndex) {
		if (gp.ui.messages.contains("Needs iron gate key. . .")) {
			gp.playSE(26);
			gp.ui.messages.remove("Needs iron gate key. . .");
			gp.ui.messages.add("Iron gate unlocked. . .");
			gp.obj[gp.player.doorIndex].isOpened = true;
			gp.isViewingStatus = false;
			gp.player.inventory.remove(itemIndex);
			
			if (gp.obj[gp.player.doorIndex].identification.equals("up")) {
				gp.player.openingIronGateUp = true;
			} else if (gp.obj[gp.player.doorIndex].identification.equals("left")) {
				gp.player.openingIronGateLeft = true;
			}
		}
	}
}
