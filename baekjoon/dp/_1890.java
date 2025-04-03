package dp;

import java.io.*;
import java.util.*;

public class _1890 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(stk.nextToken());
                arr[i][j] = a;
            }
        }
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] > 0 && arr[i][j] > 0) {
                    int right = j + arr[i][j];
                    int down = i + arr[i][j];
                    if (right < n) dp[i][right] += dp[i][j];;
                    if (down < n) dp[down][j] += dp[i][j];
                }
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}
