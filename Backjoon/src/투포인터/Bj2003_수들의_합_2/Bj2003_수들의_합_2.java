/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-08-07 PM 9:07
 */

package 투포인터.Bj2003_수들의_합_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj2003_수들의_합_2 {
    public static void main(String[] args) throws IOException {
        System.out.println(new Bj2003_수들의_합_2().solution());
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer inputToken = new StringTokenizer(br.readLine());

        int aryLength = Integer.parseInt(inputToken.nextToken());
        int M = Integer.parseInt(inputToken.nextToken());
        int[] A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int startIdx = 0;
        int endIdx = 0;
        int sum = A[startIdx];
        int count = 0;

        while (true) {
            if (sum == M) {
                count++;
            } else if (sum > M) {
                sum -= A[startIdx];
                startIdx++;
                continue;
            }
            endIdx++;

            if (endIdx == aryLength) break;
            sum += A[endIdx];
        }

        return count;
    }
}
