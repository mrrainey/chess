package pieces;

import board.Tile;
import player.Player;

public class Pawn extends Piece {

	public Pawn(final Player player) {
		super(player);
	}

	@Override
	public boolean canMove(Tile t) {
		// pawn movement logic
		return false;
	}
	
	
}
