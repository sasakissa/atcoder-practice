import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/13.
 */
public class c {
    private static long x;
    private static HashMap<Long, Long> map;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextLong();
        map = new HashMap<Long, Long>();
        map.put(0l, 0l);
        System.out.println(rec(0, 0));
    }

    private static long rec(long pos, long time) {
        if(map.get(x) != null && map.get(x) < time) return Long.MAX_VALUE;
        if(map.containsKey(pos)) {
            if (map.get(pos) < time) return Long.MAX_VALUE;
            else map.put(pos, time);
        } else {
            map.put(pos, time);
        }
        if (pos == x) {
            return time;
        } else {
            return Math.min( rec(pos + (time+1), time+1), Math.min(rec(pos - (time+1), time+1), rec(pos, time+1)));
        }
    }
}
