import org.omg.CORBA.INTERNAL;

import java.util.Scanner;

/**
 * Created by ryosuke on 2017/05/02.
 */
public class c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.next();
        StringBuffer sb = new StringBuffer(S);
        for (int i = 0; i < sb.length(); i++) {
            char[] c = new char[1];
            sb.getChars(i, i+1, c, 0);
            String s = String.valueOf(c);
            if (s.equals("*")) {
                char[] _c = new char[1];
                char[] __c = new char[1];
                sb.getChars(i-1, i, _c, 0);
                sb.getChars(i+1, i+2, __c, 0);
                int mul = Integer.parseInt(String.valueOf(_c))*Integer.parseInt(String.valueOf(__c));
                sb.delete(i-1, i+2);
                sb.insert(i-1, mul);
                i--;
            }
        }

        String[] replaceSArray = sb.toString().split("");
        int ans = 0;
        int prevPos = 0;
        for (int i = 0; i < replaceSArray.length; i++) {
            String s = replaceSArray[i];
            if (s.equals("+")) {
                char[] c = new char[i-prevPos];
                sb.getChars(prevPos, i, c, 0);
                if (Integer.parseInt(String.valueOf(c)) > 0) {
                    ans++;
                }
                prevPos = i+1;
            } else if (i == replaceSArray.length-1) {
                char[] c = new char[i+1-prevPos];
                sb.getChars(prevPos, i+1, c, 0);
                if (Integer.parseInt(String.valueOf(c)) > 0) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
