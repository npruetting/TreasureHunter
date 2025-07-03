package entity;

import main.GamePanel;

public class Projectile extends Entity{

	public Entity user;
	
	public Projectile(GamePanel gp) {
		super(gp);
		name = "projectile";
	}
	
	public void set(int worldX, int worldY, String direction, boolean alive, Entity user) {
		this.worldX = worldX;
		this.worldY = worldY;
		this.direction = direction;
		this.alive = alive;
		this.user = user;
		this.health = this.maxHealth;
	}
	
	public void update() {
		// Player/entity collision
		if (user == gp.player) {
			int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
			if (monsterIndex != -1) {
				gp.player.damageMonster(monsterIndex, attack);
				alive = false;
			}
		} else {
			boolean contactPlayer = gp.cChecker.checkPlayer(this);
			if (!gp.player.invincible && contactPlayer) {
				damagePlayer(attack);
				gp.ui.addMessage("Damaged from arrow!");
				alive = false;
			}
		}
		// Tile collision
		collisionOn = false;
		gp.cChecker.checkTile(this);
		gp.cChecker.checkObject(this, false);
		if (collisionOn) {
			alive = false;
		}
		
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
		
		health--;
		if (health <= 0) {
			alive = false;
		}
		
		spriteCounter++;
		if (spriteCounter > 12) {
			if (spriteNum == 1) {
				spriteNum = 2;
			} else if (spriteNum == 2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
	}
}
