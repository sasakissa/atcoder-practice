import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/22.
 */
public class d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        int H = Integer.valueOf(firstLine.split(" ")[0]);
        int W = Integer.valueOf(firstLine.split(" ")[1]);
        String[][] input = new String[H][W];
        for (int i = 0; i < H; i++) {
            input[i] = scanner.nextLine().split("");
        }
        boolean[][] isBlack = new boolean[H][W];
        String[][] source = new String[H][W];
        for (int i = 0; i < H; i++) {
            Arrays.fill(isBlack[i], false);
            Arrays.fill(source[i], ".");
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (input[i][j].equals("#")) {
                    int startX = i > 0 ? i - 1 : i;
                    int endX = i < W - 1 ? i + 1 : i;
                    int startY = j > 0 ? j - 1 : j;
                    int endY = j < H - 1 ? j + 1 : j;
                    boolean isSurrounded = true;
                    for (int k = startX; k <= endX; k++){
                        for (int l = startY; l <= endY; l++) {
                            if (!input[k][l].equals("#")) {
                                isSurrounded = false;
                                break;
                            }
                        }
                    }
                    // 四方をかこまれてたら黒く塗る
                    if(isSurrounded) {
                        source[i][j] = "#";
                        for (int k = startX; k <= endX; k++){
                            for (int l = startY; l <= endY; l++) {
                                isBlack[k][l] = true;
                                }
                            }
                        }

                    }
                }
            }
            boolean isPossible = true;
            // 塗った結果とinputが一致しているか調べる
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (input[i][j].equals("#") && !isBlack[i][j]) {
                        isPossible = false;
                        break;
                    }
                }
            }

            if(isPossible) {
                System.out.println("possible");
                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < W; j++) {
                        System.out.print(source[i][j]);
                    }
                    System.out.println();
                }
            } else {
                System.out.println("impossible");
            }

        }

    }
