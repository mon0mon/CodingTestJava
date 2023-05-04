package 누적합;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//  인간-컴퓨터 상호작용
//  https://www.acmicpc.net/problem/16139
public class Bj16139_인간_컴퓨터_상호작용 {
    public static void main(String[] args) throws IOException {
        System.setIn(new ByteArrayInputStream(("seungjaehwang\n" +
            "4\n" +
            "a 0 5\n" +
            "a 0 6\n" +
            "a 6 10\n" +
            "a 7 10").getBytes()));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String S = br.readLine();
        int q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            String Alpha = st.nextToken();
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            
        }
    }
}
