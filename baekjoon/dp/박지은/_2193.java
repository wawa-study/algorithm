package dp.박지은;

import java.io.*;

/**
 * @Description 이친수
 * https://www.acmicpc.net/problem/2193
 * */
public class _2193 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N + 1][2];

        dp[1][1] = 1;

        // dp[n][0] = n-1의 0끝 + 1끝
        // dp[n][1] = n-1의 0끝
        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        // 출력
        long result = 0;
        for (int j = 0; j < 2; j++) {
            result = (result + dp[N][j]);
        }
        System.out.println(result);
    }
}

/*
이친수
1. 1로 시작
2. 11 가질수 없음

N = 1
1
[0][1]

N = 2
10
[1][0]

N = 3
101
100
[0+1][1]
[1로끝난거 + 0끝난거][0끝난거]

N = 4
1000
1001
1010
[2][1]

N = 5
10000
10001
10010
10100
10101
[3][2]

입력:
90
정답:
2880067194370816120
*/
