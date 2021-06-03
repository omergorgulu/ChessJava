import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {

		Board testBoard = new Board();
		try {
			testBoard.initializeFromFile(args[0]);
		} catch (FileNotFoundException e) {
			System.out.println("Please enter a valid filename.");
			System.exit(0);
		}

		System.out.println(testBoard);
		System.out.println("Sonuçlar :" + Arrays.toString(testBoard.calculatePoints()));
	}
}
