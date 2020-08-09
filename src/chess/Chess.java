package chess;
import java.util.Random;

import board.*;
import player.Player;
import utilities.Colour;

public class Chess {
	public static void main(String args[]) {
		
		Random rand = new Random();
		int randNum = rand.nextInt(2);
		Colour p1Col;
		Colour p2Col;
		
		if (randNum == 0) {
			p1Col = Colour.White;
			p2Col = Colour.Black;
		}
		else {
			p1Col = Colour.Black;
			p2Col = Colour.White;
		}
		
		Player p1 = new Player("Matthew", p1Col);
		Player p2 = new Player("Saul", p2Col);
		
		Chessboard board = new Chessboard(p1, p2);
		
		for (int x = 0; x < 8; ++x)
			for (int y = 0; y < 8; ++y)
				System.out.println(board.getPiece(x, y));
		
	}
}