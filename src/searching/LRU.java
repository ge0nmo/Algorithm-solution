package searching;

import java.io.*;
import java.util.*;
public class LRU
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int arr[] = new int[m];
        for(int i = 0 ; i < m; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i : solution1(arr, n))
        {
            System.out.print(i + " ");
        }
    }

    public static int[] solution1(int arr[], int n)
    {
        //n의 크기만큼 배열 answer의 크기를 설정
        //arr 크기만큼 반복문을 돌린다.
        //answer 배열 안에 입력 받을 값이 있는지 체크
        //있다면 0부터 값의 위치까지 오른쪽으로 값을 이동
        //없다면 0부터 answer 배열의 크기 끝까지 값을 오른쪽으로 이동
        //새로운 수를 0에 집어넣는다

        int answer[] = new int[n];

        for(int x : arr)
        {
            int idx = n - 1;
            for(int i = 0; i < n; i++)
            {
                if(x == answer[i])
                {
                    idx = i;
                }
            }

            for(int k = idx; k >= 1; k--)
            {
                answer[k] = answer[k - 1];
            }

            answer[0] = x;
        }

        return answer;
    }
}
