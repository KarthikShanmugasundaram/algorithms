
public class WordSearch {

	public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            return false;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, k)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        int m = board.length;
        int n = board[0].length;
        
        if (j < 0 || i < 0 || i >= m || j >= n) {
            return false;
        }
        
        if (board[i][j] == word.charAt(k)) {
            char temp = board[i][j];
            board[i][j] = '#';
            
            if (k == word.length() - 1) {
                return true;
            } else if ( dfs(board, word, i-1, j, k+1)
                || dfs(board, word, i+1, j, k+1)
                || dfs(board, word, i, j-1, k+1)
                || dfs(board, word, i, j+1, k+1)) {
                    return true;
            }
            
            board[i][j] = temp;
        }
        
        return false;
    }
}
