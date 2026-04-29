import java.util.Scanner;
import java.util.Random;

/**
 * TicTacToe
 * UC8 controls the continuous game loop and alternates
 * turns until the game ends.
 */
public class Tiktactoe_uc8 {

    static char[][] board = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
    };

    static boolean isHumanTurn = true;
    static boolean gameOver = false;

    static char humanSymbol = 'X';
    static char computerSymbol = 'O';

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Tic Tac Toe!");

        while (!gameOver) {

            printBoard();

            if (isHumanTurn) {
                humanMove(sc);
            } else {
                computerMove();
            }

            // Check game status
            if (checkWin(humanSymbol)) {
                printBoard();
                System.out.println("Human Wins!");
                gameOver = true;
            } else if (checkWin(computerSymbol)) {
                printBoard();
                System.out.println("Computer Wins!");
                gameOver = true;
            } else if (isBoardFull()) {
                printBoard();
                System.out.println("It's a Draw!");
                gameOver = true;
            }

            // Switch turn
            isHumanTurn = !isHumanTurn;
        }

        sc.close();
    }

    // Human move
    static void humanMove(Scanner sc) {
        int row, col;

        while (true) {
            System.out.print("Enter row (0-2): ");
            row = sc.nextInt();
            System.out.print("Enter col (0-2): ");
            col = sc.nextInt();

            if (isValidMove(row, col)) {
                board[row][col] = humanSymbol;
                break;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    // Computer move (random)
    static void computerMove() {
        Random rand = new Random();
        int row, col;

        while (true) {
            row = rand.nextInt(3);
            col = rand.nextInt(3);

            if (isValidMove(row, col)) {
                board[row][col] = computerSymbol;
                System.out.println("Computer played at (" + row + ", " + col + ")");
                break;
            }
        }
    }

    // Check valid move
    static boolean isValidMove(int row, int col) {
        return board[row][col] == '-';
    }

    // Print board
    static void printBoard() {
        System.out.println("\nBoard:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Check win condition
    static boolean checkWin(char symbol) {

        // Rows & Columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                    (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }

        // Diagonals
        if ((board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            return true;
        }

        return false;
    }

    // Check if board is full
    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') return false;
            }
        }
        return true;
    }
}