package dp.박지은;

import java.io.*;
import java.util.*;

/**
 * @Description 내리막 길
 * https://www.acmicpc.net/problem/1520
 * */
public class _1520 {

    static int M, N, nextX, nextY;
    static int[][] map, dp;
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 세로
        N = Integer.parseInt(st.nextToken()); // 가로
        map = new int[M + 1][N + 1];
        dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1; // tip) 초기화
            }
        }
        System.out.println(bfs(1, 1));
    }

    public static int bfs(int x, int y) {
        if (x == M && y == N) return 1;
        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            nextX = x + dirX[i];
            nextY = y + dirY[i];

            if (isRangeOk() && map[x][y] > map[nextX][nextY]) {
                dp[x][y] += bfs(nextX, nextY);
            }
        }
        return dp[x][y];
    }

    public static boolean isRangeOk() {
        return nextX > 0 && nextY > 0 && nextX <= M && nextY <= N;
    }
}

/*
4 5
50 45 37 32 30
35 50 40 20 25
30 30 25 17 28
27 24 22 15 10

3
*/