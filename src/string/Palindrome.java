package string;

import java.io.*;
public class Palindrome
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        str = str.toLowerCase();

        System.out.println(solution1(str));
        System.out.println(solution2(str));
        System.out.println(solution3(str));
    }

    public static String solution1(String str)
    {
        int lt = 0;
        int rt = str.length() - 1;

        while(lt < rt)
        {
            if(str.charAt(lt) != str.charAt(rt))
                return "NO";

            ++lt;
            --rt;
        }
        return "YES";
    }

    public static String solution2(String str)
    {
        int length = str.length();

        for(int i = 0; i < length/2; i++)
        {
            if(str.charAt(i) != str.charAt(length - i - 1))
                return "NO";
        }
        return "YES";
    }

    public static String solution3(String str)
    {
        String reverse = new StringBuilder(str).reverse().toString();

        if(!reverse.equalsIgnoreCase(str))
            return "NO";

        return "YES";
    }
}
