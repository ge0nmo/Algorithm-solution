package array;

import java.io.*;
public class Fibonacci
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for(int i : solution1(num))
        {
            System.out.print(i + " ");
        }
        System.out.print("\n");

        solution2(num);
    }

    public static int[] solution1(int n)
    {
        int arr[] = new int[n];
        arr[0] = 1;
        arr[1] = 1;

        for(int i = 2; i < n; i++)
        {
            arr[i] = arr[i - 2] + arr[i - 1];
        }

        return arr;
    }

    public static void solution2(int n)
    {
       int a = 1;
       int b = 1;
       int c;

       System.out.print(a + " " + b + " ");
       for(int i = 2; i < n; i++)
       {
           c = a + b;
           System.out.print(c + " ");
           a = b;
           b = c;
       }
    }
}
