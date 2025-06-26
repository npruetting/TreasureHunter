package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

/**
 * Class that houses many variables used by entities among the tile map.
 */
public class Entity {

	public GamePanel gp;
	private UtilityTool uTool = new UtilityTool();
	public Rectangle solidArea = new Rectangle(0, 0, 64, 64);
	public Rectangle attackArea = new Rectangle(0, 0, 0, 0);
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collisionOn = false;
	public String dialogues[] = new String[20];
	public int dialogueIndex = 0;
	private boolean zeroToggled;
	private boolean oneToggled;
	private boolean twoToggled;
	public boolean collision;

	// Entity attributes
	public String name;
	public int speed;
	public int worldX, worldY;
	public String direction;
	public boolean attacking;
	public int health;
	public int maxHealth;
	public boolean invincible;
	public boolean alive = true;
	public boolean dying;
	public boolean canDamage = true;
	public boolean damaged;
	public boolean treeHit;
	public boolean skeletonAttacking;
	// Attributes for character status
	public int level;
	public int strength;
	public int dexterity;
	public int attack;
	public int defense;
	public int exp;
	public int nextLevelExp;
	public int coin;
	public int dungeonCoin;
	public Entity currentWeapon;
	public Entity currentShield;
	public Projectile projectile;
	public int arrowAmount;
	// Item attributes
	public ArrayList<Entity> inventory = new ArrayList<Entity>();
	public final int maxInventorySize = 20;
	public int attackValue;
	public int defenseValue;
	public String description = "";
	public int price;
	public boolean forSale;
	public boolean isDungeonObject;
	// Type
	public int type;
	public final int type_player = 0;
	public final int type_npc = 1;
	public final int type_monster = 2;
	public final int type_sword = 3;
	public final int type_axe = 4;
	public final int type_shield = 5;
	public final int type_item = 6;
	public final int type_bow = 7;

	// Imaging
	private BufferedImage image;
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
	public BufferedImage attackUp1, attackUp2, attackDown1, attackDown2, attackLeft1, attackLeft2, attackRight1,
			attackRight2;
	public int spriteCounter = 0;
	public int spriteNum = 1;

	// Counters
	public int actionLockCounter;
	public int invincibleCounter;
	public int deathCounter;
	public int damagedCounter;
	public int shotAvailableCounter;
	public int skeletonAttackCounter;

	/**
	 * Constructs an entity.
	 * 
	 * @param gp - the game panel
	 */
	public Entity(GamePanel gp) {
		this.gp = gp;
	}

	/**
	 * Called by extending classes to set the movement and action of an entity.
	 */
	public void setAction() {
	}

	/**
	 * Called by extending classes for an entity to react to damage.
	 */
	public void damageReaction() {
	}

	/**
	 * Called by extending classes for an entity that hits a player.
	 */
	public void hitPlayerReaction() {
	}

	/**
	 * Called by extending classes for when an entity is interacted with by the
	 * player.
	 */
	public void interactionReaction() {
	}

