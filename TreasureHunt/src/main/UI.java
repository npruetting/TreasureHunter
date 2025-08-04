package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import entity.Entity;
import object.OBJ_Lantern_Big;

/**
 * This class represents the user interface of the game, including the time
 * played, text, and messages that appear on screen.
 */
public class UI {

	private Graphics2D g2;
	private GamePanel gp;
	private Font marumonica;
	public ArrayList<String> messages = new ArrayList<String>();
	public ArrayList<Integer> messageCounter = new ArrayList<Integer>();
	public boolean gameCompleted;
	private double playTime;
	private DecimalFormat dFormat = new DecimalFormat("#0.00");
	public String currentDialogue = "";
	private UtilityTool uTool = new UtilityTool();
	private int spriteCounter;
	public boolean controlsMenuIsOpened;
	public int playerSlotCol = 0;
	public int playerSlotRow = 0;
	public int npcSlotCol = 0;
	public int npcSlotRow = 0;
	public boolean showTime = true;
	public boolean equippedMessage;
	public int equippedTimer;
	public int introEndTimer;
	public int menuFadeTimer;
	public int tradeTimer;
	public int tradeTimer2;
	public int tradeScrollTimer;
	public boolean introTransitionPhase;
	private boolean canPlaySE = true;
	public Entity npc;
	public int subState = 0;
	public int commandNum = 0;
	public boolean buyState, sellState;
	public boolean canDrawTradeText;
	private boolean isTrading;
	private int gameEndCounter, gameEndCounter2, gameEndCounter3, gameEndCounter4 = 0;
	public boolean canPressEnter;
	// UI Images
	private BufferedImage boyRight1, boyRight2, boyDown1, chest, oldManDown1, oldManDown2, shield, coin, dungeonCoin,
			tinyLantern, arrow, ironScrap, diamond;

