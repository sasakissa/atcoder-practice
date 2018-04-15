import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/04.
 */
public class a {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.valueOf(scanner.nextLine());
        String[] records = scanner.nextLine().split("");
        double sum = 0;

        for (int i = 0; i < N; i++) {
            String record = records[i];
            if (record.equals("A")) sum += 4;
            else if (record.equals("B")) sum += 3;
            else if (record.equals("C")) sum += 2;
            else if (record.equals("D")) sum += 1;
            else if (record.equals("F")) sum += 0;
        }

        if (sum == 0) System.out.println(0);
        else System.out.println(sum / N);
    }

}
