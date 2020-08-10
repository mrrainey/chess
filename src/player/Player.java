package player;

import utilities.Colour;

public class Player {

	private String name;
	private Colour colour;
	private final int id;

	public Player(String _name, Colour _colour) {
		name = _name;
		colour = _colour;
		if (_colour == Colour.White)
			id = 1;
		else if (_colour == Colour.Black)
			id = 2;
		else
			throw new IllegalArgumentException("invalid colour");
	}

	public Player(final String name, final int id) {
		this.name = name;
		this.id = id;
		if (id == 1)
			setColour(Colour.White);
		else if (id == 2)
			setColour(Colour.Black);
		else
			throw new IllegalArgumentException("id must be 1 or 2");

	}

	public Colour getColour() {
		return colour;
	}

	/**
	 * @return the id (e.g. 1 for Player 1, or 2 for Player 2)
	 */
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	/**
	 * @param colour the colour to set
	 */
	public void setColour(Colour colour) {
		this.colour = colour;
	}
}
