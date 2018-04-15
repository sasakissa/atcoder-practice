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

        int[] dp = new int[N];
        Arrays.fill(dp, 0);
        dp[1] = Math.abs(a[1] - a[0]);

        for (int i = 2; i < N; i++) {
            dp[i] = Math.min(dp[i-1] + Math.abs(a[i] - a[i-1]), dp[i-2] + Math.abs(a[i] - a[i-2]));
        }

        System.out.println(dp[N-1]);
    }
}
