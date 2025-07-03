package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

/**
 * Class that sets an array of tiles, loads the tile map from a file, and draws
 * the tile map from the loaded file.
 */
public class TileManager {

	private GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];

	/**
	 * Constructs the tiles on the given map to load.
	 * 
	 * @param gp - the game panel
	 */
	public TileManager(GamePanel gp) {
		this.gp = gp;
		tile = new Tile[50];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

		loadMap("/maps/world01.txt");
	}

	/**
	 * Sets each array element to a tile image.
	 * 
	 * @param mapToLoad - the map to load
	 */
	public void setTileImage(String mapToLoad) {
		if (mapToLoad.equals("/maps/world01.txt")) {
			// Grass and shrubbery
			setup(0, "grass", false, true);
			setup(1, "grass_red_flower", false, true);
			setup(2, "grass_yellow_flower", false, true);
			// Trail
			setup(3, "trail_0", false, true);
			setup(4, "trail_1", false, true);
			setup(5, "trail_10", false, true);
			setup(6, "trail_11", false, true);
			setup(7, "trail_12", false, true);
			setup(8, "trail_2", false, true);
			setup(9, "trail_3", false, true);
			setup(10, "trail_4", false, true);
			setup(11, "trail_5", false, true);
			setup(12, "trail_6", false, true);
			setup(13, "trail_7", false, true);
			setup(14, "trail_8", false, true);
			setup(15, "trail_9", false, true);
			// Tree
			setup(16, "tree", true, false);
			setup(17, "tree_stub", false, true);
			// Wall
			setup(18, "wall_0", true, false);
			// Water (projectile can pass through)
			setup(19, "water_0", true, true);
			setup(20, "water_1", true, true);
			setup(21, "water_10", true, true);
			setup(22, "water_11", true, true);
			setup(23, "water_12", true, true);
			setup(24, "water_13", true, true);
			setup(25, "water_2", true, true);
			setup(26, "water_3", true, true);
			setup(27, "water_4", true, true);
			setup(28, "water_5", true, true);
			setup(29, "water_6", true, true);
			setup(30, "water_7", true, true);
			setup(31, "water_8", true, true);
			setup(32, "water_9", true, true);
			// Extras
			setup(33, "wooden_floor", false, true);
		} else if (mapToLoad.equals("/maps/dungeon.txt")) {
			setupDungeon(0, "dungeon_floor_0", false, true);
			setupDungeon(1, "dungeon_floor_1", false, true);
			setupDungeon(2, "dungeon_floor_2", false, true);
			setupDungeon(3, "dungeon_floor_3", false, true);
			setupDungeon(4, "dungeon_floor_4", false, true);
			setupDungeon(5, "dungeon_floor_5", false, true);
			setupDungeon(6, "dungeon_floor_6", false, true);
			setupDungeon(7, "dungeon_floor_7", false, true);
			setupDungeon(8, "dungeon_floor_8", false, true);
			setupDungeon(9, "dungeon_floor_9", false, true);
			setupDungeon(10, "void", false, true);
			setupDungeon(11, "wall_0", true, false);
		}
	}

	/**
	 * Sets up the tiles in the tile array by assigning an image as an index in the
	 * array and another parameter to decipher if the given tile has collisions.
	 * 
	 * @param index     - index in tile array
	 * @param imageName - name of the image
	 * @param collision - true if this is a collision tile
	 * @param projectileCanPassThrough - true if a projectile can pass through
	 */
	public void setup(int index, String imageName, boolean collision, boolean projectileCanPassThrough) {
		UtilityTool uTool = new UtilityTool();
		try {
			tile[index] = new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imageName + ".png"));
			tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
			tile[index].collision = collision;
			tile[index].projectileCanPassThrough = projectileCanPassThrough;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets up the tiles in the tile array by assigning an image as an index in the
	 * array and another parameter to decipher if the given tile has collisions.
	 * 
	 * @param index     - index in tile array
	 * @param imageName - name of the image
	 * @param collision - true if this is a collision tile
	 * @param projectileCanPassThrough - true if a projectile can pass through
	 */
	public void setupDungeon(int index, String imageName, boolean collision, boolean projectileCanPassThrough) {
		UtilityTool uTool = new UtilityTool();
		try {
			tile[index] = new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/dungeonTiles/" + imageName + ".png"));
			tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
			tile[index].collision = collision;
			tile[index].projectileCanPassThrough = projectileCanPassThrough;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads the map from the given file input.
	 * 
	 * @param filePath - given file input
	 */
	public void loadMap(String filePath) {
		setTileImage(filePath);
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			int col = 0;
			int row = 0;
			while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
				String line = br.readLine();
				while (col < gp.maxWorldCol) {
					String[] numbers = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					mapTileNum[col][row] = num;
					col++;
				}
				if (col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();
		} catch (Exception e) {
		}
	}

	/**
	 * Draws the map from the loaded file, filling the whole screen.
	 * 
	 * @param g2 - the graphics
	 */
	public void draw(Graphics2D g2) {
		int worldCol = 0;
		int worldRow = 0;
		while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			int tileNum = mapTileNum[worldCol][worldRow];
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX
					&& worldX - gp.tileSize < gp.player.worldX + gp.player.screenX
					&& worldY + gp.tileSize > gp.player.worldY - gp.player.screenY
					&& worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
				g2.drawImage(tile[tileNum].image, screenX, screenY, null);
			}
			worldCol++;
			if (worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;
			}
		}
	}

	/**
	 * Draws tilesDrawnFromCenter tiles around the center of the screen. Used to
	 * decrease draw time for lighting.
	 * 
	 * @param g2                   - the graphics
	 * @param tilesDrawnFromCenter - the number of tiles drawn from the center of
	 *                             the screen
	 */
	public void draw(Graphics2D g2, int tilesDrawnFromCenter) {
		int centerCol = gp.player.worldX / gp.tileSize;
		int centerRow = gp.player.worldY / gp.tileSize;

		for (int rowOffset = -tilesDrawnFromCenter; rowOffset <= tilesDrawnFromCenter + 1; rowOffset++) {
			for (int colOffset = -tilesDrawnFromCenter; colOffset <= tilesDrawnFromCenter + 1; colOffset++) {
				int worldCol = centerCol + colOffset;
				int worldRow = centerRow + rowOffset;

				// Ensure within valid map bounds
				if (worldCol >= 0 && worldCol < gp.maxWorldCol && worldRow >= 0 && worldRow < gp.maxWorldRow) {
					int tileNum = mapTileNum[worldCol][worldRow];
					int worldX = worldCol * gp.tileSize;
					int worldY = worldRow * gp.tileSize;
					int screenX = worldX - gp.player.worldX + gp.player.screenX;
					int screenY = worldY - gp.player.worldY + gp.player.screenY;

					g2.drawImage(tile[tileNum].image, screenX, screenY, null);
				}
			}
		}
	}
}
