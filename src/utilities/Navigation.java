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

	/**
	 * Used to determine if tile1 and tile2 are cardinal from each other
	 * (North/East/South/West).
	 * 
	 * @param tile1 the tile to compare with tile2 for direction
	 * @param tile2 the tile to compare with tile1 for direction
	 * @return <code>true</code> if tile1 and tile2 are cardinal of each other;<br>
	 *         <code>false</code> if they are not
	 */
	public static boolean isCardinal(Tile tile1, Tile tile2) {
		if (tile1.getX() == tile2.getX() || tile1.getY() == tile2.getY())
			return true;
		return false;
	}

	/**
	 * Used to determine if tile1 and tile2 are ordinal from each other (North
	 * East/North West/South East/South West).
	 * 
	 * @param tile1 the tile to compare with tile2 for direction
	 * @param tile2 the tile to compare with tile1 for direction
	 * @return <code>true</code> if tile1 and tile2 are ordinal of each other;<br>
	 *         <code>false</code> if they are not
	 */
	public static boolean isOrdinal(Tile tile1, Tile tile2) {
		if (tile2.getX() - tile1.getX() == tile2.getY() - tile1.getY()
				|| tile2.getX() - tile1.getX() == tile1.getY() - tile2.getY())
			return true;
		return false;
	}

	/**
	 * Generates a path from the origin tile to the target tile.
	 * 
	 * @param origin the origin tile
	 * @param target the target tile to path to
	 * @return an array of tiles from the origin to the target, inclusive of the
	 *         target tile and exclusive of the origin
	 */
	public static Tile[] getPath(Tile origin, Tile target) {
		switch (getDirection(origin, target)) {
		case East: {
			Tile[] path = new Tile[target.getY() - origin.getY()];
			int c = 0;
			for (int i = origin.getY(); i < target.getY(); i++) {
				path[c] = Chess.getBoard().getTile(origin.getX(), i + 1);
				c++;
			}
			return path;
		}
		case North:
			Tile[] path = new Tile[origin.getX() - target.getX()];
			int c = 0;
			for (int i = origin.getX(); i > target.getX(); i--) {
				path[c] = Chess.getBoard().getTile(i - 1, origin.getX());
			}
			return path;
		case NorthEast:
			// Tile[] path = new Tile();
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

	/**
	 * Returns the direction required to travel to get from one tile to another
	 * tile.
	 * 
	 * @param origin the origin tile
	 * @param target the tile to get the direction of from the origin tile. This
	 *               tile must be directly ordinal (NE/NW/SE/SW) or cardinal
	 *               (N/E/S/W) from the origin tile
	 * @return the direction from the origin tile to the target, or
	 *         <code>null</code> if the target tile is not directly ordinal or
	 *         cardinal to the origin tile
	 */
	public static Direction getDirection(Tile origin, Tile target) {
		int x1 = origin.getX();
		int y1 = origin.getY();
		int x2 = target.getX();
		int y2 = target.getY();
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

	/**
	 * For testing and debugging purposes. This method is a quick way to print all
	 * the tiles in an array.
	 * 
	 * @param path the array of tiles to be printed
	 */
	public static void printPath(Tile[] path) {
		System.out.print("Path tiles: {");
		for (Tile tile : path) {
			System.out.print(tile + ",");
		}
		System.out.println("}");
	}

	/**
	 * Compares two tiles and returns the distance between them. If the tiles being
	 * compared are not cardinal (North/East/South/West) or ordinal
	 * (North-east/South-east/South-west/North-west) of each other then -1 will be
	 * returned.
	 * 
	 * @param from the start tile
	 * @param to   the end tile
	 * @return <code>int</code> value greater than or equal to <code>0</code>, representing the
	 *         distance between the start and end tiles; or <code>-1</code> if the tiles are
	 *         neither ordinal or cardinal of each other
	 */
	public static int getDistance(Tile from, Tile to) {

		if (!isOrdinal(from, to) && !isCardinal(from, to))
			return -1;

		int distX = Math.abs(to.getX() - from.getX());
		int distY = Math.abs(to.getY() - from.getY());

		if (distX == distY)
			return distX;
		else if (distX == 0)
			return distY;
		else
			return distX;
	}
}
