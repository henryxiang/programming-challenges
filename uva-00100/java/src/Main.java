import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long a = 0, b = 0;
            a = scanner.nextLong();
            b = scanner.nextLong();
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
        while (i != 1) {
            n += 1;
            if (i % 2 == 1) {
                i = 3 * i + 1;
            } else {
                i = i / 2;
            }
        }
        return n;
    }

}
