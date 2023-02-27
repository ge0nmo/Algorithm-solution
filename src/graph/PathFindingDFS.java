package graph;

import java.io.*;
import java.util.StringTokenizer;

public class PathFindingDFS
{
    static int n, m, answer = 0;
    static int check[];
    static int graph[][];


    public void DFS(int v)
    {
        if(v == n)
            answer++;

        else
        {
            for(int i = 1; i <= n; i++)
            {
                if(graph[v][i] != 0 && check[i] == 0)
                {
                    check[i] = 1;
                    DFS(i);
                    check[i] = 0;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException
    {
        PathFindingDFS t = new PathFindingDFS();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];
        check = new int[n + 1];

        for(int i = 0; i < m; i++)
        {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
        }

        check[1] = 1;
        t.DFS(1);
        System.out.println(answer);
    }
}
