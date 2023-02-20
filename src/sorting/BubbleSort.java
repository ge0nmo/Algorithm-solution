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
            boolean swapped = false;
            for(int j = 0; j < arr.length - i - 1; j++)
            {
                if(arr[j] > arr[j + 1])
                {
                    swap(j + 1, j, arr);
                    swapped = true;
                }
            }
            //스왑된 것이 없다면 더 이상 정렬할 것이 없다.
            //배열은 정렬된 상태라는 뜻
            if(!swapped)
                break;
        }
    }

    public static void swap(int a, int b, int arr[])
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
