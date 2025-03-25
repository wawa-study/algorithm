package dp;

import java.io.*;
import java.util.*;

public class _11057 {
    static int[][] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[1001][10];

        dp[1][1] = 10;
        dp[1][0] = 10;
        dp[2][1] = 9;
        dp[2][2] = 8;
        dp[2][3] = 7;
        dp[2][4] = 6;
        dp[2][5] = 5;
        dp[2][6] = 4;
        dp[2][7] = 3;
        dp[2][8] = 2;
        dp[2][9] = 1;
        dp[2][0] = 55;

        int sum = 45;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= 9; j++) {
                if (j == 1) {
                    dp[i][1] = sum;
                } else {
                    dp[i][j] = (dp[i][j - 1] - dp[i - 1][j - 1] + 10007) % 10007;
                    sum += dp[i][j] % 10007;
                }
            }
            dp[i][0] = sum + dp[i-1][0] % 10007;
        }
        System.out.println(dp[n][0] % 10007);
    }
}
