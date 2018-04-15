import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * Created by ryosuke on 2017/04/22.
 */
public class c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.next());
        long[] a = new long[N];
        long[] b = new long[N];
        Set<Long> set = new HashSet<Long>();
        Map<Long, Integer> map = new HashMap<Long, Integer>();

        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(scanner.next());
            if (!set.contains(a[i])) {
                set.add(a[i]);
            }
        }

        Long[] setArray = set.toArray(new Long[set.size()]);
        Arrays.sort(setArray);
        for (int i = 0; i < setArray.length; i++) {
            map.put(setArray[i], i);
        }

        for (int i = 0; i < N; i++) {
            System.out.println(map.get(a[i]));
        }

    }
}
