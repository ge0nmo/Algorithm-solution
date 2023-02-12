package array;

import java.io.*;
import java.util.StringTokenizer;
public class CalculateRank
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i : solution1(arr))
        {
            System.out.print(i + " ");
        }
    }

    public static int[] solution1(int arr[])
    {
        int result[] = new int[arr.length];

        for(int i = 0; i < arr.length; i++)
        {
            int rank = 1;
            for(int j = 0; j < arr.length; j++)
            {
                if(arr[j] > arr[i])
                    ++rank;
            }
            result[i] = rank;
        }
        return result;
    }
}
