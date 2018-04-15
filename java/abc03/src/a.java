import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/05.
 */
public class a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        double sum = 0;
        for (int i = 1; i < N; i++) {
            sum += i;
        }

        int ans = (int) sum*10000/N;

        System.out.println(ans);
    }
}
