public class Board {
    private char[][] grid; 
    private int rows;
    private int columns;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        grid = new char[rows][columns];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("| " + grid[i][j] + " ");
            }
            System.out.println("|");
        }
        for (int j = 0; j < columns; j++) {
            System.out.print("'---");
        }
        System.out.println("'");
    }

    public boolean isValidColumn(int column) {
        return column >= 0 && column < columns;
    }

    public boolean isColumnFull(int column) {
        if (isValidColumn(column)) {
            return grid[0][column] != ' ';
        }
        return false;
    }
    

    public void dropDisc(int column, char player) {
        if (isValidColumn(column) && !isColumnFull(column)) {
            for (int i = rows - 1; i >= 0; i--) {
                if (grid[i][column] == ' ') {
                    grid[i][column] = player;
                    break;
                }
            }
        }
    }
    
    public boolean isBoardFull() {
        for (int i = 0; i < columns; i++) {
            if (!isColumnFull(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasPlayerWon(char player) {
        //Horizontal
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns - 3; j++) {
                if (grid[i][j] == player && grid[i][j + 1] == player && grid[i][j + 2] == player && grid[i][j + 3] == player) {
                    return true;
                }
            }
        }

        //Vertical
        for (int i = 0; i < rows - 3; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == player && grid[i + 1][j] == player && grid[i + 2][j] == player && grid[i + 3][j] == player) {
                    return true;
                }
            }
        }

        //Diagonal
        for (int i = 0; i < rows - 3; i++) {
            for (int j = 0; j < columns - 3; j++) {
                if (grid[i][j] == player && grid[i + 1][j + 1] == player && grid[i + 2][j + 2] == player && grid[i + 3][j + 3] == player) {
                    return true;
                }
            }
        }

        //Diagonal
        for (int i = 3; i < rows; i++) {
            for (int j = 0; j < columns - 3; j++) {
                if (grid[i][j] == player && grid[i - 1][j + 1] == player && grid[i - 2][j + 2] == player && grid[i - 3][j + 3] == player) {
                    return true;
                }
            }
        }

        return false;
    }


}