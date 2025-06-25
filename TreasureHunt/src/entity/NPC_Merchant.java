package entity;

import java.awt.Rectangle;

import main.GamePanel;
import object.OBJ_Arrow;
import object.OBJ_Axe;
import object.OBJ_Bow;
import object.OBJ_Dungeon_Key;
import object.OBJ_Key;
import object.OBJ_Lantern_Big;
import object.OBJ_Potion_Red;
import object.OBJ_Shield_Blue;

public class NPC_Merchant extends Entity{

	/**
	 * Constructs the old man npc.
	 * 
	 * @param gp - the game panel
	 */
	public NPC_Merchant(GamePanel gp) {
		super(gp);

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
		up1 = setup("/npc/merchant_down_1");
		up2 = setup("/npc/merchant_down_2");
		down1 = setup("/npc/merchant_down_1");
		down2 = setup("/npc/merchant_down_2");
		left1 = setup("/npc/merchant_down_1");
		left2 = setup("/npc/merchant_down_2");
		right1 = setup("/npc/merchant_down_1");
		right2 = setup("/npc/merchant_down_2");
	}

	/**
	 * Sets the dialogue for the NPC.
	 */
	public void setDialogue() {
		dialogues[0] = "Welcome to my shop new traveler. . .\nI can give you all the materials you will ever\nneed, and I won't bite. . .";
	}

	/**
	 * Sets the inventory items for the merchant.
	 */
	public void setItems() {
		inventory.add(new OBJ_Potion_Red(gp));
		inventory.add(new OBJ_Key(gp));
		inventory.add(new OBJ_Axe(gp));
		inventory.add(new OBJ_Shield_Blue(gp));
		inventory.add(new OBJ_Dungeon_Key(gp));
		inventory.add(new OBJ_Lantern_Big(gp));
		inventory.add(new OBJ_Bow(gp));
		inventory.add(new OBJ_Arrow(gp));
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
