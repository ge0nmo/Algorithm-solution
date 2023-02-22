package searching;

import java.util.*;
import java.io.*;
public class MusicVideo
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

        System.out.print(solution1(arr, m));
    }

    public static int solution1(int arr[], int m)
    {
        //배열의 최소값과 배열의 총 합을 구해서 최소값 ~ 총 합 까지의 반복문을 돌린다
        //가운데 값(mid)을 찾아서 그 이상의 값은 검사할 필요가 없고
        //그 이하의 값들을 1칸씩 내려가며 DVD들이 m장에 담기는지 확인한다.

        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr)
                .sum();

        int answer = 0;

        while(lt <= rt)
        {
            //DVD 한 장의 용량
            int mid = (lt + rt) / 2;

            if(count(arr, mid) <= m)
            {
                answer = mid;
                rt = mid - 1;
            }
            else
                lt = mid + 1;
        }

        return answer;
    }

    public static int count(int arr[], int capacity)
    {
        int cnt = 1;
        int sum = 0;

        for(int i : arr)
        {
            if(sum + i > capacity)
            {
                cnt++;
                sum = i;
            }
            else
                sum += i;
        }

        return cnt;
    }
}
