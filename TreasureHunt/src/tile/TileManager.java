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

		setTileImage();
		loadMap("/maps/world01.txt");
	}

	/**
	 * Sets each array element to a tile image.
	 */
	public void setTileImage() {
		// Grass and shrubbery
		setup(0, "grass", false);
		setup(1, "grass_red_flower", false);
		setup(2, "grass_yellow_flower", false);
		// Trail
		setup(3, "trail_0", false);
		setup(4, "trail_1", false);
		setup(5, "trail_10", false);
		setup(6, "trail_11", false);
		setup(7, "trail_12", false);
		setup(8, "trail_2", false);
		setup(9, "trail_3", false);
		setup(10, "trail_4", false);
		setup(11, "trail_5", false);
		setup(12, "trail_6", false);
		setup(13, "trail_7", false);
		setup(14, "trail_8", false);
		setup(15, "trail_9", false);
		// Tree
		setup(16, "tree", true);
		setup(17, "tree_stub", false);
		// Wall
		setup(18, "wall_0", true);
		// Water
		setup(19, "water_0", true);
		setup(20, "water_1", true);
		setup(21, "water_10", true);
		setup(22, "water_11", true);
		setup(23, "water_12", true);
		setup(24, "water_13", true);
		setup(25, "water_2", true);
		setup(26, "water_3", true);
		setup(27, "water_4", true);
		setup(28, "water_5", true);
		setup(29, "water_6", true);
		setup(30, "water_7", true);
		setup(31, "water_8", true);
		setup(32, "water_9", true);
		// Extras
		setup(33, "wooden_floor", false);
	}

	/**
	 * Sets up the tiles in the tile array by assigning an image as an index in the
	 * array and another parameter to decipher if the given tile has collisions.
	 * 
	 * @param index     - index in tile array
	 * @param imageName - name of the image
	 * @param collision - true if this is a collision tile
	 */
	public void setup(int index, String imageName, boolean collision) {
		UtilityTool uTool = new UtilityTool();
		try {
			tile[index] = new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imageName + ".png"));
			tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
			tile[index].collision = collision;
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
