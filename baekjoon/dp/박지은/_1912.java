package dp.박지은;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @Description 연속합
 * https://www.acmicpc.net/problem/1912
 * */
public class _1912 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp =  new int[N];
        dp[0] = arr[0];
        int maxSum = arr[0];
        for (int i = 1; i < N; i++) {
            // 1. 새로운 연속합을 시작 = arr[i]
            // 2. 이전까지의 합에 현재 수 더하기 = dp[i - 1] + arr[i]
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);

            // 최대 합산 값
            maxSum = Math.max(maxSum, dp[i]);
        }
        System.out.println(maxSum);
    }
}
/*
10
10 -4 3 1 5 6 -35 12 21 -1
-> 33

10
2 1 -4 3 4 -4 6 5 -5 1
-> 14

5
-1 -2 -3 -4 -5
-> -1
* */
