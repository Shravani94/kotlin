import java.util.HashMap;
import java.util.Scanner;

public class Lexical {
    public static void lexical(String s, int n) {
        HashMap<Character, Integer> cnt = new HashMap<Character, Integer>();
        String R = "";
        char[] str = s.toCharArray();
        for (char c : str) {
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
        for (char i = 'a'; i <= 'z'; i++) {
            if (cnt.containsKey(i)) {
                if (cnt.get(i) % 2 != 0) {
                    R += i;
                    //System.out.println(R);
                }
            }
        }
        int l = R.length();
        int j = 0;
        char[] str1 = R.toCharArray();
        for (int i = l - 1; i >= l / 2; i--) {
            cnt.put(str[i], cnt.get(str[i]) - 1);
            str[i] = str[j];
            cnt.put(str[j], cnt.get(str[j]) + 1);
            j++;

        }
        String first = "";
        String middle = "";
        String second = "";
        for (char i = 'a'; i <= 'z'; i++) {

            if (cnt.containsKey(i)) {
                if (cnt.get(i) != 0) {
                    if (cnt.get(i) % 2 == 0) {
                        int m = 0;
                        while (m < cnt.get(i) / 2) {
                            first = first + i;
                            m++;
                        }

                    } else {
                        int m = 0;
                        while (m < (cnt.get(i) - 1) / 2) {
                            first += i;
                            m++;
                        }
                        middle += i;

                    }
                }
            }
        }
        second = first;
        StringBuilder temp = new StringBuilder();
        temp.append(second);
        temp.reverse();

        String resultant = first + middle + temp;
        System.out.println(first);
        System.out.println(temp);
        System.out.println(middle);
        System.out.println(resultant);
    }

   /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string");
        String str = sc.next().toLowerCase();
        int length = str.length();
        lexical(str, length);

    }
*/
}
