import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/22.
 */
public class d {
    private static int H;
    private static int W;
    private static long[][] a;
    private static long[][] dp;
    private static long BASE = 1000000007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        H = Integer.parseInt(scanner.next());
        W = Integer.parseInt(scanner.next());
        a = new long[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                a[i][j] = Long.parseLong(scanner.next());
            }
        }

        dp = new long[H][W];
        long ans = 0;
        for (int i = 0; i < H; i++) {
            Arrays.fill(dp[i], (long)0);
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                ans += rec(i, j);
                ans = ans % BASE;
            }
        }

        System.out.println(ans);
    }

    private static long rec(int h, int w) {
        if (dp[h][w] > 0) return dp[h][w];

        long ans = 1;
        if (h-1 > -1 && a[h-1][w] > a[h][w]) {
            ans += rec(h-1, w)%BASE;
            ans = ans % BASE;
        }
        if (w-1 > -1 && a[h][w-1] > a[h][w]) {
            ans += rec(h, w-1)%BASE;
            ans = ans % BASE;
        }
        if (h+1 < H && a[h+1][w] > a[h][w]) {
            ans += rec(h+1, w)%BASE;
            ans = ans % BASE;
        }
        if (w+1< W && a[h][w+1] > a[h][w]) {
            ans += rec(h, w+1)%BASE;
            ans = ans % BASE;
        }

        dp[h][w] = ans;
        return ans;
    }
}
