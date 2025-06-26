package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Classed used to check the and update the health of the player.
 */
public class HealthSetter {

	private GamePanel gp;
	private UtilityTool uTool = new UtilityTool();
	public BufferedImage heartSlot1, heartSlot2, heartSlot3, heartSlot4, heartSlot5, heartSlot6, heartSlot7, heartSlot8,
			heartSlot9, heartSlot10, fullHeart, halfHeart, fullHeartYellow, halfHeartYellow, emptyHeart;
	public int extraHeartsDisplayed = 0;

	/**
	 * Constructs a HealthSetter.
	 * 
	 * @param gp - the game panel
	 */
	public HealthSetter(GamePanel gp) {
		this.gp = gp;
		// Construct health bar images
		fullHeart = null;
		halfHeart = null;
		emptyHeart = null;
		halfHeartYellow = null;
		fullHeartYellow = null;
		try {
			fullHeart = ImageIO.read(getClass().getResourceAsStream("/ui/full_heart.png"));
			halfHeart = ImageIO.read(getClass().getResourceAsStream("/ui/half_heart.png"));
			fullHeartYellow = ImageIO.read(getClass().getResourceAsStream("/ui/full_heart_yellow.png"));
			halfHeartYellow = ImageIO.read(getClass().getResourceAsStream("/ui/half_heart_yellow.png"));
			emptyHeart = ImageIO.read(getClass().getResourceAsStream("/ui/empty_heart.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		fullHeart = uTool.scaleImage(fullHeart, gp.tileSize - 16, gp.tileSize - 16);
		halfHeart = uTool.scaleImage(halfHeart, gp.tileSize - 16, gp.tileSize - 16);
		fullHeartYellow = uTool.scaleImage(fullHeartYellow, gp.tileSize - 16, gp.tileSize - 16);
		halfHeartYellow = uTool.scaleImage(halfHeartYellow, gp.tileSize - 16, gp.tileSize - 16);
		emptyHeart = uTool.scaleImage(emptyHeart, gp.tileSize - 16, gp.tileSize - 16);
	}

	/**
	 * Sets player health, calls the respective set health method to display on the
	 * UI.
	 * 
	 * @param g2 - graphics
	 */
	public void setHealth(Graphics2D g2) {
		if (gp.player.health > 20) {
			setHealth20(g2);
		}
		switch (gp.player.health) {
		case 20:
			setHealth20(g2);
			break;
		case 19:
			setHealth19(g2);
			break;
		case 18:
			setHealth18(g2);
			break;
		case 17:
			setHealth17(g2);
			break;
		case 16:
			setHealth16(g2);
			break;
		case 15:
			setHealth15(g2);
			break;
		case 14:
			setHealth14(g2);
			break;
		case 13:
			setHealth13(g2);
			break;
		case 12:
			setHealth12(g2);
			break;
		case 11:
			setHealth11(g2);
			break;
		case 10:
			setHealth10(g2);
			break;
		case 9:
			setHealth9(g2);
			break;
		case 8:
			setHealth8(g2);
			break;
		case 7:
			setHealth7(g2);
			break;
		case 6:
			setHealth6(g2);
			break;
		case 5:
			setHealth5(g2);
			break;
		case 4:
			setHealth4(g2);
			break;
		case 3:
			setHealth3(g2);
			break;
		case 2:
			setHealth2(g2);
			break;
		case 1:
			setHealth1(g2);
			break;
		}
	}

	/**
	 * Sets player health to 20 and displays it on the UI.
	 * 
	 * @param g2 - graphics
	 */
	public void setHealth20(Graphics2D g2) {
		heartSlot1 = fullHeart;
		heartSlot2 = fullHeart;
		heartSlot3 = fullHeart;
		heartSlot4 = fullHeart;
		heartSlot5 = fullHeart;
		heartSlot6 = fullHeartYellow;
		heartSlot7 = fullHeartYellow;
		heartSlot8 = fullHeartYellow;
		heartSlot9 = fullHeartYellow;
		heartSlot10 = fullHeartYellow;
		drawHealthBarExtended(g2);
	}

	/**
	 * Sets player health to 19 and displays it on the UI.
	 * 
	 * @param g2 - graphics
	 */
	public void setHealth19(Graphics2D g2) {
		heartSlot1 = fullHeart;
		heartSlot2 = fullHeart;
		heartSlot3 = fullHeart;
		heartSlot4 = fullHeart;
		heartSlot5 = fullHeart;
		heartSlot6 = fullHeartYellow;
		heartSlot7 = fullHeartYellow;
		heartSlot8 = fullHeartYellow;
		heartSlot9 = fullHeartYellow;
		heartSlot10 = halfHeartYellow;
		drawHealthBarExtended(g2);
	}

	/**
	 * Sets player health to 18 and displays it on the UI.
	 * 
	 * @param g2 - graphics
	 */
	public void setHealth18(Graphics2D g2) {
		heartSlot1 = fullHeart;
		heartSlot2 = fullHeart;
		heartSlot3 = fullHeart;
		heartSlot4 = fullHeart;
		heartSlot5 = fullHeart;
		heartSlot6 = fullHeartYellow;
		heartSlot7 = fullHeartYellow;
		heartSlot8 = fullHeartYellow;
		heartSlot9 = fullHeartYellow;
		heartSlot10 = null;
		drawHealthBarExtended(g2);
	}

	/**
	 * Sets player health to 17 and displays it on the UI.
	 * 
	 * @param g2 - graphics
	 */
	public void setHealth17(Graphics2D g2) {
		heartSlot1 = fullHeart;
		heartSlot2 = fullHeart;
		heartSlot3 = fullHeart;
		heartSlot4 = fullHeart;
		heartSlot5 = fullHeart;
		heartSlot6 = fullHeartYellow;
		heartSlot7 = fullHeartYellow;
		heartSlot8 = fullHeartYellow;
		heartSlot9 = halfHeartYellow;
		heartSlot10 = null;
		drawHealthBarExtended(g2);
	}

	/**
	 * Sets player health to 16 and displays it on the UI.
	 * 
	 * @param g2 - graphics
	 */
	public void setHealth16(Graphics2D g2) {
		heartSlot1 = fullHeart;
		heartSlot2 = fullHeart;
		heartSlot3 = fullHeart;
		heartSlot4 = fullHeart;
		heartSlot5 = fullHeart;
		heartSlot6 = fullHeartYellow;
		heartSlot7 = fullHeartYellow;
		heartSlot8 = fullHeartYellow;
		heartSlot9 = null;
		heartSlot10 = null;
		drawHealthBarExtended(g2);
	}

	/**
	 * Sets player health to 15 and displays it on the UI.
	 * 
	 * @param g2 - graphics
	 */
	public void setHealth15(Graphics2D g2) {
		heartSlot1 = fullHeart;
		heartSlot2 = fullHeart;
		heartSlot3 = fullHeart;
		heartSlot4 = fullHeart;
		heartSlot5 = fullHeart;
		heartSlot6 = fullHeartYellow;
		heartSlot7 = fullHeartYellow;
		heartSlot8 = halfHeartYellow;
		heartSlot9 = null;
		heartSlot10 = null;
		drawHealthBarExtended(g2);
	}

	/**
	 * Sets player health to 14 and displays it on the UI.
	 * 
	 * @param g2 - graphics
	 */
	public void setHealth14(Graphics2D g2) {
		heartSlot1 = fullHeart;
		heartSlot2 = fullHeart;
		heartSlot3 = fullHeart;
		heartSlot4 = fullHeart;
		heartSlot5 = fullHeart;
		heartSlot6 = fullHeartYellow;
		heartSlot7 = fullHeartYellow;
		heartSlot8 = null;
		heartSlot9 = null;
		heartSlot10 = null;
		drawHealthBarExtended(g2);
	}

	/**
	 * Sets player health to 13 and displays it on the UI.
	 * 
	 * @param g2 - graphics
	 */
	public void setHealth13(Graphics2D g2) {
		heartSlot1 = fullHeart;
		heartSlot2 = fullHeart;
		heartSlot3 = fullHeart;
		heartSlot4 = fullHeart;
		heartSlot5 = fullHeart;
		heartSlot6 = fullHeartYellow;
		heartSlot7 = halfHeartYellow;
		heartSlot8 = null;
		heartSlot9 = null;
		heartSlot10 = null;
		drawHealthBarExtended(g2);
	}

	/**
	 * Sets player health to 12 and displays it on the UI.
	 * 
	 * @param g2 - graphics
	 */
	public void setHealth12(Graphics2D g2) {
		heartSlot1 = fullHeart;
		heartSlot2 = fullHeart;
		heartSlot3 = fullHeart;
		heartSlot4 = fullHeart;
		heartSlot5 = fullHeart;
		heartSlot6 = fullHeartYellow;
		heartSlot7 = null;
		heartSlot8 = null;
		heartSlot9 = null;
		heartSlot10 = null;
		drawHealthBarExtended(g2);
	}

	/**
	 * Sets player health to 11 and displays it on the UI.
	 * 
	 * @param g2 - graphics
	 */
	public void setHealth11(Graphics2D g2) {
		heartSlot1 = fullHeart;
		heartSlot2 = fullHeart;
		heartSlot3 = fullHeart;
		heartSlot4 = fullHeart;
		heartSlot5 = fullHeart;
		heartSlot6 = halfHeartYellow;
		heartSlot7 = null;
		heartSlot8 = null;
		heartSlot9 = null;
		heartSlot10 = null;
		drawHealthBarExtended(g2);
	}

	/**
	 * Sets player health to 10 and displays it on the UI.
	 * 
	 * @param g2 - graphics
	 */
	public void setHealth10(Graphics2D g2) {
		heartSlot1 = fullHeart;
		heartSlot2 = fullHeart;
		heartSlot3 = fullHeart;
		heartSlot4 = fullHeart;
		heartSlot5 = fullHeart;
		heartSlot6 = null;
		heartSlot7 = null;
		heartSlot8 = null;
		heartSlot9 = null;
		heartSlot10 = null;
		if (extraHeartsDisplayed == 0) {
			drawHealthBar(g2);
		} else {
			drawHealthBarExtended(g2);
		}
	}

	/**
	 * Sets player health to 9 and displays it on the UI.
	 * 
	 * @param g2 - graphics
	 */
	public void setHealth9(Graphics2D g2) {
		heartSlot1 = fullHeart;
		heartSlot2 = fullHeart;
		heartSlot3 = fullHeart;
		heartSlot4 = fullHeart;
		heartSlot5 = halfHeart;
		heartSlot6 = null;
		heartSlot7 = null;
		heartSlot8 = null;
		heartSlot9 = null;
		heartSlot10 = null;
		if (extraHeartsDisplayed == 0) {
			drawHealthBar(g2);
		} else {
			drawHealthBarExtended(g2);
		}
	}

	/**
	 * Sets player health to 8 and displays it on the UI.
	 * 
	 * @param g2 - graphics
	 */
	public void setHealth8(Graphics2D g2) {
		heartSlot1 = fullHeart;
		heartSlot2 = fullHeart;
		heartSlot3 = fullHeart;
		heartSlot4 = fullHeart;
		heartSlot5 = emptyHeart;
		heartSlot6 = null;
		heartSlot7 = null;
		heartSlot8 = null;
		heartSlot9 = null;
		heartSlot10 = null;
		if (extraHeartsDisplayed == 0) {
			drawHealthBar(g2);
		} else {
			drawHealthBarExtended(g2);
		}
	}

	/**
	 * Sets player health to 7 and displays it on the UI.
	 * 
	 * @param g2 - graphics
	 */
	public void setHealth7(Graphics2D g2) {
		heartSlot1 = fullHeart;
		heartSlot2 = fullHeart;
		heartSlot3 = fullHeart;
		heartSlot4 = halfHeart;
		heartSlot5 = emptyHeart;
		heartSlot6 = null;
		heartSlot7 = null;
		heartSlot8 = null;
		heartSlot9 = null;
		heartSlot10 = null;
		if (extraHeartsDisplayed == 0) {
			drawHealthBar(g2);
		} else {
			drawHealthBarExtended(g2);
		}
	}

	/**
	 * Sets player health to 6 and displays it on the UI.
	 * 
	 * @param g2 - graphics
	 */
	public void setHealth6(Graphics2D g2) {
		heartSlot1 = fullHeart;
		heartSlot2 = fullHeart;
		heartSlot3 = fullHeart;
		heartSlot4 = emptyHeart;
		heartSlot5 = emptyHeart;
		heartSlot6 = null;
		heartSlot7 = null;
		heartSlot8 = null;
		heartSlot9 = null;
		heartSlot10 = null;
		if (extraHeartsDisplayed == 0) {
			drawHealthBar(g2);
		} else {
			drawHealthBarExtended(g2);
		}
	}

	/**
	 * Sets player health to 5 and displays it on the UI.
	 * 
	 * @param g2 - graphics
	 */
	public void setHealth5(Graphics2D g2) {
		heartSlot1 = fullHeart;
		heartSlot2 = fullHeart;
		heartSlot3 = halfHeart;
		heartSlot4 = emptyHeart;
		heartSlot5 = emptyHeart;
		heartSlot6 = null;
		heartSlot7 = null;
		heartSlot8 = null;
		heartSlot9 = null;
		heartSlot10 = null;
		if (extraHeartsDisplayed == 0) {
			drawHealthBar(g2);
		} else {
			drawHealthBarExtended(g2);
		}
	}

	/**
	 * Sets player health to 4 and displays it on the UI.
	 * 
	 * @param g2 - graphics
	 */
	public void setHealth4(Graphics2D g2) {
		heartSlot1 = fullHeart;
		heartSlot2 = fullHeart;
		heartSlot3 = emptyHeart;
		heartSlot4 = emptyHeart;
		heartSlot5 = emptyHeart;
		heartSlot6 = null;
		heartSlot7 = null;
		heartSlot8 = null;
		heartSlot9 = null;
		heartSlot10 = null;
		if (extraHeartsDisplayed == 0) {
			drawHealthBar(g2);
		} else {
			drawHealthBarExtended(g2);
		}
	}

	/**
	 * Sets player health to 3 and displays it on the UI.
	 * 
	 * @param g2 - graphics
	 */
	public void setHealth3(Graphics2D g2) {
		heartSlot1 = fullHeart;
		heartSlot2 = halfHeart;
		heartSlot3 = emptyHeart;
		heartSlot4 = emptyHeart;
		heartSlot5 = emptyHeart;
		heartSlot6 = null;
		heartSlot7 = null;
		heartSlot8 = null;
		heartSlot9 = null;
		heartSlot10 = null;
		if (extraHeartsDisplayed == 0) {
			drawHealthBar(g2);
		} else {
			drawHealthBarExtended(g2);
		}
	}

	/**
	 * Sets player health to 2 and displays it on the UI.
	 * 
	 * @param g2 - graphics
	 */
	public void setHealth2(Graphics2D g2) {
		heartSlot1 = fullHeart;
		heartSlot2 = emptyHeart;
		heartSlot3 = emptyHeart;
		heartSlot4 = emptyHeart;
		heartSlot5 = emptyHeart;
		heartSlot6 = null;
		heartSlot7 = null;
		heartSlot8 = null;
		heartSlot9 = null;
		heartSlot10 = null;
		if (extraHeartsDisplayed == 0) {
			drawHealthBar(g2);
		} else {
			drawHealthBarExtended(g2);
		}
	}

	/**
	 * Sets player health to 1 and displays it on the UI.
	 * 
	 * @param g2 - graphics
	 */
	public void setHealth1(Graphics2D g2) {
		heartSlot1 = halfHeart;
		heartSlot2 = emptyHeart;
		heartSlot3 = emptyHeart;
		heartSlot4 = emptyHeart;
		heartSlot5 = emptyHeart;
		heartSlot6 = null;
		heartSlot7 = null;
		heartSlot8 = null;
		heartSlot9 = null;
		heartSlot10 = null;
		if (extraHeartsDisplayed == 0) {
			drawHealthBar(g2);
		} else {
			drawHealthBarExtended(g2);
		}
	}

	/**
	 * Method that draws the health bar based on the current player's health.
	 * 
	 * @param g2 - graphics
	 */
	public void drawHealthBar(Graphics2D g2) {
		// Frame
		int frameX = gp.tileSize * 6 + 7;
		int frameY = 6;
		int frameWidth = gp.tileSize * 4 - 13;
		int frameHeight = gp.tileSize;
		gp.ui.drawSubWindow(frameX, frameY, frameWidth, frameHeight, g2);
		// Hearts
		g2.drawImage(heartSlot1, gp.tileSize * 5 + 48 + 31, 16, null);
		g2.drawImage(heartSlot2, gp.tileSize * 6 + 40 + 19, 16, null);
		g2.drawImage(heartSlot3, gp.tileSize * 7 + 39, 16, null);
		g2.drawImage(heartSlot4, gp.tileSize * 8 + 24 - 5, 16, null);
		g2.drawImage(heartSlot5, gp.tileSize * 9 + 16 - 17, 16, null);
	}

	/**
	 * Method that draws the health bar based on the current player's health for
	 * when the player's health is greater than 10.
	 * 
	 * @param g2 - graphics
	 */
	public void drawHealthBarExtended(Graphics2D g2) {
		// Frame
		int frameX = gp.tileSize * 6 + 7;
		int frameY = 6;
		int frameWidth = gp.tileSize * 4 - 13;
		int frameHeight = gp.tileSize * 2 - 16;
		gp.ui.drawSubWindow(frameX, frameY, frameWidth, frameHeight, g2);
		// Hearts
		g2.drawImage(heartSlot1, gp.tileSize * 5 + 48 + 31, 16, null);
		g2.drawImage(heartSlot2, gp.tileSize * 6 + 40 + 19, 16, null);
		g2.drawImage(heartSlot3, gp.tileSize * 7 + 39, 16, null);
		g2.drawImage(heartSlot4, gp.tileSize * 8 + 24 - 5, 16, null);
		g2.drawImage(heartSlot5, gp.tileSize * 9 + 16 - 17, 16, null);
		g2.drawImage(heartSlot6, gp.tileSize * 5 + 48 + 31, gp.tileSize, null);
		g2.drawImage(heartSlot7, gp.tileSize * 6 + 40 + 19, gp.tileSize, null);
		g2.drawImage(heartSlot8, gp.tileSize * 7 + 39, gp.tileSize, null);
		g2.drawImage(heartSlot9, gp.tileSize * 8 + 24 - 5, gp.tileSize, null);
		g2.drawImage(heartSlot10, gp.tileSize * 9 + 16 - 17, gp.tileSize, null);
	}

	/**
	 * Draws an empty heart on the screen to signify player max health for 1 extra heart.
	 * 
	 * @param g2 - graphics
	 */
	public void drawEmptyHeart1(Graphics2D g2) {
		g2.drawImage(emptyHeart, gp.tileSize * 5 + 48 + 31, gp.tileSize, null);
	}
	
	/**
	 * Draws an empty heart on the screen to signify player max health for 2 extra hearts.
	 * 
	 * @param g2 - graphics
	 */
	public void drawEmptyHeart2(Graphics2D g2) {
		g2.drawImage(emptyHeart, gp.tileSize * 5 + 48 + 31, gp.tileSize, null);
		g2.drawImage(emptyHeart, gp.tileSize * 6 + 40 + 19, gp.tileSize, null);
	}
	
	/**
	 * Draws an empty heart on the screen to signify player max health for 3 extra hearts.
	 * 
	 * @param g2 - graphics
	 */
	public void drawEmptyHeart3(Graphics2D g2) {
		g2.drawImage(emptyHeart, gp.tileSize * 5 + 48 + 31, gp.tileSize, null);
		g2.drawImage(emptyHeart, gp.tileSize * 6 + 40 + 19, gp.tileSize, null);
		g2.drawImage(emptyHeart, gp.tileSize * 7 + 39, gp.tileSize, null);
	}
	
	/**
	 * Draws an empty heart on the screen to signify player max health for 4 extra hearts.
	 * 
	 * @param g2 - graphics
	 */
	public void drawEmptyHeart4(Graphics2D g2) {
		g2.drawImage(emptyHeart, gp.tileSize * 5 + 48 + 31, gp.tileSize, null);
		g2.drawImage(emptyHeart, gp.tileSize * 6 + 40 + 19, gp.tileSize, null);
		g2.drawImage(emptyHeart, gp.tileSize * 7 + 39, gp.tileSize, null);
		g2.drawImage(emptyHeart, gp.tileSize * 8 + 24 - 5, gp.tileSize, null);
	}
	
	/**
	 * Draws an empty heart on the screen to signify player max health for 5 extra hearts.
	 * 
	 * @param g2 - graphics
	 */
	public void drawEmptyHeart5(Graphics2D g2) {
		g2.drawImage(emptyHeart, gp.tileSize * 5 + 48 + 31, gp.tileSize, null);
		g2.drawImage(emptyHeart, gp.tileSize * 6 + 40 + 19, gp.tileSize, null);
		g2.drawImage(emptyHeart, gp.tileSize * 7 + 39, gp.tileSize, null);
		g2.drawImage(emptyHeart, gp.tileSize * 8 + 24 - 5, gp.tileSize, null);
		g2.drawImage(emptyHeart, gp.tileSize * 9 + 16 - 17, gp.tileSize, null);
	}
}
