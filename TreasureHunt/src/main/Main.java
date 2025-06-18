package main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * The main method for the game which opens the window when the program is ran.
 */
public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame window = new JFrame();
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setResizable(false);
			window.setTitle("Treasure Hunt");

			GamePanel gamePanel = new GamePanel();
			window.add(gamePanel);

			window.pack();
			window.setLocationRelativeTo(null);
			
			window.setVisible(true);
			
			gamePanel.setUpGame();
			gamePanel.startGameThread();
		});
	}
}
