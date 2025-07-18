package entity;

import java.awt.Rectangle;

import main.GamePanel;

public class NPC_Guard extends Entity {

	/**
	 * Constructs the old man npc.
	 * 
	 * @param gp - the game panel
	 */
	public NPC_Guard(GamePanel gp) {
		super(gp);

		name = "guard";
		direction = "left";
		this.solidArea = new Rectangle(0, 0, gp.tileSize - 10, gp.tileSize - 20);
		this.solidAreaDefaultX = 10;
		this.solidAreaDefaultY = 10;

		getImage();
		setDialogue();
	}

	/**
	 * Method that assigns each .png file to an image variable, representing the
	 * direction which the player is facing.
	 */
	public void getImage() {
		up1 = setup("/npc/guard_down_1");
		up2 = setup("/npc/guard_down_2");
		down1 = setup("/npc/guard_down_1");
		down2 = setup("/npc/guard_down_2");
		left1 = setup("/npc/guard_down_1");
		left2 = setup("/npc/guard_down_2");
		right1 = setup("/npc/guard_down_1");
		right2 = setup("/npc/guard_down_2");
	}

	/**
	 * Sets the dialogue for the NPC.
	 */
	public void setDialogue() {
		dialogues[0] = "CANNOT PASS.";
		dialogues[1] = "MY MASTER HAS TOLD TO GUARD THIS PATH.";
		dialogues[2] = "I WILL NOT MOVE UNDER ANY CONDITION. . .";
	}

	/**
	 * Called when the NPC_Merchant is spoken to.
	 */
	public void speak() {
		super.speak();
	}
}
