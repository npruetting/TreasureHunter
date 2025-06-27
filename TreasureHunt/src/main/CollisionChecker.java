package main;

import entity.Entity;

/**
 * Classed used to detect collisions among tiles and objects.
 */
public class CollisionChecker {

	private GamePanel gp;

	/**
	 * Constructs a CollisionChecker.
	 * 
	 * @param gp - the game panel
	 */
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}

	/**
	 * Checks if a tile is a collision tile, based on the objects and tile images
	 * represented by the tile. Also deciphers the direction of interaction.
	 * 
	 * @param entity - the tile
	 */
	public void checkTile(Entity entity) {

		int entityLeftWorldX = entity.worldX + entity.solidArea.x;
		int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.worldY + entity.solidArea.y;
		int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

		int entityLeftCol = entityLeftWorldX / gp.tileSize;
		int entityRightCol = entityRightWorldX / gp.tileSize;
		int entityTopRow = entityTopWorldY / gp.tileSize;
		int entityBottomRow = entityBottomWorldY / gp.tileSize;

		int tileNum1, tileNum2;

		switch (entity.direction) {
		case "up":
			entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
				entity.collisionOn = true;
				// Messed around with collision tiles, turning trees into tree stubs on contact
//				if (entity == gp.player) {
//					if (gp.tileM.tile[tileNum1].name.equals("tree") || gp.tileM.tile[tileNum2].name.equals("tree")) {
//						gp.tileM.mapTileNum[entityLeftCol][entityTopRow] = 17;
//					}
//				}
			}
			break;

		case "down":
			entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
				entity.collisionOn = true;
			}
			break;

		case "left":
			entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
				entity.collisionOn = true;
			}
			break;

		case "right":
			entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
				entity.collisionOn = true;
			}
			break;
		}
	}

	/**
	 * Checks if an object is a collision object, and deciphers which object is
	 * being interacted with and at which direction.
	 * 
	 * @param entity - the tile
	 * @param player - the player
	 * @return the index of the object array to decipher which object is being
	 *         interacted with
	 */
	public int checkObject(Entity entity, boolean player) {
		int index = -1;
		for (int i = 0; i < gp.obj.length; i++) {
			if (gp.obj[i] != null) {

				// Get entity's solid area position
				entity.solidArea.x += entity.worldX;
				entity.solidArea.y += entity.worldY;

				// Get the object's solid area position
				gp.obj[i].solidArea.x += gp.obj[i].worldX;
				gp.obj[i].solidArea.y += gp.obj[i].worldY;

				switch (entity.direction) {
				case "up":
					entity.solidArea.y -= entity.speed;
					break;
				case "down":
					entity.solidArea.y += entity.speed;
					break;
				case "left":
					entity.solidArea.x -= entity.speed;
					break;
				case "right":
					entity.solidArea.x += entity.speed;
					break;
				}
				if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
					if (gp.obj[i].collision) {
						entity.collisionOn = true;
					}
					if (player) {
						index = i;
					}
				}
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
				gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
			}
		}
		return index;
	}

	/**
	 * Used to check collisions on entities, including npcs and monsters.
	 * 
	 * @param entity - the tile
	 * @param target - the player
	 * @return the index of the entities array to decipher which entity is being
	 *         interacted with
	 */
	public int checkEntity(Entity entity, Entity[] target) {
		int index = -1;
		for (int i = 0; i < target.length; i++) {

			if (target[i] != null) {

				// Get entity's solid area position
				entity.solidArea.x += entity.worldX;
				entity.solidArea.y += entity.worldY;

				// Get the object's solid area position
				target[i].solidArea.x += target[i].worldX;
				target[i].solidArea.y += target[i].worldY;

				switch (entity.direction) {
				case "up":
					entity.solidArea.y -= entity.speed;
					break;
				case "down":
					entity.solidArea.y += entity.speed;
					break;
				case "left":
					entity.solidArea.x -= entity.speed;
					break;
				case "right":
					entity.solidArea.x += entity.speed;
					break;
				}
				if (entity.solidArea.intersects(target[i].solidArea)) {
					if (target[i] != entity) {
						entity.collisionOn = true;
						index = i;
					}
				}
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				target[i].solidArea.x = target[i].solidAreaDefaultX;
				target[i].solidArea.y = target[i].solidAreaDefaultY;
			}
		}
		return index;
	}

	/**
	 * Used to check if an player is colliding with the entity.
	 * 
	 * @param entity - the entity
	 * @return if entity is in contact with player
	 */
	public boolean checkPlayer(Entity entity) {
		boolean contactPlayer = false;
		// Get entity's solid area position
		entity.solidArea.x += entity.worldX;
		entity.solidArea.y += entity.worldY;

		// Get the object's solid area position
		gp.player.solidArea.x += gp.player.worldX;
		gp.player.solidArea.y += gp.player.worldY;

		switch (entity.direction) {
		case "up":
			entity.solidArea.y -= entity.speed;
			break;
		case "down":
			entity.solidArea.y += entity.speed;
			break;
		case "left":
			entity.solidArea.x -= entity.speed;
			break;
		case "right":
			entity.solidArea.x += entity.speed;
			break;
		}
		if (entity.solidArea.intersects(gp.player.solidArea)) {
			entity.collisionOn = true;
			contactPlayer = true;
		}
		entity.solidArea.x = entity.solidAreaDefaultX;
		entity.solidArea.y = entity.solidAreaDefaultY;
		gp.player.solidArea.x = gp.player.solidAreaDefaultX;
		gp.player.solidArea.y = gp.player.solidAreaDefaultY;
		return contactPlayer;
	}
}
