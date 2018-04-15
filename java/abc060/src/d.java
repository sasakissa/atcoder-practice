import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/13.
 */
public class d {
    static double[] horizontal;
    static double[] vertical;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        horizontal = new double[n];
        vertical = new double[m];

        for (int i = 0; i < n; i++) {
            horizontal[i] = scanner.nextDouble();
        }

        for (int i = 0; i < m; i++) {
            vertical[i] = scanner.nextDouble();
        }

        ArrayList<Long> ansList = rec(new ArrayList<>());
        long ans = 0;

        for (long d : ansList) {
            ans += Double.valueOf(d);
        }

        System.out.println(ans%1000000007);

    }

    private static ArrayList<Long> rec(ArrayList<Integer> axisIndex) {
        ArrayList<Long> res = new ArrayList();
        switch (axisIndex.size()) {
            case 4:
                res.add( ( ( ((long)Math.abs(horizontal[axisIndex.get(0)]-horizontal[axisIndex.get(1)]))%1000000007) *
                        (((long)Math.abs( vertical[axisIndex.get(2)] - vertical[axisIndex.get(3)] ))% 1000000007) )
                        % 1000000007) ;
                break;
            case 3:
                for (int i = axisIndex.get(2); i < vertical.length; i++) {
                    ArrayList<Integer> _axis = new ArrayList<Integer>();
                    _axis.addAll(axisIndex);
                    if (i != axisIndex.get(2)) {
                        _axis.add(i);
                        res.addAll(rec(_axis));
                    }
                }
                break;
            case 2:
                for (int i = 0; i < vertical.length; i++) {
                    ArrayList<Integer> _axis = new ArrayList<Integer>();
                    _axis.addAll(axisIndex);
                    _axis.add(i);
                    res.addAll(rec(_axis));
                }
                break;
            case 1:
                for (int i = axisIndex.get(0); i < horizontal.length; i++) {
                    ArrayList<Integer> _axis = new ArrayList<Integer>();
                    _axis.addAll(axisIndex);
                    if (i != axisIndex.get(0)) {
                        _axis.add(i);
                        res.addAll(rec(_axis));
                    }
                }
                break;
            case 0:
                for (int i = 0; i < horizontal.length; i++) {
                    ArrayList<Integer> _axis = new ArrayList<Integer>();
                    _axis.addAll(axisIndex);
                    _axis.add(i);
                    res.addAll(rec(_axis));
                }
                break;
        }
        return res;
    }
}
