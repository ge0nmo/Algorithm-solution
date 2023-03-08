package bfs;

import java.io.*;
import java.util.*;

public class IslandBFS
{
    //깊이 우선탐색과 마찬가지로 배열의 0, 0부터 시작
    //1인 경우 카운트를 해주고 넓이 우선 탐색 시작
    //해당 배열을 큐에 넣고 큐가 비어있을 때까지 탐색

    static int n, answer = 0;
    static int arr[][];

    static Queue<Point> que = new LinkedList<>();
    static int dx[] = {-1, 0, 1, 0, 1, -1, 1, -1};
    static int dy[] = {0, 1, 0, -1, 1, -1, -1, 1};

    public static void BFS(int x, int y, int arr[][])
    {
        que.offer(new Point(x, y));
        while(!que.isEmpty())
        {
            Point cur = que.poll();

            for(int i = 0; i < 8; i++)
            {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] == 1)
                {
                    arr[nx][ny] = 0;
                    que.offer(new Point(nx, ny));

                }
            }
        }
    }

    public static void solution(int arr[][])
    {
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(arr[i][j] == 1)
                {
                    answer++;
                    arr[i][j] = 0;
                    BFS(i, j, arr);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for(int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(arr);

        System.out.println(answer);

    }
}
