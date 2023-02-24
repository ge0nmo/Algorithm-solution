package tree;

import java.io.*;
import java.util.*;
public class Subset
{
    static int n;
    static int arr[];


    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        n = num;
        arr = new int[n + 1];

        DFS(1);
    }



    public static void DFS(int depth)
    {
        if(n + 1 == depth)
        {
            for(int i = 1; i <= n; i++)
            {
                if(arr[i] == 1)
                    System.out.print(i + " ");
            }
            System.out.println();
        }

        else
        {
            //사용
            arr[depth] = 1;
            DFS(depth + 1);

            arr[depth] = 0;
            DFS(depth + 1);
        }
    }
}


