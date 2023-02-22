package searching;

import java.util.*;
import java.io.*;
public class BinarySearch
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution1(arr, m));
    }

    public static int solution1(int arr[], int key)
    {
        quickSort(arr, 0, arr.length - 1);
        int start = 0;
        int end = arr.length - 1;
        int idx = 0;

        while(start <= end)
        {
            int mid = (start + end) /2;

            if(arr[mid] == key)
            {
                idx = mid + 1;
                break;
            }

            else if(arr[mid] > key)
                end = mid - 1 ;

            else
                start = mid + 1;
        }

        return idx;
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

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

            arr[left] = arr[i];
            arr[i] = pivot;
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }
}
