package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;
import object.OBJ_Axe;
import object.OBJ_Bow;
import object.OBJ_Dungeon_Key;
import object.OBJ_Key;
import object.OBJ_Lantern_Tiny;
import object.OBJ_Shield_Wood;
import object.OBJ_Sword_Normal;
import object.PROJ_Arrow;

/**
 * Class that houses methods for the player's animation and object interaction.
 */
public class Player extends Entity {

	private UtilityTool uTool = new UtilityTool();
	private KeyHandler keyH;
	private BufferedImage image;
	public final int screenX;
	public final int screenY;
	public boolean isFast;
	public int counter = 0;
	public int mapChangeTimer;
	public int alphaValue;
	private boolean playAttackSound;
	public int npcIndex;
	public int doorIndex;
	private boolean axeEquipped;
	private boolean bowEquipped;
	public boolean arrowShot;
	private int arrowDamageAmount;

	/**
	 * Constructor that initializes the player in the game, including its hit box
	 * and what keys affect the player's movement.
	 * 
	 * @param gp   - the game panel
	 * @param keyH - the key handler
	 */
	public Player(GamePanel gp, KeyHandler keyH) {
		super(gp);
		this.keyH = keyH;
		screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
		screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

		solidArea = new Rectangle(14, 22, 36, 36);
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;

		setDefaultValues();
		getPlayerImage();
		getPlayerAttackImage();
		setDefaultInventoryItems();
	}

	/**
	 * Sets the default values of spawn point for the player (worldX and worldY) and
	 * the speed. The direction is set to default, meaning the player is facing
	 * forward and not moving.
	 */
	public void setDefaultValues() {
		worldX = 47 * gp.tileSize;
		worldY = 38 * gp.tileSize;
		speed = 6;
		direction = "down";
		// Player status
		level = 0;
		maxHealth = 10;
		health = maxHealth;
		strength = 1; // More strength, more damage given
		dexterity = 1; // More dexterity, less damage received
		exp = 0;
		nextLevelExp = 10;
		coin = 0;
		//arrowAmount = 10;
		arrowDamageAmount = 1;
		projectile = new PROJ_Arrow(gp, arrowDamageAmount);
		// No starting weapon
		currentShield = new OBJ_Shield_Wood(gp);
		defense = getDefense();
	}

	/**
	 * Sets player default inventory items.
	 */
	public void setDefaultInventoryItems() {
		inventory.add(new OBJ_Lantern_Tiny(gp));
		inventory.add(currentShield);
		// TODO temp items
		inventory.add(new OBJ_Key(gp));
		inventory.add(new OBJ_Dungeon_Key(gp));
		inventory.add(new OBJ_Sword_Normal(gp));
		inventory.add(new OBJ_Bow(gp));
		inventory.add(new OBJ_Axe(gp));
	}

	/**
	 * Determines total attack value, being player strength and weapon.
	 * 
	 * @return the attack value
	 */
	public int getAttack() {
		attackArea = currentWeapon.attackArea;
		return strength * currentWeapon.attackValue;
	}

	/**
	 * Determines total defense value, being player dexterity and shield.
	 * 
	 * @return the defense value
	 */
	public int getDefense() {
		return dexterity * currentShield.defenseValue;
	}

	/**
	 * Method that assigns each .png file to an image variable, representing the
	 * direction which the player is facing.
	 */
	public void getPlayerImage() {
		up1 = setup("/player/boy_up_1");
		up2 = setup("/player/boy_up_2");
		down1 = setup("/player/boy_down_1");
		down2 = setup("/player/boy_down_2");
		left1 = setup("/player/boy_left_1");
		left2 = setup("/player/boy_left_2");
		right1 = setup("/player/boy_right_1");
		right2 = setup("/player/boy_right_2");
	}

