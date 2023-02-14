package efficiency.slidingwindow;

import java.util.*;
import java.io.*;

public class BiggestSales
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int days = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution1(days, arr));
        System.out.println(solution2(days, arr));
    }

    //744ms
    public static int solution1(int days, int arr[])
    {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length - days; i++)
        {
            int sum = 0;
            for(int j = i; j < i + days; j++)
            {
                sum += arr[j];
            }

            if(sum > max)
                max = sum;
        }

        return max;
    }

    //243ms
    public static int solution2(int days, int arr[])
    {
        int sum = 0;
        int max = 0;

        for(int i = 0; i < days; i++)
        {
            sum += arr[i];
        }

        max = sum;

        for(int i = days; i < arr.length; i++)
        {
            sum += (arr[i] + arr[i - days]);
            max = Math.max(sum, max);
        }

        return max;
    }
}
