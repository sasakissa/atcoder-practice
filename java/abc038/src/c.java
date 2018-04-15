import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/22.
 */
public class c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int a[] = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextInt();
        }

        long dp[] = new long[N];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        int c = 1;
        for (int i = 1; i < N; i++) {
            if (a[i] > a[i-1]) {
                c++;
            } else {
                c = 1;
            }
            dp[i] = dp[i-1] + c;
        }

        System.out.println(dp[N-1]);
    }
}
