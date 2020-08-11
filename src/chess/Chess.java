package chess;
import java.util.Random;

import board.*;
import pieces.Piece;
import player.Player;
import utilities.Colour;
import utilities.Navigation;

public class Chess {
	
	private static Chessboard board;
	
	public static void main(String args[]) {
		
		Random rand = new Random();
		int randNum = rand.nextInt(2);
		Colour p1Col = Colour.White;
		Colour p2Col = Colour.Black;
		
		Player p1;
		Player p2; 
		
		if (randNum == 0) {
			p1 = new Player("Matthew", p1Col);
			p2 = new Player("Saul", p2Col);
		}
		else {
			p1 = new Player("Saul", p1Col);
			p2 = new Player("Matthew", p2Col);
		}
		
		
		setBoard(new Chessboard(p1, p2));
		
		Piece p = board.getPiece(0, 0);
		//board.printSnapshot();
		board.move(p, board.tiles[0][0]);
		board.move(p, board.tiles[2][0]);
		board.printSnapshot();
		
		Tile t1 = board.getTile(0, 0);
		Tile t2 = board.getTile(4, 0);
				
		//Navigation.printPath(Navigation.getPath(board.tiles[3][0], board.tiles[3][5]));
		System.out.println(Navigation.getDistance(t1, t2));
	}

	/**
	 * @return the board
	 */
	public static Chessboard getBoard() {
		return board;
	}

	/**
	 * @param board the board to set
	 */
	public static void setBoard(Chessboard board) {
		Chess.board = board;
	}
}
