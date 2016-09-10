
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static String[] names = {
        "RAKIBUL",
        "ANINDYA",
        "MOSHIUR",
        "SHIPLU",
        "KABIR",
        "SUNNY",
        "OBAIDA",
        "WASI"
    };
    private static String[] grid = {
        "OBIDAIBKR",
        "RKAULHISP",
        "SADIYANNO",
        "HEISAWHIA",
        "IRAKIBULS",
        "MFBINTRNO",
        "UTOYZIFAH",
        "LEBSYNUNE",
        "EMOTIONAL"
    };
    private static Map<String, Integer> namesMap = null;
    private static List<String> gridList = null;

    public static void main(String[] args) {
        readInData();
        solve();
    }

    private static void readInData() {
        namesMap = new HashMap<String, Integer>();
        for (int i = 0; i < names.length; i++) {
            namesMap.put(names[i], 0);
        }
        
        gridList = new ArrayList<String>(Arrays.asList(grid));
        for (int col = 0; col < grid[0].length(); col++) {
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < grid.length; row++) {
                sb.append(gridList.get(row).substring(col, col + 1));
            }
            gridList.add(sb.toString());
        }
    }

    private static void solve() {
        for (String name : namesMap.keySet()) {
            String n = sortString(name);
            for (String chars : gridList) {
                for (int i = 0; i <= chars.length() - n.length(); i++) {
                    if (n.equals(sortString(chars.substring(i, i + n.length())))) {
//                        System.out.println(name + " is found in [" + chars + "]");
                        namesMap.put(name, namesMap.get(name) + 1);
                        if (namesMap.get(name) >= 2) {
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
