import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Euler {
	final static int grids = 50;
	final static int blanks = 1;

	public static void main(String[] args) {
		File file = new File("96.txt");
		try {
			Scanner scanner = new Scanner(file);
			int[][][] mat = new int[grids][9][9];
			for (int i = 0; i < grids; i++) {
				for (int q = 0; q < blanks; q++)
					scanner.nextLine();
				for (int j = 0; j < 9; j++) {
					String row = scanner.nextLine();
					for (int k = 0; k < 9; k++) {
						mat[i][j][k] = Integer.parseInt(row.substring(k, k + 1));
					}
				}
			}
			int total = 0;
			for (int i = 0; i < grids; i++) {
				Sudoku puzzle = new Sudoku(mat[i]);
				int[][] answer = puzzle.solve();
				int value = answer[0][0] * 100 + answer[0][1] * 10 + answer[0][2];
				total += value;
				System.out.println("solved: " + value);
			}
			System.out.println(total);
			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
