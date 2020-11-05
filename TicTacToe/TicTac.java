
import java.util.*;


class TicTac {
/*
	private static String[] X = { "- - - - - - - ", // 0
			"| ██      ██ |", // 1
			"|   ██  ██   |", // 2
			"|     ██     |", // 3
			"|   ██  ██   |", // 4
			"| ██      ██ |", // 5
			"- - - - - - - " };// 6

	private static String[] O = { "- - - - - - - ", // 0
			"|    ████    |", // 1
			"|  ██    ██  |", // 2
			"| ██      ██ |", // 3
			"|  ██    ██  |", // 4
			"|    ████    |", // 5
			"- - - - - - - " };// 6

	private static String[] empty = { "- - - - - - - ", // 0
			"|            |", // 1
			"|            |", // 2
			"|            |", // 3
			"|            |", // 4
			"|            |", // 5
			"- - - - - - - " };// 6

	private static boolean isPlayer1 = true; // true = p1 false = p2
	// p1 = x
	private static int[][] board = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
	private static boolean gameIsRunning = true; // true if game is running
	private static Scanner keyboard = new Scanner(System.in);

	private static int turnCount = 0;

	public static void main(String[] args) {
		// empty = 0, x = 1, O = 2
		printBoard();
		do {
			turnCount++;
			int space = turn() - 1;
			int row = space / 3;
			int column = space % 3;
			if (isPlayer1) {
				board[row][column] = 1;
			} else {
				board[row][column] = 2;
			}
			printBoard();
			isPlayer1 = !isPlayer1;
		} while (!isWinner() && turnCount < 9);
		if (isPlayer1) {
			System.out.println("Player 2 Wins!!");
		} else if (turnCount == 9) {
			System.out.println("Cat's Scratch ¯\\_₍⸍⸌̣ʷ̣̫⸍̣⸌₎_/¯");
		} else {
			System.out.println("Player 1 Wins!!");
		}
	}

	public static void printBoard() {
		for (int row = 0; row < 3; row++) {
			String[] left = empty;
			String[] middle = empty;
			String[] right = empty;
			for (int col = 0; col < 3; col++) {
				String[] placeholder = empty;
				if (board[row][col] == 1) {
					placeholder = X;
				} else if (board[row][col] == 2) {
					placeholder = O;
				}
				if (col == 0) {
					left = placeholder;
				} else if (col == 1) {
					middle = placeholder;
				} else {
					right = placeholder;
				}
			}
			printRowOfBoard(left, middle, right, row);
		}
	}

	public static void printRowOfBoard(String[] left, String[] middle, String[] right, int row) {
		if (row == 0) {
			for (int i = 1; i < 6; i++) {
				System.out.print(" " + left[i].substring(1, left[i].length() - 1) + " " + middle[i] + " "
						+ right[i].substring(1, right[i].length() - 1));
				System.out.println();
			}
		} else if (row == 1) {
			for (int i = 0; i < 7; i++) {
				if (i == 0 || i == 6) {
					System.out.print(" " + left[i].substring(1, left[i].length() - 1) + " " + middle[i] + "-"
							+ right[i].substring(1, right[i].length() - 1));
				} else {
					System.out.print(" " + left[i].substring(1, left[i].length() - 1) + " " + middle[i] + " "
							+ right[i].substring(1, right[i].length() - 1));
				}
				System.out.println();
			}
		} else {
			for (int i = 1; i < 6; i++) {
				System.out.print(" " + left[i].substring(1, left[i].length() - 1) + " " + middle[i] + " "
						+ right[i].substring(1, right[i].length() - 1));
				System.out.println();
			}
		}

	}

	public static int turn() {
		if (isPlayer1) {
			System.out.println("Player 1, where do you want to place an X?");
		} else {
			System.out.println("Player 2, where do you want to place an O?");
		}
		int number = keyboard.nextInt();
		keyboard.nextLine();
	  if (number < 1 || number > 9) {
	      System.out.println("Invalid Placement");
	  		return turn();
	  }
		int space = number - 1;
		int row = space / 3;
		int column = space % 3;
		if (board[row][column] != 0) {
			System.out.println("Invalid Placement");
			return turn();
		} else {
			return number;
		}

	}

	public static boolean isWinner() {
		for (int row = 0; row < 3; row++) {
			if (board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] != 0) {
				return true;
			}
		}
		for (int col = 0; col < 3; col++) {
			if (board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col] != 0) {
				return true;
			}
		}
		if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != 0)
				|| (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != 0)) {
			return true;
		}
		return false;
	}
*/
}

