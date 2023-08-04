/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-08-03 PM 11:49
 */

package 재귀.Bj1629_곱셈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//  곱셈
//  https://www.acmicpc.net/problem/1629
public class Bj1629_곱셈 {
    public static void main(String[] args) throws IOException {
        System.out.println(new Bj1629_곱셈().solution());
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer inputToken = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(inputToken.nextToken());
        int B = Integer.parseInt(inputToken.nextToken());
        int C = Integer.parseInt(inputToken.nextToken());

        return recursive(A, B, C);
    }

    private int recursive(int A, int count, int C) {
        if (count == 1) {
            return A;
        }

        return A * recursive(A, count -1, C);
    }
}
