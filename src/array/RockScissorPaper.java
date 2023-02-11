package array;

import java.io.*;
import java.util.*;

public class RockScissorPaper
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int A[] = new int[n];
        int B[] = new int[n];

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++)
        {
            A[i] = Integer.parseInt(st1.nextToken());

        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
        {
            B[i] = Integer.parseInt(st2.nextToken());
        }

        System.out.print(solution1(A, B));
    }

    public static String solution1(int a[], int b[])
    {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < a.length; i++)
        {
            if(a[i] == b[i])
                sb.append("D");

            else if(a[i] == 1 && b[i] == 3)
                sb.append("A");

            else if(a[i] == 2 && b[i] == 1)
                sb.append("A");

            else if(a[i] == 3 && b[i] == 2)
                sb.append("A");

            else
                sb.append("B");
        }

        return sb.toString();
    }


}
