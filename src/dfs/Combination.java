package dfs;

import java.io.*;
import java.util.*;
public class Combination
{
    static int n, m;
    static int[] arr, answer;

    static boolean check[];
    public static void DFS(int depth, int s)
    {
        if(depth == m)
        {
            for(int x : answer)
            {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        else
        {
            for(int i = s; i <= n; i++)
            {
                answer[depth] = i;
                DFS(depth + 1, i + 1);
            }
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for(int i = 0; i < n; i++)
        {
            arr[i] = i + 1;
        }

        check = new boolean[n + 1];
        answer = new int[m];

        DFS(0, 1);
    }
}
