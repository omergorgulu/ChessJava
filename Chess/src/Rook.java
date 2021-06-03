/*
 * Detection of standings, color status and position status for the Piece class.
 * */


public class Rook extends Piece {

	public Rook(Piece.Colour colour, int x, int y) {
		super(5, colour, x, y);
	}

	public String toString() {
		return "k" + Piece.colourToString(this.getColour());
	}
}
