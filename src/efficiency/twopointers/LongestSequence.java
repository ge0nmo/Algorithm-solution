package efficiency.twopointers;

import java.io.*;
import java.util.*;
public class LongestSequence
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution1(m, arr));
    }

    public static int solution1(int m, int arr[])
    {
        int lt = 0;
        int answer = 0;
        int count = 0;

        for(int rt = 0; rt < arr.length; rt++)
        {
            if(arr[rt] == 0)
                ++count;

            while(count > m)
            {
                if(arr[lt] == 0)
                    --count;

                ++lt;
            }

            answer = Math.max(answer, rt - lt + 1);
        }

        return answer;
    }
}
