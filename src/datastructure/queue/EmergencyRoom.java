package datastructure.queue;

import java.util.*;
import java.io.*;

public class EmergencyRoom
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution1(arr, m));
    }

    public static int solution1(int arr[], int m)
    {
        //클래스를 만들어서 id와 우선순위를 변수로 만든다
        //큐에 각 환자의 id와 우선순위를 넣는다
        //큐가 비어있을 때까지 반복문을 돌린다.
        //큐를 꺼낸 후 반복문으로 나머지 큐에 있는 우선순위와 비교를 한다
        //꺼낸 값보다 더 큰 우선순위가 있다면 큐에 값을 다시 집어 넣고 값을 null로 변환 후 반복문 종료
        //값이 null이라면 치료를 받지 않는 것이므로 다시 처음부터 반복
        //null이 아니라면 치료를 받아야하기 때문에 카운트를 올려준 후 id를 비교
        //id값이 같다면 카운트를 리턴
        //다르다면 다른 환자이므로 처음부터 다시 반복

        Queue<Person> que = new LinkedList<>();
        int count = 0;

        for(int i = 0; i < arr.length; i++)
        {
            que.offer(new Person(i, arr[i]));
        }

        while(!que.isEmpty())
        {
            Person temp = que.poll();

            for (Person person : que)
            {
                if(person.priority > temp.priority)
                {
                    que.offer(temp);
                    temp = null;
                    break;
                }
            }

            if(temp != null)
            {
                ++count;

                if(temp.id == m)
                    return count;
            }
        }

        return count;
    }
}

class Person
{
    int id;
    int priority;

    public Person(int id, int priority)
    {
        this.id = id;
        this.priority = priority;
    }
}

