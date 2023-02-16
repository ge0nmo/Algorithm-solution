package collection;

import java.io.*;
import java.util.*;
public class Anagram
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        System.out.println(solution1(str1, str2));
    }

    public static String solution1(String str1, String str2)
    {
        Map<Character, Integer> map = new HashMap<>();

        for(char ch : str1.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(char ch : str2.toCharArray())
        {
            if(!map.containsKey(ch) || map.get(ch) == 0)
                return "NO";

            map.put(ch, map.get(ch) - 1);
        }

        return "YES";
    }
}
