package dfs;

import java.io.*;
import java.util.*;
public class CoinExchange
{
    //깊이 우선탐색을 돌리고 동전의 합이 주어진 거스름돈과 같을 때 멈춘다
    //해당 깊이 레벨이 동전의 개수이기 때문에 답을 출력할 변수와, 깊이 레벨 중 작은 값을 저장
    //동전의 합이 작다면 동전의 개수만큼 모두 더해줘야 하기 때문에 동전의 개수만큼 반복문을 돌려준다
    //만약 동전의 합이 거슬러줄 금액보다 크다면 종료
    //다른 동전을 더하고 있을 경우 만약 깊이 레벨이 답을 출력할 변수보다 크다면 더 볼 이유가 없으므로 재귀 종료
    //큰 값부터 더하는 것이 더 빠르므로 주어진 배열을 내림차순으로 정렬
    static int n, m, answer = Integer.MAX_VALUE;

    public static void DFS(int depth, int sum, Integer arr[])
    {
        if(sum > m)
            return;

        if(depth > answer)
            return;

        if(sum == m)
            answer = Math.min(answer, depth);

        else
        {
            for(int i = 0; i < n; i++)
            {
                DFS(depth + 1, sum + arr[i], arr);
            }
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Integer arr[] = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());

        Arrays.sort(arr, Collections.reverseOrder());

        DFS(0, 0, arr);

        System.out.println(answer);
    }
}
