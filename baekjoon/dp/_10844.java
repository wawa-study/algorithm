package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10844 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];

        if(n == 1) System.out.println(9);
        if(n == 2) System.out.println(17);
        if (n >= 3) {
            dp[1][1] = 1;
            dp[1][2] = 1;
            dp[1][3] = 1;
            dp[1][4] = 1;
            dp[1][5] = 1;
            dp[1][6] = 1;
            dp[1][7] = 1;
            dp[1][8] = 1;
            dp[1][9] = 1;
            dp[2][1] = 2;
            dp[2][2] = 2;
            dp[2][3] = 2;
            dp[2][4] = 2;
            dp[2][5] = 2;
            dp[2][6] = 2;
            dp[2][7] = 2;
            dp[2][8] = 2;
            dp[2][9] = 1;
            long sum = 0;
            for (int i = 3; i <= n; i++) {
                sum = 0;
                for (int j = 1; j <= 9; j++) {
                    if (j == 1) {
                        dp[i][j] = dp[i - 1][j + 1] % 1000000000 + dp[i-2][j] % 1000000000;
                        sum += dp[i][j] % 1000000000;
                        continue;
                    }
                    if(j==9) {
                        dp[i][j] = dp[i - 1][j-1] % 1000000000;
                        sum += dp[i][j]% 1000000000;
                        continue;
                    }
                    dp[i][j] = dp[i-1][j-1] % 1000000000 + dp[i-1][j+1] % 1000000000;
                    sum += dp[i][j]% 1000000000;
                }
            }
            System.out.println(sum% 1000000000);
        }
    }
}