	/**
	 * Called by extending classes if an entity is being spoken to.
	 */
	public void speak() {
		gp.npcIsBeingSpokenTo = true;
		// Sound effect
		Random rng = new Random();
		int npcTalk = rng.nextInt(9, 11);
		gp.playSE(npcTalk);
		// Resets back to first dialogue if dialogue limit is reached
		if (dialogues[dialogueIndex] == null) {
			dialogueIndex = 0;
		}
		gp.ui.currentDialogue = dialogues[dialogueIndex];
		dialogueIndex++;
		// Makes the NPC face towards the player
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

	/**
	 * Called by extending classes if an item is used.
	 * 
	 * @param itemIndex - index of item being used
	 */
	public void use(int itemIndex) {
	}

	public void checkDrop() {
	}

	public void attacking() {
	}

	public void dropItem(Entity droppedItem) {
		for (int i = 0; i < gp.obj.length; i++) {
			if (gp.obj[i] == null) {
				gp.obj[i] = droppedItem;
				gp.obj[i].worldX = worldX;
				gp.obj[i].worldY = worldY;
				break;
			}
		}
	}

	/**
	 * Sets the color of the particles.
	 * 
	 * @return particle color
	 */
	public Color getParticleColor() {
		return null;
	}

	/**
	 * Size of the particle in pixels.
	 * 
	 * @return size of particle
	 */
	public int getParticleSize() {
		return 0;
	}

	/**
	 * Speed of particle.
	 * 
	 * @return speed of particle
	 */
	public int getParticleSpeed() {
		return 0;
	}

	/**
	 * Particle max health.
	 * 
	 * @return particle max health
	 */
	public int getParticleMaxHealth() {
		return 0;
	}

	/**
	 * Generates particles for items when hit.
	 * 
	 * @param generator - item that generates particle effect
	 * @param target    - target being hit by generator particles
	 */
	public void generateParticle(Entity generator, Entity target) {
		Color color = generator.getParticleColor();
		int size = generator.getParticleSize();
		int speed = generator.getParticleSpeed();
		int maxHealth = generator.getParticleMaxHealth();

		Particle p1 = new Particle(gp, generator, color, size, speed, maxHealth, -2, -1);
		Particle p2 = new Particle(gp, generator, color, size, speed, maxHealth, 2, -1);
		Particle p3 = new Particle(gp, generator, color, size, speed, maxHealth, -2, 1);
		Particle p4 = new Particle(gp, generator, color, size, speed, maxHealth, 2, 1);
		gp.particleList.add(p1);
		gp.particleList.add(p2);
		gp.particleList.add(p3);
		gp.particleList.add(p4);
	}

	/**
	 * Calls this method 60 times per second which updates the entities on the map.
	 */
	public void update() {
		// Specific to the entity class
		setAction();
		// Collision checks
		collisionOn = false;
		gp.cChecker.checkTile(this);
		gp.cChecker.checkObject(this, false);
		gp.cChecker.checkEntity(this, gp.npc);
		gp.cChecker.checkEntity(this, gp.monster);
		boolean contactPlayer = gp.cChecker.checkPlayer(this);

		// If entity is attacking
		if (attacking) {
			attacking();
		}

		// If monster interacts with player
		if (this.type == type_monster && contactPlayer) {
			damagePlayer(attack);
		}
		// If collision is false, the entity can move
		if (!collisionOn) {
			switch (direction) {
			case "up":
				worldY -= speed;
				break;
			case "down":
				worldY += speed;
				break;
			case "left":
				worldX -= speed;
				break;
			case "right":
				worldX += speed;
				break;
			case "stable":
				break;
			}
		}
		// Used to animate the entities movement
		int spriteCounterInt;
		if (name == "Skeleton") {
			spriteCounterInt = 10;
		} else {
			spriteCounterInt = 30;
		}
		if (direction != "stable") {
			spriteCounter++;
			if (spriteCounter > spriteCounterInt) {
				if (spriteNum == 1) {
					spriteNum = 2;
				} else if (spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
			// Used to display entity invincibility
			if (invincible) {
				invincibleCounter++;
				if (invincibleCounter > 40) {
					invincible = false;
					invincibleCounter = 0;
				}
			}
		}

		if (shotAvailableCounter < 30) {
			shotAvailableCounter++;
		}
	}

	public void damagePlayer(int attack) {
		if (!gp.player.invincible) {
			int damage = attack - gp.player.defense;
			if (damage < 0) {
				damage = 0;
			}
			gp.player.health -= damage;
			gp.playSE(6);
			gp.player.invincible = true;
		}
	}

	/**
	 * Draws the entities based on their current direction.
	 * 
	 * @param g2 - graphics
	 */
	public void draw(Graphics2D g2) {
		image = null;
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX
				&& worldX - gp.tileSize < gp.player.worldX + gp.player.screenX
				&& worldY + gp.tileSize > gp.player.worldY - gp.player.screenY
				&& worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
			switch (direction) {
			case "up":
				if (spriteNum == 1) {
					image = up1;
				} else {
					image = up2;
				}
				break;
			case "down":
				if (spriteNum == 1) {
					image = down1;
				} else {
					image = down2;
				}
				break;
			case "left":
				if (spriteNum == 1) {
					image = left1;
				} else {
					image = left2;
				}
				break;
			case "right":
				if (spriteNum == 1) {
					image = right1;
				} else {
					image = right2;
				}
				break;
			default:
				image = down1;
			}

			// Skeleton attack
			if (skeletonAttacking) {
				speed = 0;
				switch (direction) {
				case "up":
					image = attackUp1;
					break;
				case "down":
					image = attackDown1;
					break;
				case "left":
					image = attackLeft1;
					break;
				case "right":
					image = attackRight1;
					break;
				}
				skeletonAttackCounter++;
				System.out.println(skeletonAttackCounter);
			}
			if (skeletonAttackCounter > 20) {
				skeletonAttacking = false;
				skeletonAttackCounter = 0;
				speed = 2;
			}

			int yValue = screenY;
			// Health bar
			if (type == type_monster && damaged) {
				damagedCounter++;
				if (name == "Skeleton") {
					yValue = screenY - 24;
				}
				double oneScale = (double) gp.tileSize / maxHealth;
				double hpBarValue = oneScale * health;
				g2.setColor(new Color(35, 35, 35));
				g2.fillRect(screenX - 2, yValue - 2, gp.tileSize + 4, 14);

				g2.setColor(new Color(255, 0, 30));
				g2.fillRect(screenX, yValue, (int) hpBarValue, 10);

				if (damagedCounter > 120) {
					damaged = false;
					damagedCounter = 0;
				}
			}
			// Entity opacity changed if invincible
			if (invincible) {
				uTool.changeAlpha(g2, 0.4f);
			}
			// Death animation
			if (dying) {
				deathMessage(g2, screenX, yValue);
				deathAnimation(g2, 5);
			}
			g2.drawImage(image, screenX, screenY, null);
			// Reset opacity
			uTool.changeAlpha(g2, 1f);

			// DEBUG HITBOX
			if (gp.keyH.toggleDebug) {
				g2.setColor(new Color(255, 0, 0, 128));
				int hitboxScreenX = screenX + solidArea.x;
				int hitboxScreenY = screenY + solidArea.y;
				g2.drawRect(hitboxScreenX, hitboxScreenY, solidArea.width, solidArea.height);
			}
		}
	}

	/**
	 * Animates entity death.
	 * 
	 * @param g2 - graphics
	 * @param i  - multiplier of alternating frame changes
	 */
	public void deathAnimation(Graphics2D g2, int i) {
		canDamage = false;
		deathCounter++;
		if (deathCounter <= i) {
			uTool.changeAlpha(g2, 0f);
		} else if (deathCounter > i && deathCounter <= i * 2) {
			uTool.changeAlpha(g2, 1f);
		} else if (deathCounter > i * 2 && deathCounter <= i * 3) {
			uTool.changeAlpha(g2, 0f);
		} else if (deathCounter > i * 3 && deathCounter <= i * 4) {
			uTool.changeAlpha(g2, 1f);
		} else if (deathCounter > i * 4 && deathCounter <= i * 5) {
			uTool.changeAlpha(g2, 0f);
		} else if (deathCounter > i * 5 && deathCounter <= i * 6) {
			uTool.changeAlpha(g2, 1f);
		} else if (deathCounter > i * 6 && deathCounter <= i * 7) {
			uTool.changeAlpha(g2, 0f);
		} else if (deathCounter > i * 7 && deathCounter <= i * 8) {
			uTool.changeAlpha(g2, 1f);
		} else if (deathCounter > i * 8) {
			alive = false;
			dying = false;
		}
	}

	/**
	 * Method that displays a message on the monster's health bar once it is killed.
	 * 
	 * @param g2      - graphics
	 * @param screenX - the screenX position of the entity
	 * @param screenY - the screenY position of the entity
	 */
	public void deathMessage(Graphics2D g2, int screenX, int screenY) {
		g2.setColor(Color.white);
		Random random = new Random();
		int rng = random.nextInt(0, 3);
		String deathMessage = null;
		if (!zeroToggled && !oneToggled && !twoToggled) {
			if (rng == 0) {
				zeroToggled = true;
			} else if (rng == 1) {
				oneToggled = true;
			} else if (rng == 2) {
				twoToggled = true;
			}
		}
		if (zeroToggled) {
			deathMessage = "Nice!";
		} else if (oneToggled) {
			deathMessage = "Boom!";
		} else if (twoToggled) {
			deathMessage = "Haha!";
		}
		uTool.changeAlpha(g2, 1f);
		g2.drawString(deathMessage, screenX + 17, screenY + 9);
	}

	/**
	 * Method that sets up the images from the given image name. Each image is
	 * default 64x64.
	 * 
	 * @param imageName - given image
	 * @return the rendered image
	 */
	public BufferedImage setup(String imagePath) {
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
			image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

	/**
	 * Method that sets up the images from the given image name. Each image is setup
	 * with a given width and height, making non 64x64 images able to setup.
	 * 
	 * @param imageName - given image
	 * @return the rendered image
	 */
	public BufferedImage setup(String imagePath, int width, int height) {
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
			image = uTool.scaleImage(image, width, height);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
}
