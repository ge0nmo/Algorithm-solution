package sorting;

import java.io.*;
import java.util.*;
public class QuickSort
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

        quickSort(arr, 0, arr.length - 1);
        for (int i : arr)
        {
            System.out.print(i + " ");
        }
    }

    public static void quickSort(int arr[], int left, int right)
    {
        int i, j, pivot;

        if(left < right)
        {
            i = left;
            j = right;
            pivot = arr[left];

            while(i < j)
            {
                while(arr[j] > pivot)
                {
                    j--;
                }

                while(i < j && arr[i] <= pivot)
                {
                    i++;
                }

                swap(i, j, arr);
            }

            arr[left] = arr[i];
            arr[i] = pivot;

            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }


    public static void swap(int a, int b, int arr[])
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
