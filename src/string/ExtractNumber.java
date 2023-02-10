package string;
import java.io.*;
import java.util.Scanner;

public class ExtractNumber
{
    public static void main(String ars[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution1(str));
        System.out.println(solution2(str));

    }

    public static int solution1(String str)
    {
        String answer = str.replaceAll("[^0-9]]", "");

        return Integer.parseInt(answer);
    }

    public static int solution2(String str)
    {
        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray())
        {
            if(Character.isDigit(ch))
            {
                sb.append(ch);
            }
        }

        return Integer.parseInt(sb.toString());
    }
}
