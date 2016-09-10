
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    
    private static Map<String, Integer> names = new HashMap<>();
    private static List<String> grid = new ArrayList<>();
    
    public static void main(String[] args) {
        readInData();
        solve();
    } 
    
    private static void readInData() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.equals("--name--")) {
                for (int i = 0; i < 9; i++) {
                    line = sc.nextLine();
//                    System.out.println(line);
                    names.put(line, 0);
                }
            }
            else if (line.equals("--grid--")) {
                for (int i = 0; i < 9; i++) {
                    line = sc.nextLine();
//                    System.out.println(line);
                    grid.add(line);
                }
                for (int col = 0; col < 9; col++) {
                    StringBuilder sb = new StringBuilder();
                    for (int row = 0; row < 9; row++) {
                        sb.append(grid.get(row).substring(col, col+1));
                    }
                    grid.add(sb.toString());
                }
            }
            else if (line.equals("--end--")) {
                return;
            }
        } 
    }
    
    private static void solve() {
        for (String name : names.keySet()) {
            String n = sortString(name);
            for (String chars : grid) {
                for (int i = 0; i <= chars.length() - n.length(); i++) {
                    if (n.equals(sortString(chars.substring(i, i+n.length())))) {
                        System.out.println(name + " is found in [" + chars + "]");
                        names.put(name, names.get(name) + 1);
                        if (names.get(name) >= 2) {
                            System.out.println(name);
                            return;
                        }
                    }
                }
            }         
        }
    }
    
    private static String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
