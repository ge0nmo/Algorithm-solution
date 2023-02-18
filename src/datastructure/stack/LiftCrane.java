package datastructure.stack;

import java.io.*;
import java.util.*;
public class LiftCrane
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[][] = new int[n][n];
        for(int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int m = Integer.parseInt(br.readLine());
        int moves[] = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++)
        {
            moves[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution1(moves, arr));
    }

    public static int solution1(int moves[], int arr[][])
    {
        //moves 크기만큼 반복문을 돌린다.
        //arr[][moves]의 가장 상단이 0이 아닐 때까지 for 문을 돌린다
        //0이 아니라면 스택이 비어있는지 확인
        //비어있다면 해당 값을 추가 후 0으로 바꿔준다
        //비어있지 않다면 peek로 해당 값과 비교
        //값이 같으면 count를 2 올린 후 pop
        //다르다면 추가 후 0으로 변환

        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for(int pos : moves)
        {
            for(int i = 0; i < arr.length; i++)
            {
                if(arr[i][pos - 1] != 0)
                {
                    int temp = arr[i][pos - 1];
                    arr[i][pos - 1] = 0;
                    if(!stack.isEmpty() && stack.peek() == temp)
                    {
                        stack.pop();
                        count += 2;
                    }
                    else
                    {
                        stack.push(temp);
                    }
                    break;
                }
            }
        }

        return count;
    }
}