	/**
	 * Method that assigns each .png file to an image variable, representing the
	 * direction which the attacking player is facing. The images are set up such
	 * that the width and height match the original image width and height.
	 */
	public void getPlayerAttackImage() {
		if (currentWeapon != null) {
			if (currentWeapon.type == type_sword) {
				attackUp1 = setup("/player/boy_attack_up_1", gp.tileSize, gp.tileSize * 2);
				attackUp2 = setup("/player/boy_attack_up_2", gp.tileSize, gp.tileSize * 2);
				attackDown1 = setup("/player/boy_attack_down_1", gp.tileSize, gp.tileSize * 2);
				attackDown2 = setup("/player/boy_attack_down_2", gp.tileSize, gp.tileSize * 2);
				attackLeft1 = setup("/player/boy_attack_left_1", gp.tileSize * 2, gp.tileSize);
				attackLeft2 = setup("/player/boy_attack_left_2", gp.tileSize * 2, gp.tileSize);
				attackRight1 = setup("/player/boy_attack_right_1", gp.tileSize * 2, gp.tileSize);
				attackRight2 = setup("/player/boy_attack_right_2", gp.tileSize * 2, gp.tileSize);
			} else if (currentWeapon.type == type_axe) {
				attackUp1 = setup("/player/boy_axe_up_1", gp.tileSize, gp.tileSize * 2);
				attackUp2 = setup("/player/boy_axe_up_2", gp.tileSize, gp.tileSize * 2);
				attackDown1 = setup("/player/boy_axe_down_1", gp.tileSize, gp.tileSize * 2);
				attackDown2 = setup("/player/boy_axe_down_2", gp.tileSize, gp.tileSize * 2);
				attackLeft1 = setup("/player/boy_axe_left_1", gp.tileSize * 2, gp.tileSize);
				attackLeft2 = setup("/player/boy_axe_left_2", gp.tileSize * 2, gp.tileSize);
				attackRight1 = setup("/player/boy_axe_right_1", gp.tileSize * 2, gp.tileSize);
				attackRight2 = setup("/player/boy_axe_right_2", gp.tileSize * 2, gp.tileSize);
			} else if (currentWeapon.type == type_bow) {
				attackUp1 = setup("/player/boy_bow_up");
				attackUp2 = setup("/player/boy_bow_up");
				attackDown1 = setup("/player/boy_bow_down");
				attackDown2 = setup("/player/boy_bow_down");
				attackLeft1 = setup("/player/boy_bow_left");
				attackLeft2 = setup("/player/boy_bow_left");
				attackRight1 = setup("/player/boy_bow_right");
				attackRight2 = setup("/player/boy_bow_right");
			}
		}
	}

	/**
	 * Calls this method 60 times per second which updates the Player on the map.
	 */
	public void update() {
		// Player invincible
		if (invincible) {
			invincibleCounter++;
			if (invincibleCounter > 60) {
				invincible = false;
				invincibleCounter = 0;
			}
		}
		// Map change
		if (mapChangeTimer > 0) {
			mapChangeTimer--;
			if (mapChangeTimer < 13) {
				alphaValue -= 20;
			}
			return;
		}
		// Makes player fast for 10 seconds
		if (isFast) {
			counter++;
			if (counter > 1800) {
				gp.ui.addMessage("Speed boost deactivated.");
				speed -= 2;
				counter = 0;
				isFast = false;
			}
		}

		// Check if the player levels up
		checkLevelUp();

		if (arrowShot && !projectile.alive && shotAvailableCounter == 40) {
			// Set default coordinates, direction, and user
			projectile.set(worldX, worldY, direction, true, this);
			// Add it to the list
			gp.projectileList.add(projectile);

			shotAvailableCounter = 0;

			arrowShot = false;
		}

		if (shotAvailableCounter < 40) {
			shotAvailableCounter++;
		}

		// If player is attacking
		if (attacking) {
			attacking();
		}

		// The player can move around
		else if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
			if (keyH.upPressed) {
				direction = "up";
			} else if (keyH.downPressed) {
				direction = "down";
			} else if (keyH.leftPressed) {
				direction = "left";
			} else if (keyH.rightPressed) {
				direction = "right";
			}

			// Check tile collision
			collisionOn = false;
			gp.cChecker.checkTile(this);

			// Check object collision
			int objIndex = gp.cChecker.checkObject(this, true);
			interactObject(objIndex);

			// Check npc collision
			npcIndex = gp.cChecker.checkEntity(this, gp.npc);
			interactNPC(npcIndex);

			// Check monster collision
			int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
			if (monsterIndex != -1 && gp.monster[monsterIndex].canDamage) {
				contactMonster(monsterIndex);
			}

			// When the player status is not opened, player can move
			if (!gp.isViewingStatus) {
				// If collision is false, Player can move
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
					}
				}

