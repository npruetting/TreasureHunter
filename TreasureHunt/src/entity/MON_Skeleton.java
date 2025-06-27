package entity;

import java.awt.Color;
import java.util.Random;

import main.GamePanel;
import object.OBJ_Arrow;
import object.OBJ_Coin;
import object.OBJ_Heart;
import object.PROJ_Arrow;

public class MON_Skeleton extends Entity {

	public MON_Skeleton(GamePanel gp) {
		super(gp);
		name = "Skeleton";
		type = type_monster;
		direction = "down";
		speed = 2;
		maxHealth = 6;
		health = maxHealth;
		attack = 4;
		defense = 0;
		exp = 4;
		projectile = new PROJ_Arrow(gp, 6);

		solidArea.x = 4;
		solidArea.y = 4;
		solidArea.width = 56;
		solidArea.height = 56;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;

		getImage();
		getSkeletonAttackImage();
	}

	public void getImage() {
		up1 = setup("/monster/skeleton_up_1");
		up2 = setup("/monster/skeleton_up_2");
		down1 = setup("/monster/skeleton_down_1");
		down2 = setup("/monster/skeleton_down_2");
		left1 = setup("/monster/skeleton_left_1");
		left2 = setup("/monster/skeleton_left_2");
		right1 = setup("/monster/skeleton_right_1");
		right2 = setup("/monster/skeleton_right_2");
	}

	/**
	 * Method that assigns each .png file to an image variable, representing the
	 * direction which the attacking skeleton is facing. The images are set up such
	 * that the width and height match the original image width and height.
	 */
	private void getSkeletonAttackImage() {
		attackUp1 = setup("/monster/skeleton_attack_up");
		attackUp2 = setup("/monster/skeleton_attack_up");
		attackDown1 = setup("/monster/skeleton_attack_down");
		attackDown2 = setup("/monster/skeleton_attack_down");
		attackLeft1 = setup("/monster/skeleton_attack_left");
		attackLeft2 = setup("/monster/skeleton_attack_left");
		attackRight1 = setup("/monster/skeleton_attack_right");
		attackRight2 = setup("/monster/skeleton_attack_right");
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
				if (i <= 20) {
					direction = "up";
				}
				if (i > 20 && i <= 40) {
					direction = "down";
				}
				if (i > 40 && i <= 60) {
					direction = "left";
				}
				if (i > 60 && i <= 80) {
					direction = "right";
				}
				actionLockCounter = 0;
			}

			int i = new Random().nextInt(100) + 1;
			if (i > 99 && !projectile.alive) {
				// Animation in entity draw method
				skeletonAttacking = true;
				// Arrow shot
				projectile.set(worldX, worldY, direction, true, this);
				gp.projectileList.add(projectile);
				shotAvailableCounter = 0;
			}
			// Skeleton changes direction after colliding with collision tile.
			collisionOn = false;
			gp.cChecker.checkTile(this);
			if (collisionOn) {
				switchDirection();
			}
		}
	}

	/**
	 * Makes the monster run towards the player after being damaged.
	 */
	public void damageReaction() {
		switchDirection();
	}

	/**
	 * Makes the monster run towards the player after contact.
	 */
	public void hitPlayerReaction() {
		switchDirection();
	}

	/**
	 * Method that switches the Skeleton's direction.
	 */
	private void switchDirection() {
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
		if (rng < 40) {
			dropItem(new OBJ_Coin(gp));
		} else if (rng >= 40 && rng < 60) {
			dropItem(new OBJ_Heart(gp));
		}else if (rng > 75) {
			dropItem(new OBJ_Arrow(gp));
		}
	}

	public Color getParticleColor() {
		return Color.gray;
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
