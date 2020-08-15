package utilities.text;

public class TextRow {
	public final TextTile[] tiles;
	public final int rows;
	public TextRow(final TextTile[] tiles) {
		this.tiles = tiles;
		this.rows = tiles[0].getInnerHeight();
	}
	
	public final TextTile[] getTiles() {
		return this.tiles;
	}
	
	public String getBody() {
		String buffer = "";
		for (int i = 0; i < rows; i++) {
			for (int t = 0; t < tiles.length; t++) {
				buffer = buffer + tiles[t].getBody()[i];
			}
			buffer = buffer + "\r\n";
		}
		return buffer;
	}
}
