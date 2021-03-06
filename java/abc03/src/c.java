import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/05.
 */
public class c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] rateArray = new int [N];
        double ans = 0;
        for (int i = 0; i < N; i++) {
            rateArray[i] = scanner.nextInt();
        }
        Arrays.sort(rateArray);
        if (N != K) {
            rateArray = Arrays.copyOfRange(rateArray, N-K, N);
        }

        if (K == 1) {
            System.out.println(rateArray[rateArray.length-1]/2.0);
            return;
        }

        for (int i = 0; i < K; i++) {
            ans = (ans+rateArray[i])/2;
        }

        System.out.println(ans);
    }
}
