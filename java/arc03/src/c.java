import javafx.scene.Scene;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/04.
 */
public class c {
    static int N;
    static int M;
    static int startX = -1;
    static int startY = -1;
    static int goalX = -1;
    static int goalY = -1;
    static String[][] map;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        N = Integer.valueOf(firstLine.split(" ")[0]);
        M = Integer.valueOf(firstLine.split(" ")[1]);
        map = new String[N][M];

        // 入力mapの初期化とstart/goalの位置を確認
        for (int i = 0; i < N; i++) {
            map[i] = scanner.nextLine().split("");
            for (int j = 0; j < M; j++) {
                if (map[i][j].equals("s")){
                    startX = j;
                    startY = i;
                }
                if (map[i][j].equals("g")){
                    goalX = j;
                    goalY = i;
                }
            }
        }


    }

    private double searchMap(int posX, int posY, int t, double currentMin) {
        int[] xVector = {-1, 0, 0, 1,};
        int[] yVector = {0, 1, -1, 0};
        double min = currentMin;

        if (posX == goalX && posY == goalY) return currentMin;
        if (posX < 0 || posX > N-1 || posY < 0 || posY > M-1) {
            return Double.MIN_VALUE;
        }

        if (posX != startX && posY != startY) {
            double day = Double.valueOf(map[posX][posY]);
            min = Math.min(currentMin, day* Math.pow(0.99, t));
        }

        double[] candidates = new double[3];

        for (int i = 0; i < 4; i++) {
            candidates[i] = searchMap(posX+xVector[i], posY+yVector[i], t+1, min);
        }

        Arrays.sort(candidates);
        return Math.max(min, candidates[3]);
    }
}
