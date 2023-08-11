/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-08-12 AM 5:23
 */

package dp.Bj2579_계단_오르기;

import java.util.Scanner;

public class Bj2579_계단_오르기_chatgpt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 계단의 개수
        int[] stair = new int[n + 1]; // 각 계단의 점수를 저장하는 배열
        int[] dp = new int[n + 1]; // 동적 계획법을 위한 배열

        // 각 계단의 점수 입력 받기
        for (int i = 1; i <= n; i++) {
            stair[i] = sc.nextInt();
        }

        dp[1] = stair[1]; // 첫 번째 계단은 그대로 밟는 것이 최적
        if (n >= 2) {
            dp[2] = stair[1] + stair[2]; // 두 번째 계단은 첫 번째와 두 번째 계단을 연속으로 밟는 것이 최적
        }

        for (int i = 3; i <= n; i++) {
            // 현재 계단을 밟을 경우, (1) 이전 계단을 밟고 이전 이전 계단을 밟지 않은 경우, (2) 이전 이전 계단을 밟고 이전 계단을 밟은 경우 중에서 큰 값 선택
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stair[i - 1]) + stair[i];
        }

        System.out.println(dp[n]); // 마지막 계단까지의 최대 점수 출력
    }
}