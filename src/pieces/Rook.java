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
	public boolean canMove(Tile target) {
		if (Navigation.isCardinal(getTile(), target)) {
			Tile[] path = Navigation.getPath(getTile(), target);
			for (int i = 0; i < path.length; i++)
				if (!path[i].isEmpty())
					if (i < path.length)
						return false;
					else if (path[i].getPiece().getPlayer() == getPlayer())
						return false;
		} else {
			return false;
		}
		return true;
	}
	
	
}
