public class Main {

    public static void main(String[] args) {
        int level = 7;
        if (args.length > 0) {
            level = Integer.parseInt(args[0]);
        }
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        towerOfHanoi.solve(level, "L", "M", "R");
    }
}

class TowerOfHanoi {
    int step = 0;
    public void solve(int level, String source, String target, String ancillary) {
        if (level == 1) {
            System.out.printf("Step %3d: Move top disk from %s to %s\n", ++step, source, target);
        }
        else {
            solve(level-1, source, ancillary, target);
            solve(1, source, target, ancillary);
            solve(level-1, ancillary, target, source);
        }
    }
}