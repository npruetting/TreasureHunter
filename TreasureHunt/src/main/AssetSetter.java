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
		setAsset("Dungeon_Door", 18, 46, 16);
		setAsset("Dungeon_Coin", 19, 82, 20, 32, 32);
		setAsset("Dungeon_Coin", 20, 57, 6, 32, 32);
		setAsset("Dungeon_Coin", 21, 37, 6, 32, 32);
		setAsset("Dungeon_Coin", 22, 47, 16, 32, 0);
		setAsset("Dungeon_Coin", 23, 90, 28, 32, 32);
		setAsset("Dungeon_Coin", 24, 71, 74, 32, 32);
		setAsset("Dungeon_Coin", 25, 26, 51, 32, 32);
		setAsset("Dungeon_Coin", 26, 28, 26, 32, 32);
		setAsset("Dungeon_Coin", 27, 44, 31, 32, 32);
		setAsset("Dungeon_Coin", 28, 54, 37, 32, 32);
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
		setAsset("Dungeon_Portal", 40, 43, 16);
		// Fragile Trees
		setAsset("Tree_Fragile", 41, 53, 40);
		setAsset("Tree_Fragile", 42, 53, 39);
		setAsset("Tree_Fragile", 43, 54, 39);
		
		setAsset("Tree_Fragile", 44, 42, 29);
		setAsset("Tree_Fragile", 45, 42, 30);
		setAsset("Tree_Fragile", 46, 43, 30);
		setAsset("Tree_Fragile", 47, 44, 30);
		
		setAsset("Tree_Fragile", 48, 36, 29);
		setAsset("Tree_Fragile", 49, 36, 28);
		setAsset("Tree_Fragile", 50, 35, 28);
		setAsset("Tree_Fragile", 51, 34, 28);
		setAsset("Tree_Fragile", 52, 33, 28);
		setAsset("Tree_Fragile", 53, 32, 28);
		setAsset("Tree_Fragile", 54, 31, 28);
		setAsset("Tree_Fragile", 55, 31, 27);
		setAsset("Tree_Fragile", 56, 30, 27);
		
		setAsset("Tree_Fragile", 57, 23, 10);
		setAsset("Tree_Fragile", 58, 24, 10);
		setAsset("Tree_Fragile", 59, 27, 10);
		setAsset("Tree_Fragile", 60, 29, 9);
		
		setAsset("Tree_Fragile", 61, 28, 44);
		setAsset("Tree_Fragile", 62, 33, 44);
		
		setAsset("Tree_Fragile", 63, 42, 52);
		setAsset("Tree_Fragile", 64, 42, 51);
		setAsset("Tree_Fragile", 65, 43, 51);
		setAsset("Tree_Fragile", 66, 44, 51);
		setAsset("Tree_Fragile", 67, 44, 50);
		setAsset("Tree_Fragile", 68, 45, 50);
		setAsset("Tree_Fragile", 69, 46, 50);
		
		setAsset("Tree_Fragile", 70, 15, 42);
		setAsset("Tree_Fragile", 71, 14, 42);
		setAsset("Tree_Fragile", 72, 13, 42);
		setAsset("Tree_Fragile", 73, 13, 41);
		setAsset("Tree_Fragile", 74, 13, 40);
		setAsset("Tree_Fragile", 75, 13, 39);
		setAsset("Tree_Fragile", 76, 13, 38);
		setAsset("Tree_Fragile", 77, 13, 37);
		setAsset("Tree_Fragile", 78, 13, 36);
		setAsset("Tree_Fragile", 79, 13, 35);
		
		setAsset("Tree_Fragile", 80, 21, 52);
		setAsset("Tree_Fragile", 81, 22, 52);
		setAsset("Tree_Fragile", 82, 23, 52);
		setAsset("Tree_Fragile", 83, 24, 52);
		setAsset("Tree_Fragile", 84, 25, 52);
		
		setAsset("Tree_Fragile", 85, 17, 83);
		setAsset("Tree_Fragile", 86, 16, 83);
		setAsset("Tree_Fragile", 87, 15, 83);
		setAsset("Tree_Fragile", 88, 15, 84);
		setAsset("Tree_Fragile", 89, 15, 85);
		setAsset("Tree_Fragile", 90, 15, 86);
		setAsset("Tree_Fragile", 91, 15, 87);
		
		setAsset("Tree_Fragile", 92, 84, 53);
		setAsset("Tree_Fragile", 93, 87, 49);
		setAsset("Tree_Fragile", 94, 88, 49);
		setAsset("Tree_Fragile", 95, 89, 49);
		setAsset("Tree_Fragile", 96, 89, 49);
		setAsset("Tree_Fragile", 97, 89, 48);
		setAsset("Tree_Fragile", 98, 90, 48);
		setAsset("Tree_Fragile", 99, 91, 48);
		setAsset("Tree_Fragile", 100, 91, 47);
		
		setAsset("Tree_Fragile", 101, 91, 31);
		setAsset("Tree_Fragile", 102, 91, 32);
		setAsset("Tree_Fragile", 103, 91, 33);
		setAsset("Tree_Fragile", 104, 91, 34);
		setAsset("Tree_Fragile", 105, 91, 35);
		
		setAsset("Tree_Fragile", 106, 83, 17);
		setAsset("Tree_Fragile", 107, 84, 17);
		setAsset("Tree_Fragile", 108, 85, 17);
		
		setAsset("Tree_Fragile", 109, 79, 17);
		setAsset("Tree_Fragile", 110, 79, 18);
		setAsset("Tree_Fragile", 111, 79, 19);
		setAsset("Tree_Fragile", 112, 79, 20);
		setAsset("Tree_Fragile", 113, 80, 20);
		setAsset("Tree_Fragile", 114, 81, 20);
		
		setAsset("Tree_Fragile", 115, 53, 21);
		setAsset("Tree_Fragile", 116, 54, 21);
		setAsset("Tree_Fragile", 117, 54, 20);
		setAsset("Tree_Fragile", 118, 54, 19);
		setAsset("Tree_Fragile", 119, 54, 18);
		setAsset("Tree_Fragile", 120, 54, 17);
		setAsset("Tree_Fragile", 121, 54, 16);
		setAsset("Tree_Fragile", 122, 53, 16);
		setAsset("Tree_Fragile", 123, 55, 19);
		setAsset("Tree_Fragile", 124, 56, 19);
		setAsset("Tree_Fragile", 125, 57, 19);
		setAsset("Tree_Fragile", 126, 58, 19);
		setAsset("Tree_Fragile", 127, 59, 19);
		
		setAsset("Tree_Fragile", 128, 55, 65);
		setAsset("Tree_Fragile", 129, 56, 65);
		// NPCs
		setAsset("Old_Man", 0, 36, 36);
		setAsset("Merchant", 1, 17, 37);
		// Monsters
		setAsset("Green_Slime", 0, 21, 15);
		setAsset("Green_Slime", 1, 21, 16);
		setAsset("Green_Slime", 2, 22, 15);
		setAsset("Green_Slime", 3, 22, 16);
		setAsset("Green_Slime", 4, 14, 24);
		setAsset("Skeleton", 5, 14, 25);
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
		setAsset("Skeleton", 21, 65, 28);
		setAsset("Green_Slime", 22, 58, 42);
		setAsset("Green_Slime", 23, 59, 41);
		setAsset("Green_Slime", 24, 56, 25);
		setAsset("Green_Slime", 25, 56, 55);
		setAsset("Skeleton", 26, 41, 62);
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
		setAsset("Skeleton", 46, 11, 78);
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
		setAsset("Skeleton", 64, 19, 82);
		
		setAsset("Green_Slime", 65, 18, 65);
		setAsset("Green_Slime", 66, 19, 65);
		setAsset("Skeleton", 67, 20, 65);
		setAsset("Green_Slime", 68, 18, 66);
		setAsset("Skeleton", 69, 19, 66);
		setAsset("Green_Slime", 70, 20, 66);
		setAsset("Green_Slime", 71, 19, 67);
		
		setAsset("Skeleton", 72, 22, 38);
		setAsset("Green_Slime", 73, 19, 52);
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
		case "Dungeon_Door":
			gp.obj[arrIndex] = new OBJ_Dungeon_Door(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize;
			break;
		case "Dungeon_Coin":
			gp.obj[arrIndex] = new OBJ_Dungeon_Coin(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize;
			break;
		case "Dungeon_Portal":
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
		case "Dungeon_Door":
			gp.obj[arrIndex] = new OBJ_Dungeon_Door(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize + xOffset;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize + yOffset;
			break;
		case "Dungeon_Coin":
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
