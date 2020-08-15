package utilities.text;

import board.Tile;

public class TextTile {
	public enum Border {
		East, North, South, West
	}

	private String[] body;
	private String text;
	private final int innerHeight;
	private final int innerWidth;
	private int height;
	private int width;
	private final Tile tile;

	private Border[] border;

	public TextTile(final Tile tile, final int height, final int width, final Border... borders) {
		this.innerHeight = height;
		this.innerWidth = width;
		this.height = height;
		this.width = width;
		this.tile = tile;
		if (borders != null)
			for (Border b : borders)
				if (b == Border.North || b == Border.South)
					this.setHeight(height + 1);
				else
					this.setWidth(width + 1);
		this.border = borders;
	}

	private void setWidth(int width) {
		this.width = width;
	}

	public void generate() {
		int centreLine = (int) Math.floor(getInnerHeight() / 2);
		String centreText;

		if (getText().length() == getInnerWidth())
			centreText = getText();
		else
			centreText = " ".repeat((int) Math.floor((getInnerWidth() - getText().length()) / 2)) + getText()
					+ " ".repeat((int) Math.round((getInnerWidth() - getText().length()) / 2));

		String[] content = new String[getHeight() + 1];
		for (int h = 0; h < getHeight(); h++) {
			content[h] = "";
			if (hasBorder(Border.North)) {
				if (h == 0) {
					content[h] = "-".repeat(getWidth());
				}
			}
			if (hasBorder(Border.West)) {
				if (h > 0 && h < getHeight()) {
					content[h] = content[h] + "|";
				}
			}
			if (h == centreLine) {
				content[h] = content[h] + centreText;
			} else if (h > 0 && h < getHeight()) {
				content[h] = content[h] + " ".repeat(getInnerWidth());
			}
			if (hasBorder(Border.East)) {
				if (h > 0 && h < getHeight()) {
					content[h] = content[h] + "|";
				}
			}
			if (hasBorder(Border.South)) {
				if (h == getHeight()) {
					content[h] = "-".repeat(getWidth());
				}
			}
		}
		setBody(content);
	}

	/**
	 * @return the body
	 */
	public String[] getBody() {
		return body;
	}

	public boolean hasBorder(final Border border) {
		if (this.border != null)
			for (final Border b : this.border)
				if (b == border) 
					return true;
		return false;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return the height
	 */
	public int getInnerHeight() {
		return innerHeight;
	}

	/**
	 * @return the width
	 */
	public int getInnerWidth() {
		return innerWidth;
	}

	public String getText() {
		return text;
	}

	/**
	 * @return the tile
	 */
	public Tile getTile() {
		return tile;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(final String[] body) {
		this.body = body;
	}

	public void setBorder(final Border... borders) {
		this.border = borders;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(final String text) {
		this.text = text;
	}

}
