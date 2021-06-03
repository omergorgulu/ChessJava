/*
 * 
 * Detection of standings, color status and position status for the Queen class.
 * */


public class Queen extends Piece {

	public Queen(Piece.Colour colour, int x, int y) {
		super(9, colour, x, y);
	}

	public String toString() {
		return "v" + Piece.colourToString(this.getColour());
	}
}
