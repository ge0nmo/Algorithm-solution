package greedy;

import java.io.*;
import java.util.*;
public class Wedding
{
    //방문자 클래스에 시간과 상태라는 변수를 만든다
    //입력을 받을 때 첫번째 숫자는 입장 시간, 두 번째 숫자는 퇴장 시간이기 때문에
    //입장을 s, 퇴장을 e라고 정한다
    //방문객을 가지는 리스트를 생성 후 입력을 받기 시작
    //첫 번째 숫자는 상태를 s로 저장, 두 번째 숫자는 상태를 e로 저장
    //리스트 정렬을 할 때 시간 별로 오름차순 정렬을 하되, 시간이 같은 경우는 퇴장을 우선으로 정렬을 한다
    //그렇게 하지 않으면 최대값이 변경 될 수 있음
    //입력받은 입장객 리스트를 반복문으로 돌리고 상태를 체크한다
    //입장이면 카운트를 올리고, 퇴장이면 카운트를 내린다
    //그 후 정답 변수와, 카운트 변수 중 큰 값으로 정답 변수를 정한다.

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Visitor> list = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());

            int b = Integer.parseInt(st.nextToken());

            list.add(new Visitor(a, 'S'));
            list.add(new Visitor(b, 'E'));
        }

        System.out.println(solution(list));

    }

    public static int solution(List<Visitor> list)
    {
        Collections.sort(list);
        int count = 0;
        int answer = 0;

        for(Visitor v : list)
        {
            if(v.status == 'S')
                count++;

            else
                count--;

            answer = Math.max(answer, count);
        }

        return answer;
    }
}

class Visitor implements Comparable<Visitor>
{
    public int time;
    public char status;
    public Visitor(int time, char status)
    {
        this.time = time;
        this.status = status;
    }

    @Override
    public int compareTo(Visitor v)
    {
        if(this.time == v.time)
            return this.status - v.status;

        else
            return this.time - v.time;
    }
}
