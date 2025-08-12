package tile;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;
import main.UtilityTool;

public class Map extends TileManager {

	private GamePanel gp;
	private BufferedImage worldMap[];
	public boolean miniMapOn;
	private UtilityTool uTool = new UtilityTool();

	public Map(GamePanel gp) {
		super(gp);
		this.gp = gp;
		createWorldMap();
	}

	/**
	 * Creates the map image.
	 */
	public void createWorldMap() {
		worldMap = new BufferedImage[2];
		int worldMapWidth = gp.tileSize * gp.maxWorldCol;
		int worldMapHeight = gp.tileSize * gp.maxWorldRow;

		for (int i = 0; i < 2; i++) {
			worldMap[i] = new BufferedImage(worldMapWidth, worldMapHeight, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = (Graphics2D) worldMap[i].createGraphics();
			int col = 0;
			int row = 0;

			while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
				int tileNum = mapTileNum[col][row];
				int x = gp.tileSize * col;
				int y = gp.tileSize * row;
				g2.drawImage(tile[tileNum].image, x, y, null);
				col++;
				if (col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
		}
	}

	/**
	 * Draws the map in the corner of the screen at a lower opacity.
	 * 
	 * @param g2 - the graphics
	 */
	public void drawMapCornerScreen(Graphics2D g2) {
		// Map
		int width = gp.tileSize * 3;
		int height = gp.tileSize * 3;
		int x = gp.tileSize * 12 + 48;
		int y = 16;
		uTool.changeAlpha(g2, 0.5f);
		g2.drawImage(worldMap[0], x, y, width, height, null);
		uTool.changeAlpha(g2, 1f);
		// Player
		double scale = (double) (gp.tileSize * gp.maxWorldCol) / width;
		int playerX = (int) (x + gp.player.worldX / scale);
		int playerY = (int) (y + gp.player.worldY / scale);
		int playerSize = (int) (gp.tileSize / 8);
		g2.drawImage(gp.player.pointer, playerX - 3, playerY - 3, playerSize, playerSize, null);
		// Text
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 16F));
		g2.setColor(new Color(255, 255, 125));
		g2.drawString("Press m to toggle map view", gp.tileSize * 13, gp.tileSize * 3 + 32);
	}

	/**
	 * Draws the map full screen.
	 * 
	 * @param g2 - the graphics
	 */
	public void drawMapFullScreen(Graphics2D g2) {
		g2.setColor(Color.black);
		g2.fillRect(0, 0, gp.tileSize * 16, gp.tileSize * 12);
		// Map
		int width = gp.tileSize * 10;
		int height = gp.tileSize * 10;
		int x = gp.tileSize * 3;
		int y = gp.tileSize;
		g2.drawImage(worldMap[0], x, y, width, height, null);
		// Player
		double scale = (double) (gp.tileSize * gp.maxWorldCol) / width;
		int playerX = (int) (x + gp.player.worldX / scale);
		int playerY = (int) (y + gp.player.worldY / scale);
		int playerSize = (int) (gp.tileSize / 6);
		g2.drawImage(gp.player.pointer, playerX - 2, playerY - 1, playerSize, playerSize, null);
		// Text
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F));
		g2.setColor(new Color(255, 255, 125));
		g2.drawString("Monsters can still move while in map view!", gp.tileSize * 4, 48);
	}
}
