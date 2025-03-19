package dp;

import java.io.*;
import java.util.*;

public class _2747 {
            static int[] arr;
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                int n = Integer.parseInt(br.readLine());

                if (n == 0) {
                    System.out.println(0);
                    return;
                }

                if (n == 1 || n == 2) {
                    System.out.println(1);
                    return;
                }

                arr = new int[n+1];
                arr[1] = 1;
                arr[2] = 1;

                int answer = dp(n);
                System.out.println(answer);
            }

            public static int dp(int num) {
                if (arr[num] == 0) {
                    arr[num] = dp(num - 1) + dp(num - 2);
                }
                return arr[num];
    }
}
