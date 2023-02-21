package sorting;

import java.util.*;
import java.io.*;
public class ComparedTo
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Point> list = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Point(x, y));
        }

        Collections.sort(list);
        for (Point point : list)
        {
            System.out.println(point.x + " " + point.y);
        }
    }


}

class Point implements Comparable<Point>
{
    public int x, y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o)
    {
        //x 값들이 같을 때 y에 의해 리턴
        if(this.x == o.x)
            return this.y - o.y;

        //x 값들이 다르다면 x에 의해 리턴
        else
            return this.x - o.x;
    }
}
