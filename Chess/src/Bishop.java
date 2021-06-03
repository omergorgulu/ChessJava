/*
 *
 * Detection of score status, color status and position status for the Bishop class and 
 * calculation of the threat status according to its position.
 * */


public class Bishop extends Piece {

	public Bishop(Piece.Colour colour, int x, int y) {
		super(3, colour, x, y);
	}

	public String toString() {
		return "f" + Piece.colourToString(this.getColour());
	}

	
	/*
	 *chess piece marks threat 
	 */
	public void markThreats(Board board) {
		int[] position = this.getPosition();
		int[] current = new int[2];

		current[0] = position[0];
		current[1] = position[1];
		do {
			current[0] -= 1;
			current[1] -= 1;
		} while (board.checkPiece(current[0], current[1], this.getColour()));

		current[0] = position[0];
		current[1] = position[1];
		do {
			current[0] -= 1;
			current[1] += 1;
		} while (board.checkPiece(current[0], current[1], this.getColour()));

		current[0] = position[0];
		current[1] = position[1];
		do {
			current[0] += 1;
			current[1] -= 1;
		} while (board.checkPiece(current[0], current[1], this.getColour()));

		current[0] = position[0];
		current[1] = position[1];
		do {
			current[0] += 1;
			current[1] += 1;
		} while (board.checkPiece(current[0], current[1], this.getColour()));
	}
}
