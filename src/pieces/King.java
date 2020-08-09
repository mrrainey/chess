package pieces;

import board.Tile;
import player.Player;

public class King extends Piece {


	public King(Player player, Tile tile) {
		super(player, tile);
	}

	public King(Tile t) {
		super(t);
	}

	@Override
	public boolean canMove(Tile t) {
		// movement logic
		return false;
	}
	
	
}
