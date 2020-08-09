package pieces;

import board.Tile;
import player.Player;

public class Rook extends Piece {


	public Rook(Player player) {
		super(player);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Tile t) {
		// movement logic
		return false;
	}
	
	
}
