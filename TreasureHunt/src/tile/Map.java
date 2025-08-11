package tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;
import main.UtilityTool;

public class Map extends TileManager{

	private GamePanel gp;
	private BufferedImage worldMap[];
	public boolean miniMapOn;
	private UtilityTool uTool = new UtilityTool();
	
	public Map(GamePanel gp) {
		super(gp);
		this.gp = gp;
		createWorldMap();
	}
	
	public void createWorldMap() {
		worldMap = new BufferedImage[2];
		int worldMapWidth = gp.tileSize * gp.maxWorldCol;
		int worldMapHeight = gp.tileSize * gp.maxWorldRow;
		
		for (int i = 0; i < 2; i++) {
			worldMap[i] = new BufferedImage(worldMapWidth, worldMapHeight, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = (Graphics2D)worldMap[i].createGraphics();
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
	
	public void drawFullMapScreen(Graphics2D g2) {
		// Map
		int width = gp.tileSize * 3;
		int height = gp.tileSize * 3;
		int x = gp.tileSize * 12 + 48;
		int y = 16;
		uTool.changeAlpha(g2, 0.5f);
		g2.drawImage(worldMap[0], x, y, width, height, null);
		uTool.changeAlpha(g2, 1f);
		// Player
		double scale = (double)(gp.tileSize * gp.maxWorldCol)/width;
		int playerX = (int)(x + gp.player.worldX/scale);
		int playerY = (int)(y + gp.player.worldY/scale);
		int playerSize = (int)(gp.tileSize/8);
		g2.drawImage(gp.player.pointer, playerX - 3, playerY - 3, playerSize, playerSize, null);
	}
}
