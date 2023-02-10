package string;

import java.io.*;
public class StringCompression
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        //마지막 문자를 더해주기 위해 공백 추가
        str = str + " ";

        System.out.println(solution1(str));

    }

    public static String solution1(String str)
    {
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for(int i = 0; i < str.length() - 1; i++)
        {
            //다음 문자와 같은지 비교
            //같다면 count 를 1증가
            if(str.charAt(i) == str.charAt(i + 1))
                ++count;


            //문자가 다르다면 해당 문자를 저장
            else
            {
                sb.append(str.charAt(i));

                //숫자가 1 보다 크다면 숫자도 함께 저장
                if(count > 1)
                {
                    sb.append(count);
                }

                //숫자는 다시 1로 초기화
                count = 1;
            }
        }
        return sb.toString();
    }
}
