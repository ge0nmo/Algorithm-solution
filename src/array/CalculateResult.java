package array;

import java.io.*;
import java.util.StringTokenizer;

public class CalculateResult
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = "";

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
        {
            str += st.nextToken();
        }

        System.out.print(solution1(str));
    }

    public static int solution1(String str)
    {
        int result = 0;
        int count = 1;

        for(char ch : str.toCharArray())
        {
            if (ch == '1')
            {
                result += count;
                ++count;
            }
            else
                count = 1;
        }

        return result;
    }
}
