package all;

import java.util.Iterator;

public class Game {

	public static String Inturn;
	public static String[][] board;

	public String getInturn() {
		return Inturn;
	}

	public void setInturn(String inturn) {
		Inturn = inturn;
	}

	public String[][] getBoard() {
		return board;
	}

	public void setBoard(String[][] board) {
		this.board = board;
	}

	public static void change() {
		if (Inturn.equals("x"))
			Inturn = "o";
		else
			Inturn = "x";
	}

	public static void Start() {
		board = new String[3][3];
		Inturn = "x";
	}

	public static boolean checkWin(String t) {

		return checkColumns(t) || checkDiagonal(t) || checkRows(t);

	}

	public static boolean checkRows(String t) {
		boolean flag = false;
		for (int i = 0; i < board.length; i++) {
			flag = (board[i][0] != null && board[i][0].equals(t) && board[i][1] != null && board[i][1].equals(t)
					&& board[i][2] != null && board[i][2].equals(t));
			if (flag)
				return flag;
		}
		return flag;
	}

	public static boolean checkColumns(String t) {
		boolean flag = false;
		for (int i = 0; i < board.length; i++) {
			flag = (board[0][i] != null && board[0][i].equals(t) && board[1][i] != null && board[1][i].equals(t)
					&& board[2][i] != null && board[2][i].equals(t));
			if (flag)
				return flag;
		}
		return flag;
	}

	public static boolean checkDiagonal(String t) {
		boolean flagOne = board[0][0] != null && board[0][0].equals(t) && board[1][1] != null && board[1][1].equals(t)
				&& board[2][2] != null && board[2][2].equals(t);
		boolean flagTwo = board[0][2] != null && board[0][2].equals(t) && board[1][1] != null && board[1][1].equals(t)
				&& board[2][0] != null && board[2][0].equals(t);
		return flagOne || flagTwo;
	}
	public static boolean checkDraw() {
		boolean flag = board[0][0] != null;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				flag = flag && board[i][j] != null;
			}
		}
		return flag;
	}
    
}
