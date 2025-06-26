package main;

import entity.NPC_OldMan;
import entity.MON_GreenSlime;
import entity.MON_Skeleton;
import entity.NPC_Merchant;
import object.OBJ_Axe;
import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Coin;
import object.OBJ_Door;
import object.OBJ_Dungeon_Coin;
import object.OBJ_Dungeon_Door;
import object.OBJ_Dungeon_Portal;
import object.OBJ_Key;
import object.OBJ_Portal;
import object.OBJ_Potion_Red;
import object.OBJ_Shield_Blue;
import object.OBJ_Sword_Normal;
import object.OBJ_Table;
import object.OBJ_Tree_Fragile;

/**
 * Class that sets objects on the specified map at their specified location.
 */
public class AssetSetter {

	private GamePanel gp;

	/**
	 * Constructor for AssetSetter.
	 * 
	 * @param gp - the game panel
	 */
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}

	/**
	 * Sets all objects, NPCs, and monsters for map 1.
	 */
	public void setAssetsMap1() {
		// Objects
		setAsset("Door", 0, 40, 82);
		setAsset("Door", 1, 19, 63);
		setAsset("Door", 2, 17, 41);
		setAsset("Door", 3, 52, 16);
		setAsset("Door", 4, 60, 7);
		setAsset("Door", 5, 85, 16);
		setAsset("Door", 6, 60, 38);
		setAsset("Door", 7, 54, 54);
		setAsset("Door", 8, 82, 27);
		setAsset("Key", 9, 10, 11, 42, 42);
		setAsset("Key", 10, 32, 31, 32, 32);
		setAsset("Key", 11, 49, 68, 32, 32);
		setAsset("Key", 12, 45, 84, 32, 32);
		setAsset("Key", 14, 11, 81);
		setAsset("Key", 15, 83, 9, 32, 32);
		setAsset("Table", 16, 17, 38);
		setAsset("Sword_Normal", 17, 33, 24, 32, 32);
		setAsset("Dungeon Door", 18, 46, 16);
		setAsset("Dungeon Coin", 19, 82, 20, 32, 32);
		setAsset("Dungeon Coin", 20, 57, 6, 32, 32);
		setAsset("Dungeon Coin", 21, 37, 6, 32, 32);
		setAsset("Dungeon Coin", 22, 47, 16, 32, 0);
		setAsset("Dungeon Coin", 23, 90, 28, 32, 32);
		setAsset("Dungeon Coin", 24, 71, 74, 32, 32);
		setAsset("Dungeon Coin", 25, 26, 51, 32, 32);
		setAsset("Dungeon Coin", 26, 28, 26, 32, 32);
		setAsset("Dungeon Coin", 27, 44, 31, 32, 32);
		setAsset("Dungeon Coin", 28, 54, 37, 32, 32);
		setAsset("Door", 29, 29, 8);
		setAsset("Portal", 30, 47, 49, 32, 32);
		setAsset("Chest", 31, 85, 13, 32, 32);
		setAsset("Chest", 32, 48, 58);
		setAsset("Chest", 33, 33, 89, 32, 32);
		setAsset("Chest", 34, 10, 34, 32, 0);
		setAsset("Chest", 35, 76, 38);
		setAsset("Chest", 36, 80, 36);
		setAsset("Chest", 37, 61, 20);
		setAsset("Chest", 38, 90, 45, 32, 32);
		setAsset("Chest", 39, 41, 7);
		setAsset("Dungeon Portal", 40, 43, 16);
		// NPCs
		setAsset("Old_Man", 0, 36, 36);
		setAsset("Merchant", 1, 17, 37);
		// Monsters
		setAsset("Green_Slime", 0, 21, 15);
		setAsset("Green_Slime", 1, 21, 16);
		setAsset("Green_Slime", 2, 22, 15);
		setAsset("Green_Slime", 3, 22, 16);
		setAsset("Green_Slime", 4, 14, 24);
		setAsset("Green_Slime", 5, 14, 25);
		setAsset("Green_Slime", 6, 15, 24);
		setAsset("Green_Slime", 7, 15, 25);
		setAsset("Green_Slime", 8, 40, 24);
		setAsset("Green_Slime", 9, 40, 25);
		setAsset("Green_Slime", 10, 41, 24);
		setAsset("Green_Slime", 11, 41, 25);
		setAsset("Skeleton", 12, 77, 11);
		setAsset("Green_Slime", 13, 77, 12);
		setAsset("Green_Slime", 14, 55, 8);
		setAsset("Green_Slime", 15, 55, 9);
		setAsset("Green_Slime", 16, 11, 12);
		setAsset("Green_Slime", 17, 32, 15);
		setAsset("Green_Slime", 18, 33, 14);
		setAsset("Green_Slime", 19, 35, 43);
		setAsset("Green_Slime", 20, 36, 44);
		setAsset("Green_Slime", 21, 65, 28);
		setAsset("Green_Slime", 22, 58, 42);
		setAsset("Green_Slime", 23, 59, 41);
		setAsset("Green_Slime", 24, 56, 25);
		setAsset("Green_Slime", 25, 56, 55);
		setAsset("Green_Slime", 26, 41, 62);
		setAsset("Green_Slime", 27, 63, 55);
		setAsset("Green_Slime", 28, 63, 56);
		setAsset("Green_Slime", 29, 75, 27);
		setAsset("Green_Slime", 30, 76, 27);
		setAsset("Skeleton", 31, 87, 27);
		setAsset("Green_Slime", 32, 46, 70);
		setAsset("Green_Slime", 33, 54, 79);
		setAsset("Green_Slime", 34, 55, 80);
		setAsset("Skeleton", 35, 72, 62);
		setAsset("Green_Slime", 36, 72, 63);
		setAsset("Skeleton", 37, 73, 62);
		setAsset("Green_Slime", 38, 73, 63);
		setAsset("Skeleton", 39, 87, 64);
		setAsset("Skeleton", 40, 88, 63);
		setAsset("Green_Slime", 41, 63, 73);
		setAsset("Green_Slime", 42, 86, 53);
		setAsset("Green_Slime", 43, 73, 48);
		setAsset("Green_Slime", 44, 74, 49);
		setAsset("Green_Slime", 45, 27, 59);
		setAsset("Green_Slime", 46, 11, 78);
		setAsset("Green_Slime", 47, 35, 71);
		setAsset("Green_Slime", 48, 35, 72);
		setAsset("Green_Slime", 49, 40, 7);
		// Big battles/clumps of monsters
		setAsset("Skeleton", 50, 74, 37);
		setAsset("Green_Slime", 51, 75, 36);
		setAsset("Skeleton", 52, 74, 38);
		setAsset("Skeleton", 53, 74, 39);
		setAsset("Green_Slime", 54, 76, 40);
		
		setAsset("Green_Slime", 55, 81, 38);
		setAsset("Green_Slime", 56, 81, 39);
		setAsset("Skeleton", 57, 82, 38);
		setAsset("Skeleton", 58, 82, 39);
		setAsset("Skeleton", 59, 80, 38);
		setAsset("Skeleton", 60, 80, 39);
		
		setAsset("Skeleton", 61, 81, 15);
		setAsset("Green_Slime", 62, 82, 16);
		
		setAsset("Green_Slime", 63, 30, 82);
		setAsset("Green_Slime", 64, 19, 82);
		
		setAsset("Green_Slime", 65, 18, 65);
		setAsset("Green_Slime", 66, 19, 65);
		setAsset("Green_Slime", 67, 20, 65);
		setAsset("Green_Slime", 68, 18, 66);
		setAsset("Green_Slime", 69, 19, 66);
		setAsset("Green_Slime", 70, 20, 66);
		setAsset("Green_Slime", 71, 19, 67);
		
		setAsset("Skeleton", 72, 22, 38);
		setAsset("Green_Slime", 73, 19, 52);
		// TODO temp
		setAsset("Skeleton", 73, 48, 41);
	}

	/**
	 * Sets all objects, NPCs, and monsters for dungeon.
	 */
	public void setAssetsDungeon() {
		setAsset("Key", 0, 23, 10);
	}

	/**
	 * Private helper that sets the assets for the map.
	 * 
	 * @param objectName - name of object to set
	 * @param arrIndex   - index of the object array to set the object
	 * @param xPos       - x position on map
	 * @param yPos       - y position on map
	 */
	private void setAsset(String objectName, int arrIndex, int xPos, int yPos) {
		switch (objectName) {
		case "Key":
			gp.obj[arrIndex] = new OBJ_Key(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize;
			break;
		case "Chest":
			gp.obj[arrIndex] = new OBJ_Chest(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize;
			break;
		case "Portal":
			gp.obj[arrIndex] = new OBJ_Portal(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize;
			break;
		case "Boots":
			gp.obj[arrIndex] = new OBJ_Boots(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize;
			break;
		case "Door":
			gp.obj[arrIndex] = new OBJ_Door(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize;
			break;
		case "Axe":
			gp.obj[arrIndex] = new OBJ_Axe(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize;
			break;
		case "Sword_Normal":
			gp.obj[arrIndex] = new OBJ_Sword_Normal(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize;
			break;
		case "Blue_Shield":
			gp.obj[arrIndex] = new OBJ_Shield_Blue(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize;
			break;
		case "Red_Potion":
			gp.obj[arrIndex] = new OBJ_Potion_Red(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize;
			break;
		case "Tree_Fragile":
			gp.obj[arrIndex] = new OBJ_Tree_Fragile(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize;
			break;
		case "Coin":
			gp.obj[arrIndex] = new OBJ_Coin(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize;
			break;
		case "Table":
			gp.obj[arrIndex] = new OBJ_Table(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize;
			break;
		case "Dungeon Door":
			gp.obj[arrIndex] = new OBJ_Dungeon_Door(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize;
			break;
		case "Dungeon Coin":
			gp.obj[arrIndex] = new OBJ_Dungeon_Coin(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize;
			break;
		case "Dungeon Portal":
			gp.obj[arrIndex] = new OBJ_Dungeon_Portal(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize;
			break;
		case "Old_Man":
			gp.npc[arrIndex] = new NPC_OldMan(gp);
			gp.npc[arrIndex].worldX = xPos * gp.tileSize;
			gp.npc[arrIndex].worldY = yPos * gp.tileSize;
			break;
		case "Merchant":
			gp.npc[arrIndex] = new NPC_Merchant(gp);
			gp.npc[arrIndex].worldX = xPos * gp.tileSize;
			gp.npc[arrIndex].worldY = yPos * gp.tileSize;
			break;
		case "Green_Slime":
			gp.monster[arrIndex] = new MON_GreenSlime(gp);
			gp.monster[arrIndex].worldX = xPos * gp.tileSize;
			gp.monster[arrIndex].worldY = yPos * gp.tileSize;
			break;
		case "Skeleton":
			gp.monster[arrIndex] = new MON_Skeleton(gp);
			gp.monster[arrIndex].worldX = xPos * gp.tileSize;
			gp.monster[arrIndex].worldY = yPos * gp.tileSize;
			break;
		}
	}

	/**
	 * Private helper that sets the assets for the map with a tile offset, where the
	 * asset is not directly set on a tile. With a tile size of 64, any x or y
	 * offset between -63 and 63 will offset the asset.
	 * 
	 * @param objectName - name of object to set
	 * @param arrIndex   - index of the object array to set the object
	 * @param xPos       - x position on map
	 * @param yPos       - y position on map
	 * @param xOffset    - x offset from tile
	 * @param yOffset    - y offset from tile
	 */
	private void setAsset(String objectName, int arrIndex, int xPos, int yPos, int xOffset, int yOffset) {
		switch (objectName) {
		case "Key":
			gp.obj[arrIndex] = new OBJ_Key(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize + xOffset;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize + yOffset;
			break;
		case "Chest":
			gp.obj[arrIndex] = new OBJ_Chest(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize + xOffset;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize + yOffset;
			break;
		case "Portal":
			gp.obj[arrIndex] = new OBJ_Portal(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize + xOffset;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize + yOffset;
			break;
		case "Boots":
			gp.obj[arrIndex] = new OBJ_Boots(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize + xOffset;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize + yOffset;
			break;
		case "Door":
			gp.obj[arrIndex] = new OBJ_Door(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize + xOffset;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize + yOffset;
			break;
		case "Axe":
			gp.obj[arrIndex] = new OBJ_Axe(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize + xOffset;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize + yOffset;
			break;
		case "Sword_Normal":
			gp.obj[arrIndex] = new OBJ_Sword_Normal(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize + xOffset;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize + yOffset;
			break;
		case "Blue_Shield":
			gp.obj[arrIndex] = new OBJ_Shield_Blue(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize + xOffset;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize + yOffset;
			break;
		case "Red_Potion":
			gp.obj[arrIndex] = new OBJ_Potion_Red(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize + xOffset;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize + yOffset;
			break;
		case "Tree_Fragile":
			gp.obj[arrIndex] = new OBJ_Tree_Fragile(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize + xOffset;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize + yOffset;
			break;
		case "Coin":
			gp.obj[arrIndex] = new OBJ_Coin(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize + xOffset;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize + yOffset;
			break;
		case "Table":
			gp.obj[arrIndex] = new OBJ_Table(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize + xOffset;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize + yOffset;
			break;
		case "Dungeon Door":
			gp.obj[arrIndex] = new OBJ_Dungeon_Door(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize + xOffset;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize + yOffset;
			break;
		case "Dungeon Coin":
			gp.obj[arrIndex] = new OBJ_Dungeon_Coin(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize + xOffset;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize + yOffset;
			break;
		case "Old_Man":
			gp.npc[arrIndex] = new NPC_OldMan(gp);
			gp.npc[arrIndex].worldX = xPos * gp.tileSize + xOffset;
			gp.npc[arrIndex].worldY = yPos * gp.tileSize + yOffset;
			break;
		case "Merchant":
			gp.npc[arrIndex] = new NPC_Merchant(gp);
			gp.npc[arrIndex].worldX = xPos * gp.tileSize + xOffset;
			gp.npc[arrIndex].worldY = yPos * gp.tileSize + yOffset;
			break;
		case "Green_Slime":
			gp.monster[arrIndex] = new MON_GreenSlime(gp);
			gp.monster[arrIndex].worldX = xPos * gp.tileSize + xOffset;
			gp.monster[arrIndex].worldY = yPos * gp.tileSize + yOffset;
			break;
		}
	}
}
