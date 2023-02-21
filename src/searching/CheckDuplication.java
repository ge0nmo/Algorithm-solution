package searching;

import java.util.*;
import java.io.*;
public class CheckDuplication
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

        System.out.print(solution1(arr));
    }

    public static String solution1(int arr[])
    {
        Set<Integer> set = new HashSet();

        for(int i = 0; i < arr.length; i++)
        {
            set.add(arr[i]);
        }

        if(set.size() == arr.length)
            return "U";

        return "D";
    }

    public static String solution2(int arr[])
    {
        quickSort(arr, 0, arr.length - 1);
        for(int i = 0; i < arr.length - 1; i++)
        {
            if(arr[i] == arr[i + 1])
                return "D";
        }

        return "U";
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
