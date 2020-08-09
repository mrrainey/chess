package pieces;

import board.Tile;
import player.Player;

public class Bishop extends Piece {


	public Bishop(Player player) {
		super(player);
	}

	@Override
	public boolean canMove(Tile t) {
		// movement logic
		return false;
	}
	
	
}
