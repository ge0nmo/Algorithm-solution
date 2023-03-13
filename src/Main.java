import java.util.*;
import java.io.*;

public class Main
{
    //금액이 가장 높은 순서대로 내림차순 정렬
    //금액이 같은 경우 날짜가 빠른 순서대로 정렬
    //

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Profit> list = new ArrayList();
        int max = 0;

        for(int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());

            list.add(new Profit(money, day));

            if(day > max)
                max = day;
        }

        System.out.print(solution(list, max));

    }

    public static int solution(List<Profit> list, int max)
    {
        Collections.sort(list);
        int answer = 0;

        for(Profit p : list)
        {
            if(p.day <= max)
            {
                answer += p.money;
                max--;
            }

        }

        return answer;
    }
}

class Profit implements Comparable<Profit>
{
    public int money, day;
    public Profit(int money, int day)
    {
        this.money = money;
        this.day = day;
    }

    public int compareTo(Profit p)
    {
        if(this.money == p.money)
            return this.day - p.day;

        else
            return p.money - this.money;
    }
}