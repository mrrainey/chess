package board;

<<<<<<< HEAD
import pieces.*;
import player.Player;
=======
import pieces.Piece;
>>>>>>> 48959d04596d04525a409948776cd332d8728fa1

/**
 * @author Matt
 */

public class Chessboard {
	public Tile[][] board = new Tile[8][8];
	
	/*
	 * Creates the chess board tiles and initialises
	 * them with the corresponding pieces
	 */
	public Chessboard(Player p1, Player p2) {
		for (int x = 0; x < 8; ++x)
			for (int y = 0; y < 8; ++y)
				board[x][y] = new Tile(x, y);
		
		for (int y = 0; y < 8; ++y) {
			board[1][y].setPiece(new Pawn(p1));
			board[6][y].setPiece(new Pawn(p2));
		}
		
		int[] rows = {0, 7};
		for (int row : rows) {
			Player p = row == 0 ? p1 : p2;
			board[row][0].setPiece(new Rook(p));
			board[row][1].setPiece(new Knight(p));
			board[row][2].setPiece(new Bishop(p));
			board[row][3].setPiece(new Queen(p));
			board[row][4].setPiece(new King(p));
			board[row][5].setPiece(new Bishop(p));
			board[row][6].setPiece(new Knight(p));
			board[row][7].setPiece(new Rook(p));
		}
	}
	
<<<<<<< HEAD
=======
	/**
	 * Records the movement of a <code>Piece</code> to a new <code>Tile</code> in the game logic,
	 * provided that the particular piece can legally move to the tile.
	 * @param piece the <code>piece</code> to move
	 * @param newTile the <code>tile</code> to move it to
	 * @return whether or not the piece was able to be successfully moved to the new tile
	 */
	public boolean move(Piece piece, Tile newTile) {
		if (piece.canMove(newTile)) {
			piece.getTile().setPiece(null);
			piece.setTile(newTile);
			newTile.setPiece(piece);
			return true;
		}	
		return false;
	}
>>>>>>> 48959d04596d04525a409948776cd332d8728fa1
}
