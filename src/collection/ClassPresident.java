package collection;

import java.io.*;
import java.util.*;
public class ClassPresident
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        System.out.println(solution1(str));
    }

    public static char solution1(String str)
    {
        Map<Character, Integer> map = new HashMap();
        char answer = ' ';
        int max = Integer.MIN_VALUE;

        for(char ch : str.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(char key : str.toCharArray())
        {
            if(map.get(key) > max)
            {
                max = map.get(key);
                answer = key;
            }
        }

        return answer;
    }
}
