import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/12.
 */
public class b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] students = new int[N][2];
        int[][] checkpoints = new int[M][2];
        int[] ans = new int[N];

        for (int i = 0; i < N; i++) {
            students[i][0] = scanner.nextInt();
            students[i][1] = scanner.nextInt();
        }

        for (int i = 0; i < M; i++) {
            checkpoints[i][0] = scanner.nextInt();
            checkpoints[i][1] = scanner.nextInt();
        }


        for (int i = 0; i < N; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < M; j++) {
                int distance = Math.abs(students[i][0] - checkpoints[j][0]) + Math.abs(students[i][1] - checkpoints[j][1] );
                if (min > distance) {
                    min = distance;
                    ans[i] = j;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(ans[i]+1);
        }
    }
}
