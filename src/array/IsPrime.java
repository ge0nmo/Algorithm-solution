package array;

import java.io.*;
public class IsPrime
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.print(solution1(n));
    }

    private static int solution1(int n)
    {
        boolean check[] = new boolean[n + 1];
        int count = 0;

        for(int i = 2; i <= n; i++)
        {
            if(!check[i])
                ++count;

            for(int j = i; j <= n; j += i)
                check[j] = true;
        }

        return count;
    }
}
