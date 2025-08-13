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
		dialogues[0] = "Look at you! The one\nto present me the sacred\nancient scroll from the dungeon!";
		dialogues[1] = "You should be proud of\nyourself lad. Few make it past\nthat cursed place.";
		dialogues[2] = "This scroll. . . it speaks of\nthe Velari. My kind.\nLong thought scattered across the lands.";
		dialogues[3] = "I remember being no taller\nthan a mushroom when I\nfirst heard whispers of our lost colony.";
		dialogues[4] = "Back then, I was alone.\nA glowing child in a\nworld that feared the light.";
		dialogues[5] = "But an old man, wrinkled and kind,\nfound me in the woods on my island,\nriddled with bridges, lakes,\nand tales of lost treasure. . .";
		dialogues[6] = "He gave me shelter.\nTaught me stories. Said I\nwas a \"Little Lantern meant to guide others.\"";
		dialogues[7] = "Years passed. His stories led\nme to the ruins, the\nrivers, and finally. . . to my people.";
		dialogues[8] = "Now, thanks to you, this scroll\nconfirms what he always\nbelieved: the Velari would rise again.";
		dialogues[9] = "Funny, isn’t it? One man’s\nkindness lit a path, and\nnow you’ve helped me light the way\nto the rebirth of the Velari.";
		dialogues[10] = "I owe you, son. Follow the\npath of treasure back down to where you\ncame, and take the portal to your ultimate\ndestiny. Haha!";
	}

	/**
	 * Called when the NPC_Merchant is spoken to.
	 */
	public void speak() {
		super.speak();
	}
}
