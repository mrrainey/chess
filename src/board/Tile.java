package board;

import pieces.Piece;

public class Tile {
	int x;
	int y;
	private Piece piece = null;

	/*
	 * 0,0 0,1 0,2 1,0
	 */
	public Tile(int _x, int _y) {
		x = _x;
		y = _y;
	}

	/**
	 * Gets the <code>Piece</code> on this the tile.
	 * 
	 * @return the piece currently on the tile, or <code>null</code> if there isn't
	 *         one
	 */
	public Piece getPiece() {
		return piece;
	}

	/**
	 * Determines whether or not the tile contains a <code>Piece</code>.
	 * 
	 * @return whether or not a <code>Piece</code> is on the tile.
	 */
	public boolean isEmpty() {
		return piece == null;
	}

	/**
	 * Sets the <code>Piece</code> that is on the tile.
	 * 
	 * @param piece the piece to set as being on the tile.
	 */
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
}
