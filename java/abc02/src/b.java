import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/04.
 */
public class b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] array = input.split("");
        ArrayList<String> inputArray  = new ArrayList<>();
        String ans = "";
        for (int i = 0; i < array.length; i++) {
            inputArray.add(array[i]);
        }
        String aiueo = "aiueo";

        for (int i = 0; i < inputArray.size(); i++) {
            if (aiueo.contains(inputArray.get(i))) {
               inputArray.remove(i);
               i--;
            }
        }

        for (int i = 0; i < inputArray.size(); i++) {
            ans += inputArray.get(i);
        }
        System.out.println(ans);
    }
}
