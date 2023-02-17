package datastructure.stack;

import java.util.*;
import java.io.*;
public class ProperParentheses
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution1(str));
    }

    public static String solution1(String str)
    {
        if(str.length() % 2 == 1)
            return "NO";

        Stack<Character> stack = new Stack<>();

        for(char ch : str.toCharArray())
        {
            if(ch == '(')
                stack.push(')');

            else if(stack.isEmpty() || stack.pop() != ch)
                return "NO";
        }

        return stack.isEmpty() ? "YES" : "NO";
    }
}
