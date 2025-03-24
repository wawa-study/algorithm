package dp.박지은;

import java.io.*;
import java.util.*;

/**
 * @Description 점프
 * https://www.acmicpc.net/problem/1890
 * */
public class _1890 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // tip)
        // int 최댓값: 2,147,483,647 (2^31 - 1)
        // long 최댓값: 9,223,372,036,854,775,807 (2^63 - 1)
        long[][] dp = new long[N + 1][N + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 도착지
                if (map[i][j] == 0) continue;
                // 우측 이동 가능한지
                if (map[i][j] + j <= N) dp[i][map[i][j] + j] += dp[i][j];
                // 아래로 이동 가능한지
                if (map[i][j] + i <= N) dp[map[i][j] + i][j] += dp[i][j];
            }
        }
        System.out.println(dp[N][N]);
    }
}

/*
    4
    2 3 3 1
    1 2 1 3
    1 2 3 1
    3 1 1 0

    3

    1 0 1 0
    0 0 0 0
    1 1 0 1
    1 0 1 3
*/
