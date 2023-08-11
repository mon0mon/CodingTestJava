/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-08-10 PM 7:47
 */

package 투포인터.Bj11728_배열_합치기;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//  배열 합치기
//  https://www.acmicpc.net/problem/11728
public class Bj11728_배열_합치기 {
    public static void main(String[] args) throws IOException {
        System.out.println(Bj11728_배열_합치기.solution());
    }

    public static String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer inputToken = new StringTokenizer(br.readLine());
        int ASize = Integer.parseInt(inputToken.nextToken());
        int BSize = Integer.parseInt(inputToken.nextToken());

        inputToken = new StringTokenizer(br.readLine());
        int[] A = new int[ASize];
        for (int i = 0; i < ASize; i++) {
            A[i] = Integer.parseInt(inputToken.nextToken());
        }

        inputToken = new StringTokenizer(br.readLine());
        int[] B = new int[BSize];
        for (int i = 0; i < BSize; i++) {
            B[i] = Integer.parseInt(inputToken.nextToken());
        }

        int AIdx = 0;
        int BIdx = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ASize + BSize; i++) {
            if (BIdx == B.length) {
                sb.append(A[AIdx++]).append(' ');
                continue;
            } else if (AIdx == A.length) {
                sb.append(B[BIdx++]).append(' ');
                continue;
            }


            if (A[AIdx] >= B[BIdx]) {
                sb.append(B[BIdx++]).append(' ');
            } else {
                sb.append(A[AIdx++]).append(' ');
            }
        }

        return sb.toString();
    }
}
