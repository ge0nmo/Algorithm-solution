package string;

import java.io.*;

public class Password
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();

        System.out.println(solution1(num, str));
        System.out.println(solution2(num, str));
    }

    public static String solution1(int n, String str)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++)
        {
            //문자열을 7개씩 끊은 후 # = 1로 *은 0으로 변환
            String result = str.substring(0, 7).replace('#', '1').replace('*', '0');

            //끊은 문자열을 기존 문자열에서 제외
            str = str.substring(7);

            //2진수로 변환
            int num = transform(result);

            sb.append((char)num);
        }

        return sb.toString();
    }

    public static int transform(String str)
    {
        //
        int length = str.length() - 1;
        int result = 0;

        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == '1')
                result += Math.pow(2, length);

            --length;
        }

        return result;
    }

    public static String solution2(int n, String str)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++)
        {
            //1000001
            String result = str.substring(0, 7).replace('#', '1').replace('*', '0');
            str = str.substring(7);

            int num = Integer.parseInt(result, 2);

            sb.append((char)num);
        }

        return sb.toString();
    }
}
