package array;

import java.util.*;
import java.io.*;
public class CountPeak
{
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //solution1
        int arr[][] = new int[n + 2][n +2];

        for(int i = 1; i < arr.length - 1; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j < arr.length - 1; j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution1(arr));


        //solution2
        int arr2[][] = new int[n][n];

        for(int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
            {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution2(n, arr2));
    }

    public static int solution1(int[][] arr)
    {
        int count = 0;
        for(int i = 1; i < arr.length - 1; i++)
        {
            for(int j = 1; j < arr.length - 1; j++)
            {
                if(check(arr[i][j], arr[i + 1][j], arr[i - 1][j], arr[i][j + 1], arr[i][j - 1]))
                    ++count;
            }
        }

        return count;
    }



    private static boolean check(int num, int a, int b, int c, int d)
    {
        if(a >= num)
            return false;

        if(b >= num)
            return false;

        if(c >= num)
            return false;

        if(d >= num)
            return false;

        return true;
    }

    public static int solution2(int n, int arr[][])
    {
        int count = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                boolean flag = true;
                for(int k = 0; k < 4; k++)
                {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx >= 0 & nx < n && ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j])
                    {
                        flag = false;
                        break;
                    }

                }
                if(flag)
                    ++count;
            }
        }

        return count;
    }
}
