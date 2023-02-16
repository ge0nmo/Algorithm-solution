package collection;

import java.io.*;
import java.util.*;
public class TypeOfSales
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

        for(int i : solution1(m, arr))
        {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> solution1(int m, int arr[])
    {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int lt = 0;

        for(int i = 0; i < m; i++)
        {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        list.add(map.size());

        for(int rt = m; rt < arr.length; rt++)
        {
            //앞에 매출 지우기
            map.put(arr[lt], map.get(arr[lt]) - 1);

            if(map.get(arr[lt]) == 0)
                map.remove(arr[lt]);

            ++lt;

            //새로운 매출 더하기
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);

            list.add(map.size());
        }

        return list;
    }
}
