package datastructure.stack;

import java.util.*;
import java.io.*;
public class IronBar
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(solution1(str));
    }

    public static int solution1(String str)
    {
        //문자열을 반복문으로 돌린다.
        //여는 괄호가 나오면 스택에 push
        //닫는 괄호가 나오면 pop 해준 뒤 스택의 가장 윗 부분과 비교
        //여는 괄호면 레이저이기 때문에 스택의 크기만큼 더해준다
        //닫는 괄호라면 +1만 해준다
        //최종 count 개수를 리턴

        Stack<Character> stack = new Stack<>();
        int count = 0;

        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == '(')
                stack.push('(');

            else
            {
                stack.pop();
                if(str.charAt(i - 1) == '(')
                    count += stack.size();

                else
                    ++count;
            }
        }

        return count;
    }
}
