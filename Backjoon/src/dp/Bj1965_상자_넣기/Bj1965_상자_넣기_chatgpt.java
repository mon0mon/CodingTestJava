/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-08-12 AM 4:03
 */

package dp.Bj1965_상자_넣기;

import java.util.Scanner;

//  상자 넣기
//  https://www.acmicpc.net/problem/1965

public class Bj1965_상자_넣기_chatgpt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 상자의 개수 입력
        int[] boxes = new int[n]; // 상자의 크기를 저장할 배열
        int[] dp = new int[n]; // 각 상자에서 시작하는 LIS의 길이를 저장할 배열

        for (int i = 0; i < n; i++) {
            boxes[i] = sc.nextInt(); // 각 상자의 크기 입력
        }

        int maxLength = 0; // 최대 길이 변수 초기화

        // 각 상자를 시작점으로 하는 LIS의 길이를 계산
        for (int i = 0; i < n; i++) {
            dp[i] = 1; // 초기 길이는 최소 1
            for (int j = 0; j < i; j++) {
                if (boxes[j] < boxes[i] && dp[j] + 1 > dp[i]) {
                    // 현재 상자보다 작은 크기의 상자를 찾고, 그 상자에서 시작하는 LIS의 길이가 더 길다면 업데이트
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i]; // 최대 길이 업데이트
            }
        }

        System.out.println(maxLength); // 최대 길이 출력
    }
}
