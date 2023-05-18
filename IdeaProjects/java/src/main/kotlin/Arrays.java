import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Arrays {
    public static void polindrom() {
        HashMap<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        String R = "";
        int[] str = {2, 2, 2, 2, 3, 4, 2, 3, 4, 5};
        for (int c : str) {
            //System.out.println(c);
            if (cnt.containsKey(c)) {
                cnt.put(c, cnt.get(c) + 1);
            } else {
                cnt.put(c, 1);
                /*
                 * for (Entry<Character, Integer> entry : cnt.entrySet()) {
                 * System.out.println(entry.getKey() + " " + entry.getValue()); }
                 */
            }
        }
        List<Integer> list = new ArrayList<Integer>();

        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int num = entry.getKey() * entry.getValue();
            list.add(num);


        }
        System.out.println(list);
    }

}
