import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/13.
 */
public class b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] odd = scanner.nextLine().split("");
        String[] even =  scanner.nextLine().split("");
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < odd.length; i++) {
            ans.append(odd[i]);
            if (even.length > i) {
                ans.append(even[i]);
            }
        }
        System.out.println(ans.toString());
    }
}