	/**
	 * Constructor that sets the elements to be displayed on the screen.
	 * 
	 * @param gp - the game panel
	 */
	public UI(GamePanel gp) {
		this.gp = gp;
		try {
			InputStream is = getClass().getResourceAsStream("/font/MaruMonica.ttf");
			marumonica = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		renderImages();
	}

	/**
	 * Renders the images for the UI to decrease draw time.
	 */
	private void renderImages() {
		try {
			boyRight1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		boyRight1 = uTool.scaleImage(boyRight1, gp.tileSize * 4, gp.tileSize * 4);
		try {
			boyRight2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		boyRight2 = uTool.scaleImage(boyRight2, gp.tileSize * 4, gp.tileSize * 4);
		try {
			boyDown1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		boyDown1 = uTool.scaleImage(boyDown1, gp.tileSize * 2, gp.tileSize * 2);
		try {
			chest = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		chest = uTool.scaleImage(chest, gp.tileSize * 2 + 32, gp.tileSize * 2 + 32);
		try {
			oldManDown1 = ImageIO.read(getClass().getResourceAsStream("/npc/oldman_down_1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		oldManDown1 = uTool.scaleImage(oldManDown1, gp.tileSize * 4, gp.tileSize * 4);
		try {
			oldManDown2 = ImageIO.read(getClass().getResourceAsStream("/npc/oldman_down_2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		oldManDown2 = uTool.scaleImage(oldManDown2, gp.tileSize * 4, gp.tileSize * 4);
		try {
			shield = ImageIO.read(getClass().getResourceAsStream("/objects/shield_wood.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		shield = uTool.scaleImage(shield, gp.tileSize * 4, gp.tileSize * 4);
		try {
			coin = ImageIO.read(getClass().getResourceAsStream("/objects/coin.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		coin = uTool.scaleImage(coin, gp.tileSize - 16, gp.tileSize - 16);
		try {
			dungeonCoin = ImageIO.read(getClass().getResourceAsStream("/objects/dungeon_coin.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		dungeonCoin = uTool.scaleImage(dungeonCoin, gp.tileSize - 16, gp.tileSize - 16);
		try {
			tinyLantern = ImageIO.read(getClass().getResourceAsStream("/objects/lantern_tiny.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		tinyLantern = uTool.scaleImage(tinyLantern, gp.tileSize * 3, gp.tileSize * 3);
		try {
			arrow = ImageIO.read(getClass().getResourceAsStream("/objects/arrow.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		arrow = uTool.scaleImage(arrow, gp.tileSize, gp.tileSize);
		try {
			ironScrap = ImageIO.read(getClass().getResourceAsStream("/objects/iron_scrap.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ironScrap = uTool.scaleImage(ironScrap, gp.tileSize - 16, gp.tileSize - 16);
		try {
			diamond = ImageIO.read(getClass().getResourceAsStream("/objects/diamond.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		diamond = uTool.scaleImage(diamond, gp.tileSize - 16, gp.tileSize - 16);
	}

	/**
	 * This method is used to add a message from the specified text to the UI.
	 * 
	 * @param text - the message
	 */
	public void addMessage(String text) {
		messages.add(text);
		messageCounter.add(0);
	}

	/**
	 * Draws the UI components for the game. Each condition calls a separate method
	 * to display the correct components of the UI.
	 * 
	 * @param g2 - the graphics
	 */
	public void draw(Graphics2D g2) {
		this.g2 = g2;
		g2.setFont(marumonica);
		// If player dies
		if (gp.player.health < 1) {
			drawDeathScreen();
		}
		// For trading with NPC
		if (gp.tradeState) {
			drawTradeScreen();
		}
		// Drawn Continuously
		if (gp.gameStarted && !gameCompleted && !gp.gameEnded) {
			drawTime();
			drawMessages();
			if (!gp.levelUpState && !gp.dialogueState) {
				drawHealthBar();
			}
		}
		// Game menu
		if (!gp.gameStarted) {
			if (!controlsMenuIsOpened) {
				drawGameMenu();
			} else {
				drawControlsMenu();
			}
			if (gp.canShowGameIntro && gp.gameIntroCounter > 0) {
				drawIntroScene();
			}
		}
		// Game finished
		if (gameCompleted) {
			drawGameFinished();
		}
		// If the game is paused
		if (gp.isPaused && gp.gameStarted) {
			drawPausedState();
		}
		// If the character status is opened
		if (gp.isViewingStatus && gp.gameStarted && !gp.dialogueState) {
			drawCharacterStatus();
			drawInventory(gp.player, true);
		}
		// If world 2 is loaded
		if (gp.player.mapChangeTimer > 0) {
			drawCutscene();
		}
		// Dialogue state
		if (gp.dialogueState) {
			drawDialogueScreen();
		}
		// Level up state
		if (gp.levelUpState) {
			drawLevelUpScreen();
		}
	}

	/**
	 * Draws the intro state when the player first starts the game.
	 */
	public void drawIntroScene() {
		if (gp.introBreak) {
			introTransitionPhase = false;
			gp.introState = false;
			gp.gameIntroCounter = -1;
			gp.canShowGameIntro = false;
			gp.playMusic(0);
			gp.gameStarted = true;
			gp.finalGameStart = true;
			return;
		}
		menuFadeTimer++;
		int alpha = menuFadeTimer * 5;
		if (alpha > 255) {
			alpha = 255;
		}
		g2.setColor(new Color(0, 0, 0, alpha));
		g2.fillRect(0, 0, gp.tileSize * 16, gp.tileSize * 12);
		if (menuFadeTimer > 90) {
			// Text window
			int x = gp.tileSize * 2;
			int y = gp.tileSize / 2 + gp.tileSize - 24;
			int width = gp.screenWidth - (gp.tileSize * 4);
			int height = gp.tileSize * 5;
			drawSubWindow(x, y, width, height, g2);
			g2.setFont(g2.getFont().deriveFont(Font.ITALIC, 30F));
			x += gp.tileSize - 24;
			y += gp.tileSize;
			g2.drawString("Press enter to continue", x + gp.tileSize * 7 + 12, y + gp.tileSize * 4 - 20);
			g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40F));
			// Old man image
			if (spriteCounter < 60) {
				g2.drawImage(oldManDown1, gp.tileSize * 6, gp.tileSize * 6 + 32, null);
			} else {
				g2.drawImage(oldManDown2, gp.tileSize * 6, gp.tileSize * 6 + 32, null);
			}
			if (spriteCounter == 120) {
				spriteCounter = 0;
			}
			g2.setColor(new Color(255, 255, 125));
			// Intro screens
			Random rng = new Random();
			int npcTalk = rng.nextInt(9, 11);
			String text;
			x = gp.tileSize * 2 + 20;
			y = gp.tileSize * 2 - 8;
			if (gp.gameIntroCounter == 1) {
				text = "What do we have here? Looks like a new traveler\nis here searching for some treasure.\nHaha, well you've come to the right place! I think\nI could really use your help with something. . .";
				for (String line : text.split("\n")) {
					g2.drawString(line, x, y);
					y += 50;
				}
				if (canPlaySE) {
					gp.playSE(npcTalk);
					canPlaySE = false;
				}
			} else if (gp.gameIntroCounter == 2) {
				text = "I've been searching my whole life for a treasure\nthat many say is impossible to find. I've had some\nclose encounters with death myself in this area\nbecause of how dark it is, so make the best of\nwhat you can with your limited surroundings.";
				for (String line : text.split("\n")) {
					g2.drawString(line, x, y);
					y += 50;
				}
				if (!canPlaySE) {
					gp.playSE(npcTalk);
					canPlaySE = true;
				}
			} else if (gp.gameIntroCounter == 3) {
				text = "I'm giving you my wooden shield and tiny lantern\nto help with the start of your journey.\nGood luck youngin', and find yourself a weapon,\nor you'll be dead meat. . .";
				for (String line : text.split("\n")) {
					g2.drawString(line, x, y);
					y += 50;
				}
				g2.drawImage(shield, gp.tileSize * 9, gp.tileSize * 7, null);
				g2.drawImage(tinyLantern, gp.tileSize * 3 + 36, gp.tileSize * 7 + 40, null);
				if (canPlaySE) {
					gp.playSE(npcTalk);
					canPlaySE = false;
				}
			} else if (gp.gameIntroCounter == 4) {
				text = "I'm giving you my wooden shield and tiny lantern\nto help with the start of your journey.\nGood luck youngin', and find yourself a weapon,\nor you'll be dead meat. . .";
				for (String line : text.split("\n")) {
					g2.drawString(line, x, y);
					y += 50;
				}
				g2.drawImage(shield, gp.tileSize * 9, gp.tileSize * 7, null);
				g2.drawImage(tinyLantern, gp.tileSize * 3 + 36, gp.tileSize * 7 + 40, null);
				introTransitionPhase = true;
				int opacity = introEndTimer * 5;
				if (opacity > 255) {
					opacity = 255;
				}
				g2.setColor(new Color(0, 0, 0, opacity));
				g2.fillRect(0, 0, gp.tileSize * 16, gp.tileSize * 12);
				introEndTimer++;
				if (introEndTimer == 76) {
					gp.playSE(19);
				}
				if (introEndTimer > 80) {
					introTransitionPhase = false;
					gp.introState = false;
					gp.gameIntroCounter = -1;
					gp.canShowGameIntro = false;
					gp.playMusic(0);
					gp.gameStarted = true;
					gp.finalGameStart = true;
				}
			}
		}
	}

	/**
	 * Draws the time bar.
	 */
	public void drawTime() {
		// Time
		if (!gp.isPaused) {
			playTime += (double) 1 / 60;
		}
		if (showTime) {
			g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 60F));
			if (playTime < 10) {
				drawSubWindowLowOpacity(-gp.tileSize, gp.tileSize * 11, gp.tileSize * 5 - 32, gp.tileSize * 2, g2);
			} else if (playTime >= 10 && playTime < 100) {
				drawSubWindowLowOpacity(-gp.tileSize, gp.tileSize * 11, gp.tileSize * 5 - 8, gp.tileSize * 2, g2);
			} else if (playTime >= 100) {
				drawSubWindowLowOpacity(-gp.tileSize, gp.tileSize * 11, gp.tileSize * 5 + 16, gp.tileSize * 2, g2);
			}
			g2.setColor(new Color(255, 255, 255, 155));
			g2.drawString("Time: " + dFormat.format(playTime), 7, gp.tileSize * 12 - 6);
		}
	}

	/**
	 * Draws the health bar.
	 */
	public void drawHealthBar() {
		gp.hSetter.setHealth(g2);
		switch (gp.hSetter.extraHeartsDisplayed) {
		case 1:
			gp.hSetter.drawEmptyHeart1(g2);
			break;
		case 2:
			gp.hSetter.drawEmptyHeart2(g2);
			break;
		case 3:
			gp.hSetter.drawEmptyHeart3(g2);
			break;
		case 4:
			gp.hSetter.drawEmptyHeart4(g2);
			break;
		case 5:
			gp.hSetter.drawEmptyHeart5(g2);
			break;
		}
	}

	/**
	 * Used to draw messages that pop up.
	 */
	public void drawMessages() {
		int messageX = gp.tileSize - 32;
		int messageY = gp.tileSize - 8;
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 32F));
		for (int i = 0; i < messages.size(); i++) {
			if (messages.get(i) != null) {
				g2.setColor(Color.black);
				g2.drawString(messages.get(i), messageX + 2, messageY + 2);
				g2.setColor(Color.white);
				g2.drawString(messages.get(i), messageX, messageY);
				int counter = messageCounter.get(i) + 1;
				messageCounter.set(i, counter);
				messageY += 50;
				if (messageCounter.get(i) > 180) {
					messages.remove(i);
					messageCounter.remove(i);
				}
			}
		}
	}

	/**
	 * Draws the game finished screen when called in the draw method.
	 */
	public void drawGameFinished() {

		String text;
		int textLength;
		int x;
		int y;

		if (gameEndCounter > 255) {
			gameEndCounter = 255;
			gameEndCounter2++;
		}
		if (gameEndCounter2 > 255) {
			gameEndCounter2 = 255;
		}
		if (gameEndCounter3 > 1154) {
			gameEndCounter3 = 1154;
		}

		g2.setColor(new Color(0, 0, 0, gameEndCounter));
		gameEndCounter += 2;
		g2.fillRect(0, 0, gp.tileSize * 16, gp.tileSize * 12);

		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40F));
		g2.setColor(new Color(255, 255, 255, gameEndCounter2));

		text = "You found the treasure!";
		textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		x = gp.screenWidth / 2 - textLength / 2;
		y = gp.screenHeight / 2 - (gp.tileSize * 3);
		g2.drawString(text, x, y);

		text = "Your time is : " + dFormat.format(playTime) + "!";
		textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		x = gp.screenWidth / 2 - textLength / 2;
		y = gp.screenHeight / 2 + (gp.tileSize * 4);
		g2.drawString(text, x, y);

		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80F));
		g2.setColor(new Color(255, 255, 0, gameEndCounter2));
		text = "Congratulations!";
		textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		x = gp.screenWidth / 2 - textLength / 2;
		y = gp.screenHeight / 2 + (gp.tileSize * 2);
		g2.drawString(text, x, y);

		if (gameEndCounter2 > 0) {
			g2.drawImage(boyDown1, gp.tileSize * 7, gp.tileSize * 4, null);
			g2.setColor(new Color(0, 0, 0, 255 - gameEndCounter2));
			g2.fillRect(gp.tileSize * 7, gp.tileSize * 4, gp.tileSize * 2, gp.tileSize * 2);
			gameEndCounter3 += 2;
		}
		if (gameEndCounter3 > 900) {
			g2.setColor(new Color(0, 0, 0, gameEndCounter3 - 901));
			g2.fillRect(0, 0, gp.tileSize * 16, gp.tileSize * 12);
			gameEndCounter4++;
		}
		// Old Man Outro
		if (gameEndCounter4 > 200) {
			if (gameEndCounter4 == 201) {
				canPressEnter = true;
				canPlaySE = true;
			}
			// Text window
			int xOutro = gp.tileSize * 2;
			int yOutro = gp.tileSize / 2 + gp.tileSize - 24;
			int width = gp.screenWidth - (gp.tileSize * 4);
			int height = gp.tileSize * 5;
			drawSubWindow(xOutro, yOutro, width, height, g2);
			g2.setFont(g2.getFont().deriveFont(Font.ITALIC, 30F));
			x += gp.tileSize - 24;
			y += gp.tileSize;
			g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40F));
			// Old man image
			spriteCounter++;
			if (spriteCounter < 60) {
				g2.drawImage(oldManDown1, gp.tileSize * 6, gp.tileSize * 6 + 32, null);
			} else {
				g2.drawImage(oldManDown2, gp.tileSize * 6, gp.tileSize * 6 + 32, null);
			}
			if (spriteCounter == 120) {
				spriteCounter = 0;
			}
			g2.setColor(new Color(255, 255, 125));
			// Intro screens
			Random rng = new Random();
			int npcTalk = rng.nextInt(9, 11);
			String theText;
			x = gp.tileSize * 2 + 20;
			y = gp.tileSize * 2 - 8;
			if (gp.completedTextState == 0) {
				theText = "Look at yourself lad! You did it, you found the\ntreasure! Oh how proud of you I am, you\njust did something very few have ever\naccomplished.";
				for (String line : theText.split("\n")) {
					g2.drawString(line, x, y);
					y += 50;
				}
				if (canPlaySE) {
					gp.playSE(npcTalk);
					canPlaySE = false;
				}
			} else if (gp.completedTextState == 1) {
				theText = "From the journey of the dark overworld, with\nall those monsters trying to get you, to\nthe depths of the even darker dungeon, you\nstood your ground and never gave up!";
				for (String line : theText.split("\n")) {
					g2.drawString(line, x, y);
					y += 50;
				}
				if (!canPlaySE) {
					gp.playSE(npcTalk);
					canPlaySE = true;
				}
			} else if (gp.completedTextState == 2) {
				theText = "Thank you for playing my game and I hope you\nhad fun! A lot of time and effort was put into it,\nand I want to give a big shoutout to RyiSnow\non YouTube for the inspiration to start a project\nlike this. Your tutorials and inspiration made this\nproject as a whole. Signing off for now, GeoNate17.";
				for (String line : theText.split("\n")) {
					g2.drawString(line, x, y);
					y += 50;
				}
				if (canPlaySE) {
					gp.playSE(npcTalk);
					canPlaySE = false;
				}
			} else if (gp.completedTextState == 3) {
				System.exit(0);
			}
		}
	}

	/**
	 * Draws the game menu when called in the draw method.
	 */
	public void drawGameMenu() {
		// Title card
		if (!gp.finalGameStart) {
			g2.setColor(Color.BLACK);
		} else {
			g2.setColor(new Color(0, 0, 0, 240));
		}
		g2.fillRect(0, 0, gp.tileSize * 16, gp.tileSize * 12);
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 150F));
		g2.setColor(new Color(70, 70, 70));
		g2.drawString("Treasure Hunt", gp.tileSize * 2 - 10, gp.tileSize * 3 + 3);
		g2.setColor(new Color(100, 100, 100));
		g2.drawString("Treasure Hunt", gp.tileSize * 2 - 17, gp.tileSize * 3);
		// Images on menu
		spriteCounter++;
		if (spriteCounter < 45) {
			g2.drawImage(boyRight1, gp.tileSize * 4, gp.tileSize * 3 + 32, null);
		} else {
			g2.drawImage(boyRight2, gp.tileSize * 4, gp.tileSize * 3 + 32, null);
		}
		if (spriteCounter == 90) {
			spriteCounter = 0;
		}
		g2.drawImage(chest, gp.tileSize * 8, gp.tileSize * 5 - 6, null);
		// Menu tabs
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
		drawSubWindow(gp.tileSize * 6 + 32, gp.tileSize * 8, gp.tileSize * 3, gp.tileSize, g2);
		if (!gp.finalGameStart) {
			g2.drawString("Start", gp.tileSize * 7 + 24, gp.tileSize * 9 - 20);
		} else {
			g2.drawString("Resume", gp.tileSize * 7, gp.tileSize * 9 - 20);
		}
		drawSubWindow(gp.tileSize * 6 + 32, gp.tileSize * 10 + 24, gp.tileSize * 3, gp.tileSize, g2);
		g2.drawString("Exit", gp.tileSize * 8 - 30, gp.tileSize * 11 + 5);
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 32F));
		drawSubWindow(gp.tileSize * 6 + 32, gp.tileSize * 9 + 12, gp.tileSize * 3, gp.tileSize, g2);
		g2.drawString("Controls", gp.tileSize * 7 + 14, gp.tileSize * 10 - 10);
		// Menu instructions
		drawSubWindow(gp.tileSize * 11 - 14, gp.tileSize * 10, gp.tileSize * 6, gp.tileSize * 3, g2);
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
		g2.drawString("Select an option by pressing          ", gp.tileSize * 11 + 13, gp.tileSize * 10 + 40);
		g2.drawString("Use     and    to toggle selections", gp.tileSize * 11 + 21, gp.tileSize * 11 + 8);
		g2.drawString("Good luck and have fun!", gp.tileSize * 12 - 12, gp.tileSize * 11 + 40);
		g2.setColor(Color.YELLOW);
		g2.drawString("enter", gp.tileSize * 15, gp.tileSize * 10 + 40);
		g2.drawString("w        s", gp.tileSize * 12 - 8, gp.tileSize * 11 + 8);
		// Cursor
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
		if (gp.menuState == 0 || gp.menuState == 3) {
			g2.drawString(">", gp.tileSize * 6 + 12, gp.tileSize * 9 - 20);
		} else if (gp.menuState == 1) {
			g2.drawString(">", gp.tileSize * 6 + 12, gp.tileSize * 10 - 8);
		} else if (gp.menuState == 2 || gp.menuState == -1) {
			g2.drawString(">", gp.tileSize * 6 + 12, gp.tileSize * 11 + 6);
		}
		// Volume control
		// TODO temp volume UI in menu
		g2.drawString("Volume: " + 100, gp.tileSize, gp.tileSize);
	}

	/**
	 * Draws the game control menu if the user presses c in the menu.
	 */
	public void drawControlsMenu() {
		if (!gp.finalGameStart) {
			g2.setColor(Color.BLACK);
		} else {
			g2.setColor(new Color(0, 0, 0, 240));
		}
		g2.fillRect(0, 0, gp.tileSize * 16, gp.tileSize * 12);
		drawSubWindow(gp.tileSize - 32, gp.tileSize - 32, gp.tileSize * 15, gp.tileSize * 11, g2);
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
		// Row 1 white
		g2.drawString("Press     to", gp.tileSize, gp.tileSize + 40);
		g2.drawString("Press    to", gp.tileSize, gp.tileSize * 3 + 8);
		g2.drawString("Press    to", gp.tileSize, gp.tileSize * 4 + 40);
		g2.drawString("Press    to", gp.tileSize, gp.tileSize * 6 + 8);
		g2.drawString("Press           to", gp.tileSize, gp.tileSize * 7 + 40);
		g2.drawString("Press          to", gp.tileSize, gp.tileSize * 9 + 8);
		g2.drawString("Press    to", gp.tileSize, gp.tileSize * 10 + 40);
		// Row 2 white
		g2.drawString("Press   to", gp.tileSize * 7, gp.tileSize + 40);
		g2.setColor(Color.YELLOW);
		// Row 1 yellow
		g2.drawString("w     move up", gp.tileSize * 2 + 32, gp.tileSize + 40);
		g2.drawString("a     move left", gp.tileSize * 2 + 32, gp.tileSize * 3 + 8);
		g2.drawString("s     move down", gp.tileSize * 2 + 32, gp.tileSize * 4 + 40);
		g2.drawString("d     move right", gp.tileSize * 2 + 32, gp.tileSize * 6 + 8);
		g2.drawString("space     pause game", gp.tileSize * 2 + 32, gp.tileSize * 7 + 40);
		g2.drawString("enter     attack", gp.tileSize * 2 + 32, gp.tileSize * 9 + 8);
		g2.drawString("e     open character status", gp.tileSize * 2 + 32, gp.tileSize * 10 + 40);
		// Row 2 yellow
		g2.drawString("t     toggle time on and off", gp.tileSize * 8 + 32, gp.tileSize + 40);
		// c to exit controls text
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
		g2.drawString("enter", gp.tileSize * 7 - 10, gp.tileSize - 36);
		g2.setColor(Color.white);
		g2.drawString("Press            to exit game controls", gp.tileSize * 6, gp.tileSize - 36);
	}

	/**
	 * Draws the paused game state when called in the draw method.
	 */
	public void drawPausedState() {
		g2.setColor(new Color(0, 0, 0, 200));
		drawSubWindow(gp.tileSize * 6 - 32, gp.tileSize * 5 - 24, gp.tileSize * 5, gp.tileSize * 2, g2);
		drawSubWindow(gp.tileSize * 7, gp.tileSize * 7, gp.tileSize * 2, gp.tileSize * 1, g2);
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
		g2.setColor(Color.white);
		String text = "Paused";
		int textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth / 2 - textLength / 2;
		int y = gp.screenHeight / 2;
		g2.drawString(text, x, y);
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 24F));
		g2.drawString("esc to menu", x + gp.tileSize - 18, y + gp.tileSize + 38);
	}

	/**
	 * Draws the character status when opened with e.
	 */
	public void drawCharacterStatus() {
		drawSubWindow(gp.tileSize - 32, gp.tileSize, gp.tileSize * 5 + 32, gp.tileSize * 10, g2);
		g2.setColor(Color.white);
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 45F));
		// Stat names
		g2.drawString("Level", gp.tileSize - 12, gp.tileSize * 2);
		g2.drawString("Health", gp.tileSize - 12, gp.tileSize * 2 + 50);
		g2.drawString("Strength", gp.tileSize - 12, gp.tileSize * 2 + 100);
		g2.drawString("Dexterity", gp.tileSize - 12, gp.tileSize * 2 + 150);
		g2.drawString("Attack", gp.tileSize - 12, gp.tileSize * 2 + 200);
		g2.drawString("Defense", gp.tileSize - 12, gp.tileSize * 2 + 250);
		g2.drawString("Exp", gp.tileSize - 12, gp.tileSize * 2 + 300);
		g2.drawString("Next Level", gp.tileSize - 12, gp.tileSize * 2 + 350);
		g2.drawString("Currency", gp.tileSize - 12, gp.tileSize * 2 + 400);
		g2.drawString("Weapon", gp.tileSize - 12, gp.tileSize * 2 + 468);
		g2.drawString("Shield", gp.tileSize - 12, gp.tileSize * 2 + 536);
		// Stat values
		BufferedImage image = null;
		g2.drawString(gp.player.level + "", gp.tileSize * 5, gp.tileSize * 2);
		g2.drawString(gp.player.health + "/" + gp.player.maxHealth, gp.tileSize * 4, gp.tileSize * 2 + 50);
		g2.drawString(gp.player.strength + "", gp.tileSize * 5, gp.tileSize * 2 + 100);
		g2.drawString(gp.player.dexterity + "", gp.tileSize * 5, gp.tileSize * 2 + 150);
		g2.drawString(gp.player.attack + "", gp.tileSize * 5, gp.tileSize * 2 + 200);
		g2.drawString(gp.player.defense + "", gp.tileSize * 5, gp.tileSize * 2 + 250);
		g2.drawString(gp.player.exp + "", gp.tileSize * 5, gp.tileSize * 2 + 300);
		g2.drawString(gp.player.nextLevelExp + "", gp.tileSize * 5, gp.tileSize * 2 + 350);
		// Currency
		g2.drawImage(coin, gp.tileSize * 5, gp.tileSize + 484 - gp.tileSize, null);
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 30F));
		g2.setColor(new Color(255, 200, 255));
		g2.drawString(gp.player.coin + "", gp.tileSize * 5 + 20, gp.tileSize * 2 + 416);
		if (gp.player.dungeonCoin > 0) {
			g2.drawImage(dungeonCoin, gp.tileSize * 4 + 12, gp.tileSize + 484 - gp.tileSize, null);
			g2.drawString(gp.player.dungeonCoin + "", gp.tileSize * 4 + 32, gp.tileSize * 2 + 416);
		}
		if (gp.player.ironScrapAmount > 0) {
			g2.drawImage(ironScrap, gp.tileSize * 4 - 40, gp.tileSize + 484 - gp.tileSize, null);
			g2.drawString(gp.player.ironScrapAmount + "", gp.tileSize * 4 - 6, gp.tileSize * 2 + 416);
		}
		// Weapon / shield
		try {
			if (gp.player.currentWeapon != null) {
				image = ImageIO
						.read(getClass().getResourceAsStream("/objects/" + gp.player.currentWeapon.name + ".png"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (gp.player.currentWeapon != null) {
			image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
			g2.drawImage(image, gp.tileSize * 5 - 32, gp.tileSize + 484, null);

			if (gp.player.currentWeapon.type == gp.player.type_bow) {
				g2.drawImage(arrow, gp.tileSize * 4 - 32, gp.tileSize + 484, null);
				g2.setColor(new Color(255, 200, 255));
				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 24F));
				g2.drawString(gp.player.arrowAmount + "", gp.tileSize * 4 + 8, gp.tileSize + 504);
			}
		}
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/" + gp.player.currentShield.name + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		g2.drawImage(image, gp.tileSize * 5 - 32, gp.tileSize + 484 + gp.tileSize, null);
	}

	/**
	 * Draws the entity inventory.
	 * 
	 * @param entity - entity's inventory to draw
	 * @param cursor - cursor for the entity's inventory
	 */
	public void drawInventory(Entity entity, boolean cursor) {
		// Frame
		int frameX = 0;
		int frameY = 0;
		int frameWidth = 0;
		int frameHeight = 0;
		int slotCol = 0;
		int slotRow = 0;
		if (entity == gp.player) {
			frameX = gp.tileSize * 10;
			frameY = gp.tileSize;
			frameWidth = gp.tileSize * 5 - 24;
			frameHeight = gp.tileSize * 6 - 24;
			slotCol = playerSlotCol;
			slotRow = playerSlotRow;
			drawSubWindow(frameX, frameY - gp.tileSize + 12, frameWidth, gp.tileSize - 12, g2);
			g2.setColor(new Color(255, 255, 125));
			g2.setFont(g2.getFont().deriveFont(Font.ITALIC, 36F));
			g2.drawString("Player Inventory", frameX + gp.tileSize - 22, frameY - 14);
		} else {
			frameX = gp.tileSize + 18;
			frameY = gp.tileSize;
			frameWidth = gp.tileSize * 5 - 24;
			frameHeight = gp.tileSize * 6 - 24;
			slotCol = npcSlotCol;
			slotRow = npcSlotRow;
			drawSubWindow(frameX, frameY - gp.tileSize + 12, frameWidth, gp.tileSize - 12, g2);
			g2.setColor(new Color(200, 0, 0));
			g2.setFont(g2.getFont().deriveFont(Font.ITALIC, 36F));
			g2.drawString("Trader Inventory", frameX + gp.tileSize - 22, frameY - 14);
		}
		drawSubWindow(frameX, frameY, frameWidth, frameHeight, g2);
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 45F));
		// Slot
		final int slotXstart = frameX + 20;
		final int slotYstart = frameY + 20;
		int slotX = slotXstart;
		int slotY = slotYstart;
		// Draw player's items
		if (entity == gp.player) {
			g2.setColor(new Color(240, 20, 240, 150));
			g2.fillRoundRect(slotX, slotY, gp.tileSize, gp.tileSize, 10, 10);
		}
		for (int i = 0; i < entity.inventory.size(); i++) {
			// Draw currently equipped items
			if (entity.inventory.get(i) == entity.currentWeapon || entity.inventory.get(i) == entity.currentShield) {
				g2.setColor(new Color(240, 190, 90));
				g2.fillRoundRect(slotX, slotY, gp.tileSize, gp.tileSize, 10, 10);
			}
			g2.drawImage(entity.inventory.get(i).down1, slotX, slotY, null);
			slotX += gp.tileSize;
			if (i == 3 || i == 7 || i == 11 || i == 15) {
				slotX = slotXstart;
				slotY += gp.tileSize;
			}
		}
		// Cursor
		if (cursor) {
			int cursorX = slotXstart + (gp.tileSize * slotCol);
			int cursorY = slotYstart + (gp.tileSize * slotRow);
			int cursorWidth = gp.tileSize;
			int cursorHeight = gp.tileSize;
			// Draw cursor
			g2.setColor(Color.white);
			g2.setStroke(new BasicStroke(3));
			g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 10, 10);

			// Description frame
			int dFrameX = frameX;
			int dFrameY = frameY + frameHeight + gp.tileSize - 32;
			int dFrameWidth = frameWidth;
			int dFrameHeight = gp.tileSize * 3;
			// Description text
			int textX = dFrameX + 20;
			int textY = dFrameY + gp.tileSize - 24;
			g2.setFont(g2.getFont().deriveFont(28F));
			int itemIndex = getItemIndexOnSlot(slotCol, slotRow);
			if (itemIndex < entity.inventory.size()) {
				drawSubWindow(dFrameX, dFrameY, dFrameWidth, dFrameHeight, g2);
				for (String line : entity.inventory.get(itemIndex).description.split("\n")) {
					g2.drawString(line, textX, textY);
					textY += 32;
				}
			}
			// Equipped message pop-up
			if (equippedMessage) {
				equippedTimer++;
				drawEquipped();
			}
			if (equippedTimer > 45) {
				equippedMessage = false;
			}
		}
	}

	/**
	 * Draws an equipped window pop-up when a weapon or shield is equipped.
	 */
	public void drawEquipped() {
		// Frame
		int frameX;
		int frameY;
		int frameWidth;
		int frameHeight;
		if (gp.player.health <= 10) {
			frameX = gp.tileSize * 6 + 17;
			frameY = gp.tileSize + 12;
			frameWidth = gp.tileSize * 4 - 33;
			frameHeight = gp.tileSize;
		} else {
			frameX = gp.tileSize * 6 + 17;
			frameY = gp.tileSize * 2 - 4;
			frameWidth = gp.tileSize * 4 - 33;
			frameHeight = gp.tileSize;
		}
		drawSubWindow(frameX, frameY, frameWidth, frameHeight, g2);
		// Text
		g2.setColor(Color.white);
		g2.setFont(g2.getFont().deriveFont(Font.ITALIC, 32F));
		g2.drawString("Item Equipped!", frameX + 26, frameY + 42);
	}

	/**
	 * Returns the item index which the cursor is hovering over in the inventory.
	 * 
	 * @param slotCol - the current slot col
	 * @param slotRow - the current slot row
	 * @return the item index
	 */
	public int getItemIndexOnSlot(int slotCol, int slotRow) {
		return slotCol + (slotRow * 4);
	}

	/**
	 * Draws cutscenes when called in the draw method.
	 */
	public void drawCutscene() {
		if (gp.isPaused) {
			gp.isPaused = false;
		}
		int colorSet = gp.player.mapChangeTimer - 40;
		if (colorSet < 0) {
			colorSet = 0;
		}
		g2.setColor(new Color(colorSet, colorSet, colorSet, gp.player.alphaValue));
		g2.fillRect(0, 0, gp.tileSize * 16, gp.tileSize * 12);
		g2.setColor(Color.WHITE);
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60F));
		if (gp.player.alphaValue > 0) {
			g2.setColor(new Color(255, 255, 255, gp.player.alphaValue));
		} else {
			g2.setColor(new Color(255, 255, 255, 0));
		}
		switch (gp.transitionState) {
		case 1:
			g2.drawString("? ? ?", gp.tileSize * 7, gp.tileSize * 6 + 12);
			break;
		case 2:
			g2.drawString("Leaving the Secret Island", gp.tileSize * 3 + 32, gp.tileSize * 6 + 12);
			break;
		case 3:
			g2.drawString("Entering the Dungeon", gp.tileSize * 4 + 30, gp.tileSize * 6 + 12);
			break;
		case 4:
			g2.drawString("Entering Battle", gp.tileSize * 5 + 6, gp.tileSize * 6 + 12);
			break;
		case 5:
			g2.drawString("Leaving Battle", gp.tileSize * 5 + 6, gp.tileSize * 6 + 12);
			break;
		}
	}

	/**
	 * Draws the dialogue screen when called in the draw method.
	 */
	public void drawDialogueScreen() {
		// Dialogue window
		if (!buyState && !sellState) {
			int x = gp.tileSize * 2;
			int y = gp.tileSize / 2 + gp.tileSize - 24;
			int width = gp.screenWidth - (gp.tileSize * 4);
			int height = gp.tileSize * 4;
			drawSubWindow(x, y, width, height, g2);
			g2.setFont(g2.getFont().deriveFont(Font.ITALIC, 30F));
			x += gp.tileSize - 24;
			y += gp.tileSize;
			if (!gp.tradeState) {
				g2.drawString("Press e to continue", x + gp.tileSize * 7 + 60, y + gp.tileSize * 3 - 20);
			}
			g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40F));
			g2.setColor(new Color(255, 255, 125));
			// Splits long text at \n
			for (String line : currentDialogue.split("\n")) {
				g2.drawString(line, x, y);
				y += 50;
			}
		}
	}

	/**
	 * Draws the level up screen once the player levels up.
	 */
	public void drawLevelUpScreen() {
		// Level up window
		int x = gp.tileSize * 2;
		int y = gp.tileSize / 2 + gp.tileSize - 24;
		int width = gp.screenWidth - (gp.tileSize * 4);
		int height = gp.tileSize * 4;
		drawSubWindow(x, y, width, height, g2);
		g2.setFont(g2.getFont().deriveFont(Font.ITALIC, 30F));
		x += gp.tileSize - 24;
		y += gp.tileSize;
		g2.drawString("Press e to escape", x + gp.tileSize * 8 + 6, y + gp.tileSize * 3 - 20);
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 50F));
		g2.setColor(Color.yellow);
		g2.drawString("Leveled Up!", x + gp.tileSize * 4 - 20, y);
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40F));
		g2.setColor(new Color(255, 255, 125));
		g2.drawString("Extra heart + health restored", x, y + 40);
		g2.drawString("Strength + 1", x, y + 30 + gp.tileSize);
		g2.drawString("Dexterity + 1", x, y + 20 + gp.tileSize * 2);
	}

	/**
	 * Drawn if the player dies.
	 */
	public void drawDeathScreen() {
		// Game over sound
		if (!gp.gameEnded) {
			gp.playSE(7);
			gp.playSE(8);
		}
		gp.gameEnded = true;
		gp.stopMusic();
		gp.isViewingStatus = false;
		gp.levelUpState = false;
		// UI
		g2.setColor(new Color(0, 0, 0, 240));
		g2.fillRect(0, 0, gp.tileSize * 16, gp.tileSize * 12);
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 150F));
		g2.setColor(new Color(70, 70, 70));
		g2.drawString("Game Over", gp.tileSize * 3 + 28, gp.tileSize * 3 + 3);
		g2.setColor(new Color(100, 100, 100));
		g2.drawString("Game Over", gp.tileSize * 3 + 21, gp.tileSize * 3);
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
		// Menu tabs
		drawSubWindow(gp.tileSize * 6 + 32, gp.tileSize * 8, gp.tileSize * 3, gp.tileSize, g2);
		g2.drawString("Respawn", gp.tileSize * 7 - 6, gp.tileSize * 9 - 20);
		drawSubWindow(gp.tileSize * 6 + 32, gp.tileSize * 9 + 12, gp.tileSize * 3, gp.tileSize, g2);
		g2.drawString("Exit", gp.tileSize * 8 - 30, gp.tileSize * 10 - 6);
		// Cursor
		g2.setColor(Color.YELLOW);
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
		if (gp.menuState == 2 || gp.menuState == 0) {
			g2.drawString(">", gp.tileSize * 6 + 12, gp.tileSize * 9 - 20);
		} else if (gp.menuState == -1 || gp.menuState == 1) {
			g2.drawString(">", gp.tileSize * 6 + 12, gp.tileSize * 10 - 8);
		}
		// Text
		int x = gp.tileSize * 2;
		int y = gp.tileSize / 2 + gp.tileSize * 3;
		int width = gp.screenWidth - (gp.tileSize * 4);
		int height = gp.tileSize * 4;
		drawSubWindow(x, y, width, height, g2);
		x += gp.tileSize - 24;
		y += gp.tileSize;
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40F));
		g2.setColor(new Color(255, 255, 125));
		String text = "Respawning will take you back to the initial\nmap spawn. You keep all of your inventory\nitems, though you will lose half of your coins.\nHealth restored depends on your current level.";
		for (String line : text.split("\n")) {
			g2.drawString(line, x, y);
			y += 50;
		}
	}

	/**
	 * Screen drawn when trading with NPCs.
	 */
	public void drawTradeScreen() {
		if (!isTrading) {
			if (!gp.player.isInDungeon) {
				gp.stopMusic();
				gp.playMusic(24);
			} else {
				gp.stopMusic();
				gp.playMusic(22);
			}
			isTrading = true;
		}
		tradeScrollTimer++;
		switch (subState) {
		case 0:
			trade_select();
			break;
		case 1:
			trade_buy();
			buyState = true;
			break;
		case 2:
			trade_sell();
			sellState = true;
			break;
		}
	}

	/**
	 * Method that draws the trade select option screen.
	 */
	public void trade_select() {
		// Window
		int x = gp.tileSize * 6 + 28;
		int y = gp.tileSize * 8;
		int width = gp.tileSize * 3;
		int height = gp.tileSize * 3;
		drawSubWindow(x, y, width, height, g2);
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40F));
		// Draw text
		x += gp.tileSize;
		y += gp.tileSize - 8;
		g2.drawString("Buy", x, y);
		if (commandNum == 0) {
			g2.drawString(">", x - 24, y);
			if (gp.keyH.enterPressed) {
				subState = 1;
			}
		}
		y += gp.tileSize - 12;

		g2.drawString("Sell", x, y);
		if (commandNum == 1) {
			g2.drawString(">", x - 24, y);
			if (gp.keyH.enterPressed) {
				subState = 2;
			}
		}
		y += gp.tileSize - 12;

		g2.drawString("Leave", x, y);
		if (commandNum == 2) {
			g2.drawString(">", x - 24, y);
			if (gp.keyH.enterPressed) {
				commandNum = 0;
				if (!gp.player.isInDungeon) {
					currentDialogue = "I'm not going anywhere. . .";
					gp.stopMusic();
					gp.playMusic(0);
				} else {
					currentDialogue = "This dungeon is a little hard to navigate. . .\nGo get me some iron scrap!";
					gp.stopMusic();
					gp.playMusic(21);
				}
				isTrading = false;
				gp.tradeState = false;
				tradeScrollTimer = 0;
			}
		}
	}

	/**
	 * Method that draws the trade buy screen.
	 */
	public void trade_buy() {
		tradeTimer++;
		drawTradeText("Invalid purchase!");
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F));
		// Draw player inventory
		drawInventory(gp.player, false);
		// Draw NPC inventory
		drawInventory(npc, true);
		// Hint window
		int x = gp.tileSize * 6 - 3;
		int y = gp.tileSize;
		int width = gp.tileSize * 4;
		int height = gp.tileSize;
		drawSubWindow(x, y, width, height, g2);
		g2.drawString("Press ESC to go back", x + 24, y + 42);
		// Coin window
		y += gp.tileSize;
		drawSubWindow(x, y, width, height, g2);
		g2.drawImage(coin, x + 20, y + 8, null);
		if (gp.player.dungeonCoin > 0) {
			g2.drawImage(dungeonCoin, x + gp.tileSize + 36, y + 8, null);
		}
		if (gp.player.ironScrapAmount > 0) {
			g2.drawImage(ironScrap, x + gp.tileSize * 2 + 44, y + 8, null);
		}
		x += gp.tileSize * 2;
		y += gp.tileSize - 20;
		g2.setColor(Color.yellow);
		g2.drawString(gp.player.coin + "", x - gp.tileSize, y - 1);
		if (gp.player.dungeonCoin > 0) {
			g2.drawString(gp.player.dungeonCoin + "", x + 16, y - 1);
		}
		if (gp.player.ironScrapAmount > 0) {
			g2.drawString(gp.player.ironScrapAmount + "", x + gp.tileSize + 16, y - 1);
		}
		// Price window
		int itemIndex = getItemIndexOnSlot(npcSlotCol, npcSlotRow);
		if (itemIndex < npc.inventory.size()) {
			x = gp.tileSize + 18;
			y = gp.tileSize * 10;
			width = gp.tileSize * 3 - 20;
			height = gp.tileSize;
			drawSubWindow(x, y, width, height, g2);

			boolean isDungeonKey = false;
			boolean isIronGateKey = false;
			boolean isAncientScroll = false;
			int price = npc.inventory.get(itemIndex).price;
			// Normal item
			if (price >= 0) {
				g2.drawImage(coin, x + gp.tileSize + 40, y + 7, null);
				if (gp.player.coin >= price && gp.player.inventory.size() != gp.player.maxInventorySize) {
					g2.setColor(Color.green);
				} else {
					g2.setColor(Color.red);
				}
				g2.drawString("Price: " + price, x + 24, y + 42);
			}
			// Dungeon key
			else if (price == -1) {
				isDungeonKey = true;
				g2.drawImage(dungeonCoin, x + gp.tileSize + 40, y + 7, null);
				if (gp.player.dungeonCoin >= 10 && gp.player.inventory.size() != gp.player.maxInventorySize) {
					g2.setColor(Color.green);
				} else {
					g2.setColor(Color.red);
				}
				g2.drawString("Price: 10", x + 24, y + 42);
			}
			// Iron gate key
			else if (price == -2) {
				isIronGateKey = true;
				g2.drawImage(ironScrap, x + gp.tileSize + 40, y + 7, null);
				if (gp.player.ironScrapAmount >= 5 && gp.player.inventory.size() != gp.player.maxInventorySize) {
					g2.setColor(Color.green);
				} else {
					g2.setColor(Color.red);
				}
				g2.drawString("Price: 5", x + 24, y + 42);
			}
			// Ancient scroll
			else if (price == -3) {
				isAncientScroll = true;
				g2.drawImage(diamond, x + gp.tileSize + 40, y + 12, null);
				if (gp.player.diamondAmount >= 3 && gp.player.inventory.size() != gp.player.maxInventorySize) {
					g2.setColor(Color.green);
				} else {
					g2.setColor(Color.red);
				}
				g2.drawString("Price: 3", x + 24, y + 42);
			}

			// Buy an item
			if (gp.keyH.enterPressed && tradeTimer > 45) {
				if (!isDungeonKey && !isIronGateKey && !isAncientScroll) {
					if (price > gp.player.coin || gp.player.inventory.size() == gp.player.maxInventorySize) {
						canDrawTradeText = true;
					} else {
						// If lantern is bought
						if (npc.inventory.get(itemIndex).name == "lantern_big") {
							tradeTimer = 0;
							gp.playSE(1);
							gp.player.coin -= price;
							gp.player.inventory.set(0, new OBJ_Lantern_Big(gp));
							npc.inventory.remove(npc.inventory.get(itemIndex));
							gp.eManager.setup(700, false);
							gp.eManager.bigLanternEquipped = true;
						} else if (npc.inventory.get(itemIndex).name == "arrow") {
							tradeTimer = 0;
							gp.playSE(1);
							gp.player.coin -= price;
							gp.player.arrowAmount += 15;
						} else {
							tradeTimer = 0;
							gp.playSE(1);
							gp.player.coin -= price;
							gp.player.inventory.add(npc.inventory.get(itemIndex));
						}
					}
				} else {
					if (isDungeonKey) {
						if (10 > gp.player.dungeonCoin || gp.player.inventory.size() == gp.player.maxInventorySize) {
							canDrawTradeText = true;
						} else {
							tradeTimer = 0;
							gp.playSE(1);
							gp.player.dungeonCoin -= 10;
							gp.player.inventory.add(npc.inventory.get(itemIndex));
							npc.inventory.remove(npc.inventory.get(itemIndex));
						}
					} else if (isIronGateKey) {
						if (5 > gp.player.ironScrapAmount || gp.player.inventory.size() == gp.player.maxInventorySize) {
							canDrawTradeText = true;
						} else {
							tradeTimer = 0;
							gp.playSE(1);
							gp.player.ironScrapAmount -= 5;
							gp.player.inventory.add(npc.inventory.get(itemIndex));
							npc.inventory.remove(npc.inventory.get(itemIndex));
						}
					} else if (isAncientScroll) {
						if (3 > gp.player.diamondAmount || gp.player.inventory.size() == gp.player.maxInventorySize) {
							canDrawTradeText = true;
						} else {
							tradeTimer = 0;
							gp.playSE(1);
							gp.player.diamondAmount -= 3;
							gp.player.inventory.removeIf(e -> {
								if (e.name.equals("diamond")) {
									return true;
								}
								return false;
							});
							gp.player.inventory.add(npc.inventory.get(itemIndex));
							npc.inventory.remove(npc.inventory.get(itemIndex));
							gp.player.ancientScrollBought = true;
							gp.npc[2].dialogues[0] = "Is that the. . . ancient scroll!? That's something\nmy master has been looking for for years! We\nhave to go show him now! Follow me.";
							gp.npc[2].dialogues[1] = null;
							gp.npc[2].dialogues[2] = null;
						}
					}
				}
			}
		}
	}

	/**
	 * Draws the trade sell screen.
	 */
	public void trade_sell() {
		tradeTimer++;
		drawTradeText("Cannot sell item!");
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F));
		// Draw player inventory
		drawInventory(gp.player, true);
		// NPC word frame
		int frameX = gp.tileSize + 18;
		int frameY = gp.tileSize;
		int frameWidth = gp.tileSize * 5 - 24;
		int frameHeight = gp.tileSize * 8 - 40;
		drawSubWindow(frameX, frameY, frameWidth, frameHeight, g2);
		g2.setColor(new Color(255, 255, 125));
		String text = "";
		if (npc.name.equals("merchant")) {
			text = "Here, you can sell your\nitems for half of their\noriginal price! Some items\ncan't be sold by default,\nand you can't sell a\ncurrently equipped\nweapon or shield. Feel\nfree to make some coins,\nbut I would focus on those\npurple coins, I heard\nthey lead to a dungeon. . .";
		} else if (npc.name.equals("dungeon_merchant")) {
			text = "You know the drill. . .";
		}
		int xPos = frameX + 20;
		int yPos = frameY + 42;
		for (String line : text.split("\n")) {
			g2.drawString(line, xPos, yPos);
			yPos += 40;
		}
		// Hint window
		g2.setColor(Color.white);
		int x = gp.tileSize * 6 - 3;
		int y = gp.tileSize;
		int width = gp.tileSize * 4;
		int height = gp.tileSize;
		drawSubWindow(x, y, width, height, g2);
		g2.drawString("Press ESC to go back", x + 24, y + 42);
		// Coin window
		y += gp.tileSize;
		drawSubWindow(x, y, width, height, g2);
		g2.drawImage(coin, x + 20, y + 8, null);
		if (gp.player.dungeonCoin > 0) {
			g2.drawImage(dungeonCoin, x + gp.tileSize + 36, y + 8, null);
		}
		if (gp.player.ironScrapAmount > 0) {
			g2.drawImage(ironScrap, x + gp.tileSize * 2 + 44, y + 8, null);
		}
		x += gp.tileSize * 2;
		y += gp.tileSize - 20;
		g2.setColor(Color.yellow);
		g2.drawString(gp.player.coin + "", x - gp.tileSize, y - 1);
		if (gp.player.dungeonCoin > 0) {
			g2.drawString(gp.player.dungeonCoin + "", x + 16, y - 1);
		}
		if (gp.player.ironScrapAmount > 0) {
			g2.drawString(gp.player.ironScrapAmount + "", x + gp.tileSize + 16, y - 1);
		}
		// Price window
		int itemIndex = getItemIndexOnSlot(playerSlotCol, playerSlotRow);
		if (itemIndex < gp.player.inventory.size()) {
			x = gp.tileSize * 12 - 18;
			y = gp.tileSize * 10;
			width = gp.tileSize * 3 - 6;
			height = gp.tileSize;
			drawSubWindow(x, y, width, height, g2);
			if (gp.player.inventory.get(itemIndex).forSale) {
				g2.drawImage(coin, x + gp.tileSize * 2, y + 8, null);
			}
			// NPC offer is half of original price
			int price = gp.player.inventory.get(itemIndex).price / 2;
			if (!gp.player.inventory.get(itemIndex).forSale
					|| gp.player.inventory.get(itemIndex) == gp.player.currentWeapon
					|| gp.player.inventory.get(itemIndex) == gp.player.currentShield) {
				g2.setColor(Color.red);
			} else {
				g2.setColor(Color.green);
			}
			if (!gp.player.inventory.get(itemIndex).forSale) {
				g2.drawString("Not for sale.", x + 30, y + 42);
			} else {
				g2.drawString("Sell for: " + price, x + 24, y + 42);
			}
			// Sell an item
			if (gp.keyH.enterPressed && tradeTimer > 45) {
				if (!gp.player.inventory.get(itemIndex).forSale
						|| gp.player.inventory.get(itemIndex) == gp.player.currentWeapon
						|| gp.player.inventory.get(itemIndex) == gp.player.currentShield) {
					canDrawTradeText = true;
				} else {
					tradeTimer = 0;
					gp.playSE(1);
					gp.player.coin += price;
					gp.player.inventory.remove(gp.player.inventory.get(itemIndex));
				}
			}
		}
	}

	/**
	 * Method used to draw text when an invalid input is done in the trade menu.
	 * 
	 * @param text - text to output on screen
	 */
	public void drawTradeText(String text) {
		if (canDrawTradeText && tradeTimer2 <= 45) {
			tradeTimer2++;
			if (tradeTimer2 == 1) {
				gp.playSE(20);
			}
			int x = gp.tileSize * 6 + 14;
			int y = gp.tileSize * 3;
			int width = gp.tileSize * 4 - 33;
			int height = gp.tileSize;
			drawSubWindow(x, y, width, height, g2);
			// Text
			g2.setColor(Color.white);
			g2.setFont(g2.getFont().deriveFont(Font.ITALIC, 28F));
			g2.drawString(text, x + 26, y + 42);
		}
		if (tradeTimer2 > 45) {
			tradeTimer2 = 0;
			canDrawTradeText = false;
		}
	}

	/**
	 * Draws a sub window for text when called.
	 * 
	 * @param x          - x coordinate
	 * @param y          - y coordinate
	 * @param width      - width
	 * @param height     - height
	 * @param Graphics2D g2 - graphics
	 */
	public void drawSubWindow(int x, int y, int width, int height, Graphics2D g2) {
		Color c = new Color(0, 0, 0, 210);
		g2.setColor(c);
		g2.fillRoundRect(x, y, width, height, 35, 35);

		c = new Color(255, 255, 255);
		g2.setColor(c);
		g2.setStroke(new BasicStroke(4));
		g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
	}

	/**
	 * Draws a sub window with low opacity for text when called.
	 * 
	 * @param x          - x coordinate
	 * @param y          - y coordinate
	 * @param width      - width
	 * @param height     - height
	 * @param Graphics2D g2 - graphics
	 */
	public void drawSubWindowLowOpacity(int x, int y, int width, int height, Graphics2D g2) {
		Color c = new Color(0, 0, 0, 110);
		g2.setColor(c);
		g2.fillRoundRect(x, y, width, height, 35, 35);

		c = new Color(255, 255, 255, 155);
		g2.setColor(c);
		g2.setStroke(new BasicStroke(4));
		g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
	}
}
