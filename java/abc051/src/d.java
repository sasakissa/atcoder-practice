import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/21.
 */
public class d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] edge = new int[m][3];
        long[][] cost = new long[n][n];
        ArrayList<Integer>[][] minEdgeList = new ArrayList[n][n];

        for (int i = 0; i < m; i++) {
            edge[i][0] = scanner.nextInt()-1;
            edge[i][1] = scanner.nextInt()-1;
            edge[i][2] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minEdgeList[i][j] = new ArrayList<>();
            }
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            cost[i][i] = 0;
        }

        // ベルマンフォード法？
        for (int startIndex = 0; startIndex < n; startIndex++) {
            while (true) {
                boolean isUpdated = false;
                for (int edgeIndex = 0; edgeIndex < m; edgeIndex++) {
                    int viaNode = edge[edgeIndex][0];
                    int targetNode = edge[edgeIndex][1];
                    int viaCost = edge[edgeIndex][2];
                    if (cost[startIndex][targetNode] > cost[startIndex][viaNode] + viaCost) {
                        isUpdated = true;
                        cost[startIndex][targetNode] = cost[startIndex][viaNode] + viaCost;
                        minEdgeList[startIndex][targetNode].clear();
                        minEdgeList[startIndex][targetNode].addAll(minEdgeList[startIndex][viaNode]);
                        minEdgeList[startIndex][targetNode].add(edgeIndex);
                    }
                    viaNode = edge[edgeIndex][1];
                    targetNode = edge[edgeIndex][0];
                    if (cost[startIndex][targetNode] > cost[startIndex][viaNode] + viaCost) {
                        isUpdated = true;
                        cost[startIndex][targetNode] = cost[startIndex][viaNode] + viaCost;
                        minEdgeList[startIndex][targetNode].clear();
                        minEdgeList[startIndex][targetNode].addAll(minEdgeList[startIndex][viaNode]);
                        minEdgeList[startIndex][targetNode].add(edgeIndex);
                    }
                }
                if(!isUpdated) {
                    break;
                }
            }
        }

        boolean[] used = new boolean[m];
        Arrays.fill(used, false);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int edgeIndex : minEdgeList[i][j]) {
                    used[edgeIndex] = true;
                }
            }
        }

        int ans = 0;
        for (boolean isUsed : used) {
            if (!isUsed) ans++;
        }
        System.out.println(ans);
    }
}
