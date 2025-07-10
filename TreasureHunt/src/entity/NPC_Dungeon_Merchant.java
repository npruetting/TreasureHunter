package entity;

import java.awt.Rectangle;

import main.GamePanel;
import object.OBJ_Boots;
import object.OBJ_Dungeon_Key;
import object.OBJ_Potion_Red;

public class NPC_Dungeon_Merchant extends Entity{

	/**
	 * Constructs the old man npc.
	 * 
	 * @param gp - the game panel
	 */
	public NPC_Dungeon_Merchant(GamePanel gp) {
		super(gp);

		name = "dungeon_merchant";
		direction = "down";
		this.solidArea = new Rectangle(0, 0, gp.tileSize, gp.tileSize * 2);

		getImage();
		setDialogue();
		setItems();
	}

	/**
	 * Method that assigns each .png file to an image variable, representing the
	 * direction which the player is facing.
	 */
	public void getImage() {
		up1 = setup("/npc/dungeon_merchant_down_1");
		up2 = setup("/npc/dungeon_merchant_down_2");
		down1 = setup("/npc/dungeon_merchant_down_1");
		down2 = setup("/npc/dungeon_merchant_down_2");
		left1 = setup("/npc/dungeon_merchant_down_1");
		left2 = setup("/npc/dungeon_merchant_down_2");
		right1 = setup("/npc/dungeon_merchant_down_1");
		right2 = setup("/npc/dungeon_merchant_down_2");
	}

	/**
	 * Sets the dialogue for the NPC.
	 */
	public void setDialogue() {
		dialogues[0] = "Welcome to the dungeon traveler. . .\nI'm sure you've met my brother. His trades\nare. . okay, but I think mine are even better.\nI would love if you got me some iron scrap. . .";
	}

	/**
	 * Sets the inventory items for the merchant.
	 */
	public void setItems() {
		inventory.add(new OBJ_Potion_Red(gp));
		inventory.add(new OBJ_Boots(gp));
		inventory.add(new OBJ_Dungeon_Key(gp));
		inventory.add(new OBJ_Dungeon_Key(gp));
		inventory.add(new OBJ_Dungeon_Key(gp));
		//inventory.add(new OBJ_Iron_Gate_Key(gp));
	}
	
	/**
	 * Called when the NPC_Merchant is spoken to.
	 */
	public void speak() {
		super.speak();
		gp.tradeState = true;
		gp.ui.npc = this;
	}
}
