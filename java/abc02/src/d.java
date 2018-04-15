import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/04.
 */
public class d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        int N = Integer.valueOf(firstLine.split(" ")[0]);
        int M = Integer.valueOf(firstLine.split(" ")[1]);
        ArrayList<Integer>[] relationList = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            relationList[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            String line = scanner.nextLine();
            int a = Integer.valueOf(line.split(" ")[0]);
            int b = Integer.valueOf(line.split(" ")[1]);
            relationList[a-1].add(b-1);
            relationList[b-1].add(a-1);
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            boolean isChecked = true;

            for (int target : relationList[i]) {
                ArrayList<Integer> checkList = new ArrayList<>(relationList[i]);
                for (int k : checkList) {
                    if (k != target && !relationList[target].contains(k)) {
                        isChecked = false;
                    }
                }
            }

            if (isChecked) max = Math.max(max, relationList[i].size()+1);
        }
        System.out.println(max);
    }
}
