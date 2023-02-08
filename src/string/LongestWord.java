package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LongestWord
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        System.out.println(solution1(word));
        System.out.println(solution2(word));
        System.out.println(solution3(word));
    }

    public static String solution1(String str)
    {
        StringTokenizer st = new StringTokenizer(str);
        String answer = "";

        while(st.hasMoreTokens())
        {
            String word = st.nextToken();
            if(word.length() > answer.length()) answer = word;

        }
        return answer;
    }

    public static String solution2(String str)
    {
        String answer = "";
        String array[] = str.split(" ");
        int min = Integer.MIN_VALUE;

        for(String word : array)
        {
            if(word.length() > min)
            {
                min = word.length();
                answer = word;
            }
        }
        return answer;
    }

    public static String solution3(String str)
    {
        String answer = "";
        int min = Integer.MIN_VALUE, pos;

        while((pos = str.indexOf(' ')) != -1) //띄어쓰기가 있다면 반복문이 돈다
        {
            String temp = str.substring(0, pos);
            int len = temp.length();
            if(len > min)
            {
                min = len;
                answer = temp;
            }
            str = str.substring(pos + 1);
        }
        if(str.length() > min)
            answer = str;

        return answer;
    }
}

