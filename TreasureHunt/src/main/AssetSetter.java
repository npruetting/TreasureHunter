package main;

import entity.NPC_OldMan;
import object.OBJ_Sign;
import entity.MON_GreenSlime;
import entity.MON_Skeleton;
import entity.MON_Skeleton_Purple;
import entity.NPC_Dungeon_Merchant;
import entity.NPC_Guard;
import entity.NPC_Guard_Friendly;
import entity.NPC_Guard_Master;
import entity.NPC_Merchant;
import object.OBJ_Axe;
import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Chest_Final;
import object.OBJ_Coin;
import object.OBJ_Diamond;
import object.OBJ_Door;
import object.OBJ_Dungeon_Chest;
import object.OBJ_Dungeon_Coin;
import object.OBJ_Dungeon_Door;
import object.OBJ_Dungeon_Map;
import object.OBJ_Dungeon_Portal;
import object.OBJ_Iron_Gate;
import object.OBJ_Iron_Scrap;
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
		//setAsset("Door", 2, 17, 41);
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

		// TODO temporary placement
//		setAsset("Portal", 30, 48, 58);
		setAsset("Portal", 30, 45, 40, 32, 32);
		gp.obj[30].identification = "to_island";

		setAsset("Chest", 31, 85, 13, 32, 32);
		setAsset("Chest", 32, 47, 49, 32, 32);
		setAsset("Chest", 33, 33, 89, 32, 32);
		setAsset("Chest", 34, 10, 34, 32, 0);
		setAsset("Chest", 35, 76, 38);
		setAsset("Chest", 36, 80, 36);
		setAsset("Chest", 37, 61, 20);
		setAsset("Chest", 38, 90, 45, 32, 32);
		setAsset("Chest", 39, 41, 7);

		// TODO temporary placement
//		setAsset("Dungeon_Portal", 40, 43, 16);
		setAsset("Dungeon_Portal", 40, 45, 38);

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

		setAsset("Chest", 130, 81, 86, 32, 32);
		setAsset("Chest", 131, 88, 86, 32, 32);
		setAsset("Chest", 132, 85, 84);
		setAsset("Portal", 133, 85, 90);
		gp.obj[133].identification = "from_island";
		setAsset("Key", 134, 72, 64, 32, 32);
		
		// TODO temp final chest
		setAsset("Chest_Final", 135, 45, 35, 32, 32);

		// NPCs
		// TODO temp npc placements
//		setAsset("Old_Man", 0, 21, 15);
		setAsset("Old_Man", 0, 48, 36);
//		setAsset("Merchant", 1, 17, 37);
		setAsset("Merchant", 1, 48, 40);
		setSign("Starting_Sign", 2, 48, 39, 48, 24);
		setSign("Secret_Island_Sign", 3, 86, 85, 52, 18);

		// Monsters
		setAsset("Green_Slime", 0, 21, 13);
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
		// Objects
		setAsset("Table", 0, 69, 36, 0, 32);
		setAsset("Dungeon_Chest", 1, 63, 58, 0, 32);
		setAsset("Dungeon_Chest", 2, 90, 65, 0, 32);
		setAsset("Dungeon_Door", 3, 43, 40);
		setAsset("Dungeon_Door", 4, 50, 40);
		setAsset("Dungeon_Door", 5, 57, 40);
		setAsset("Iron_Gate", 6, 36, 60);
		gp.obj[6].identification = "left";
		setAsset("Iron_Gate", 7, 50, 71);
		gp.obj[7].identification = "left";
		setAsset("Iron_Gate", 8, 75, 50);
		gp.obj[8].identification = "up";
		setAsset("Iron_Gate", 9, 42, 32);
		gp.obj[9].identification = "up";
		setAsset("Iron_Scrap", 10, 60, 71);
		setAsset("Iron_Scrap", 11, 60, 79);
		setAsset("Iron_Scrap", 12, 64, 77);
		setAsset("Iron_Scrap", 13, 73, 77);
		setAsset("Iron_Scrap", 14, 73, 71);
		setAsset("Iron_Scrap", 15, 71, 62);
		setAsset("Iron_Scrap", 16, 75, 59);
		setAsset("Iron_Scrap", 17, 77, 73);
		setAsset("Iron_Scrap", 18, 83, 72);
		setAsset("Iron_Scrap", 19, 85, 78);
		setAsset("Iron_Scrap", 20, 91, 74);
		setAsset("Iron_Scrap", 21, 91, 63);
		setAsset("Iron_Scrap", 22, 86, 61);
		setAsset("Iron_Scrap", 23, 57, 53);
		setAsset("Iron_Scrap", 24, 67, 65);
		setAsset("Dungeon_Chest", 25, 50, 76);
		setAsset("Dungeon_Chest", 26, 36, 65);
		setAsset("Dungeon_Chest", 27, 48, 32);
		setAsset("Dungeon_Chest", 28, 89, 47);
		setAsset("Dungeon_Chest", 29, 89, 53);
		setAsset("Portal", 30, 57, 37, 0, 32);
		gp.obj[30].identification = "to_boss_1";
		setAsset("Portal", 31, 50, 37, 0, 32);
		gp.obj[31].identification = "to_boss_2";
		setAsset("Portal", 32, 43, 37, 0, 32);
		gp.obj[32].identification = "to_boss_3";
		setAsset("Portal", 33, 89, 20, 32, 32);
		gp.obj[33].identification = "from_boss_1";
		setAsset("Portal", 34, 19, 30, 32, 32);
		gp.obj[34].identification = "from_boss_2";
		setAsset("Portal", 35, 13, 89);
		gp.obj[35].identification = "from_boss_3";
		// TODO temporary diamond placement
