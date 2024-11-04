public class Queens {
    private final int N;

    Queens(int n){
        this.N = n;
    }
    public void resolve(){
        int[][] board = new int[N][N];
        if (putQueens(board, 0)){
            printBoard(board);
        }
        else{
            System.out.println("Es imposible hallar una solución");
        }
    }
    private void printBoard(int[][] board){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                System.out.print(board[i][j] == 1 ? " N " : " . ");
            }
            System.out.println();
        }
    }
    private boolean checkSite(int[][] board, int row, int col){
        for (int i = 0; i < row; i++){
            if (board[i][col] == 1)return false;
        }
        for (int i = row, j = col; i >= 0 && j >= 0;i--, j--){
            if (board[i][j] == 1)return false;
        }
        for (int i = row, j = col; i >= 0 && j < N;i--,j++){
            if(board[i][j] == 1)return false;
        }
        return true;
    }
    private boolean putQueens(int[][] board, int row){
        if (row >= N)return true;
        for (int i = 0; i < N; i++){
            if (checkSite(board, row, i)){
                board[row][i] = 1;
                if (putQueens(board, row + 1))return true;
                board[row][i] = 0;
            }
        }
        return false;
    }
}
