package recursive;

import java.io.*;


public class Factorial
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.print(factorial(n));
    }

    public static int factorial(int n)
    {
        if(n == 1)
            return n;

        return n * factorial(n - 1);
    }
}
