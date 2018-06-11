import java.util.ArrayList;

public class Sudoku {
	public int[][] board;
	public int remaining;

	public Sudoku(int[][] start) {
		board = new int[9][9];
		remaining = 81;
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				board[i][j] = start[i][j];
				if (board[i][j]!=0)
					remaining--;
			}
	}

	// returns null if impossible
	public int[][] solve() {
		if (remaining == 0)
			return board;
		boolean found;
		int minY = -1;
		int minX = -1;
		ArrayList<Integer> minA = new ArrayList<>();
		for (int i = 0; i <= 9; i++)
			minA.add(i);
		ArrayList<Integer> pos;
		while (true) {
			found = true;
			while (found) {
				found = false;
				for (int i = 0; i < 9; i++)
					for (int j = 0; j < 9; j++)
						if (board[i][j] == 0) {
							pos = calp(i, j);
							if (pos.size() == 0){
								return null;
								//return board;
								}
							else if (pos.size() == 1) {
								found = true;
								board[i][j] = pos.get(0);
								remaining--;
								if (remaining == 0)
									return board;
							} else if (pos.size() < minA.size()) {
								minY = i;
								minX = j;
								minA = pos;
							}
						}
			}
			// no obvious moves
			for (Integer value : minA) {
				board[minY][minX] = value;
				Sudoku next = new Sudoku(board);
				int[][] result = next.solve();
				if (result != null)
					return result;
			}
			return null;
		}
	}

	public ArrayList<Integer> calp(int y, int x) {
		if (board[y][x] != 0) {
			ArrayList<Integer> done = new ArrayList<>();
			done.add(board[y][x]);
			return done;
		}
		boolean[] found = new boolean[10];
		for (int i = 0; i < 9; i++) {
			if (i != x)
				found[board[y][i]] = true;
			if (i != y)
				found[board[i][x]] = true;
		}
		for (int i = 3*(y / 3); i < 3*(y / 3) + 3; i++)
			for (int j = 3*(x / 3); j < 3*(x / 3) + 3; j++)
				if (i != y || j != x){
					found[board[i][j]] = true;}
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 1; i <= 9; i++)
			if (!found[i])
				result.add(i);
		return result;
	}
}
