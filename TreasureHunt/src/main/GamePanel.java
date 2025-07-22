package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import environment.EnvironmentManager;
import tile.TileManager;

/**
 * Class used to represent the game panel. This class implements the Runnable
 * interface, where in this implementation, the game loop runs 60 times per
 * second. This class also houses methods that play and stop music and sound
 * effects.
 */
public class GamePanel extends JPanel implements Runnable {

	/**
	 * Required for a class extending JPanel.
	 */
	private static final long serialVersionUID = 1L;

	// Screen Settings
	private final int originalTileSize = 16; // 16x16 tile
	private final int scale = 4;

	public final int tileSize = originalTileSize * scale; // 64x64 tile
	public final int maxScreenCol = 16; // Screen is 16 tiles x
	public final int maxScreenRow = 12; // Screen is 12 tiles y
	public final int screenWidth = tileSize * maxScreenCol; // 1024 pixels
	public final int screenHeight = tileSize * maxScreenRow; // 768 pixels

	// World settings
	public final int maxWorldCol = 100;
	public final int maxWorldRow = 100;

	// FPS
	private int FPS = 60;

	// System
	public TileManager tileM = new TileManager(this);
	public KeyHandler keyH = new KeyHandler(this);
	private Sound music = new Sound();
	public Sound se = new Sound();
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui = new UI(this);
	public HealthSetter hSetter = new HealthSetter(this);
	public EnvironmentManager eManager = new EnvironmentManager(this);
	public Thread gameThread;

	// Entity and object
	public Player player = new Player(this, keyH);
	public Entity obj[] = new Entity[150];
	public Entity npc[] = new Entity[30];
	public Entity monster[] = new Entity[100];
	public ArrayList<Entity> projectileList = new ArrayList<Entity>();
	public ArrayList<Entity> particleList = new ArrayList<Entity>();

	// Game state
	public boolean isPaused;
	public boolean gameStarted;
	public boolean dialogueState;
	public int menuState;
	public boolean finalGameStart;
	public boolean gameEnded;
	public boolean isViewingStatus;
	public boolean levelUpState;
	public boolean npcIsBeingSpokenTo;
	public int gameIntroCounter;
	public boolean canShowGameIntro = true;
	public boolean introState;
	public boolean introBreak;
	public boolean tradeState;
	public boolean isDark;
	public int transitionState;

	/**
	 * Constructs this game panel.
	 */
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	/**
	 * Sets up game objects and environment.
	 */
	public void setUpGame() {
		aSetter.setAssetsMap1();
		eManager.setup(590, false);
		isDark = true;
	}

	/**
	 * Starts the game thread used to run the game.
	 */
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	/**
	 * Implements a game loop using the delta method which runs the game in 60 FPS,
	 * updating the player and repainting for each frame. Overridden from Runnable
	 * interface.
	 */
	@Override
	public void run() {
		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;

		while (gameThread != null) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;

			if (delta >= 1) {
				if (!isPaused && gameStarted && !dialogueState && !gameEnded && !levelUpState) {
					update();
				}
				repaint();
				delta--;
			}

			if (timer >= 1000000000) {
				timer = 0;
			}
		}
	}

	/**
	 * Toggles pausing the game, to be called in KeyPressed.
	 */
	public void togglePause() {
		isPaused = !isPaused;
	}

	/**
	 * Toggles view of character status, to be called in KeyPressed.
	 */
	public void toggleCharacterStatus() {
		isViewingStatus = !isViewingStatus;
	}

	/**
	 * Updates the player and other entities.
	 */
	public void update() {
		player.update();

		for (int i = 0; i < npc.length; i++) {
			if (npc[i] != null) {
				npc[i].update();
			}
		}

		for (int i = 0; i < monster.length; i++) {
			if (monster[i] != null) {
				if (monster[i].alive && !monster[i].dying) {
					monster[i].update();
				}
				if (!monster[i].alive) {
					monster[i].checkDrop();
					monster[i] = null;
				}
			}
		}

		for (int i = 0; i < projectileList.size(); i++) {
			if (projectileList.get(i) != null) {
				if (projectileList.get(i).alive) {
					projectileList.get(i).update();
				}
				if (!projectileList.get(i).alive) {
					projectileList.remove(i);
				}
			}
		}

		for (int i = 0; i < particleList.size(); i++) {
			if (particleList.get(i) != null) {
				if (particleList.get(i).alive) {
					particleList.get(i).update();
				}
				if (!particleList.get(i).alive) {
					particleList.remove(i);
				}
			}
		}
	}

	/**
	 * Draws the elements of the game in an ordering where background comes before
	 * items.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		// Debug
		long drawStart = 0;
		if (keyH.toggleDebug) {
			drawStart = System.nanoTime();
		}

		// Tile
		if (isDark && !eManager.bigLanternEquipped) {
			tileM.draw(g2, 4);
		} else if (eManager.bigLanternEquipped && isDark) {
			tileM.draw(g2, 5);
		} else {
			tileM.draw(g2);
		}

		// Object
		for (int i = 0; i < obj.length; i++) {
			if (obj[i] != null) {
				obj[i].draw(g2);
			}
		}
		// NPC
		for (int i = 0; i < npc.length; i++) {
			if (npc[i] != null) {
				npc[i].draw(g2);
			}
		}
		// Monster
		for (int i = 0; i < monster.length; i++) {
			if (monster[i] != null) {
				monster[i].draw(g2);
			}
		}
		// Projectile
		for (int i = 0; i < projectileList.size(); i++) {
			if (projectileList.get(i) != null) {
				projectileList.get(i).draw(g2);
			}
		}
		// Particle
		for (int i = 0; i < particleList.size(); i++) {
			if (particleList.get(i) != null) {
				particleList.get(i).draw(g2);
			}
		}
		// Player
		player.draw(g2);

		// Environment
		if (isDark) {
			eManager.draw(g2);
		}

		// UI
		ui.draw(g2);

		// Debug
		if (keyH.toggleDebug) {
			long drawEnd = System.nanoTime();
			long passed = drawEnd - drawStart;
			g2.setColor(Color.white);
			g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40F));
			g2.drawString("Draw Time: " + passed, 10, 400);
			g2.drawString("Player Health: " + player.health, 10, 500);
		}

		g2.dispose();
	}

	/**
	 * Plays and loops audio file.
	 * 
	 * @param i - index of audio
	 */
	public void playMusic(int i) {
		music.setFile(i);
		music.play(i);
		music.loop();
	}

	/**
	 * Sets the volume of the music being played.
	 * 
	 * @param volume - volume to set
	 */
	public void setMusicVolume(float volume) {
		music.volumeSetter(volume);
	}

	/**
	 * Sets the volume of the sound effect being played.
	 * 
	 * @param volume - volume to set
	 */
	public void setSFXVolume(float volume) {
		// se.volumeSFX = volume;
		se.volumeSetter(volume);
	}

	/**
	 * Stops the current music.
	 */
	public void stopMusic() {
		music.stop();
	}

	/**
	 * Plays the given sound effect one time.
	 * 
	 * @param i - index of audio
	 */
	public void playSE(int i) {
		se.setFile(i);
		se.play(1);
	}
}