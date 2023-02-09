package string;

import java.io.*;


public class ValidPalindrome
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution1(str));
        System.out.println(solution2(str));
    }

    public static String solution1(String str)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++)
        {
            if(Character.isAlphabetic(str.charAt(i)))
            {
                sb.append(str.charAt(i));
            }
        }

        String word = sb.toString();
        word = word.toLowerCase();

        String reverse = new StringBuilder(word).reverse().toString();
        if(reverse.equalsIgnoreCase(word))
            return "YES";

        return "NO";
    }

    public static String solution2(String str)
    {
        str = str.toLowerCase().replaceAll("[^a-z]", "");
        String word = new StringBuilder(str).reverse().toString();

        if(str.equalsIgnoreCase(word))
            return "YES";

        return "NO";
    }

}