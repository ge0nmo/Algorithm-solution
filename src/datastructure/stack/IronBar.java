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
