package dfs;

import java.util.*;
import java.io.*;

public class SubsetSum
{
    static String answer = "NO";
    static int n, total = 0;
    static boolean flag = false;

    public static void DFS(int L, int sum, int arr[])
    {
        if(flag)
            return;

        if(sum > total/2)
            return;

        if(L == n)
        {
            if((total - sum) == sum)
            {
                answer = "YES";
                flag = true;
            }
        }

        else
        {
            DFS(L + 1, sum + arr[L], arr);
            DFS(L + 1, sum, arr);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        DFS(0, 0, arr);

        System.out.print(answer);
    }
}
