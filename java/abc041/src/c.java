import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/21.
 */
public class c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] a = new int[N][2];
        for (int i = 0; i < N; i++) {
            a[i][0] = i;
            a[i][1] = scanner.nextInt();
        }

        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i][0]+1);
        }
    }
}
