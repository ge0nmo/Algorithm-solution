package array;

import java.io.*;
import java.util.*;
public class ClassPresident
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[][] = new int[n + 1][6];
        for(int i = 1; i <= n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 5; j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(solution1(n, arr));
    }

    public static int solution1(int n, int arr[][])
    {
        int max = Integer.MIN_VALUE;
        int answer = 0;

        for(int i = 1; i <= n; i++)
        {
            int count = 0;
            for(int j = 1; j <= n; j++)
            {

                for(int k = 1; k <= 5; k++)
                {
                    if(arr[i][k] == arr[j][k])
                    {
                        ++count;
                        break;
                    }
                }
            }
            if(count > max)
            {
                max = count;
                answer = i;
            }
        }

        return answer;
    }
}
