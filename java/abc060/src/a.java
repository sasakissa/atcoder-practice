import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/13.
 */
public class a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if ( b - a == c - b) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
