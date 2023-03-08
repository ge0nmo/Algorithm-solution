package dfs;

import java.io.*;
import java.util.*;
public class IslandDFS
{
    //대각선까지 체크해야하기 때문에 방향을 바꿔줄 배열을 8개로 만든다
    //그리고 배열의 0, 0부터 시작해서 1인 경우 탐색을 시작하고 카운트를 1 올려준다
    //탐색을 할때는 다른 문제들처럼 0 ~ 배열의크기 사이인지 체크하고 육지인 경우(1일 때)만 탐색

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
