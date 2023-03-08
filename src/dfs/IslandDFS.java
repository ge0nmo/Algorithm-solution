package dfs;

import java.io.*;
import java.util.*;
public class Island
{
    static int n, answer = 0;
    static int arr[][];

    static int dx[] = {-1, 0, 1, 0, 1, -1, 1, -1};
    static int dy[] = {0, 1, 0, -1, 1, -1, -1, 1};

    public static void DFS(int x, int y, int arr[][])
    {
        for(int i = 0; i < 8; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] == 1)
            {
                arr[nx][ny] = 0;
                DFS(nx, ny, arr);
            }
        }

    }

    public static void solution(int board[][])
    {
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i][j] == 1)
                {
                    answer++;
                    board[i][j] = 0;
                    DFS(i, j, board);
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
