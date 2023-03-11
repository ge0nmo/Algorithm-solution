package greedy;

import java.io.*;
import java.util.*;
public class ConferenceRoom
{
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