				// Used to animate the players ability to walk
				spriteCounter++;
				if (spriteCounter > 12) {
					if (spriteNum == 1) {
						spriteNum = 2;
					} else if (spriteNum == 2) {
						spriteNum = 1;
					}
					spriteCounter = 0;
				}
			} else {
				direction = "default";
			}
		}
	}

	/**
	 * Called if the player is attacking.
	 */
	public void attacking() {
		// Bow attack
		if (bowEquipped) {

			if (arrowAmount == 0) {
				if (!gp.ui.messages.contains("Out of arrows!")) {
					gp.ui.addMessage("Out of arrows!");
				}
				attacking = false;
			} else {
				if (!playAttackSound) {
					playAttackSound = true;
					if (!projectile.alive) {
						gp.playSE(12);
					}
				}
				spriteCounter++;
				if (spriteCounter <= 5) {
					spriteNum = 1;
				} else if (spriteCounter > 5 && spriteCounter <= 25) {
					spriteNum = 2;
				} else if (spriteCounter > 25) {
					if (arrowAmount > 0) {
						arrowAmount--;
					}
					spriteNum = 1;
					spriteCounter = 0;
					playAttackSound = false;
					attacking = false;
				}

				if (!projectile.alive && shotAvailableCounter == 40) {
					arrowShot = true;
				}
			}
		}
		// Other weapon attack
		else {
			int objIndex = gp.cChecker.checkObject(this, true);
			// Animation
			if (!playAttackSound) {
				playAttackSound = true;
				gp.playSE(12);
			}
			spriteCounter++;
			if (spriteCounter <= 5) {
				spriteNum = 1;
			} else if (spriteCounter > 5 && spriteCounter <= 25) {
				spriteNum = 2;
				hitDetection(objIndex);
			} else if (spriteCounter > 25) {
				spriteNum = 1;
				spriteCounter = 0;
				attacking = false;
				playAttackSound = false;
				// Tree hit animation
				if (objIndex != -1) {
					gp.obj[objIndex].treeHit = false;
				}
			}
		}
	}

	/**
	 * Method that detects if an entity is hit by the player attack.
	 * 
	 * @param objIndex - index of object being attacked
	 */
	private void hitDetection(int objIndex) {
		// Save the current worldX, worldY, solidArea
		int currentWorldX = worldX;
		int currentWorldY = worldY;
		int solidAreaWidth = solidArea.width;
		int solidAreaHeight = solidArea.height;
		// Adjust player's worldY and worldY for the attackArea
		switch (direction) {
		case "up":
			worldY -= attackArea.height;
			break;
		case "down":
			worldY += attackArea.height;
			break;
		case "left":
			worldX -= attackArea.width;
			break;
		case "right":
			worldX += attackArea.width;
			break;
		}
		// Attack area becomes solid area
		solidArea.width = attackArea.width;
		solidArea.height = attackArea.height;
		// Check monster collision with updated worldX, worldY, solidArea
		int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
		damageMonster(monsterIndex, attack);
		// Check if a fragile tree is being attacked
		hitFragileTree(objIndex);
		// Reset position
		worldX = currentWorldX;
		worldY = currentWorldY;
		solidArea.width = solidAreaWidth;
		solidArea.height = solidAreaHeight;
	}

	/**
	 * Performs specific outputs when objects are interacted with.
	 * 
	 * @param i - object index from array
	 */
	public void interactObject(int i) {
		if (i != -1) {
			String objectName = gp.obj[i].name;
			switch (objectName) {
			case "key":
				if (inventory.size() < maxInventorySize) {
					inventory.add(new OBJ_Key(gp));
					gp.playSE(1);
					gp.obj[i] = null;
					gp.ui.addMessage("Key aquired!");
				} else {
					if (!gp.ui.messages.contains("Inventory is full!")) {
						gp.ui.addMessage("Inventory is full!");
					}
				}
				break;
			case "door":
				if (!gp.ui.messages.contains("Need a key. . .")) {
					doorIndex = i;
					gp.ui.addMessage("Need a key. . .");
				}
				break;
			case "chest":
				if (gp.obj[i].health == 0) {
					gp.playSE(1);
					Random rng = new Random();
					int coinAmount = rng.nextInt(10, 21);
					coin += coinAmount;
					gp.dialogueState = true;
					gp.ui.currentDialogue = "You found treasure!\n+ " + coinAmount + " coins!";
					gp.ui.addMessage("+ " + coinAmount + " coins!");
					gp.obj[i].down1 = setup("/objects/chest_opened", gp.tileSize, gp.tileSize);
					gp.obj[i].health = 1;
				}
				break;
			case "dungeon_chest":
				if (gp.obj[i].health == 0) {
					gp.playSE(1);
					Random rng = new Random();
					int coinAmount = rng.nextInt(4, 9);
					dungeonCoin += coinAmount;
					gp.dialogueState = true;
					gp.ui.currentDialogue = "You found treasure!\n+ " + coinAmount + " dungeon coins!";
					gp.ui.addMessage("+ " + coinAmount + " dungeon coins!");
					gp.obj[i].down1 = setup("/objects/dungeon_chest_opened", gp.tileSize, gp.tileSize);
					gp.obj[i].health = 1;
				}
				break;
			case "portal":
				mapChangeTimer = 90;
				alphaValue = 255;
				gp.playSE(5);
				gp.obj[i] = null;
				gp.tileM.loadMap("/maps/world02.txt");

				// Clears all assets on map when it is loaded
				for (int x = 0; x < gp.monster.length; x++) {
//					System.out.println(counter);
//					gp.obj[x] = null;
//					gp.npc[x] = null;
					gp.monster[x].direction = "stable";
					gp.monster[x].worldX -= gp.tileSize * 100;
				}
				gp.aSetter.setAssetsDungeon();
				worldX = 47 * gp.tileSize;
				worldY = 38 * gp.tileSize;
				break;
			case "dungeon_portal":
				transitionDungeon();
				break;
			case "sword_normal":
				if (inventory.size() < maxInventorySize) {
					inventory.add(new OBJ_Sword_Normal(gp));
					gp.playSE(1);
					gp.obj[i] = null;
					gp.ui.addMessage("Sword aquired!");
				} else {
					if (!gp.ui.messages.contains("Inventory is full!")) {
						gp.ui.addMessage("Inventory is full!");
					}
				}
				break;
			case "coin":
				gp.playSE(1);
				gp.obj[i] = null;
				gp.ui.addMessage("+1 coin!");
				coin++;
				break;
			case "dungeon_coin":
				gp.playSE(1);
				gp.obj[i] = null;
				gp.ui.addMessage("+1 dungeon coin!");
				dungeonCoin++;
				break;
			case "dungeon_door":
				if (!gp.ui.messages.contains("Needs dungeon key. . .")) {
					doorIndex = i;
					gp.ui.addMessage("Needs dungeon key. . .");
				}
				break;
			case "arrow":
				gp.playSE(25);
				gp.obj[i] = null;
				gp.ui.addMessage("+1 arrow");
				arrowAmount++;
				break;
			case "heart":
				gp.playSE(1);
				gp.obj[i] = null;
				gp.ui.addMessage("+1 heart");
				health += 2;
				if (health > maxHealth) {
					health = maxHealth;
				}
				break;
			}
		}
	}

	/**
	 * Called when player transitions to or from the dungeon
	 */
	private void transitionDungeon() {
		mapChangeTimer = 90;
		alphaValue = 255;
		gp.playSE(5);
		gp.tileM.loadMap("/maps/world02.txt");

		// Clears all assets on map when it is loaded
//		for (int x = 0; x < gp.obj.length; x++) {
//			System.out.println(x);
//			gp.obj[x].worldX -= gp.tileSize * 100;
//		}
		for (int x = 0; x < gp.npc.length; x++) {
			gp.npc[x].direction = "stable";
			gp.npc[x].worldX -= gp.tileSize * 100;
		}
		for (int x = 0; x < gp.monster.length; x++) {
			gp.monster[x].direction = "stable";
			gp.monster[x].worldX -= gp.tileSize * 100;
		}

		gp.aSetter.setAssetsDungeon();
		worldX = 47 * gp.tileSize;
		worldY = 38 * gp.tileSize;
	}

	/**
	 * Called when npc is interacted with.
	 * 
	 * @param i - index of npc in its array
	 */
	public void interactNPC(int i) {
		if (i != -1) {
			gp.dialogueState = true;
			gp.npc[i].speak();
		}
	}

	/**
	 * Called when monster is interacted with.
	 * 
	 * @param i - index of monster in its array
	 */
	public void contactMonster(int i) {
		if (i != -1) {
			if (!invincible && !gp.monster[i].dying) {
				// Monster damages player
				int damage = gp.monster[i].attack - defense;
				if (damage < 0) {
					damage = 0;
				}
				health -= damage;
				gp.playSE(6);
				gp.monster[i].hitPlayerReaction();
				gp.ui.addMessage("Damaged!");
				invincible = true;
			}
		}
	}

	/**
	 * Method called when a player damages a monster.
	 * 
	 * @param i - index of monster in its array
	 */
	public void damageMonster(int i, int attack) {
		if (i != -1) {
			if (!gp.monster[i].invincible && !gp.monster[i].dying) {
				// Give damage to monster
				int damage = attack - gp.monster[i].defense;
				if (damage < 0) {
					damage = 0;
				}
				gp.monster[i].health -= damage;
				gp.ui.addMessage(damage + " damage given!");
				// Health bar UI
				gp.monster[i].damaged = true;
				gp.monster[i].damagedCounter = 0;
				gp.monster[i].damageReaction();
				// If monster dies
				if (gp.monster[i].health <= 0) {
					generateParticle(gp.monster[i], gp.monster[i]);
					gp.monster[i].dying = true;
					gp.ui.addMessage("Killed the " + gp.monster[i].name + "!");
					gp.ui.addMessage("Exp + " + gp.monster[i].exp);
					exp += gp.monster[i].exp;
					gp.monster[i].invincible = true;
					gp.playSE(13);
				} else {
					generateParticle(gp.monster[i], gp.monster[i]);
					gp.playSE(11);
					gp.monster[i].invincible = true;
				}
			}
		}
	}

	/**
	 * Method used to see if the player hits a fragile tree with an axe, enacting
	 * damage on that tree.
	 * 
	 * @param i - index of object
	 */
	public void hitFragileTree(int i) {
		if (i != -1) {
			if (gp.obj[i].name == "tree_fragile" && axeEquipped && !gp.obj[i].treeHit) {
				gp.obj[i].generateParticle(gp.obj[i], gp.obj[i]);
				if (gp.obj[i].health <= 1) {
					gp.playSE(18);
					gp.obj[i] = null;
				} else {
					gp.playSE(17);
					gp.obj[i].health--;
					gp.obj[i].treeHit = true;
				}
			}
		}
	}

	/**
	 * Checks if the player levels up; if their exp reaches the next level exp
	 * needed.
	 */
	public void checkLevelUp() {
		if (exp >= nextLevelExp) {
			// UI health display
			gp.hSetter.extraHeartsDisplayed++;
			// Character status
			level++;
			nextLevelExp *= 2 + 10;
			if (maxHealth < 20) {
				maxHealth += 2;
			}
			health = maxHealth;
			strength++;
			dexterity++;
			attack = getAttack();
			defense = getDefense();
			arrowDamageAmount++;
			projectile = new PROJ_Arrow(gp, arrowDamageAmount);
			
			gp.playSE(14);
			gp.levelUpState = true;
		}
	}

	/**
	 * Called when the user selects an item in the inventory.
	 */
	public void selectItem() {
		int itemIndex = gp.ui.getItemIndexOnSlot(gp.ui.playerSlotCol, gp.ui.playerSlotRow);
		if (itemIndex < inventory.size()) {
			Entity selectedItem = inventory.get(itemIndex);
			if (selectedItem.type == type_sword && selectedItem != currentWeapon) {
				gp.playSE(16);
				currentWeapon = selectedItem;
				attack = getAttack();
				getPlayerAttackImage();
				gp.ui.equippedMessage = true;
				gp.ui.equippedTimer = 0;
				axeEquipped = false;
				bowEquipped = false;
			}
			if (selectedItem.type == type_axe && selectedItem != currentWeapon) {
				gp.playSE(16);
				currentWeapon = selectedItem;
				attack = getAttack();
				getPlayerAttackImage();
				gp.ui.equippedMessage = true;
				gp.ui.equippedTimer = 0;
				axeEquipped = true;
				bowEquipped = false;
			}
			if (selectedItem.type == type_bow && selectedItem != currentWeapon) {
				gp.playSE(16);
				currentWeapon = selectedItem;
				getPlayerAttackImage();
				gp.ui.equippedMessage = true;
				gp.ui.equippedTimer = 0;
				axeEquipped = false;
				bowEquipped = true;
			}
			if (selectedItem.type == type_shield && selectedItem != currentShield) {
				gp.playSE(16);
				currentShield = selectedItem;
				defense = getDefense();
				gp.ui.equippedMessage = true;
				gp.ui.equippedTimer = 0;
			}
			if (selectedItem.type == type_item) {
				selectedItem.use(itemIndex);
			}
		}
	}

	/**
	 * Draws the player based on their current direction. The player is initially
	 * drawn to be facing down.
	 * 
	 * @param g2 - graphics
	 */
	public void draw(Graphics2D g2) {
		image = null;
		int tempScreenX = screenX;
		int tempScreenY = screenY;
		switch (direction) {
		case "up":
			if (attacking) {
				if (currentWeapon != null && currentWeapon.type != type_bow) {
					tempScreenY -= gp.tileSize;
				}
				if (spriteNum == 1) {
					image = attackUp1;
				} else {
					image = attackUp2;
				}
			} else {
				if (spriteNum == 1) {
					image = up1;
				} else {
					image = up2;
				}
			}
			break;
		case "down":
			if (attacking) {
				if (spriteNum == 1) {
					image = attackDown1;
				} else {
					image = attackDown2;
				}
			} else {
				if (spriteNum == 1) {
					image = down1;
				} else {
					image = down2;
				}
			}
			break;
		case "left":
			if (attacking) {
				if (currentWeapon != null && currentWeapon.type != type_bow) {
					tempScreenX -= gp.tileSize;
				}
				if (spriteNum == 1) {
					image = attackLeft1;
				} else {
					image = attackLeft2;
				}
			} else {
				if (spriteNum == 1) {
					image = left1;
				} else {
					image = left2;
				}
			}
			break;
		case "right":
			if (attacking) {
				if (spriteNum == 1) {
					image = attackRight1;
				} else {
					image = attackRight2;
				}
			} else {
				if (spriteNum == 1) {
					image = right1;
				} else {
					image = right2;
				}
			}
			break;
		default:
			image = down1;
			break;
		}
		// Player opacity changed if invincible
		if (invincible) {
			uTool.changeAlpha(g2, 0.4f);
		}
		g2.drawImage(image, tempScreenX, tempScreenY, null);
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