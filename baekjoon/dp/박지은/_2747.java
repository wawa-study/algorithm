package dp.박지은;

import java.io.*;

/**
 * @Description 피보나치 수
 * https://www.acmicpc.net/problem/2747
 */
public class _2747 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2 ; i <= n ; i++) {
            // 피보나치 수 -> Fn = Fn-1 + Fn-2
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
    }
}