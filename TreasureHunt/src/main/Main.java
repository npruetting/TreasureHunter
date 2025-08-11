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

		    LoadingPanel loadingPanel = new LoadingPanel();
		    window.add(loadingPanel);
		    window.pack();
		    window.setLocationRelativeTo(null);
		    window.setVisible(true);

		    // Start loading in the background
		    new Thread(() -> {
		        GamePanel gamePanel = new GamePanel();
		        gamePanel.setUpGame();
		        
		        // Swap panels on EDT
		        SwingUtilities.invokeLater(() -> {
		            window.remove(loadingPanel);
		            window.add(gamePanel);
		            window.revalidate();
		            window.repaint();
		            
		            gamePanel.setFocusable(true);
		            gamePanel.requestFocusInWindow();

		            gamePanel.startGameThread();
		        });
		    }).start();
		});
	}
}
