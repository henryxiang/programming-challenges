import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    static {
        logger.setLevel(Level.OFF);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long a = 0, b = 0;
            a = scanner.nextLong();
            b = scanner.nextLong();
            logger.log(Level.INFO, String.format("a = %d, b = %d", a, b));

            int max = 0;
            long start = Math.min(a, b);
            long end = Math.max(a, b);
            for (long i = start; i <= end; i++) {
                int r = run3nPlus1(i);
                if (r > max) {
                    max = r;
                }
            }
            System.out.printf("%d %d %d\n", a, b, max);
        }
    }

    private static int run3nPlus1(long i) {
        int n = 1;
        logger.log(Level.INFO, String.format("i = %d", i));
        while (i != 1) {
            n += 1;
            if (i % 2 == 1) {
                i = 3 * i + 1;
            } else {
                i = i / 2;
            }
            logger.log(Level.INFO, String.format("  i = %d", i));

        }
        return n;
    }

}
