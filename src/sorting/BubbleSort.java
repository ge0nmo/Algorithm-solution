package sorting;

import java.io.*;
import java.util.*;
public class BubbleSort
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
        for(int i = 0; i < arr.length - 1; i++)
        {
            for(int j = 0; j < arr.length - i - 1; j++)
            {
                if(arr[j] > arr[j + 1])
                    swap(j + 1, j, arr);
            }
        }
    }

    public static void swap(int a, int b, int arr[])
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
