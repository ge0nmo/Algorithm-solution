package datastructure.queue;

import java.io.*;
import java.util.*;
public class SavePrincess
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(solution1(n, k));
    }
    public static int solution1(int n, int k)
    {
        //큐에 1 ~ n 까지 숫자를 넣는다.
        //큐의 크기가 1이 될 때까지 반복문을 돌린다.
        //0부터 숫자를 외치고 주어진 값 k와 숫자를 비교한다
        //k와 같지 않다면 큐의 앞 부분을 빼낸 후에 맨 뒤로 보낸다.
        //k와 같다면 큐의 앞 부분을 지운다.
        //최종적으로 남아있는 숫자를 리턴

        Queue<Integer> que = new LinkedList<>();
        int answer = 0;

        for(int i = 1; i <= n; i++)
        {
            que.offer(i);
        }

        while(!que.isEmpty())
        {
            for(int i = 1; i < k; i++)
            {
                que.offer(que.poll());
            }

            que.poll();

            if(que.size() == 1)
                answer = que.poll();
        }

        return answer;
    }
}
