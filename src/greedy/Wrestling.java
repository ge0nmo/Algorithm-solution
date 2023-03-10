package greedy;

import java.io.*;
import java.util.*;
public class Wrestling
{
    //키와 몸무게를 저장할 클래스를 만들어서 각각 리스트에 넣어준다
    //키를 기준으로 내림차순 정렬을 한다
    //반복문으로 리스트의 첫번째 값부터 몸무게로만 비교를 시작
    //키로 내림차순 정렬을 했기 때문에 몸무게가 이전 사람보다 적다면 탈락
    //몸무게가 최대값인지를 판단 후 최대 값이라면 카운트를 해준다
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Body> list = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.add(new Body(height, weight));
        }

        System.out.println(solution(list));

    }

    public static int solution(List<Body> list)
    {
        int answer = 0;
        int max = Integer.MIN_VALUE;

        Collections.sort(list);

        for(Body body : list)
        {
            if(body.weight > max)
            {
                max = body.weight;
                answer++;
            }
        }

        return answer;
    }
}

class Body implements Comparable<Body>
{
    public int height;
    public int weight;

    public Body(int height, int weight)
    {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Body o)
    {
        return o.height - this.height;
    }

}
