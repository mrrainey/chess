package board;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.*;

import utilities.Colour;

public class ChessboardGUI {
	public void Setup() {
		JFrame f = new JFrame("Chessboard");
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setSize(1920, 1080);
	    f.setVisible(true);
	    f.setLayout(new GridLayout(8,8));
	    f.setVisible(true);
	    
    	Panel whiteTile = new Panel();
    	whiteTile.setBackground(Color.WHITE);
    	Panel blackTile = new Panel();
    	blackTile.setBackground(Color.BLACK);
	    
	    for (int i = 0; i < 64; ++i) {
	    	if (i % 2 == 0)
	    		f.add(whiteTile); 
	    	else 
	    		f.add(blackTile);
	    	
	    	if (i % 8 == 0) {
	    		Panel temp = whiteTile;
	    		whiteTile = blackTile;
	    		blackTile = temp;
	    	}
	    }
	}
}
