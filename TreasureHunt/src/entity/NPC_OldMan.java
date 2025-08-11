package entity;

import java.util.Random;

import main.GamePanel;

public class NPC_OldMan extends Entity {
	
	/**
	 * Constructs the old man npc.
	 * 
	 * @param gp - the game panel
	 */
	public NPC_OldMan(GamePanel gp) {
		super(gp);

		direction = "down";
		speed = 1;

		getImage();
		setDialogue();
	}

	/**
	 * Method that assigns each .png file to an image variable, representing the
	 * direction which the player is facing.
	 */
	public void getImage() {
		up1 = setup("/npc/oldman_up_1");
		up2 = setup("/npc/oldman_up_2");
		down1 = setup("/npc/oldman_down_1");
		down2 = setup("/npc/oldman_down_2");
		left1 = setup("/npc/oldman_left_1");
		left2 = setup("/npc/oldman_left_2");
		right1 = setup("/npc/oldman_right_1");
		right2 = setup("/npc/oldman_right_2");
	}

	/**
	 * Sets the dialogue for the NPC.
	 */
	public void setDialogue() {
		dialogues[0] = "Haha! You found me! I almost got lost\nmyself, and I've been here for ages!";
		dialogues[1] = "Remember how I was telling you about\nhow dark it is out here? No joke, am I right!";
		dialogues[2] = "I've heard stories of a dungeon where\nit's even darker than this! The dungeon is\nprobably all just a hoax! Probably. . .";
		dialogues[3] = "Anyways, I tripped and dropped\nmy sword on this trail, but I want you to\nfind and use it! Could be useful for\nattacking monsters. . .";
		dialogues[4] = "I know of a merchant who\nlives around these parts, I'll just\nask him for a new weapon.";
		dialogues[5] = "If I remember correctly, his lair is\nwithin the bottom left quadrant,\nguarded by monsters. . .";
		dialogues[6] = "A very powerful tool of his is that axe used\nto chop trees, I'd consider buying!";
		dialogues[7] = "Good luck again lad! I'm giving you this map\nI made of the island. It should be\nsuper useful for your further exploration. . .";
	}

	/**
	 * Makes the entity wander around the map, randomly changing direction every 2
	 * seconds.
	 */
	public void setAction() {
		actionLockCounter++;
		if (actionLockCounter == 120) {
			Random random = new Random();
			int i = random.nextInt(100) + 1;
			if (i <= 25) {
				direction = "up";
			}
			if (i > 25 && i <= 50) {
				direction = "down";
			}
			if (i > 50 && i <= 75) {
				direction = "left";
			}
			if (i > 75 && i <= 100) {
				direction = "right";
			}
			actionLockCounter = 0;
		}
	}

	/**
	 * Called when the NPC_OldMan is spoken to.
	 */
	public void speak() {
		super.speak();
	}

	/**
	 * Used for when an entity is interacted with by the player.
	 */
	public void interactionReaction() {
		actionLockCounter = 0;
		direction = gp.player.direction;
	}
}
