package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Sign extends Entity {

	public OBJ_Sign(GamePanel gp, String nameOfSign) {
		super(gp);

		direction = "default";

		getImage();
		setDialogue(nameOfSign);
	}

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
	 * Sets the dialogue for the Signs, depending on their set name in AssetSetter.
	 */
	public void setDialogue(String nameOfSign) {
		if (nameOfSign.equals("Starting_Sign")) {
			dialogues[0] = "There's a path of flowers down there. . .";
			dialogues[1] = "The old man loves flowers. . .\nYou should follow them, if you find him\nhe can help you. . .";
			dialogues[2] = "The monsters here also love the flowers. . .\nYou should stay away from them until\nyou find a weapon.";
			dialogues[3] = "Good luck, you'll need it,\nFind the sacred treasure. . .";
		} else if (nameOfSign.equals("Secret_Island_Sign")) {
			dialogues[0] = "Welcome to the secret island! It's\na lot brighter here than the other island,\nwho would figure! These chests should\nhelp you out a lot. . .";
		} else if (nameOfSign.equals("Dungeon_Starting_Sign")) {
			dialogues[0] = "Welcome to the dungeon traveler.\n";
			dialogues[1] = "Your bigger light won't work down here if you\nhappened to buy one in the overworld. It's a\nlittle darker here, and a lot more gloomy. . .";
			dialogues[2] = "That map from the old man got washed away\nin the teleportation process. Maybe there's\nanother map hidden within the dungeon. . . ";
			dialogues[3] = "Go explore and look for any signs of life,\nThey should help you. . .";
		}
	}

	/**
	 * Called when the sign is interacted with.
	 */
	public void speak() {
		super.speak();
	}
}
