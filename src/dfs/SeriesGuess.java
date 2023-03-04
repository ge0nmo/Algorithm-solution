package dfs;

import java.io.*;
import java.util.*;
public class SeriesGuess
{
    static int n, f;
    static int[] b, p;
    static boolean check[];
    static boolean flag = false;
    static int dy[][] = new int[35][35];

    public static int combi(int n, int r)
    {
        if(dy[n][r] > 0)
            return dy[n][r];

        if(n == r || r == 0)
            return 1;

        else
            return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }

    public static void DFS(int depth, int sum)
    {
        if(flag)
            return;

        if(depth == n)
        {
            if(sum == f)
            {
                for(int x : p)
                {
                    System.out.print(x + " ");
                }
                flag = true;
            }

        }

        else
        {
            for(int i = 1; i <= n; i++)
            {
                if(check[i] == false)
                {
                    check[i] = true;
                    p[depth] = i;
                    DFS(depth + 1, sum + (b[depth] * p[depth]));
                    check[i] = false;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        b = new int[n];
        p = new int[n];
        check = new boolean[n + 1];

        for(int i = 0; i < n; i++)
        {
            b[i] = combi(n - 1, i);
        }

        DFS(0, 0);
    }
}
