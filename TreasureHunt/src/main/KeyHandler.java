package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Class that handles if a key is pressed or released.
 */
public class KeyHandler implements KeyListener {

	private GamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
	public boolean toggleDebug;

	/**
	 * Constructs a key handler with access to the game panel.
	 * 
	 * @param gp - the game panel
	 */
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}

	/**
	 * Unused.
	 */
	@Override
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * Method that handles keys being pressed.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();

		// TODO temporary way to decrease player speed
		if (code == KeyEvent.VK_J) {
			gp.player.speed--;
		}
		// TODO temporary way to turn on and off lighting
		if (code == KeyEvent.VK_Y) {
			gp.isDark = !gp.isDark;
		}
		// TODO temporary way to give player many buffs for developing purposes
		if (code == KeyEvent.VK_G) {
			gp.player.coin += 100;
			gp.player.dungeonCoin += 100;
			gp.player.arrowAmount += 100;
			gp.player.health += 100;
			gp.player.speed += 4;
			gp.player.ironScrapAmount += 15;
		}
		// TODO temp way to lose health
		if (code == KeyEvent.VK_H) {
			gp.player.health--;
		}
		// TODO temporary way to debug draw time
		if (code == KeyEvent.VK_SHIFT) {
			toggleDebug = !toggleDebug;
		}
		// TODO temporary way to increase player exp
		if (code == KeyEvent.VK_L) {
			gp.player.exp++;
		}
		// TODO temporary way to test sound
		if (code == KeyEvent.VK_P) {
			System.out.println("Testing sound");
			gp.setMusicVolume(.8f);
			gp.setSFXVolume(10);
		}
		if (gp.gameStarted && !gp.gameCompleted) {
			// Dialogue state
			if (gp.dialogueState) {
				// Trading
				if (gp.tradeState) {
					if (code == KeyEvent.VK_ENTER) {
						enterPressed = true;
					}
					if (gp.ui.subState == 0) {
						if (gp.ui.tradeScrollTimer > 30) {
							if (code == KeyEvent.VK_W) {
								gp.ui.commandNum--;
								if (gp.ui.commandNum < 0) {
									gp.ui.commandNum = 2;
								}
								gp.playSE(15);
							}
							if (code == KeyEvent.VK_S) {
								gp.ui.commandNum++;
								if (gp.ui.commandNum > 2) {
									gp.ui.commandNum = 0;
								}
								gp.playSE(15);
							}
						}
					}
					if (gp.ui.subState == 1) {
						npcInventory(code);
						if (code == KeyEvent.VK_ESCAPE) {
							gp.ui.tradeTimer = 0;
							gp.ui.subState = 0;
							gp.ui.buyState = false;
						}
					}
					if (gp.ui.subState == 2) {
						playerInventory(code);
						if (code == KeyEvent.VK_ESCAPE) {
							gp.ui.tradeTimer = 0;
							gp.ui.subState = 0;
							gp.ui.sellState = false;
						}
					}
				}
				// Not trading
				else {
					if (code == KeyEvent.VK_E) {
						if (gp.player.npcIndex != -1) {
							if (gp.npc[gp.player.npcIndex].type != gp.player.type_merchant) {
								gp.npc[gp.player.npcIndex].speak();
							} else {
								gp.npc[gp.player.npcIndex].speak();
								gp.tradeState = false;
							}
						} else {
							gp.dialogueState = false;
						}
					}
				}
			}
			// Level up state
			else if (gp.levelUpState) {
				if (code == KeyEvent.VK_E) {
					gp.levelUpState = false;
				}
			}
			// Character status
			else if (gp.isViewingStatus) {
				if (code == KeyEvent.VK_E) {
					gp.toggleCharacterStatus();
				}
				if (code == KeyEvent.VK_ENTER) {
					gp.player.selectItem();
				}
				playerInventory(code);
			}
			// Game running state
			else if (!gp.gameEnded) {
				switch (code) {
				case KeyEvent.VK_W:
					upPressed = true;
					break;
				case KeyEvent.VK_S:
					downPressed = true;
					break;
				case KeyEvent.VK_A:
					leftPressed = true;
					break;
				case KeyEvent.VK_D:
					rightPressed = true;
					break;
				case KeyEvent.VK_SPACE:
					gp.togglePause();
					break;
				case KeyEvent.VK_E:
					gp.toggleCharacterStatus();
					break;
				case KeyEvent.VK_ENTER:
					if (gp.player.currentWeapon != null) {
						if (gp.player.currentWeapon.type == gp.player.type_bow) {
							if (gp.player.projectile.alive) {
								break;
							}
						}
						gp.player.attacking = true;
					}
					break;
				}
				// Paused state
				if (gp.isPaused) {
					// Go back to menu
					if (code == KeyEvent.VK_ESCAPE) {
						gp.gameStarted = false;
						gp.isPaused = false;
						gp.stopMusic();
					}
				}
			}
			// Controls for player death
			else if (gp.gameEnded) {
				// Menu options
				if (gp.menuState == -1) {
					gp.menuState = 1;
				}
				if (gp.menuState == 2) {
					gp.menuState = 0;
				}
				switch (code) {
				case KeyEvent.VK_W:
					gp.menuState--;
					if (gp.menuState < 0) {
						gp.menuState = 1;
					}
					gp.playSE(15);
					break;
				case KeyEvent.VK_S:
					gp.menuState++;
					if (gp.menuState > 1) {
						gp.menuState = 0;
					}
					gp.playSE(15);
					break;
				case KeyEvent.VK_ENTER:
					// Re-spawn
					if (gp.menuState == 0) {
						gp.player.coin /= 2;
						if (!gp.player.isInDungeon) {
							gp.player.worldX = gp.tileSize * 47;
							gp.player.worldY = gp.tileSize * 38;
							gp.playMusic(0);
						} else {
							gp.player.worldX = gp.tileSize * 50;
							gp.player.worldY = gp.tileSize * 50;
							gp.playMusic(21);
						}
						gp.gameEnded = false;
						gp.player.health = 6 + gp.player.level;
					}
					// Exit
					else if (gp.menuState == 1) {
						System.exit(0);
					}
					break;
				}
			}
		}
		// Game menu state
		else if (!gp.gameStarted) {
			// Menu options
			if (gp.menuState == -1) {
				gp.menuState = 2;
			}
			if (gp.menuState == 3) {
				gp.menuState = 0;
			}
			if (!gp.introState) {
				switch (code) {
				case KeyEvent.VK_W:
					gp.menuState--;
					gp.playSE(15);
					break;
				case KeyEvent.VK_S:
					gp.menuState++;
					gp.playSE(15);
					break;
				}
			}
			if (code == KeyEvent.VK_ENTER && !gp.ui.introTransitionPhase) {
				// Start game
				if (gp.menuState == 0) {
					// Intro text for the game
					gp.introState = true;
					if (gp.gameIntroCounter > 15) {
						gp.introBreak = true;
					} else if (gp.gameIntroCounter == -1) {
						gp.playMusic(0);
						gp.gameStarted = true;
						gp.introState = false;
					} else {
						gp.gameIntroCounter++;
					}
				}
				// Controls menu
				else if (gp.menuState == 1) {
					gp.ui.controlsMenuIsOpened = !gp.ui.controlsMenuIsOpened;
					gp.introState = !gp.introState;
				}
				// Exit
				else if (gp.menuState == 2) {
					System.exit(0);
				}
			}
		} 
		// Outro scene
		else if (gp.gameCompleted && gp.ui.canPressEnter) {
			if (code == KeyEvent.VK_ENTER) {
				gp.completedTextState++;
			}
		}
	}

	/**
	 * Used to control the player inventory.
	 * 
	 * @param code - key pressed
	 */
	public void playerInventory(int code) {
		switch (code) {
		case KeyEvent.VK_W:
			if (gp.ui.playerSlotRow != 0) {
				gp.ui.playerSlotRow--;
				gp.playSE(15);
			}
			break;
		case KeyEvent.VK_S:
			if (gp.ui.playerSlotRow != 4) {
				gp.ui.playerSlotRow++;
				gp.playSE(15);
			}
			break;
		case KeyEvent.VK_A:
			if (gp.ui.playerSlotCol != 0) {
				gp.ui.playerSlotCol--;
				gp.playSE(15);
			}
			break;
		case KeyEvent.VK_D:
			if (gp.ui.playerSlotCol != 3) {
				gp.ui.playerSlotCol++;
				gp.playSE(15);
			}
			break;
		}
	}

	/**
	 * Used to control the NPC inventory.
	 * 
	 * @param code - key pressed
	 */
	public void npcInventory(int code) {
		switch (code) {
		case KeyEvent.VK_W:
			if (gp.ui.npcSlotRow != 0) {
				gp.ui.npcSlotRow--;
				gp.playSE(15);
			}
			break;
		case KeyEvent.VK_S:
			if (gp.ui.npcSlotRow != 4) {
				gp.ui.npcSlotRow++;
				gp.playSE(15);
			}
			break;
		case KeyEvent.VK_A:
			if (gp.ui.npcSlotCol != 0) {
				gp.ui.npcSlotCol--;
				gp.playSE(15);
			}
			break;
		case KeyEvent.VK_D:
			if (gp.ui.npcSlotCol != 3) {
				gp.ui.npcSlotCol++;
				gp.playSE(15);
			}
			break;
		}
	}

	/**
	 * Method that handles keys being released.
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (gp.gameStarted) {
			switch (code) {
			case KeyEvent.VK_W:
				upPressed = false;
				break;
			case KeyEvent.VK_S:
				downPressed = false;
				break;
			case KeyEvent.VK_A:
				leftPressed = false;
				break;
			case KeyEvent.VK_D:
				rightPressed = false;
				break;
			case KeyEvent.VK_ENTER:
				enterPressed = false;
				break;
			}
		}
	}
}
