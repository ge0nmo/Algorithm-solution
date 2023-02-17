package datastructure.stack;

import java.util.*;
import java.io.*;

public class RemoveParentheses
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.print(solution1(str));
    }

    public static String solution1(String str)
    {
        Stack<Character> stack = new Stack();

        for(char ch : str.toCharArray())
        {
            if(ch == ')')
            {
                while (stack.pop() != '(');
            }

            else
                stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < stack.size(); i++)
        {
            sb.append(stack.get(i));
        }

        return sb.toString();

    }
}
