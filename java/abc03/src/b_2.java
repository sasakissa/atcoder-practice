import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/05.
 */
public class b_2 {

    public static void main(String[] args) {
        final String win = "You can win";
        final String lose = "You will lose";
        boolean isWinnable = true;
        String atcoder = "atcoder";

        Scanner scanner = new Scanner(System.in);
        String[] first = scanner.nextLine().split("");
        String[] second = scanner.nextLine().split("");

        for (int i = 0; i < first.length; i++) {
            if (!first[i].equals(second[i])) {
                if (first[i].equals("@") && atcoder.contains(second[i])) {
                    continue;
                }

                if (second[i].equals("@") && atcoder.contains(first[i])) {
                    continue;
                }


                isWinnable = false;
            }

        }

        if (isWinnable) System.out.println(win);
        else System.out.println(lose);
    }
}
