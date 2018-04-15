import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/11.
 */
public class c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int N = scanner.nextInt();
        ArrayList<Integer> tako = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tako.add(scanner.nextInt());
        }
        int M = scanner.nextInt();
        ArrayList<Integer> customer = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            customer.add(scanner.nextInt());
        }

        for (int cusSec : customer) {
            for (int i = 0; i < M; i++) {
                if (tako.size() == 0) {
                    System.out.println("no");
                    return;
                }
                if (tako.get(i) + T < cusSec) {
                    tako.remove(i);
                    i--;
                } else if (tako.get(i) < cusSec && cusSec <= tako.get(i) + T) {
                    tako.remove(i);
                    break;
                } else {
                    System.out.println("no");
                    return;
                }
            }
        }

        System.out.println("yes");

    }
}
