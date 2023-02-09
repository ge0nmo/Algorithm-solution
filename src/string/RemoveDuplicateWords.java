package string;

import java.io.*;

public class RemoveDuplicateWords
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        System.out.println(solution1(word));

    }

    public static String solution1(String str)
    {
        StringBuilder sb = new StringBuilder();

        //indexOf 해당 단어가 존재하는 위치가 i와 같다면 처음 등장하는 단어
        for(int i = 0; i < str.length(); i++)
        {
            if(i == str.indexOf(str.charAt(i)))
                sb.append(str.charAt(i));
        }

        return sb.toString();
    }
}
