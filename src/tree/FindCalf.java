package tree;

import java.io.*;
import java.util.*;
public class FindCalf
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        System.out.println(solution1(s, e));
    }

    public static int solution1(int s, int e)
    {
        //이동한 값을 체크하는 boolean 배열 생성
        //큐에 처음 좌표 s를 입력
        //큐가 비어있을 때까지 반복문을 돌린다
        //큐의 사이즈만큼 반복문을 돌린다
        //큐에서 빼온 값에 이동할 배열의 크기인 3만큼 반복문을 돌려서 각각 더해준다
        //이동한 값이 e와 일치하다면 해당 깊이 + 1을 반환
        //일치하지 않다면 해당 값이 1 ~ 10000사이인지 체크
        // 이동 한 적이 없다면 이동한 값 true로 변경 후 큐에 삽입

        Queue<Integer> que = new LinkedList<>();
        boolean check[] = new boolean[10001];
        int depth = 0;
        int move[] = {1, -1, 5};

        que.offer(s);
        while(!que.isEmpty())
        {
            int length = que.size();
            for(int i = 0; i < length; i++)
            {
                int cur = que.poll();
                for(int j = 0; j < 3; j++)
                {
                    int nx = cur + move[j];
                    if(nx == e)
                        return depth + 1;

                    if(nx >= 1 && nx <= 10000 && check[nx] == false)
                    {
                        check[nx] = true;
                        que.offer(nx);
                    }
                }
            }
            depth++;
        }

        return 0;
    }
}
