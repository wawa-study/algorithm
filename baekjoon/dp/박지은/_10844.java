package dp.박지은;

import java.io.*;

/**
 * @Description 쉬운 계단 수
 * https://www.acmicpc.net/problem/10844
 * */
public class _10844 {

    static int mod = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][10];

        for (int j = 1; j < 10; j++) {
            dp[1][j] =  1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > 0) dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                if (j < 9) dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod;
            }
        }

        int result = 0;
        for (int j = 0; j < 10; j++) {
            result = (result + dp[N][j]) % mod;
        }
        System.out.println(result);
    }
}

/*
    0 시작 x
    % 1,000,000,000

    dp[n+1][10] -> 0~9 로 끝나는 수
    [i-1] 의 [j-1] + [j+1]

    1 -> 9
    2 -> 17
    10

    21

    12
    32

    23
    43

    34
    54

    45
    65

    56
    76

    67
    87

    78
    98

    89
*/
