package bfs;

import java.io.*;
import java.util.*;

public class ShortestPathInMaze
{
    //주어진 미로와 같은 배열을 생성
    //이동할 때 마다 복사한 배열에 이동한 거리를 적어준다
    //목적지가 0이라면 길이 막혀 있는거니까 -1
    //아니라면 해당 길이를 출력

    static int arr[][] = new int[8][8];
    static int dis[][] = new int[8][8];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void BFS(int x, int y)
    {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(x, y));

        arr[x][y] = 1;
        while(!que.isEmpty())
        {
            Point cur = que.poll();
            for(int i = 0; i < 4; i++)
            {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && arr[nx][ny] == 0)
                {
                    arr[nx][ny] = 1;
                    que.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[cur.x][cur.y] + 1;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 1; i < 8; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j < 8; j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS(1, 1);

        if(dis[7][7] == 0)
            System.out.print(-1);

        else
            System.out.println(dis[7][7]);


    }
}

class Point
{
    public int x, y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}