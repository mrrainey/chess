package pieces;

import board.Tile;
import player.Player;

public class Knight extends Piece {


	public Knight(Player player) {
		super(player);
	}

	@Override
	public boolean canMove(Tile t) {
		// movement logic
		return false;
	}
	
	
}
