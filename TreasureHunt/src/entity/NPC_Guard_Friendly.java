package entity;

import main.GamePanel;

public class NPC_Guard_Friendly extends Entity {
	
	/**
	 * Constructs the old man npc.
	 * 
	 * @param gp - the game panel
	 */
	public NPC_Guard_Friendly(GamePanel gp) {
		super(gp);

		name = "guard_friendly";
		direction = "left";

		getImage();
		setDialogue();
	}

	/**
	 * Method that assigns each .png file to an image variable, representing the
	 * direction which the player is facing.
	 */
	public void getImage() {
		up1 = setup("/npc/guard_friendly_down_1");
		up2 = setup("/npc/guard_friendly_down_2");
		down1 = setup("/npc/guard_friendly_down_1");
		down2 = setup("/npc/guard_friendly_down_2");
		left1 = setup("/npc/guard_friendly_down_1");
		left2 = setup("/npc/guard_friendly_down_2");
		right1 = setup("/npc/guard_friendly_down_1");
		right2 = setup("/npc/guard_friendly_down_2");
	}

	/**
	 * Sets the dialogue for the NPC.
	 */
	public void setDialogue() {
		dialogues[0] = "Go speak to my master, he's excited to see you!";
	}

	/**
	 * Called when the NPC_Merchant is spoken to.
	 */
	public void speak() {
		super.speak();
	}
}
