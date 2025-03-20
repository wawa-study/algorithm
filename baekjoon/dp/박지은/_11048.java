package dp.박지은;

import java.io.*;
import java.util.*;

/**
 * @Description 이동하기
 * https://www.acmicpc.net/problem/11048
 * */
public class _11048 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {

                // 이동 방법 : (r+1, c), (r, c+1), (r+1, c+1) -> 도착지 기준으로 변경
                List<Integer> moveDp = new ArrayList<>();
                moveDp.add(dp[i - 1][j]);       // 위에서
                moveDp.add(dp[i][j - 1]);       // 왼쪽에서
                moveDp.add(dp[i - 1][j - 1]);   // 위,왼 대각선에서

                dp[i][j] = Collections.max(moveDp) + map[i - 1][j - 1];
            }
        }
        System.out.println(dp[N][M]);
    }
}
/*
    3 4

    1 2 3 4
    0 0 0 5
    9 8 7 6

    0   0   0   0   0
    0   1   3   6   10
    0   1   3   6   15
    0   10  18  25  31
*/
