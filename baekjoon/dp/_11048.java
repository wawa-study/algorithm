package dp;

import java.io.*;
import java.util.*;

public class _11048 {
    static int[] dr = {1, 0, 1};
    static int[] dc = {0, 1, 1};
    static int[][] arr;
    static int[][] dp;
    static int row;
    static int col;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        row = Integer.parseInt(stk.nextToken());
        col = Integer.parseInt(stk.nextToken());

        arr = new int[row][col];
        dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < row; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int answer = dp(0, 0);
        System.out.println(answer);
    }

    public static int dp(int x, int y) {
        //종료조건
        //x == row && y == col
        if(x == row && y == col) return dp[x][y];
        if(dp[x][y] != -1) return dp[x][y];
        int maxValue = 0;
        for (int i = 0; i < 3; i++) {
            int nx = x + dr[i];
            int ny = y + dc[i];
            if (nx < row && ny < col) {
                maxValue = Math.max(maxValue, dp(nx, ny));
            }
        }

        return dp[x][y] = arr[x][y] + maxValue;
    }
}
