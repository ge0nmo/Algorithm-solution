package efficiency.twopointers;

import java.io.*;
import java.util.*;

public class FindCommonNum
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr1[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
        {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int arr2[] = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++)
        {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        for(int i : solution1(arr1, arr2))
        {
            System.out.print(i + " ");
        }

    }

    public static List<Integer> solution1(int arr1[], int arr2[])
    {
        List<Integer> list = new ArrayList<>();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int p1 = 0;
        int p2 = 0;

        while(p1 < arr1.length && p2 < arr2.length)
        {
            if(arr1[p1] == arr2[p2])
            {
                list.add(arr1[p1++]);
                ++p2;
            }

            else if(arr1[p1] > arr2[p2])
                ++p2;

            else if(arr1[p1] < arr2[p2])
                ++p1;
        }

        return list;
    }
}
