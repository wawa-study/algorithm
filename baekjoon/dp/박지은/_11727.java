package dp.박지은;

import java.io.*;

/**
 * @Description 2×n 타일링 2
 * https://www.acmicpc.net/problem/11727
 * */
public class _11727 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        dp[1] = 1;

        // tip) 런타임 에러(ArrayIndexOutOfBounds) -> 배열의 인덱스를 초과하는 부분 체크
        if (n > 1) {
            dp[2] = 3;
            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i - 1] + (dp[i - 2] * 2)) % 10007;
            }
        }

        System.out.println(dp[n]);
    }
}

/*
        0   1   2   3   4   5
        0   1   3   5   11

        n = 1
        ㅣ

        n = 2
        ㅣㅣ
        =
        ㅁ

        n = 3
        ㅣㅣㅣ
        =ㅣ
        ㅁㅣ -1  -> *1

        ㅣ=
        ㅣㅁ -2 -> *2

        n = 4
        ㅣㅣㅣㅣ
        =ㅣㅣ
        ㅁㅣㅣ
        ㅣ=ㅣ
        ㅣㅁㅣ

        ㅣㅣ=
        ㅣㅣㅁ
        =ㅁ
        ==
        ㅁ=
        ㅁㅁ
*/
