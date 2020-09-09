
import java.util.Scanner;

public class XMtest2 {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        String word = in.next();
        System.out.println(exist(board, word));

    }

    public static boolean exist(char[][] board, String word) {
        if(board == null) {
            return false;
        }
        if (word == null)
            return false;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int i, int j, String word, int cur) {
        if(cur == word.length()) {
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || board[i][j] != word.charAt(cur)) {
            return false;
        }
        char curr = board[i][j];
        board[i][j] = '*';
        if(dfs(board, i+1, j, word, cur+1)) return true;
        if(dfs(board, i-1, j, word, cur+1)) return true;
        if(dfs(board, i, j+1, word, cur+1)) return true;
        if(dfs(board, i, j-1, word, cur+1)) return true;
        board[i][j] = curr;

        return false;
    }

}
