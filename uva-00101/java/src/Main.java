import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static Map<Integer, Stack<Integer>> slots = new TreeMap<>();
    private static Map<Integer, Integer> position = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Logger logger = Logger.getLogger(Main.class.getName());
    static {
        logger.setLevel(Level.OFF);
    }

    public static void main(String[] args) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if ("quit".equalsIgnoreCase(line)) {
                break;
            } else if (line.matches("^\\d+$")) {
                init(Integer.parseInt(line));
            } else if (!line.isEmpty()) {
                logger.info(line);
                int[] pos = new int[2];
                switch (parseCommand(line, pos)) {
                    case 1:
                        moveOnto(pos[0], pos[1]);
                        break;
                    case 2:
                        moveOver(pos[0], pos[1]);
                        break;
                    case 3:
                        pileOnto(pos[0], pos[1]);
                        break;
                    case 4:
                        pileOver(pos[0], pos[1]);
                        break;
                }
            }
        }
        printSlots();
    }

    private static void printSlots() {
        for (Integer b : slots.keySet()) {
            System.out.printf("%s:", b);
            for (int i = 0; i < slots.get(b).size(); i++) {
                System.out.printf(" %s", slots.get(b).get(i));
            }
            System.out.println("");
        }
    }

    private static int parseCommand(String line, int[] pos) {
        int cmd = 0;
        String[] data = line.split("\\s+");
        pos[0] = Integer.parseInt(data[1]);
        pos[1] = Integer.parseInt(data[3]);
        if (data[0].equalsIgnoreCase("move") && data[2].equalsIgnoreCase("onto")) {
            cmd = 1;
        }
        if (data[0].equalsIgnoreCase("move") && data[2].equalsIgnoreCase("over")) {
            cmd = 2;
        }
        if (data[0].equalsIgnoreCase("pile") && data[2].equalsIgnoreCase("onto")) {
            cmd = 3;
        }
        if (data[0].equalsIgnoreCase("pile") && data[2].equalsIgnoreCase("over")) {
            cmd = 4;
        }
        return cmd;
    }

    private static void init(int n) {
        for (int i = 0; i < n; i++) {
            slots.put(i, new Stack<>());
            slots.get(i).push(i);
            position.put(i, i);
        }
    }

    private static void moveOnto(int from, int to) {
        if (isInvalidMove(from, to)) return;

        Stack<Integer> sourceStack = slots.get(position.get(from));
        Stack<Integer> targetStack = slots.get(position.get(to));
        Integer b;
        while (sourceStack.peek() != from) {
            b = sourceStack.pop();
            slots.get(b).push(b);
            position.put(b, b);
        }
        while (targetStack.peek() != to) {
            b = targetStack.pop();
            slots.get(b).push(b);
            position.put(b, b);
        }
        b = sourceStack.pop();
        targetStack.push(b);
        position.put(b, position.get(to));
    }

    private static void moveOver(int from, int to) {
        if (isInvalidMove(from, to)) return;

        Stack<Integer> sourceStack = slots.get(position.get(from));
        Stack<Integer> targetStack = slots.get(position.get(to));
        Integer b;
        while (sourceStack.peek() != from) {
            b = sourceStack.pop();
            slots.get(b).push(b);
            position.put(b, b);
        }
        b = sourceStack.pop();
        targetStack.push(b);
        position.put(b, position.get(to));
    }

    private static void pileOnto(int from, int to) {
        if (isInvalidMove(from, to)) return;

        Stack<Integer> sourceStack = slots.get(position.get(from));
        Stack<Integer> targetStack = slots.get(position.get(to));
        Stack<Integer> temp = new Stack<>();
        Integer b;
        while (sourceStack.peek() != from) {
            b = sourceStack.pop();
            temp.push(b);
        }
        b = sourceStack.pop();
        temp.push(b);

        while (targetStack.peek() != to) {
            b = targetStack.pop();
            slots.get(b).push(b);
            position.put(b, b);
        }

        while (!temp.empty()) {
            b = temp.pop();
            targetStack.push(b);
            position.put(b, position.get(to));
        }
    }

    private static void pileOver(int from, int to) {
        if (isInvalidMove(from, to)) return;

        Stack<Integer> sourceStack = slots.get(position.get(from));
        Stack<Integer> targetStack = slots.get(position.get(to));
        Stack<Integer> temp = new Stack<>();
        Integer b;

        while (sourceStack.peek() != from) {
            b = sourceStack.pop();
            temp.push(b);
        }
        b = sourceStack.pop();
        temp.push(b);

        while (!temp.empty()) {
            b = temp.pop();
            targetStack.push(b);
            position.put(b, position.get(to));
        }
    }

    private static boolean isInvalidMove(int from, int to) {
        return (from == to || position.get(from) == position.get(to));
    }
}
