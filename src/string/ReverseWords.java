package string;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class ReverseWords
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String str[] = new String[num];

        for(int i = 0; i < num; i++)
        {
            str[i] = br.readLine();
        }

        for(String word1 : solution1(str))
        {
            System.out.println(word1);
        }

        for(String word2 : solution2(str))
        {
            System.out.println(word2);
        }

        System.out.println(solution3(str));

    }

    public static List<String> solution1(String str[])
    {
        List<String> list = new ArrayList();

        for(String word : str)
        {
            String answer = new StringBuilder(word).reverse().toString();
            list.add(answer);
        }
        return list;
    }

    public static List<String> solution2(String str[])
    {
        List<String> list = new ArrayList<>();

        for(String word : str)
        {
            char ch[] = word.toCharArray();
            int lt = 0;
            int rt = word.length() - 1;

            while(lt < rt)
            {
                char temp = ch[lt];
                ch[lt] = ch[rt];
                ch[rt] = temp;

                ++lt;
                --rt;
            }
            String answer = String.valueOf(ch);
            list.add(answer);
        }
        return list;
    }

    public static String solution3(String str[])
    {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length; i++)
        {
            for(int j = 0; j < str[i].length(); j++)
            {
                char ch = str[i].charAt(str[i].length() - 1 - j);
                sb.append(ch);
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
