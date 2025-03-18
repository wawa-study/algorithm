package dp.박지은;

import java.io.*;

/**
 * @Description 1로 만들기
 * https://www.acmicpc.net/problem/1463
 */
public class _1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 각 인덱스 값을 1로 만드는데 필요한 최소 연산 횟수
        int[] dp = new int[N + 1];

        /*
            - 1 빼기 -> 전 숫자의 dp + 1
            - 2 나누기 -> 2 나누기 숫자의 dp + 1
            - 3 나누기 -> 3 나누기 숫자의 dp + 1
        */
        for (int n = 2 ; n <= N ; n++) {
            // 1을 빼는 경우
            dp[n] = dp[n - 1] + 1;

            // 2로 나누어 떨어지는 경우
            if (n % 2 == 0) {
                dp[n] = Math.min(dp[n], dp[n / 2] + 1);
            }

            // 3으로 나누어 떨어지는 경우
            if (n % 3 == 0) {
                dp[n] = Math.min(dp[n], dp[n / 3] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}

/*
    Bottom-Up  방식 : 작은 -> 큰 문제, 반복문을 이용해서 계산
    Top-Down 방식 : 큰 -> 작은 문제, 재귀문을 이용해서 계산, 호출스택 한계 주의
*/
