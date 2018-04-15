import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/23.
 */
public class d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.next());
        int K = Integer.parseInt(scanner.next());
        long[] w = new long[N];
        int[] p = new int[N];

        for (int i = 0; i < N; i++) {
            w[i] = Long.parseLong(scanner.next());
            p[i] = Integer.parseInt(scanner.next());
        }

        double[][][] dp = new double[N+1][K+1][2];
        for (int i = 0; i < K+1; i++) {
            Arrays.fill(dp[N][i], 0);
        }

        for (int i = N-1; i > -1; i--) {
            for (int j = K; j > -1; j--) {
                if (j == K) {
                    dp[i][j][0] = dp[i+1][j][0];
                    dp[i][j][1] = dp[i+1][j][1];
                } else {
                    double portion =  (dp[i+1][j][0]*dp[i+1][j][1] + p[i]*w[i]) / (dp[i+1][j][1] + w[i]);
                    if (portion > dp[i+1][j][0]) {
                        dp[i][j+1][0] = portion;
                        dp[i][j+1][1] = dp[i+1][j+1][1] + w[i];
                    }
                }
            }
        }

        System.out.println(dp[0][0][0]);

    }
}
