package array;

import java.util.*;
import java.io.*;
public class ReversePrime
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String arr[] = new String[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++)
        {
            arr[i] = st.nextToken();
        }

        System.out.println(solution1(n, arr));
    }

    public static String solution1(int n, String arr[])
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++)
        {
            String reverse = new StringBuilder(arr[i]).reverse().toString();
            int num = Integer.parseInt(reverse);

            if(isPrime(num))
                sb.append(num).append(" ");

        }
        return sb.toString();
    }

    public static boolean isPrime(int n)
    {
        if(n == 2)
            return true;

        if(n == 1 || n % 2 == 0)
            return false;

        for(int i = 2; i <= Math.sqrt(n); i++)
        {
            if(n % i == 0)
                return false;
        }
        return true;
    }

}
