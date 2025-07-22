package entity;

import java.awt.Rectangle;

import main.GamePanel;

public class NPC_Guard_Master extends Entity {
	
	/**
	 * Constructs the old man npc.
	 * 
	 * @param gp - the game panel
	 */
	public NPC_Guard_Master(GamePanel gp) {
		super(gp);

		name = "guard_master";
		direction = "left";
		this.solidArea = new Rectangle(0, 0, gp.tileSize * 2, gp.tileSize * 2);

		getImage();
		setDialogue();
	}

	/**
	 * Method that assigns each .png file to an image variable, representing the
	 * direction which the player is facing.
	 */
	public void getImage() {
		up1 = setup("/npc/guard_master_down_1", gp.tileSize * 2, gp.tileSize * 2);
		up2 = setup("/npc/guard_master_down_2", gp.tileSize * 2, gp.tileSize * 2);
		down1 = setup("/npc/guard_master_down_1", gp.tileSize * 2, gp.tileSize * 2);
		down2 = setup("/npc/guard_master_down_2", gp.tileSize * 2, gp.tileSize * 2);
		left1 = setup("/npc/guard_master_down_1", gp.tileSize * 2, gp.tileSize * 2);
		left2 = setup("/npc/guard_master_down_2", gp.tileSize * 2, gp.tileSize * 2);
		right1 = setup("/npc/guard_master_down_1", gp.tileSize * 2, gp.tileSize * 2);
		right2 = setup("/npc/guard_master_down_2", gp.tileSize * 2, gp.tileSize * 2);
	}

	/**
	 * Sets the dialogue for the NPC.
	 */
	public void setDialogue() {
		dialogues[0] = "Text 1";
		dialogues[1] = "Text 2";
		dialogues[2] = "Text 3";
	}

	/**
	 * Called when the NPC_Merchant is spoken to.
	 */
	public void speak() {
		super.speak();
	}
}
