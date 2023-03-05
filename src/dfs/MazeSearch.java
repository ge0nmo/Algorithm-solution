package dfs;

import java.io.*;
import java.util.*;
public class MazeSearch
{
    //네 방향을 탐색해야 하기 때문에 출발지점은 (1, 1)에서 시작
    //(7, 7)에 도착을 하면 카운트 1을 올려준다

    static int arr[][] = new int[8][8];

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    static int answer = 0;

    public static void DFS(int x, int y)
    {
        if(x == 7 && y == 7)
            answer++;

        else
        {
            for(int i = 0; i < 4; i++)
            {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && arr[nx][ny] == 0)
                {
                    arr[nx][ny] = 1;
                    DFS(nx, ny);
                    arr[nx][ny] = 0;
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

        arr[1][1] = 1;

        DFS(1, 1);

        System.out.println(answer);
    }
}
