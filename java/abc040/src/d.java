import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/22.
 */
public class d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] edge = new int[M][3];
        for (int i = 0; i < M; i++) {
            edge[i][0] = scanner.nextInt();
            edge[i][1] = scanner.nextInt();
            edge[i][2] = scanner.nextInt();
        }
        int Q = scanner.nextInt();
        int[] v = new int[Q];
        int[] w = new int[Q];

        for (int i = 0; i < Q; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }

        for (int i = 0; i < Q; i++) {
            int year = w[i];
            int start = v[i];
            boolean[] visitable = new boolean[N];
            Arrays.fill(visitable, false);
            visitable[start-1] = true;

            while(true) {
                boolean isUpdate = false;
                for (int j = 0; j < M; j++) {
                    if (visitable[edge[j][0]-1] && !visitable[edge[j][1]-1] && edge[j][2] > year) {
                        visitable[edge[j][1]-1] = true;
                        isUpdate = true;
                    } else if(visitable[edge[j][1]-1] && !visitable[edge[j][0]-1] && edge[j][2] > year) {
                        visitable[edge[j][0]-1] = true;
                        isUpdate = true;
                    }
                }
                if (!isUpdate) {
                    break;
                }
            }
            int ans = 0;
            for (boolean able : visitable) {
                if(able) ans++;
            }
            System.out.println(ans);
        }
    }
}
