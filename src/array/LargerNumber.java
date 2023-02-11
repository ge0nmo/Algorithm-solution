package array;

import java.io.*;
import java.util.*;
public class LargerNumber
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[num];

        for(int i = 0; i < num; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution1(num, arr));
    }

    public static String solution1(int n, int arr[])
    {
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append(" ");

        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i] >= arr[i - 1])
                sb.append(arr[i]).append(" ");
        }

        return sb.toString();
    }
}
