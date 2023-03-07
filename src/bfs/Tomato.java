package bfs;

import java.io.*;
import java.util.*;
public class Tomato
{
    //토마토를 입력 받을 때 익은 토마토(1인 경우)라면 큐에 집어 넣는다
    //큐를 하나씩 꺼내면서 해당 좌표의 상하좌우를 살핀다.
    //0이라면 토마토를 익은것(1)으로 교체를 하고 날짜를 2차원 배열에 적는다
    //토마토 상자에 0이라는 숫자(익지 않은 토마토)가 아직 존재한다면 고립된 토마토이기 때문에 -1을 출력
    //0이라는 숫자가 없다면 날짜 배열을 모두 돌려 가장 큰 수를 출력

    static int m, n;
    static int[][] arr, dis;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};

    static Queue<Point> que = new LinkedList<>();

    public static void solution1()
    {
        while(!que.isEmpty())
        {
            Point cur = que.poll();

            for(int i = 0; i < 4; i++)
            {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == 0)
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        dis = new int[n][m];

        for(int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == 1)
                    que.offer(new Point(i, j));

            }
        }


        solution1();

        int answer = Integer.MIN_VALUE;
        boolean flag = true;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(arr[i][j] == 0)
                    flag = false;

            }
        }

        if(flag)
        {
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < m; j++)
                {
                    answer = Math.max(answer, dis[i][j]);
                }
            }

            System.out.println(answer);
        }

        else
            System.out.println(-1);


    }
}
