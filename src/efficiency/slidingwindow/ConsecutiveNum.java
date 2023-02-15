package efficiency.slidingwindow;

import java.io.*;
import java.util.*;
public class ConsecutiveNum
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(solution1(n));
        System.out.println(solution2(n));
    }

    public static int solution1(int n)
    {
        int lt = 1;
        int sum = 0;
        int count = 0;

        for(int rt = 1; rt <= n / 2 + 1; rt++)
        {
            sum += rt;
            if(sum == n)
                ++count;

            while(sum >= n)
            {
                sum -= lt++;
                if(sum == n)
                    ++count;
            }
        }

        return count;
    }

    public static int solution2(int n)
    {
        int lt = 0;
        int sum = 0;
        int count = 0;
        int m = n / 2 + 1;

        int arr[] = new int[m];
        for(int i = 0; i < m; i++)
        {
            arr[i] = i + 1;
        }

        for(int rt = 0; rt < m; rt++)
        {
            sum += arr[rt];
            if(sum == n)
                ++count;

            while(sum >= n)
            {
                sum -= arr[lt++];
                if(sum == n)
                    ++count;
            }
        }

        return count;
    }
}
