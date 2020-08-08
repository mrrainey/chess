package pieces;

import board.Tile;

/**
 * @author Saul
 *
 */
public abstract class Piece {

	private Tile tile;
	private int moves;

	public Piece(final Tile t) {
		this.tile = t;
		this.moves = 0;
	}

	/**
	 * Determines whether a piece can legally move to a tile
	 * 
	 * @param t The tile test for a legal movement
	 * @return true if the piece can legally move to the tile, false if not
	 * 
	 */
	public abstract boolean canMove(final Tile t);

	/**
	 * Gets the amount moves this piece has made
	 * 
	 * @return the number of moves
	 */
	public int getMoves() {
		return moves;
	}

	/**
	 * Gets an array of all the tiles that the piece can legally move to
	 * 
	 * @return an array of tiles that the piece can legally move to
	 */
	public Tile[] getLegalMoves() {
		return null;
	}
	
	/**
	 * Gets the tile that this piece is currently assigned to
	 * 
	 * @return the tile that this piece is currently assigned to
	 */
	public Tile getTile() {
		return tile;
	}

	/**
	 * Moves the piece to a tile
	 * 
	 * @param t The tile to move to
	 * 
	 */
	public boolean move(final Tile t) {
		if (canMove(t)) {
			setTile(t);
			return true;
		}
		return false;
	}

	/**
	 * Sets the amount of moves this piece has made
	 * 
	 * @param moves the number of moves the piece has made
	 */
	public void setMoves(final int moves) {
		this.moves = moves;
	}

	/**
	 * Assigns a new tile to the piece
	 * 
	 * @param tile the tile to assign to the piece
	 */
	private void setTile(final Tile tile) {
		this.tile = tile;
	}
}
