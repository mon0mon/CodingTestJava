/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-08-12 AM 5:23
 */

package dp.Bj2579_계단_오르기;

import java.util.Arrays;
import java.util.Scanner;

//  계단 오르기
//  https://www.acmicpc.net/problem/2579
public class Bj2579_계단_오르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stairCount = sc.nextInt();
        int[] stair = new int[stairCount];

        for (int i = 0; i < stairCount; i++) {
            stair[i] = sc.nextInt();
        }

        int[] dp = new int[stairCount + 1];
        dp[1] = stair[0];
        int seq = 1;
        for (int i = 2; i <= stairCount; i++) {
            dp[i] = 1;

            if (seq != 2) {
                dp[i] = Math.max(dp[i], dp[i - 1] + stair[i - 1]);
                seq++;
            } else {
                seq = 1;
            }

            dp[i] = Math.max(dp[i], dp[i - 2] + stair[i - 1]);
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
