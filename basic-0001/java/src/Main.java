import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while(scanner.hasNextLine()) {
            String[] data = scanner.nextLine().split("\\s+");
            char piece = data[0].charAt(0);
            int row = Integer.parseInt(data[1]);
            int col = Integer.parseInt(data[2]);

            char[][] board = new char[8][8];
            clearBoard(board);
            putPieceOnBoard(board, piece, row, col);
            findAllAttackedSpots(board, piece, row, col);
            printBoard(board);
        }
    }

    private static void printBoard(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                System.out.printf("%s ", board[r][c]);
            }
            System.out.println("\b");
        }
        System.out.println("");
    }

    private static void findAllAttackedSpots(char[][] board, char piece, int row, int col) {
        switch (piece) {
            case 'Q':
                findAllAttackedSpotsByQueen(board, row, col);
                break;
            case 'R':
                findAllAttackedSpotsByRook(board, row, col);
                break;
            case 'K':
                findAllAttackedSpotsByKnight(board, row, col);
                break;
        }
    }

    private static void findAllAttackedSpotsByRook(char[][] board, int row, int col) {
        for (int r = 0; r < board.length; r++) {
            if (r == row) {
                for (int c = 0; c < board[r].length; c++) {
                    if (c != col)
                        board[r][c] = '*';
                }
            }
            else {
                board[r][col] = '*';
            }
        }
    }

    private static void findAllAttackedSpotsByQueen(char[][] board, int row, int col) {
        findAllAttackedSpotsByRook(board, row, col);
        int r, c;
        for (int i = 1; i < board.length; i++) {
            r = row + i;
            c = col + i;
            if (r < 8 && c < 8) {
                board[r][c] = '*';
            }
            r = row - i;
            c = col - i;
            if (r >= 0 && c >= 0) {
                board[r][c] = '*';
            }
            r = row + i;
            c = col - i;
            if (r < 8 && c >= 0) {
                board[r][c] = '*';
            }
            r = row - i;
            c = col + i;
            if (r >= 0 && c < 8) {
                board[r][c] = '*';
            }
        }
    }

    private static void findAllAttackedSpotsByKnight(char[][] board, int row, int col) {
        int[][] moves = {
            {2, 1},
            {2, -1},
            {-2, 1},
            {-2, -1},
            {1, 2},
            {1, -2},
            {-1, 2},
            {-1, -2}
        };
        for (int i = 0; i < moves.length; i++) {
            int r = row + moves[i][0];
            int c = col + moves[i][1];
            if (r >= 0 && r < 8 && c >= 0 && c < 8) {
                board[r][c] = '*';
            }
        }
    }

    private static void clearBoard(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = '_';
            }
        }
    }

    private static void putPieceOnBoard(char[][] board, char piece, int row, int col) {
        board[row][col] = piece;
    }
}
