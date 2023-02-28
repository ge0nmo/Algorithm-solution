package dfs;

import java.util.*;
import java.io.*;

public class SubsetSum
{
    //원소의 개수만큼 깊이 우선 탐색을 돌린다
    //체크 값이 false 일때 돌리고 true 라면 바로 리턴
    //원소의 개수와 깊이 레벨이 같다면 total - sum 값이 sum 인지 체크
    //맞다면 answer = YES 후에 뒤의 깊이들은 체크할 필요가 없으므로 체크 값을 true 로 변경
    //틀리다면 answer = NO

    static int total = 0;
    static int n;
    static String answer = "NO";
    static boolean check = false;

    public static void DFS(int L, int sum, int arr[])
    {
        if(check)
            return;

        if(sum > total/ 2)
            return;

        if(L == n)
        {
            if((total - sum) == sum)
            {
                answer = "YES";
                check = true;
            }
        }

        else
        {
            DFS(L + 1, sum + arr[L], arr);
            DFS(L + 1, sum, arr);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        DFS(0, 0, arr);

        System.out.println(answer);

    }
}
