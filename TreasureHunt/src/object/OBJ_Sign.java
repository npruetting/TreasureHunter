package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Sign extends Entity {
	
	/**
	 * Constructs the old man npc.
	 * 
	 * @param gp - the game panel
	 */
	public OBJ_Sign(GamePanel gp) {
		super(gp);

		name = "sign";
		direction = "default";
		
		getImage();
		setDialogue();
	}
	
	/**
	 * Method that assigns each .png file to an image variable, representing the
	 * direction which the player is facing.
	 */
	public void getImage() {
		up1 = setup("/objects/sign");
		up2 = setup("/objects/sign");
		down1 = setup("/objects/sign");
		down2 = setup("/objects/sign");
		left1 = setup("/objects/sign");
		left2 = setup("/objects/sign");
		right1 = setup("/objects/sign");
		right2 = setup("/objects/sign");
	}

	/**
	 * Sets the dialogue for the NPC.
	 */
	public void setDialogue() {
		dialogues[0] = "There's a path of flowers down there. . .\n\n(Please come again, I have more to say)";
		dialogues[1] = "The old man loves flowers. . .\nYou should follow them to find him\nHe's very knowledgeable. . .";
		dialogues[2] = "The monsters here also love the flowers. . .\nYou should stay away until you find a weapon.";
		dialogues[3] = "Good luck, and don't forget your ultimate goal. . .\nFind the sacred treasure!";
	}
	
	/**
	 * Called when the sign is interacted with.
	 */
	public void speak() {
		super.speak();
	}
}
