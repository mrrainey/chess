package board;

import pieces.Piece;

public class Tile {
	private int x;
	private int y;
	private Piece piece = null;
	
	/*
	 * 0,0 0,1 0,2 1,0
	 */
	public Tile(int _x, int _y) {
		setX(_x);
		setY(_y);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	/**
	 * Determines whether or not the tile contains a <code>Piece</code>.
	 * 
	 * @return whether or not a <code>Piece</code> is on the tile.
	 */
	public boolean isEmpty() {
		return piece == null;
	}
}
