package recursive;

import java.io.*;
public class Fibonacci
{
    static int arr[];
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        fibonacci(n);

        for(int i = 1; i <= n; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }

    public static int fibonacci(int n)
    {
        //memorization
        if(arr[n] > 0)
            return arr[n];

        if(n == 1)
            return arr[n] = 1;

        if(n == 2)
            return arr[n] = 1;

        return arr[n] = fibonacci(n - 2) + fibonacci(n - 1);
    }

}
