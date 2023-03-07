package graph;

import java.util.*;
import java.io.*;
public class ShortestPathInGraphBFS
{
    //레벨을 이용해 푸는 방법과 배열을 이용해 푸는 방법 2가지가 있다

    static boolean check1[]; //배열용

    static boolean check2[]; //레벨용
    static int arr1[]; //배열용
    static int arr2[]; //레벨용
    static int n, m;

    static ArrayList<ArrayList<Integer>> graph;

    //배열을 이용한 풀이
    public static void solution1(int v)
    {
        Queue<Integer> que = new LinkedList<>();
        check1[v] = true;
        arr1[v] = 0;
        que.offer(v);

        while(!que.isEmpty())
        {
            int cur = que.poll();
            for(int i : graph.get(cur))
            {
                if(check1[i] == false)
                {
                    check1[i] = true;
                    que.offer(i);
                    arr1[i] = arr1[cur] + 1;
                }
            }
        }
    }

    //레벨을 이용한 풀이
    public static void solution2(int v)
    {
        Queue<Integer> que = new LinkedList<>();
        que.offer(v);
        int depth = 0;
        check2[1] = true;

        while(!que.isEmpty())
        {
            int length = que.size();
            for(int i = 0; i < length; i++)
            {
                Integer cur = que.poll();
                for(int x : graph.get(cur))
                {
                    if(!check2[x])
                    {
                        check2[x] = true;
                        que.offer(x);
                        arr2[x] = depth + 1;
                    }
                }
            }
            depth++;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  =new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= n; i++)
        {
            graph.add(new ArrayList<>());
        }

        check1 = new boolean[n + 1];
        check2 = new boolean[n + 1];
        arr1 = new int[n + 1];
        arr2 = new int[n + 1];
        for(int i = 0; i < m; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
        }

        solution1(1);
        solution2(1);

        for(int i = 2; i <= n; i++)
        {
            System.out.println(i + " : " + arr1[i]);
        }

        System.out.println("------------------------");

        for(int i = 2; i <= n; i++)
        {
            System.out.println(i + " : " + arr2[i]);
        }

    }
}
