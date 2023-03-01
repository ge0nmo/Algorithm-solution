package dfs;

import java.io.*;
import java.util.*;
public class BiggestScore
{
    //점수를 입력받을 배열과 시간을 입력받을 배열을 생성
    //문제의 개수만큼 깊이우선 탐색을 돌린다
    //문제의 개수와 깊이의 개수가 맞는다면 점수의 최대값을 구한다
    //개수가 서로 다르다면 문제를 풀었을 경우와 풀지 않았을 경우 2가지로 나누어 재귀를 돌린다
    //만약 주어진 시간보다 쓴 시간의 합이 더 크다면 리턴

    static int n, m, answer = 0;

    public static void DFS(int depth, int sum, int min, int score[], int time[])
    {
        //쓴 시간의 합이 더 클 경우
        if(min > m)
            return;

        if(depth == n)
            answer = Math.max(answer, sum);

        else
        {
            // 문제를 풀었을 경우
            DFS(depth + 1, sum + score[depth], min + time[depth], score, time);

            //풀지 않았을 경우
            DFS(depth + 1, sum, min, score, time);
        }

    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int score[] = new int[n];
        int time[] = new int[n];

        for(int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine());
            score[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0, 0, score, time);

        System.out.println(answer);
    }
}
