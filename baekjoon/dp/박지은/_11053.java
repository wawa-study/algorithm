package dp.박지은;

import java.io.*;
import java.util.*;

/**
 * @Description 가장 긴 증가하는 부분 수열
 * http://acmicpc.net/problem/11053
 * */
public class _11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxLength = 0;
        int[] dp = new int[N];

        for(int i = 0; i < N; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength,  dp[i]);
        }
        System.out.println(maxLength);
    }
}
/*
6
10 20 10 30 20 50
-> 4

30
67  154 11  237 200 248 197 44  128 157 161 201 193 171 127 35 211 166 10 197 203 6 243 183 182 92 222 89 163 3
[11, 44, 128, 157, 161, 166, 197, 203, 243]
-> 9

2
4 1
-> 1
*/