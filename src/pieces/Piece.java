package pieces;

import board.Tile;
import player.Player;
import utilities.Colour;

/**
 * @author Saul
 *
 */
public abstract class Piece {

	private Tile tile;
	private int moves;
	private Player player;
	private Colour colour;

	/**
	 * Constructs a new <code>Piece</code> with assigned Player and initial Tile.
	 * 
	 * @param player the <code>Player</code> to assign the <code>Piece</code> to
	 * @param tile   the <code>Tile</code> to construct the piece on
	 */
	public Piece(final Player player) {
		this.setMoves(0);
		this.setPlayer(player);
		this.setColour(player.getColour());
	}

	/**
	 * Determines whether a piece can legally move to a tile. Handled by each Piece
	 * subclass.
	 * 
	 * @param target The tile test for a legal movement
	 * @return true if the piece can legally move to the tile, false if not
	 * 
	 */
	public abstract boolean canMove(final Tile target);

	/**
	 * Gets an array of all the tiles that the piece can legally move to
	 * 
	 * @return an array of tiles that the piece can legally move to
	 */
	public Tile[] getLegalMoves() {
		return null;
	}

	/**
	 * Gets the amount moves this piece has made
	 * 
	 * @return the number of moves
	 */
	public int getMoves() {
		return moves;
	}

	/**
	 * Gets the <code>Player</code> that the piece belongs to.
	 * 
	 * @return the <code>Player</code> who owns the piece
	 */
	public Player getPlayer() {
		return player;
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
	 * Sets the amount of moves this piece has made
	 * 
	 * @param moves the number of moves the piece has made
	 */
	public void setMoves(final int moves) {
		this.moves = moves;
	}

	/**
	 * Sets the <code>Player</code> that the piece belongs to.
	 * 
	 * @param player the <code>Player</code> who will own the piece
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * Assigns a new tile to the piece
	 * 
	 * @param tile the tile to assign to the piece
	 */
	public void setTile(final Tile tile) {
		this.tile = tile;
	}

	/**
	 * Gets the colour of the piece.
	 * 
	 * @return the piece's colour
	 */
	public Colour getColour() {
		return colour;
	}

	/**
	 * Sets the colour of the piece.
	 * 
	 * @param colour the piece's colour
	 */
	public void setColour(Colour colour) {
		this.colour = colour;
	}

	/**
	 * Destroys the piece so that it can no longer be used.
	 */
	public void kill() {
		getTile().setPiece(null);
		setTile(null);
		System.out.println("Piece " + this + " was killed.");
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
