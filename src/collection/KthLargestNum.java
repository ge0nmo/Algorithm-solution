package collection;

import java.io.*;
import java.util.*;
public class KthLargestNum
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution1(arr, k));
    }

    public static int solution1(int arr[], int k)
    {
        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for(int i = 0; i < arr.length - 2; i++)
        {
            for(int j = i + 1; j < arr.length - 1; j++)
            {
                for(int l = j + 1; l < arr.length; l++)
                {
                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        int count = 0;
        for(int i : set)
        {
            ++count;
            if(count == k)
                return i;
        }

        return -1;
    }
}
