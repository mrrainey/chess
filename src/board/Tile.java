package board;

import pieces.Piece;

public class Tile {
<<<<<<< HEAD
	private int x;
	private int y;
	private Piece piece = null;
	
=======
	int x;
	int y;
	private Piece piece = null;

>>>>>>> 48959d04596d04525a409948776cd332d8728fa1
	/*
	 * 0,0 0,1 0,2 1,0
	 */
	public Tile(int _x, int _y) {
		setX(_x);
		setY(_y);
	}

<<<<<<< HEAD
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

=======
	/**
	 * Gets the <code>Piece</code> on this the tile.
	 * 
	 * @return the piece currently on the tile, or <code>null</code> if there isn't
	 *         one
	 */
>>>>>>> 48959d04596d04525a409948776cd332d8728fa1
	public Piece getPiece() {
		return piece;
	}

<<<<<<< HEAD
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	
=======
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
>>>>>>> 48959d04596d04525a409948776cd332d8728fa1
}
