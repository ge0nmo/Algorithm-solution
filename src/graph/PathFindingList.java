package graph;

import java.io.*;
import java.util.*;
public class PathFindingList
{
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int check[];

    public void DFS(int v)
    {
        if(v == n)
            answer++;

        else
        {
            for(int i : graph.get(v))
            {
                if(check[i] == 0)
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
        PathFindingList t = new PathFindingList();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= n; i++)
        {
            graph.add(new ArrayList<Integer>());
        }

        check = new int[n + 1];
        for(int i = 0; i < m; i++)
        {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        check[1] = 1;
        t.DFS(1);

        System.out.println(answer);
    }
}
