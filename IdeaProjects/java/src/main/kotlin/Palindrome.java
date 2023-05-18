import java.util.HashMap;

public class Palindrome {
    public static void polindrom(String s, int n)
    {
        HashMap<Character, Integer> cnt = new HashMap<Character, Integer>();
        String R = "";char[] str = s.toCharArray();
        for (char c : str) {
            if (cnt.containsKey(c))
            {
                cnt.put(c, cnt.get(c) + 1);
            }
            else {cnt.put(c, 1);}
        }
        System.out.println("Map"+cnt);
    for (char i = 'a'; i <= 'z'; i++)
    {
        if (cnt.containsKey(i)) {if (cnt.get(i) % 2 != 0)R += i;
        }
    }
    System.out.println("String "+R);
    int l = R.length();int j = 0;
        for (int i = l - 1; i >= l / 2; i--){
            char charAt = R.charAt(i);
        char charAt2 = R.charAt(j);
        if (cnt.containsKey(charAt))
        {
            cnt.put(charAt, cnt.get(charAt) - 1);
        }
        charAt = charAt2;
        if (cnt.containsKey(charAt2))
        {cnt.put(charAt2, cnt.get(charAt2) + 1);
        }
        j++;
        }
        System.out.println(cnt);
        String first="", middle="", second="";
        for (char i = 'a'; i <= 'z'; i++)
        {
            if (cnt.containsKey(i))
        {
            if (cnt.get(i) != 0)
            {
                if (cnt.get(i) % 2 == 0) {
                    int j1 = 0;
                    while (j1 < cnt.get(i) / 2)
                    {
                        first += i;
                        j1++;
                    }
                }
                else {
                    int j1 = 0;
                    while (j1 < (cnt.get(i) - 1) / 2)
                    {
                        first += i;
                        j1++;
                    }
                    middle += i;
                }
            }
        }
        }
        System.out.println("First name: "+first);
        System.out.println("middle name: "+middle);
        second = first;
        StringBuilder string=new StringBuilder();
        string.append(second);
        StringBuilder reverse = string.reverse();
        String resultant = first + middle + reverse;
        System.out.println("Final Output: "+resultant);
    }
        }

