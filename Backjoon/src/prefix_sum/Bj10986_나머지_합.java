/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-07-21 PM 3:42
 */

package prefix_sum;

import java.io.IOException;
import java.util.Scanner;

//  나머지 합
//  https://www.acmicpc.net/problem/10986
//  RETRY 틀린코드 (다시 풀어보기)
public class Bj10986_나머지_합 {
/*
5 3
1 2 3 1 2
 */

    public static void main(String[] args) throws IOException {
        System.out.println(new Bj10986_나머지_합().solution());
    }
    
    public int solution() throws IOException {
        Scanner sc = new Scanner(System.in);
        int numberCount = sc.nextInt();
        int divider = sc.nextInt();

        int[] prefixSum = new int[numberCount + 1];
        for (int i = 1; i < numberCount + 1; i++) {
            prefixSum[i] = prefixSum[i - 1] + sc.nextInt();
        }

        int count = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            for (int j = i + 1; j < prefixSum.length; j++) {
                if ((prefixSum[j] - prefixSum[i]) % divider == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
