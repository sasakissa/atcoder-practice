import com.sun.org.apache.xml.internal.utils.res.IntArrayWrapper;

import java.util.*;

/**
 * Created by ryosuke on 2017/04/12.
 */
public class d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        double[] values = new double[N];
        double[] highValues = new double[A];
        double max = 0;
        double combination = 0;
        HashMap<Double, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            values[i] = scanner.nextDouble();
            if (!map.containsKey(values[i])) {
                map.put(values[i], 1);
            } else {
                map.put(values[i], map.get(values[i])+1);
            }
        }

        Arrays.sort(values);
        highValues = Arrays.copyOfRange(values, N-A, N);

        for (int i = 0; i < A; i++ ) {
            max += highValues[i];
        }
        max = max/A;

        List<Double> list = new ArrayList<>();
        for (double i : highValues) list.add(i);
        Set<Double> set = new HashSet<Double>(list);
        Double[] highValuesSet = new Double[set.size()];
        set.toArray(highValuesSet);
        Arrays.sort(highValuesSet);


        if (set.size() == 1) {
            for (int i = A; i <= Math.min(map.get(highValuesSet[0]), B); i++) {
                combination += calcCombination(map.get(highValues[0]), i);
            }
        } else {
            int e = A;
            for (int i = 1; i < highValuesSet.length; i++) {
                e -= map.get(highValuesSet[i]);
            }
            combination = calcCombination(map.get(highValuesSet[0]), e);
        }
        System.out.println(String.format("%.6f", max));
        System.out.println(String.format("%.0f", combination));

    }

    private static double calcCombination( int n, int m ) {
        double c = 1;
        m = ( n - m < m ? n - m : m );
        for( int ns = n - m + 1, ms = 1; ms <= m; ns ++, ms ++ ) {
            c *= ns;
            c /= ms;
        }
        return c;
    }
}
