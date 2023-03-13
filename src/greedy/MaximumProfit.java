package greedy;

import java.io.*;
import java.util.*;
public class MaximumProfit
{
    //강연이라는 클래스를 만들고 금액과 날짜라는 변수를 만든다
    //날짜가 큰 수부터 내림차순으로 정렬을 한다
    //리스트로 강의를 입력 받고 가장 큰 날짜를 찾는다
    //가장 큰 날짜부터 시작해서 하루씩 줄어드는 반복문을 돌린다
    //그 안에는 리스트를 탐색할 반복문을 돌린다
    //가장 큰 값이 poll 되는 우선순위 큐를 만들고 강의를 할 수 있는 날짜면 큐에 넣는다
    //두번째 반복문이 종료되면 가장 큰 값을 큐에서 꺼내서 더한다

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Lecture> list = new ArrayList();
        int max = 0;

        for (int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());

            list.add(new Lecture(money, day));

            if(day > max)
                max = day;
        }

        System.out.print(solution(list, max, n));
    }

    public static int solution(List<Lecture> list, int max, int n)
    {
        Collections.sort(list);
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        int j = 0;

        for(int i = max; i >= 1; i--)
        {
            for(; j < n; j++)
            {
                if(list.get(j).day < i)
                {
                    break;
                }

                que.offer(list.get(j).money);
            }

            if(!que.isEmpty())
                answer += que.poll();
        }

        return answer;
    }
}

class Lecture implements Comparable<Lecture>
{
    public int money, day;

    public Lecture(int money, int day)
    {
        this.money = money;
        this.day = day;
    }

    @Override
    public int compareTo(Lecture o)
    {
        return o.day - this.day;
    }
}