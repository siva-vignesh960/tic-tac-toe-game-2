import java.util.Random;

/**
 * TicTacToe
 * UC7 allows the computer to make a random valid move
 * by reusing slot conversion and validation logic.
 */
public class Tiktactoe_uc7
{

    static char[][] board = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'},
    };

    static char computerSymbol = 'O';

    /**
     * Entry point of the program. Triggers the computer move.
     */
    public static void main(String[] args) {
        System.out.println("Initial Board:");
        printBoard();

        computerMove();

        System.out.println("\nBoard After Computer Move:");
        printBoard();
    }

    /**
     * Generates random slot values until a valid move is found,
     * then places the computer symbol on the board.
     */
    static void computerMove() {
        Random random = new Random();

        int row;
        int col;

        while (true) {
            row = random.nextInt(3);
            col = random.nextInt(3);

            if (isValidMove(row, col)) {
                board[row][col] = computerSymbol;
                System.out.println("\nComputer placed '" + computerSymbol +
                        "' at position (" + row + ", " + col + ")");
                break;
            }
        }
    }

    /**
     * Checks if the selected position is valid (empty).
     */
    static boolean isValidMove(int row, int col) {
        return board[row][col] == '-';
    }

    /**
     * Displays the board.
     */
    static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}