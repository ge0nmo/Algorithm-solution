package recursive;

import java.util.*;
import java.io.*;
public class OutputBinaryNum
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        DFS(n);
    }

    public static void DFS(int n)
    {
        if(n <= 0)
            return;

        DFS(n / 2);
        System.out.print(n % 2);
    }
}
