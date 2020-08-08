package pieces;

import board.Tile;

/**
 * @author Saul
 *
 */
public abstract class Piece {
	
	private Tile tile;
	private int moves;
	
	public Piece(Tile t) {
		this.tile = t;
		this.moves = 0;
	}
	
	
	/**
	 * Gets the amount moves this piece has made
	 * @return the number of moves
	 */
	public int getMoves() {
		return moves;
	}


	/**
	 * Sets the amount of moves this piece has made
	 * @param moves the number of moves the piece has made
	 */
	public void setMoves(int moves) {
		this.moves = moves;
	}


	/**
	 * Moves the piece to a tile
	 * @param t The tile to move to
	 *  
	 */
	public boolean move(Tile t) {
		if (canMove(t)) {
			tile = t;
			return true;
		}
		return false;
	}
	
	/**
	 * Determines whether a piece can legally move to a tile
	 * @param t The tile test for a legal movement
	 * @return true if the piece can legally move to the tile, false if not
	 * 
	 */
	public abstract boolean canMove(Tile t);


	/**
	 * Gets the tile that this piece is currently assigned to
	 * @return the tile that this piece is currently assigned to
	 */
	public Tile getTile() {
		return tile;
	}


	/**
	 * Assigns a new tile to the piece
	 * @param tile the tile to assign to the piece
	 */
	public void setTile(Tile tile) {
		this.tile = tile;
	}
}
