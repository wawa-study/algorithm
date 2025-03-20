package dp.박지은;

import java.io.*;
import java.util.*;

/**
 * @Description 오르막 수
 * https://www.acmicpc.net/problem/11057
 * */
public class _11057 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][10];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = getSum(dp[i - 1], j, 10);
                }
            }
        }
        System.out.println(getSum(dp[N], 0, 10));
    }

    public static int getSum(int[] arr, int startIdx, int endIdx) {
        return Arrays.stream(Arrays.copyOfRange(arr, startIdx, endIdx)).sum() % 10007;
    }
}

/*
    0   1   2   3   4
    0   10  55  220

    dp[n+1][10]
    0 ~ 9 시작하는 수

        0   1   2   3   4   5   6   7   8   9
    0   x
    1   1   1   1   1   1   1   1   1   1   1   < 초기화
    2   10  9   8   7   6   5   4   3   2   1
    3   55  45  36  28  21  15  10  6   3   1
    4

    ---
    n까지 등차수열의 합
    1 + 2 + 3 + ... + n
    n + n-1 + n-2 + ... + 1
    -> (1+n) + (2+n-1) + (3+n-2) + ... + (n+1)
    n * (n+1) / 2
*/
