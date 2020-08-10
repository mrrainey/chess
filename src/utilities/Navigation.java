/**
 * 
 */
package utilities;

import board.Tile;
import chess.Chess;

/**
 * @author Saul
 *
 */
public class Navigation {
	
	public enum Direction {
		East, North, NorthEast, NorthWest, South, SouthEast, SouthWest, West
	}

	public static boolean isCardinal(Tile tile1, Tile tile2) {
		if (tile1.getX() == tile2.getX() || tile1.getY() == tile2.getY())
			return true;
		return false;
	}
	
	public static boolean isOrdinal(Tile tile1, Tile tile2) {
		if (tile2.getX() - tile1.getX() == tile2.getY() - tile1.getY() || tile2.getX() - tile1.getX() == tile1.getY() - tile2.getY())
				return true;
		return false;
	}
	
	public static Tile[] getPath(Tile from, Tile to) {
		switch (getDirection(from, to)) {
		case East: {
			Tile[] path = new Tile[to.getY() - from.getY()];
			int c = 0;
			for (int i = from.getY(); i < to.getY(); i++) {
				path[c] = Chess.getBoard().getTile(from.getX(), i);
				c++;
			}
			return path;
		}
		case North:
			break;
		case NorthEast:
			break;
		case NorthWest:
			break;
		case South:
			break;
		case SouthEast:
			break;
		case SouthWest:
			break;
		case West:
			break;
		default:
			break;
		}
		return null;
		
	}
	
	public static Direction getDirection(Tile from, Tile to) {
		int x1 = from.getX();
		int y1 = from.getY();
		int x2 = to.getX();
		int y2 = to.getY();
		int dx = x2 - x1;
		int dy = y2 - y1;
		
		// cardinal directions
		if (dx == 0)
			if (y1 < y2) 
				return Direction.East;
			else if (y1 > y2)
				return Direction.West;
		if (dy == 0) {
			if (x1 < x2)
				return Direction.South;
			else if (x1 > x2)
				return Direction.North;
		}
		
		// ordinal directions
		if (dx == dy || dx == -dy) {
			if (x1 < x2)
				if (y1 < y2) 
					return Direction.SouthEast;
				else if (y1 > y2)
					return Direction.SouthWest;
			if (x1 > x2)
				if (y1 < y2)
					return Direction.NorthEast;
				else if (y1 > y2)
					return Direction.NorthWest;
		}
		
		return null;
	}
}
