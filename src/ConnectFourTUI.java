import java.util.Scanner;

public class ConnectFourTUI {
    public static void main(String[] args) {
        
        int rows = 6;
        int columns = 7;

        Board board = new Board(rows, columns);
        boolean gameFinished = false;
        char currentPlayer = 'X';

        System.out.println("Welcome to Connect Four!");

        Scanner scanner = new Scanner(System.in);
        
        while (!gameFinished) {
        	System.out.println();
            board.printBoard();
            System.out.println();
            System.out.println("Player " + currentPlayer + ", choose a column (1-" + columns + "): ");
            int chosenColumn = scanner.nextInt() - 1;

            if (board.isValidColumn(chosenColumn)) {
                if (board.isColumnFull(chosenColumn)) {
                    System.out.println("Column is full! Choose another column.");
                } else {
                    board.dropDisc(chosenColumn, currentPlayer);
                    if (board.hasPlayerWon(currentPlayer)) {
                        board.printBoard();
                        System.out.println("Player " + currentPlayer + " wins!");
                        gameFinished = true;
                    } else if (board.isBoardFull()) {
                        board.printBoard();
                        System.out.println("It's a draw!");
                        gameFinished = true;
                    } else {
                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    }
                }
            } else {
                System.out.println("Invalid column! Choose a column between 1 and " + columns);
                System.out.println();
            }
        }
        
        scanner.close();
        System.out.println();
    }
}

