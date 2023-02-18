package datastructure.stack;

import java.util.*;
import java.io.*;

public class Postfix
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(solution1(str));
    }

    public static int solution1(String str)
    {
        //문자열의 크기만큼 반복문을 돌린다
        //만약 문자가 숫자라면 스택에 집어넣고
        //연산자라면 스택에 있는 2개의 수를 빼온다.
        //가장 먼저 빼낸 수가 오른쪽, 두번째로 빼낸 수가 왼쪽에서 계산 시작
        //계산 후 다시 집어넣고 문자 비교
        //반복문이 끝난 후 스택에서 저장 된 1개의 숫자를 리턴

        Stack<Integer> stack = new Stack();

        for(char ch : str.toCharArray())
        {
            if(Character.isDigit(ch))
                stack.push(ch - 48);

            else
            {
                int rt = stack.pop();
                int lt = stack.pop();

                if(ch == '+')
                    stack.push(lt + rt);

                else if(ch == '-')
                    stack.push(lt - rt);

                else if(ch == '*')
                    stack.push(lt * rt);

                else
                    stack.push(lt / rt);
            }
        }

        return stack.pop();
    }
}
