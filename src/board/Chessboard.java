package board;

import pieces.Piece;

/**
 * @author Matt
 */

public class Chessboard {
	Tile[][] board = new Tile[8][8];
	
	/*
	 * Creates the chess board tiles and initialises
	 * them with the corresponding pieces
	 */
	public Chessboard() {
		for (int x = 0; x < 8; ++x)
			for (int y = 0; y < 8; ++y)
				board[x][y] = new Tile(x, y);
		
		for (int y = 0; y < 8; ++y) {
//			board[1][y].piece = Pawn()
//			board[7][y].piece = Pawn()
		}
		
		int[] rows = {0, 7};
		 
		for (int row : rows) {
//			Colour colour = row == 0 ? Colour.Black else Colour.White
//			board[row][0].piece, board[row][7].piece = Rooke(colour)
//			board[row][1].piece, board[row][6].piece = Horse(colour)
//			board[row][2].piece, board[row][5].piece = Bishop(colour)
//			board[row][3].piece = Queen(colour)
//			board[row][4].piece = King(colour)
		}
	}
	
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
}
