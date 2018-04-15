import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/13.
 */
public class d {
    private static long[] cards;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        cards = new long[N];

        for (int i = 0; i < N; i++) {
            cards[i] = scanner.nextLong();
        }

        //  良い組み合わせが一つもないとき
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum+=cards[i];
        }
        if (sum <= K) {
            System.out.println(cards.length);
            return;
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            if(rec(0, 0, K, i)) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static boolean rec(int index, double sum,int thresh, int targetIndex) {
        if (index == targetIndex) {
            return rec(index+1, sum, thresh, targetIndex);
        }
        if (index == cards.length) {
            return false;
        }

        if (thresh - cards[targetIndex] <= sum && sum < thresh) {
            return true;
        } else if(sum >= thresh){
            return false;
        } else {
            return rec(index+1, sum+cards[index], thresh, targetIndex) || rec(index+1, sum, thresh, targetIndex);
        }
    }
}
