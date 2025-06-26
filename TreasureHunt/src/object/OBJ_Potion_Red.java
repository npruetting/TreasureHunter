package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Potion_Red extends Entity {

	public OBJ_Potion_Red(GamePanel gp) {
		super(gp);
		type = type_item;
		name = "potion_red";
		direction = "down";
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
		description = "[Red Potion]\nGives player 5 hearts.";
		price = 20;
		forSale = true;
	}

	/**
	 * Called when player uses this item.
	 * 
	 * @param itemIndex - index of item being used
	 */
	public void use(int itemIndex) {
		gp.dialogueState = true;
		gp.isViewingStatus = false;
		gp.ui.currentDialogue = "You drink the Red Potion!\nYou have been healed 5 hearts.";
		gp.player.health += 10;
		if (gp.player.health > gp.player.maxHealth) {
			gp.player.health = gp.player.maxHealth;
		}
		gp.playSE(2);
		gp.player.inventory.remove(itemIndex);
	}
}
