package greedy;

import java.io.*;
import java.util.*;
public class ConferenceRoom
{
    //회의라는 클래스를 생성해서 시작 시간과 종료 시간을 변수로 설정한다.
    //정렬을 할 때 빨리 회의가 종료되는 순서대로 정렬을 하고
    //종료 시간이 같은 경우 빨리 시작하는 회의 순으로 정렬을 한다
    //0을 변수로 설정하고 모든 회의를 반복문으로 돌린다
    //회의 시작 시간이 변수보다 큰 경우 변수를 해당 회의의 종료 시간으로 변경하고 카운트를 해준다

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Conference> list = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new Conference(a, b));
        }

        System.out.println(solution(list));
    }

    public static int solution(List<Conference> list)
    {
        Collections.sort(list);

        int time = 0;
        int answer = 0;

        for(Conference o : list)
        {
            if(o.start >= time)
            {
                time = o.end;
                answer++;
            }
        }

        return answer;
    }
}

class Conference implements Comparable<Conference>
{
    public int start, end;

    public Conference(int start, int end)
    {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Conference o)
    {
        if(this.end == o.end)
            return this.start - this.end;

        else
            return this.end - o.end;
    }
}
