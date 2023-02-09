package string;

import java.io.*;

public class ReverseOnlyAlphabet
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        System.out.println(solution1(word));

    }

    public static String solution1(String word)
    {
        char ch[] = word.toCharArray();
        int lt = 0;
        int rt = word.length() - 1;

        while(lt < rt)
        {
            if(!Character.isAlphabetic(ch[lt]))
                ++lt;

            else if (!Character.isAlphabetic(ch[rt]))
                --rt;

            else
            {
                char temp = ch[lt];
                ch[lt] = ch[rt];
                ch[rt] = temp;
                ++lt;
                --rt;
            }
        }

        return String.valueOf(ch);
    }
}
