package entity;

import java.awt.Color;
import java.util.Random;

import main.GamePanel;
import object.OBJ_Coin;
import object.OBJ_Dungeon_Coin;

public class MON_GreenSlime extends Entity {

	public MON_GreenSlime(GamePanel gp) {
		super(gp);
		name = "Green Slime";
		type = type_monster;
		direction = "down";
		speed = 1;
		maxHealth = 4;
		health = maxHealth;
		attack = 4;
		defense = 0;
		exp = 2;

		solidArea.x = 4;
		solidArea.y = 22;
		solidArea.width = 56;
		solidArea.height = 38;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;

		getImage();
	}

	public void getImage() {
		up1 = setup("/monster/greenslime_down_1");
		up2 = setup("/monster/greenslime_down_2");
		down1 = setup("/monster/greenslime_down_1");
		down2 = setup("/monster/greenslime_down_2");
		left1 = setup("/monster/greenslime_down_1");
		left2 = setup("/monster/greenslime_down_2");
		right1 = setup("/monster/greenslime_down_1");
		right2 = setup("/monster/greenslime_down_2");
	}

	/**
	 * Makes the monster wander around the map, randomly changing direction every 2
	 * seconds.
	 */
	public void setAction() {
		if (direction != "stable") {
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
	}

	/**
	 * Makes the monster run away from the player after being damaged.
	 */
	public void damageReaction() {
		actionLockCounter = 0;
		direction = gp.player.direction;
	}

	/**
	 * Makes the monster run towards the player after contact.
	 */
	public void hitPlayerReaction() {
		actionLockCounter = 0;
		switch (gp.player.direction) {
		case "up":
			direction = "down";
			break;
		case "down":
			direction = "up";
			break;
		case "left":
			direction = "right";
			break;
		case "right":
			direction = "left";
			break;
		}
	}

	public void checkDrop() {
		int rng = new Random().nextInt(100) + 1;
		if (rng < 50) {
			dropItem(new OBJ_Coin(gp));
		} else if (rng > 90) {
			dropItem(new OBJ_Dungeon_Coin(gp));
		}
	}

	public Color getParticleColor() {
		return Color.red;
	}

	public int getParticleSize() {
		return 6;
	}

	public int getParticleSpeed() {
		return 1;
	}

	public int getParticleMaxHealth() {
		return 14;
	}
}
