import java.util.Scanner;

/**
 * Created by ryosuke on 2017/04/13.
 */
public class c_ans {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();
        long time = 0;
        while(true) {
            if(time*(time+1)/2 >= x) {
                System.out.println(time);
                return;
            } else {
                time++;
            }
        }
    }
}
