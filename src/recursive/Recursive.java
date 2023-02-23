package recursive;

import java.util.*;
import java.io.*;
public class Recursive
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        DFS(3);
    }

    public static void DFS(int n)
    {
        if(n == 0)
            return;

        DFS(n - 1);
        System.out.print(n + " ");
    }
}
