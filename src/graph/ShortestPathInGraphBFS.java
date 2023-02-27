package graph;

import tree.ShortestPathDFS;

import java.util.*;
import java.io.*;
public class ShortestPathInGraphBFS
{

    static boolean check[];
    static int dis[];
    static int n, m;

    static ArrayList<ArrayList<Integer>> graph;
    public void BFS(int v)
    {
        Queue<Integer> que = new LinkedList<>();
        check[v] = true;
        dis[v] = 0;
        que.offer(v);

        while(!que.isEmpty())
        {
            int cur = que.poll();
            for(int i : graph.get(cur))
            {
                if(check[i] == false)
                {
                    check[i] = true;
                    que.offer(i);
                    dis[i] = dis[cur] + 1;
                }
            }
        }


    }

    public static void main(String[] args) throws IOException
    {
        ShortestPathInGraphBFS t = new ShortestPathInGraphBFS();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  =new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= n; i++)
        {
            graph.add(new ArrayList<>());
        }

        check = new boolean[n + 1];
        dis = new int[n + 1];
        for(int i = 0; i < m; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
        }

        t.BFS(1);

        for(int i = 2; i <= n; i++)
        {
            System.out.println(i + " : " + dis[i]);
        }

    }
}
