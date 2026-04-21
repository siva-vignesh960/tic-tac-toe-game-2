package org.example;

public class TikTacToe_uc1 {

        static char[][] board = new char[3][3];

        /*
         * Entry point of the program. It initializes the board and prints
         * the empty grid on the console.
         */
        public static void main(String[] args) {
            initializeBoard();
            printBoard();
        }

        /*
         * Initializes the 3x3 board by filling each cell with '-' to indicate
         * an empty position. Students should focus on correct nested loop usage.
         */
        static void initializeBoard() {
            for(int row = 0; row < 3;row++) {
                for (int col = 0; col < 3; col++) {
                }
            }
        }

        /*
         * Prints the Tic-Tac-Toe board using horizontal and vertical separators
         * so that the grid structure is clearly visible to the user.
         */
        static void printBoard() {
            for (int row = 0; row < 3; row++) {
                System.out.println("---");

            }
        }
    }