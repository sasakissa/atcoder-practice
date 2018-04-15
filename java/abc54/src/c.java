
import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Scanner;


/**
 * Created by ryosuke on 2017/04/18.
 */
public class c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            ArrayList<Integer> arrayList = new ArrayList<>();;
            if(map.containsKey(a)) {
                arrayList.addAll(map.get(a));
            }
            arrayList.add(b);
            map.put(a, arrayList);
            arrayList = new ArrayList<>();
            if(map.containsKey(b)) {
                arrayList.addAll(map.get(b));
            }
            arrayList.add(a);
            map.put(b, arrayList);
        }

        long ans = solve(0, 1, new ArrayList<>(), map, N);

        System.out.println(ans);
    }

    private static long solve(int prevNode, int currentNode, ArrayList<Integer> route, HashMap<Integer, ArrayList<Integer>> map, int N) {
        long ans = 0;
        if (route.contains(currentNode)) {
            return 0;
        }
        route.add(currentNode);
        if (route.size() == N) {
            return 1;
        }

        ArrayList<Integer> edgeList = map.get(currentNode);
        if (edgeList.contains(prevNode)) {
            edgeList.remove(edgeList.indexOf(prevNode));
        }

        if (edgeList.size() == 0) {
            return 0;
        }

        for (Integer nextNode: edgeList) {
            ans += solve(currentNode, nextNode, (ArrayList<Integer>) route.clone(), map, N);
        }

        return ans;
    }

}
