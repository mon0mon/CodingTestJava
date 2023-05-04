package 누적합;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//  2차원 배열의 합
//  https://www.acmicpc.net/problem/2167
public class Bj2167_2차원_배열의_합 {
    public static void main(String[] args) throws IOException {
        System.setIn(new ByteArrayInputStream(("2 3\n" +
            "1 2 4\n" +
            "8 16 32\n" +
            "3\n" +
            "1 1 2 3\n" +
            "1 2 1 2\n" +
            "1 3 2 3").getBytes()));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //  N M 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //  배열 입력
        int[][] A = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                A[i][j] = A[i-1][j] + A[i][j-1] - A[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(
                A[x2][y2] - A[x1-1][y2] - A[x2][y1-1] + A[x1-1][y1-1]
            );
        }

//        System.out.println(Arrays.deepToString(Arr));
//        System.out.println(Arrays.deepToString(sum));
    }
}
