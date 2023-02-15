package efficiency.slidingwindow;

import java.io.*;
import java.util.*;

public class ConsecutiveSubsequence
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution1(num, arr));
    }

    public static int solution1(int num, int arr[])
    {
        int lt = 0;
        int sum = 0;
        int count = 0;

        for(int rt = 0; rt < arr.length; rt++)
        {
            sum += arr[rt];
            if(sum == num)
                ++count;

            while(sum >= num)
            {
                sum -= arr[lt++];
                if(sum == num)
                    ++count;
            }

        }

        return count;
    }
}
