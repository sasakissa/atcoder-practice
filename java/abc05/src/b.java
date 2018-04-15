import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/09.
 */
public class b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);

        System.out.println(array[0]);
    }
}
