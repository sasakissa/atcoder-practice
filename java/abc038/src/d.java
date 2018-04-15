import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/22.
 */

// cannot answer
public class d {
    private static int[] h;
    private static int[] w;
    private static int N;
    private static int[] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        h = new int[N];
        w = new int[N];

        for (int i = 0; i < N; i++) {
            h[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }

        dp = new int[N];
        Arrays.fill(dp, 0);

        for (int i = 0; i < N; i++) {
            dp[i] = rec(i);
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
    private static int rec(int i) {
        if (dp[i] > 0) return dp[i];
        int max = 0;
        for (int j = 0; j < N; j++) {
            if (h[i] > h[j] && w[i] > w[j]) {
                max = Math.max(max, rec(j));
            }
        }
        dp[i] = max+1;
        return max+1;
    }
}
