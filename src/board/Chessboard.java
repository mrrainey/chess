package board;

import pieces.*;
import player.Player;

/**
 * @author Matt
 */

public class Chessboard {
	public Tile[][] tiles = new Tile[8][8];

	/**
	 * Creates the chess board tiles and initialises them with the corresponding
	 * pieces
	 */
	public Chessboard(Player p1, Player p2) {
		for (int x = 0; x < 8; ++x)
			for (int y = 0; y < 8; ++y)
				tiles[x][y] = new Tile(x, y);

		for (int y = 0; y < 8; ++y) {
			createPiece(new Pawn(p1), tiles[1][y]);
			createPiece(new Pawn(p2), tiles[6][y]);
		}

		int[] rows = { 0, 7 };
		for (int row : rows) {
			Player p = row == 0 ? p1 : p2;
			createPiece(new Rook(p), tiles[row][0]);
			createPiece(new Knight(p), tiles[row][1]);
			createPiece(new Bishop(p), tiles[row][2]);
			createPiece(new Queen(p), tiles[row][3]);
			createPiece(new King(p), tiles[row][4]);
			createPiece(new Bishop(p), tiles[row][5]);
			createPiece(new Knight(p), tiles[row][6]);
			createPiece(new Rook(p), tiles[row][7]);
		}

	}

	/**
	 * Initialises the settings for a new <code>Piece</code>; linking it to its
	 * first <code>Tile</code>.
	 * 
	 * @param piece the piece to initialise
	 * @param tile  the tile to be linked
	 */
	private void createPiece(Piece piece, Tile tile) {
		tile.setPiece(piece);
		piece.setTile(tile);
	}

	/**
	 * Gets the piece at a tile using the provided coordinates.
	 * 
	 * @param x the x coordinate of the tile
	 * @param y the y coordinate of the tile
	 * @return the piece on the tile
	 */
	public Piece getPiece(int x, int y) {
		return getTile(x, y).getPiece();
	}

	/**
	 * Gets the tile at the given coordinates.
	 * 
	 * @param x the x coordinate of the tile
	 * @param y the y coordinate of the tile
	 * @return the tile at the given x and y coordinates
	 */
	public Tile getTile(int x, int y) {
		return tiles[x][y];
	}

	/**
	 * Records the movement of a <code>Piece</code> to a new <code>Tile</code> in
	 * the game logic, provided that the particular piece can legally move to the
	 * tile.
	 * 
	 * @param piece   the <code>piece</code> to move
	 * @param newTile the <code>tile</code> to move it to
	 * @return whether or not the piece was able to be successfully moved to the new
	 *         tile
	 */
	public boolean move(Piece piece, Tile newTile) {
		if (piece.canMove(newTile)) {
			piece.getTile().setPiece(null);
			if (!newTile.isEmpty()) {
				newTile.getPiece().kill();
			}
			piece.setTile(newTile);
			newTile.setPiece(piece);
			return true;
		}
		return false;
	}

	public void printSnapshot() {
		for (int x = 0; x < 8; ++x)
			for (int y = 0; y < 8; ++y) {
				Piece p = getPiece(x, y);
				String name = "     ";
				if (p != null) {
					// System.out.println(p.getClass().getSimpleName());
					switch (p.getClass().getSimpleName()) {

					case "Bishop":
						name = "Bshp ";
						break;
					case "King":
						name = "King ";
						break;
					case "Knight":
						name = "Knght";
						break;
					case "Pawn":
						name = "Pawn ";
						break;
					case "Queen":
						name = "Queen";
						break;
					case "Rook":
						name = "Rook ";
						break;

					default:
						break;
					}
				}
				if (y < 7)
					System.out.print(name + " ");
				else
					System.out.println(name);
			}
	}

	/**
	 * When a <code>Pawn</code> reaches the opponent's end of the board it can be
	 * promoted to a <code>Queen</code>, <code>Rook</code>, <code>Bishop</code> or
	 * <code>Knight</code> as the player desires.
	 * 
	 * @param pawn the pawn to promote
	 */
	public void promote(Pawn pawn) {
		// consult player for choice of new Piece and update the piece.
	}
}
