package dfs;

import java.io.*;
import java.util.StringTokenizer;

public class DogsInTruck
{
    //바둑이를 태우는 부분 O, 태우지 않는 부분 X로 나눠서 깊이 우선 탐색을 돌린다
    //마리수 = 깊이
    //sum 의 값이 무게 제한보다 크다면 return
    //바둑이 마리 수와 깊이 레벨이 같다면 총 합과, 답을 출력할 최종 값 중에 더 큰 수를 저장
    //마리수가 같지 않다면 더 태울 수 있으므로 깊이를 1단계 더하고, 태우는 부분 (sum + 배열[깊이]), 배열을 집어넣고 재귀
    //태우지 않는 부분은 깊이만 한 단계 추가한 채로 재귀

    static int c, n, answer = 0;

    public static void DFS(int L, int sum, int arr[])
    {
        if(sum > c)
            return;

        if(L == n)
            answer = Math.max(answer, sum);

        else
        {
            DFS(L + 1, sum + arr[L], arr);
            DFS(L + 1, sum, arr);
        }

    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            arr[i] = Integer.parseInt(br.readLine());
        }

        DFS(0, 0, arr);

        System.out.println(answer);
    }
}