//		setAsset("Diamond", 36, 59, 21);
//		setAsset("Diamond", 37, 19, 9, 32, 32);
//		setAsset("Diamond", 38, 21, 86);
		setAsset("Diamond", 36, 51, 51);
		setAsset("Diamond", 37, 51, 50);
		setAsset("Diamond", 38, 51, 49);
		setAsset("Portal", 39, 22, 50);
		gp.obj[39].identification = "to_final_island";
		setAsset("Chest", 40, 89, 50);
		setAsset("Chest", 41, 69, 34);
		setAsset("Chest", 42, 21, 91);
		setAsset("Chest", 43, 10, 16, 32, 32);
		setAsset("Chest", 44, 64, 8, 32, 32);
		setAsset("Chest", 45, 50, 30);
		setAsset("Chest", 46, 81, 59);
		setAsset("Portal", 47, 89, 70);
		gp.obj[47].identification = "to_dungeon_map";
		setAsset("Portal", 48, 88, 90, 0, 32);
		gp.obj[48].identification = "from_dungeon_map";
		// TODO temp dungeon map placement
//		setAsset("Dungeon_Map", 49, 83, 90, 0, 32);
		setAsset("Dungeon_Map", 49, 48, 48, 0, 32);
		
		// NPCs
//		setAsset("Dungeon_Merchant", 0, 69, 35, 0, 32);
		// TODO temporary dungeon merchant placement
		setAsset("Dungeon_Merchant", 0, 50, 48);
		setSign("Dungeon_Starting_Sign", 1, 51, 48, 48, 12);
		// TODO replace guard
		//setAsset("Guard", 2, 34, 50);

		// Monsters
		setAsset("Skeleton_Purple", 0, 48, 48);
		setAsset("Skeleton", 1, 48, 49);
	}
	
	/**
	 * Sets all assets for the final world.
	 */
	public void setAssetsFinalWorld() {
		// Objects
		setAsset("Dungeon_Coin", 0, 48, 48);
		setAsset("Coin", 1, 49, 48);
		setAsset("Coin", 2, 50, 48);
		setAsset("Dungeon_Coin", 3, 51, 48);
		setAsset("Coin", 4, 52, 48);
		
		setAsset("Coin", 5, 48, 47);
		setAsset("Coin", 6, 49, 47);
		setAsset("Dungeon_Coin", 7, 50, 47);
		setAsset("Coin", 8, 51, 47);
		setAsset("Dungeon_Coin", 9, 52, 47);
		
		setAsset("Coin", 10, 48, 46);
		setAsset("Coin", 11, 49, 46);
		setAsset("Coin", 12, 50, 46);
		setAsset("Diamond", 13, 51, 46);
		
		setAsset("Coin", 14, 48, 49);
		setAsset("Coin", 15, 48, 50);
		setAsset("Dungeon_Coin", 16, 48, 51);
		setAsset("Coin", 17, 48, 52);
		setAsset("Coin", 18, 49, 52);
		setAsset("Coin", 19, 50, 52);
		setAsset("Coin", 20, 51, 52);
		setAsset("Coin", 21, 52, 52);
		setAsset("Dungeon_Coin", 22, 52, 51);
		setAsset("Coin", 23, 52, 50);
		setAsset("Dungeon_Coin", 24, 52, 49);
		
		setAsset("Coin", 25, 47, 45);
		setAsset("Dungeon_Coin", 26, 48, 45);
		setAsset("Coin", 27, 49, 45);
		setAsset("Dungeon_Coin", 28, 50, 45);
		setAsset("Coin", 29, 51, 45);
		
		setAsset("Coin", 30, 47, 44);
		setAsset("Dungeon_Coin", 31, 48, 44);
		setAsset("Coin", 32, 49, 44);
		setAsset("Coin", 33, 50, 44);
		setAsset("Coin", 34, 51, 44);
		
		setAsset("Coin", 35, 47, 43);
		setAsset("Dungeon_Coin", 36, 48, 43);
		setAsset("Coin", 37, 49, 43);
		setAsset("Diamond", 38, 50, 43);
		setAsset("Coin", 39, 51, 43);
		
		setAsset("Dungeon_Coin", 40, 47, 42);
		setAsset("Coin", 41, 48, 42);
		setAsset("Coin", 42, 49, 42);
		setAsset("Coin", 43, 50, 42);
		setAsset("Dungeon_Coin", 44, 51, 42);
		
		setAsset("Coin", 45, 47, 41);
		setAsset("Dungeon_Coin", 46, 48, 41);
		setAsset("Coin", 47, 49, 41);
		setAsset("Coin", 48, 50, 41);
		setAsset("Coin", 49, 51, 41);
		
		setAsset("Coin", 50, 48, 40);
		setAsset("Dungeon_Coin", 51, 49, 40);
		setAsset("Coin", 52, 50, 40);
		setAsset("Coin", 53, 51, 40);
		
		setAsset("Diamond", 54, 48, 39);
		setAsset("Coin", 55, 49, 39);
		setAsset("Coin", 56, 50, 39);
		setAsset("Dungeon_Coin", 57, 51, 39);
		setAsset("Coin", 58, 52, 39);
		
		setAsset("Dungeon_Coin", 59, 48, 38);
		setAsset("Coin", 60, 49, 38);
		setAsset("Coin", 61, 50, 38);
		setAsset("Coin", 62, 51, 38);
		setAsset("Coin", 63, 52, 38);
		
		setAsset("Coin", 64, 48, 37);
		setAsset("Dungeon_Coin", 65, 49, 37);
		setAsset("Coin", 66, 50, 37);
		setAsset("Dungeon_Coin", 67, 51, 37);
		setAsset("Coin", 68, 52, 37);
		
		setAsset("Coin", 69, 48, 36);
		setAsset("Coin", 70, 49, 36);
		setAsset("Dungeon_Coin", 71, 50, 36);
		setAsset("Coin", 72, 51, 36);
		setAsset("Coin", 73, 52, 36);
		
		setAsset("Dungeon_Coin", 74, 47, 35);
		setAsset("Coin", 75, 48, 35);
		setAsset("Diamond", 79, 52, 35);
		setAsset("Coin", 80, 53, 35);
		
		setAsset("Coin", 81, 46, 34);
		setAsset("Dungeon_Coin", 82, 47, 34);
		setAsset("Coin", 83, 48, 34);
		setAsset("Coin", 84, 52, 34);
		setAsset("Dungeon_Coin", 85, 53, 34);
		setAsset("Coin", 86, 54, 34);
		
		setAsset("Coin", 87, 46, 33);
		setAsset("Dungeon_Coin", 88, 47, 33);
		setAsset("Coin", 91, 53, 33);
		setAsset("Dungeon_Coin", 92, 54, 33);
		
		setAsset("Dungeon_Coin", 93, 46, 32);
		setAsset("Coin", 94, 47, 32);
		setAsset("Coin", 97, 53, 32);
		setAsset("Coin", 98, 54, 32);
		
		setAsset("Dungeon_Coin", 99, 46, 31);
		setAsset("Coin", 100, 47, 31);
		setAsset("Coin", 101, 53, 31);
		setAsset("Coin", 102, 54, 31);
		
		setAsset("Coin", 103, 46, 30);
		setAsset("Coin", 104, 47, 30);
		setAsset("Diamond", 105, 53, 30);
		setAsset("Coin", 106, 54, 30);
		
		setAsset("Dungeon_Coin", 107, 47, 29);
		setAsset("Coin", 108, 53, 29);
		
		setAsset("Chest_Final", 110, 56, 79, 32, 32);
		
		// NPCs
		setAsset("Guard_Friendly", 0, 50, 57);
		setAsset("Guard_Friendly", 1, 44, 56);
		setAsset("Guard_Friendly", 2, 55, 56);
		setAsset("Guard_Friendly", 3, 58, 52);
		setAsset("Guard_Friendly", 4, 43, 51);
		setAsset("Guard_Friendly", 5, 41, 44);
		setAsset("Guard_Friendly", 6, 57, 47);
		setAsset("Guard_Friendly", 7, 55, 43);
		setAsset("Guard_Friendly", 8, 58, 38);
		setAsset("Guard_Friendly", 9, 43, 39);
		setAsset("Guard_Friendly", 10, 41, 34);
		setAsset("Guard_Friendly", 11, 59, 33);
		setAsset("Guard_Friendly", 12, 58, 27);
		setAsset("Guard_Friendly", 13, 50, 25);
		setAsset("Guard_Friendly", 14, 43, 26);
		setAsset("Guard_Friendly", 15, 40, 29);
		
		setAsset("Guard_Friendly", 16, 50, 34);
		
		setAsset("Guard_Friendly", 17, 45, 80);
		setAsset("Guard_Friendly", 19, 49, 75);
		setAsset("Guard_Friendly", 20, 55, 73);
		setAsset("Guard_Friendly", 21, 63, 74);
		setAsset("Guard_Friendly", 22, 64, 80);
		setAsset("Guard_Friendly", 23, 63, 86);
		setAsset("Guard_Friendly", 24, 55, 87);
		setAsset("Guard_Friendly", 25, 49, 85);
		
		setAsset("Guard_Master", 26, 49, 30, 32, 32);
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
		case "Diamond":
			gp.obj[arrIndex] = new OBJ_Diamond(gp);
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
		case "Dungeon_Chest":
			gp.obj[arrIndex] = new OBJ_Dungeon_Chest(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize;
			break;
		case "Iron_Gate":
			gp.obj[arrIndex] = new OBJ_Iron_Gate(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize;
			break;
		case "Iron_Scrap":
			gp.obj[arrIndex] = new OBJ_Iron_Scrap(gp);
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
		case "Dungeon_Merchant":
			gp.npc[arrIndex] = new NPC_Dungeon_Merchant(gp);
			gp.npc[arrIndex].worldX = xPos * gp.tileSize;
			gp.npc[arrIndex].worldY = yPos * gp.tileSize;
			break;
		case "Guard":
			gp.npc[arrIndex] = new NPC_Guard(gp);
			gp.npc[arrIndex].worldX = xPos * gp.tileSize;
			gp.npc[arrIndex].worldY = yPos * gp.tileSize;
			break;
		case "Guard_Friendly":
			gp.npc[arrIndex] = new NPC_Guard_Friendly(gp);
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
		case "Skeleton_Purple":
			gp.monster[arrIndex] = new MON_Skeleton_Purple(gp);
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
		case "Diamond":
			gp.obj[arrIndex] = new OBJ_Diamond(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize + xOffset;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize + yOffset;
			break;
		case "Chest":
			gp.obj[arrIndex] = new OBJ_Chest(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize + xOffset;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize + yOffset;
			break;
		case "Chest_Final":
			gp.obj[arrIndex] = new OBJ_Chest_Final(gp);
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
		case "Dungeon_Chest":
			gp.obj[arrIndex] = new OBJ_Dungeon_Chest(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize + xOffset;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize + yOffset;
			break;
		case "Dungeon_Map":
			gp.obj[arrIndex] = new OBJ_Dungeon_Map(gp);
			gp.obj[arrIndex].worldX = xPos * gp.tileSize + xOffset;
			gp.obj[arrIndex].worldY = yPos * gp.tileSize + yOffset;
			break;
		case "Iron_Scrap":
			gp.obj[arrIndex] = new OBJ_Iron_Scrap(gp);
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
		case "Dungeon_Merchant":
			gp.npc[arrIndex] = new NPC_Dungeon_Merchant(gp);
			gp.npc[arrIndex].worldX = xPos * gp.tileSize + xOffset;
			gp.npc[arrIndex].worldY = yPos * gp.tileSize + yOffset;
			break;
		case "Guard_Master":
			gp.npc[arrIndex] = new NPC_Guard_Master(gp);
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

	/**
	 * Private helper that sets signs based on their name for the use of multiple
	 * dialogues for different signs.
	 * 
	 * @param nameOfSign - name of the sign for dialogue purposes
	 * @param arrIndex   - index of the object array to set the object
	 * @param xPos       - x position on map
	 * @param yPos       - y position on map
	 * @param xOffset    - x offset from tile
	 * @param yOffset    - y offset from tile
	 */
	private void setSign(String nameOfSign, int arrIndex, int xPos, int yPos, int xOffset, int yOffset) {
		gp.npc[arrIndex] = new OBJ_Sign(gp, nameOfSign);
		gp.npc[arrIndex].worldX = xPos * gp.tileSize + xOffset;
		gp.npc[arrIndex].worldY = yPos * gp.tileSize + yOffset;
	}
}