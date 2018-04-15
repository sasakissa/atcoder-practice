import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/04.
 */
public class a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        Integer N = Integer.valueOf(inputStr.split(" ")[0]);
        Integer M = Integer.valueOf(inputStr.split(" ")[1]);
        System.out.println(Math.max(N, M));
    }
}
