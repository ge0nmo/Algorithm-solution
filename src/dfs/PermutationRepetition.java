package dfs;

import java.io.*;
import java.util.*;
public class PermutationRepetition
{
    static int n, m;
    static int arr[];

    public static void DFS(int depth)
    {
        if(depth == m)
        {
            for (int x : arr)
            {
                System.out.print(x + " ");
            }

            System.out.println();
        }

        else
        {
            for(int i = 1; i <= n; i++)
            {
                arr[depth] = i;
                DFS(depth + 1);
            }
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        DFS(0);
    }
}
