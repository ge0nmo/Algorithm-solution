package collection;

import java.util.*;
import java.io.*;
public class FindAllAnagram
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String s = br.readLine();

        System.out.println(solution1(str, s));
    }

    public static int solution1(String str, String s)
    {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        int count = 0;
        int lt = 0;

        for(char ch : s.toCharArray())
        {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < s.length() - 1; i++)
        {
            char ch = str.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }


        for(int rt = s.length() - 1; rt < str.length(); rt++)
        {
            //새로운 단어 더하기
            char newWord = str.charAt(rt);
            map2.put(newWord, map2.getOrDefault(newWord, 0) + 1);

            //비교
            if(map1.equals(map2))
                ++count;

            //앞의 단어 빼기
            char word = str.charAt(lt);
            map2.put(word, map2.get(word) - 1);

            //키의 값이 0이라면 없는 숫자이므로 지운다.
            if(map2.get(word) == 0)
                map2.remove(word);

            ++lt;
        }

        return count;
    }
}
