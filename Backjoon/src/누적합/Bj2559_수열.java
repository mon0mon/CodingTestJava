package 누적합;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//  수열
//  https://www.acmicpc.net/problem/2559
public class Bj2559_수열 {
    public static void main(String[] args) throws IOException {
//        System.setIn(new ByteArrayInputStream(("10 2\n" +
//            "3 -2 -4 -9 0 3 7 13 8 -3").getBytes()));

//        System.setIn(new ByteArrayInputStream(("10 5\n" +
//            "3 -2 -4 -9 0 3 7 13 8 -3").getBytes()));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //  N,K 입력
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();
        int[] S = new int[N-K+1];

        int biggest = Integer.MIN_VALUE;
        for (int i = 0; i < S.length; i++) {
            int sum = 0;
            for (int j = 1; j < K; j++) {
                sum += A[i+j];
            }
            S[i] = A[i] + sum;
            biggest = Math.max(biggest, S[i]);
        }

        System.out.println(biggest);
    }
}
