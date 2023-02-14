package array;

import java.io.*;
import java.util.*;

public class Mentoring
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int student = Integer.parseInt(st.nextToken());
        int test = Integer.parseInt(st.nextToken());

        int arr[][] = new int[test][student];

        for(int i = 0; i < test; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < student; j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(solution1(student, test, arr));

    }

    public static int solution1(int student, int test, int arr[][])
    {
        int answer = 0;

        for(int i = 1; i <= student; i++)
        {
            for(int j = 1; j <= student; j++)
            {
                int count = 0;
                for(int k = 0; k < test; k++)
                {
                    int pj = 0;
                    int pi = 0;
                    for(int s = 0; s < student; s++)
                    {
                        if(arr[k][s] == i)
                            pi = s;

                        if(arr[k][s] == j)
                            pj = s;
                    }
                    if(pi < pj)
                        ++count;
                }
                if(count == test)
                    ++answer;
            }
        }

        return answer;
    }
}