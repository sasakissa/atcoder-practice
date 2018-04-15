import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIGlobalBinding;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.zip.Inflater;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.valueOf;

/**
 * Created by ryosuke on 2017/04/23.
 */
public class c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W = Integer.parseInt(scanner.next())-1;
        int H = Integer.parseInt(scanner.next())-1;
        BigInteger up = Split.factorial(W+H);
        BigInteger down = Split.factorial(H).multiply(Split.factorial(W));
        BigInteger divided = up.divide(down);
        BigInteger ans = divided.remainder(BigInteger.valueOf(1000000007));
        System.out.println(ans);
    }

    static class Split {
        static long N;

        static BigInteger factorial(int n) {
            if (n < 2) {
                return ONE;
            }
            BigInteger p = ONE, r = ONE;
            N = 1;
            int log2n = 31 - Integer.numberOfLeadingZeros(n);
            int h = 0, shift = 0, high = 1;
            while (h != n) {
                shift += h;
                h = n >>> log2n--;
                int len = high;
                high = (h & 1) == 1 ? h : h - 1;
                len = (high - len) >> 1;
                if (len > 0) {
                    r = r.multiply((p = p.multiply(bp(len))));
                }
            }
            return r.shiftLeft(shift);
        }

        static BigInteger bp(int n) {
            int m = n >> 1;
            if (m == 0) {
                return valueOf(N += 2);
            } else if (n == 2) {
                return valueOf(N += 2).multiply(valueOf(N += 2));
            }
            return bp(n - m).multiply(bp(m));
        }
    }
}
