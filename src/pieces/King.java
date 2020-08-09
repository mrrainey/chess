package pieces;

import board.Tile;
import player.Player;

public class King extends Piece {


	public King(Player player) {
		super(player);
	}

	@Override
	public boolean canMove(Tile t) {
		// movement logic
		return false;
	}
	
	
}
