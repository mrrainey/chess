package board;

import pieces.*;
import player.Player;

/**
 * @author Matt
 */

public class Chessboard {
	public Tile[][] tiles = new Tile[8][8];
	
	/*
	 * Creates the chess board tiles and initialises
	 * them with the corresponding pieces
	 */
	public Chessboard(Player p1, Player p2) {
		for (int x = 0; x < 8; ++x)
			for (int y = 0; y < 8; ++y)
				tiles[x][y] = new Tile(x, y);
		
		for (int y = 0; y < 8; ++y) {
			tiles[1][y].setPiece(new Pawn(p1));
			tiles[6][y].setPiece(new Pawn(p2));
		}
		
		int[] rows = {0, 7};
		for (int row : rows) {
			Player p = row == 0 ? p1 : p2;
			tiles[row][0].setPiece(new Rook(p));
			tiles[row][1].setPiece(new Knight(p));
			tiles[row][2].setPiece(new Bishop(p));
			tiles[row][3].setPiece(new Queen(p));
			tiles[row][4].setPiece(new King(p));
			tiles[row][5].setPiece(new Bishop(p));
			tiles[row][6].setPiece(new Knight(p));
			tiles[row][7].setPiece(new Rook(p));
		}
	}

	public Piece getPiece(int x, int y) {
		return tiles[x][y].getPiece();
	}
}
