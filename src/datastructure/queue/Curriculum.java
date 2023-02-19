package datastructure.queue;

import java.io.*;
import java.util.*;
public class Curriculum
{
    public static void main(String args[])  throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String plan = br.readLine();

        System.out.println(solution1(str, plan));
        System.out.println(solution2(str, plan));
    }

    public static String solution1(String str, String plan)
    {
        Queue<Character> que = new LinkedList<>();
        Queue<Character> answer = new LinkedList<>();

        for(char ch : str.toCharArray())
        {
            que.offer(ch);
        }

        for(char ch : plan.toCharArray())
        {
            if(que.contains(ch))
                answer.offer(ch);
        }

        return que.equals(answer) ? "YES" : "NO";
    }

    public static String solution2(String str, String plan)
    {
        //큐에 필수과목을 넣는다
        //수업설계 과목들을 반복문으로 돌린다.
        //필수과목을 넣은 큐에 과목이 포함되있는지 검사
        //포함 되있다면 큐의 값을 꺼냈을 때 해당 과목인지 검사
        //다른 과목이라면 순서가 다르므로 NO 리턴
        //최종적으로 큐가 비어있다면 모든 필수과목을 넣은 것이므로 YES 리턴
        //비어있지 않다면 필수 과목을 넣지 않은 것이므로 NO 리턴

        Queue<Character> que = new LinkedList<>();

        for(char ch : str.toCharArray())
        {
            que.offer(ch);
        }

        for(char ch : plan.toCharArray())
        {
            if(que.contains(ch))
            {
                if(que.poll() != ch)
                    return "NO";
            }
        }

        return que.isEmpty() ? "YES" : "NO";
    }
}
