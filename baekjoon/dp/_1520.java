package dp;

import java.io.*;
import java.util.*;

public class _1520 {
    static int row;
    static int col;
    static int[][] arr;
    static int[][] dp;
    static int[] drow = {-1, 1, 0, 0};
    static int[] dcol = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        row = Integer.parseInt(stk.nextToken());
        col = Integer.parseInt(stk.nextToken());

        arr = new int[row][col];
        dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
                dp[i][j] = -1;
            }
        }

        int answer = dfs(0, 0);
        System.out.println(answer);
    }

    private static int dfs(int x, int y) {
        if(x == row-1 && y == col-1) return 1;
        if(dp[x][y] != -1) return dp[x][y];
        dp[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + drow[i];
            int ny = y + dcol[i];
            if (nx < row && ny < col && 0 <= nx && 0 <= ny) {
                if (arr[x][y] > arr[nx][ny]) {
                    dp[x][y] += dfs(nx, ny);
                }
            }
        }
        return dp[x][y];
    }
}
