public class NQueens {
    int[] board;
    int n;
    public NQueens(int n) {
        this.n = n;
        board = new int[n];
    }
    public void solve() {
        placeQueen(0);
    }
    private boolean placeQueen(int row) {
        if (row == n) {
            printBoard();
            return true;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col)) {
                board[row] = col;
                if (placeQueen(row + 1)) return true;
                board[row] = -1;
            }
        }
        return false;
    }
    private boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || board[i] - i == col - row || board[i] + i == col + row)
                return false;
        }
        return true;
    }
    private void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i] == j ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int n = 8;
        NQueens queens = new NQueens(n);
        queens.solve();
    }
}
