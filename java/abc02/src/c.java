import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/04.
 */
public class c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int xa = Integer.valueOf(input[0]);
        int ya = Integer.valueOf(input[1]);
        int xb = Integer.valueOf(input[2]);
        int yb = Integer.valueOf(input[3]);
        int xc = Integer.valueOf(input[4]);
        int yc = Integer.valueOf(input[5]);
        double ans = Math.abs(xa*(yb-yc) + xb*(yc-ya) + xc*(ya-yb)) / 2.0;
        System.out.println(ans);
    }
}
