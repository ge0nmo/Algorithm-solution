package string;

import java.io.*;
import java.util.StringTokenizer;

public class ShortestWordDistance
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        char word = st.nextToken().charAt(0);

        int[] answer = solution1(str, word);
        for (int i : answer)
        {
            System.out.print(i + " ");
        }
    }

    public static int[] solution1(String a, char b)
    {
        int answer[] = new int[a.length()];
        int p = 1000;
        for(int i = 0; i < a.length(); i++)
        {
            if(a.charAt(i) == b)
            {
                p = 0;
                answer[i] = p;
            }
            else
            {
                ++p;
                answer[i] = p;
            }
        }

        p = 1000;
        for(int i = a.length() - 1; i >= 0; i--)
        {
            if(a.charAt(i) == b)
                p = 0;


            else
            {
                ++p;
                answer[i] = Math.min(answer[i], p);
            }
        }

        return answer;
    }
}
