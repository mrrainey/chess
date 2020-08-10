package pieces;

import board.Tile;
import player.Player;
import utilities.Navigation;

public class Rook extends Piece {


	public Rook(Player player) {
		super(player);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Tile t) {
		if (Navigation.isCardinal(getTile(), t)) {
			
		}
		return true;
	}
	
	
}
