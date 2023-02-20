package sorting;

import java.io.*;
import java.util.*;

public class InsertionSort
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution1(arr);
        for(int i : arr)
        {
            System.out.print(i + " ");
        }
    }

    public static void solution1(int arr[])
    {
        for(int target = 1; target < arr.length; target++)
        {
            int temp = arr[target];
            int i = target - 1;

            while(i >= 0 && arr[i] > temp)
            {
                arr[i + 1] = arr[i];
                --i;
            }
            arr[i + 1] = temp;
        }
    }
}
