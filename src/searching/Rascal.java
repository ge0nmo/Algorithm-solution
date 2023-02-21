package searching;

import java.util.*;
import java.io.*;
public class Rascal
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


        for(int i : solution1(arr))
        {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> solution1(int arr[])
    {
        List<Integer> list = new ArrayList<>();
        int temp[] = arr.clone();

        quickSort(temp, 0, arr.length - 1);
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] != temp[i])
                list.add(i + 1);
        }

        return list;
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
