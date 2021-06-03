import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* 
 * In the board class, I read the initial positions of the stones from the file and learned the position of the stones according to their color.
 * I also made the point calculation of the stones in a method here.
 */

public class Board {

	public final static int width = 8;
	public final static int height = 8;

	private Piece[][] data;

	public Board() {
		this.data = new Piece[8][8];
	}

	public Piece[][] getData() {
		return this.data;
	}

		
	/*
	 * check piece and mark 
	*/
	public boolean checkPiece(int x, int y, Piece.Colour colour) {
		if (x >= 0 && x < Board.width && y >= 0 && y < Board.height) {
			if (this.data[x][y] != null) {
				Piece temp = this.data[x][y];
				if (temp.getColour() != colour) {
					temp.mark();
				}
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	/*
	 * progress to the next position on the chess board
	 */
	private void incrementPosition(int[] position) {
		if (position[0] == 7) {
			position[0] = 0;
			position[1] += 1;
		} else {
			position[0] += 1;
		}
	}
	
	/*
	 * Taking input from the file and determining the type, color, location information of chess pieces
	 * */
	
	public void initializeFromFile(String filename) throws FileNotFoundException {
		File file = new File(filename);
		Scanner scanner = new Scanner(file);

		String temp;
		int[] position = new int[2];
		position[0] = 0;
		position[1] = 0;
		while (scanner.hasNext()) {
			temp = scanner.next();
			switch (temp.charAt(0)) {
			case 'p':
				this.data[position[0]][position[1]] = new Pawn(Piece.convertColour(temp.charAt(1)), position[0],
						position[1]);
				break;
			case 'a':
				this.data[position[0]][position[1]] = new Knight(Piece.convertColour(temp.charAt(1)), position[0],
						position[1]);
				break;
			case 'f':
				this.data[position[0]][position[1]] = new Bishop(Piece.convertColour(temp.charAt(1)), position[0],
						position[1]);
				break;
			case 'k':
				this.data[position[0]][position[1]] = new Rook(Piece.convertColour(temp.charAt(1)), position[0],
						position[1]);
				break;
			case 'v':
				this.data[position[0]][position[1]] = new Queen(Piece.convertColour(temp.charAt(1)), position[0],
						position[1]);
				break;
			case 's':
				this.data[position[0]][position[1]] = new King(Piece.convertColour(temp.charAt(1)), position[0],
						position[1]);
				break;
			case 'x':
			default:
			}
			this.incrementPosition(position);
		}
	}
	
	/*
	 * Detecting the position of the pieces on the board
	 * */

	public String toString() {
		String result = "";
		for (int j = 0; j < Board.height; j++) {
			if (this.data[0][j] != null) {
				result = result + this.data[0][j];
			} else {
				result = result + "xx";
			}
			for (int i = 1; i < Board.width; i++) {
				if (this.data[i][j] != null) {
					result = result + " " + this.data[i][j];
				} else {
					result = result + " xx";
				}
			}
			result = result + "\n";
		}
		return result.trim();
	}

	
	
	/*
	 * Calculating the points of the pieces
	 * */
	
	public float[] calculatePoints() {
		for (int i = 0; i < Board.width; i++) {
			for (int j = 0; j < Board.width; j++) {
				if (this.data[i][j] != null) {
					Piece temp = this.data[i][j];
					temp.markThreats(this);
				}
			}
		}

		float[] result = new float[2];
		result[0] = 0f;
		result[1] = 0f;

		for (int i = 0; i < Board.width; i++) {
			for (int j = 0; j < Board.width; j++) {
				if (this.data[i][j] != null) {
					Piece temp = this.data[i][j];
					float current = (float) temp.getValue();
					if (temp.checkMarked()) {
						current = current / 2;
					}
					if (temp.getColour() == Piece.Colour.White) {
						result[0] += current;
					} else {
						result[1] += current;
					}
				}
			}
		}
		return result;
	}
}
