/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-08-07 PM 9:27
 */

package 투포인터.Bj3273_두_수의_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bj3273_두_수의_합 {
    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }

    public static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int aryLength = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(a);

        int startIdx = 0;
        int endIdx = aryLength - 1;
        int count = 0;

        while (startIdx < endIdx) {
            if (a[startIdx] + a[endIdx] == x) {
                count++;
                startIdx++;
            } else if (a[startIdx] + a[endIdx] < x) {
                startIdx++;
            } else {
                endIdx--;
            }
        }

        return count;
    }
}
