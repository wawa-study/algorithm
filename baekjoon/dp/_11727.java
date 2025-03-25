package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11727 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        if(n == 1) System.out.println(1);
        if(n == 2) System.out.println(3);
        if(n == 3) System.out.println(5);

        if (n >= 4) {
            arr[1] = 1;
            arr[2] = 3;
            arr[3] = 5;

            for (int i = 4; i <= n; i++) {
                arr[i] = (arr[i - 1] + arr[i - 2] + arr[i - 2]) % 10007;
            }

            System.out.println(arr[n]);
        }
    }
}
