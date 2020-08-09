package pieces;

import board.Tile;
import player.Player;

public class Queen extends Piece {


	public Queen(Player player) {
		super(player);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Tile t) {
		// movement logic
		return false;
	}
	
	
}
