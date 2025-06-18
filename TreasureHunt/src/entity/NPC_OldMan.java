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
		dialogues[0] = "Haha! You found me! I almost got lost here\nmyself, and I've been here for ages! Remember\nhow I was telling you about how dark it is\nout here? Hah, no joke, am I right!";
		dialogues[1] = "Looks like you've made some progress in the\ndarkness. Maybe out there somewhere, there's\na way to make this world not so dang dark. . .\nWho knows!";
		dialogues[2] = "I'll tell you boy, I heard a key can be bought\nusing a special currency to enter the depths\nof this land. . . Ah forget it, the key is\nprobably a myth anyways. . .";
		dialogues[3] = "I'm pretty tired I'll probably try and catch\nsome sleep soon. Wouldn't want to fall asleep\ntoo close to any monsters though. . .\nthey're quite scary.";
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
