package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JPanel;

public class LoadingPanel extends JPanel {
  
	private static final long serialVersionUID = 1L;
	
	private Font marumonica;

	public LoadingPanel() {
        setPreferredSize(new Dimension(1024, 768));
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        try {
			InputStream is = getClass().getResourceAsStream("/font/MaruMonica.ttf");
			marumonica = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
        g.setFont(marumonica);
        g.setFont(g.getFont().deriveFont(Font.BOLD, 100F));
        g.drawString("Loading. . .", 300, 400);
    }
}
