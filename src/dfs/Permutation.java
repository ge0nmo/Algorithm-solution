package dfs;

import java.io.*;
import java.util.*;
public class Permutation
{
    static int n, m;
    static int answer[], arr[];
    static boolean check[];

    public static void DFS(int depth)
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
            for(int i = 0; i < n; i++)
            {
                if(check[i] == false)
                {
                    check[i] = true;
                    answer[depth] = arr[i];
                    DFS(depth + 1);
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
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        check = new boolean[n];
        answer = new int[m];

        DFS(0);

    }
}
