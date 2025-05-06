import java.util.Scanner;

public class Game {
    public static void play(Scanner sc) {
        int n = Settings.size;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = ' ';

        char current = 'X';
        String currentName = Settings.player1;
        int moves = 0;
        while (true) {
            printBoard(board);
            System.out.println("Хід гравця " + currentName + " (" + current + ")");
            System.out.print("Рядок: ");
            int row = sc.nextInt() - 1;
            System.out.print("Стовпець: ");
            int col = sc.nextInt() - 1;

            if (row < 0 || col < 0 || row >= n || col >= n || board[row][col] != ' ') {
                System.out.println("Недопустимий хід!");
                continue;
            }

            board[row][col] = current;
            moves++;

            if (checkWin(board, current)) {
                printBoard(board);
                System.out.println("Переміг " + currentName + "!");
                Statistics.save(currentName, current);
                break;
            } else if (moves == n * n) {
                printBoard(board);
                System.out.println("Нічия!");
                break;
            }

            if (current == 'X') {
                current = 'O';
                currentName = Settings.player2;
            } else {
                current = 'X';
                currentName = Settings.player1;
            }
        }
    }

    public static void printBoard(char[][] b) {
        int n = b.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" " + b[i][j] + " ");
                if (j < n - 1) System.out.print("|");
            }
            System.out.println();
            if (i < n - 1) {
                for (int j = 0; j < n; j++) {
                    System.out.print("---");
                    if (j < n - 1) System.out.print("+");
                }
                System.out.println();
            }
        }
    }

    public static boolean checkWin(char[][] b, char c) {
        int n = b.length;
        for (int i = 0; i < n; i++) {
            boolean row = true, col = true;
            for (int j = 0; j < n; j++) {
                if (b[i][j] != c) row = false;
                if (b[j][i] != c) col = false;
            }
            if (row || col) return true;
        }

        boolean diag1 = true, diag2 = true;
        for (int i = 0; i < n; i++) {
            if (b[i][i] != c) diag1 = false;
            if (b[i][n - 1 - i] != c) diag2 = false;
        }

        return diag1 || diag2;
    }
}

