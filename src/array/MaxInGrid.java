package array;

import java.io.*;
import java.util.*;
public class MaxInGrid
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[][] = new int[n][n];
        for(int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(solution1(arr));
    }

    public static int solution1(int arr[][])
    {
        int sum1, sum2;
        int max = Integer.MIN_VALUE;
        int length = arr.length;

        for(int i = 0; i < length; i++)
        {
            sum1 = sum2 = 0;
            for(int j = 0; j < length; j++)
            {
               sum1 += arr[i][j];
               sum2 += arr[j][i];
            }
            max = Math.max(max, sum1);
            max = Math.max(max, sum2);
        }

        sum1 = sum2 = 0;

        for(int i = 0; i < length; i++)
        {
            sum1 += arr[i][i];
            sum2 += arr[i][length - 1 - i];
        }

        max = Math.max(max, sum1);
        max = Math.max(max, sum2);

        return max;
    }
}
