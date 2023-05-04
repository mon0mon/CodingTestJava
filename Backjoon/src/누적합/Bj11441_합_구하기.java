package 누적합;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//  합 구하기
//  https://www.acmicpc.net/problem/11441
public class Bj11441_합_구하기 {
    public static void main(String[] args) throws IOException {
//        System.setIn(new ByteArrayInputStream(("5\n" +
//            "10 20 30 40 50\n" +
//            "5\n" +
//            "1 3\n" +
//            "2 4\n" +
//            "3 5\n" +
//            "1 5\n" +
//            "4 4").getBytes()));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] S = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            S[i] = Integer.parseInt(st.nextToken()) + S[i-1];
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            System.out.println(S[e] - S[s-1]);
        }
    }
}
