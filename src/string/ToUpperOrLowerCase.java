package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ToUpperOrLowerCase
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
        //대문자 = 65 ~ 90
        //소문자 = 97 ~ 122

        StringBuilder sb = new StringBuilder();

        for(char ch : str.toCharArray())
        {
            if(ch >= 97 && ch <= 122) //대문자라면
            {
                sb.append((char)(ch-32));
            }

            else
                sb.append((char)(ch + 32));
        }

        return sb.toString();
    }

    public static String solution2(String str)
    {
        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray())
        {
            if(Character.isLowerCase(ch)) //소문자인지 확인
            {
                sb.append(Character.toUpperCase(ch)); //맞으면 대문자로 변환
            }

            else
            {
                sb.append(Character.toLowerCase(ch));
            }
        }

        return sb.toString();
    }
}
