import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/04.
 */
public class b {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.valueOf(scanner.nextLine());
        String[] inputArray = new String[N];

        for (int i = 0; i < N; i++) {
            inputArray[i] = scanner.nextLine();
        }

        for (int i = 0; i < N-1; i++) {

            for (int j = N-1; j > i; j--) {
                String current = new StringBuffer(inputArray[j]).reverse().toString();
                String next = new StringBuffer(inputArray[j-1]).reverse().toString();
                if (current.compareTo(next) < 0) {
                    String tmp = inputArray[j];
                    inputArray[j] = inputArray[j-1];
                    inputArray[j-1] = tmp;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(inputArray[i]);
        }
    }
}
