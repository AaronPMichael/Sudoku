import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		 int[][] puzzle =
				{{0,3,0,0,5,0,0,4,0},
				 {0,0,8,0,1,0,5,0,0},
				 {4,6,0,0,0,0,0,1,2},
				 {0,7,0,5,0,2,0,8,0},
				 {0,0,0,6,0,3,0,0,0},
				 {0,4,0,1,0,9,0,3,0},
				 {2,5,0,0,0,0,0,9,8},
				 {0,0,1,0,2,0,6,0,0},
				 {0,8,0,0,6,0,0,2,0}};
		 Sudoku game = new Sudoku(puzzle);
		 int[][] answer = game.solve();
		 display(answer);
	}

	public static void display(int[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				System.out.print(board[i][j]);
			System.out.println();
		}
	}
}
