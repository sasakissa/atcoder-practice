import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/05.
 */
public class b {
    public static void main(String[] args) {
        final String win = "You can win";
        final String lose = "You will lose";
        boolean isWinnable = false;

        Scanner scanner = new Scanner(System.in);
        StringBuffer first = new StringBuffer(scanner.nextLine());
        StringBuffer second = new StringBuffer(scanner.nextLine());

        ArrayList<String> firstCamdidateList = recrusion(first.toString());
        ArrayList<String> secondCamdidateList = recrusion(second.toString());

        for (String a : firstCamdidateList) {
            for (String b : secondCamdidateList) {
                if (a.equals(b)) isWinnable = true;
            }
        }

        if (isWinnable) System.out.println(win);
        else System.out.println(lose);

    }

    private static ArrayList<String> recrusion(String src) {
        String[] atcoderArray = {"a", "t", "c", "o", "d", "e", "r" };
        ArrayList<String> ans = new ArrayList<>();

        if (!src.contains("@")) {
            ans.add(src);
            return ans;
        }

        for (int i = 0; i < atcoderArray.length; i++) {
            String out = src.replaceFirst("@", atcoderArray[i]);
            ans.addAll(recrusion(out));
        }

        return ans;
    }
}
