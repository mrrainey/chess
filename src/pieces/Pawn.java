package pieces;

import board.Tile;
import player.Player;

public class Pawn extends Piece {

	public Pawn(final Player player, final Tile tile) {
		super(player, tile);
	}

	public Pawn(Tile t) {
		super(t);
	}

	@Override
	public boolean canMove(Tile t) {
		// pawn movement logic
		return false;
	}
	
	
}
