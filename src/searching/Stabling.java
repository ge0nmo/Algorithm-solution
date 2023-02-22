package searching;

import java.util.*;
import java.io.*;
public class Stabling
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution1(arr, c));
    }

    public static int solution1(int arr[], int c)
    {
        //quickSort(arr, 0, arr.length - 1);
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[arr.length - 1];
        int answer = 0;

        while(lt <= rt)
        {
            int mid = (lt + rt) / 2;

            if(count(arr, mid) >= c)
            {
                answer = mid;
                lt = mid + 1;
            }

            else
                rt = mid - 1;
        }

        return answer;
    }

    public static int count(int arr[], int distance)
    {
        int ep = arr[0];
        int cnt = 1;
        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i] - ep >= distance)
            {
                cnt++;
                ep = arr[i];
            }
        }
        return cnt;
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
