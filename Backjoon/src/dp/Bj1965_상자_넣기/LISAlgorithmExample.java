/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-08-12 AM 5:03
 */

package dp.Bj1965_상자_넣기;

public class LISAlgorithmExample {
    public static void main(String[] args) {
        int[] sequence = {4, 2, 6, 7, 9, 1, 3, 10};
        int n = sequence.length;
        int[] dp = new int[n]; // 각 위치에서 끝나는 LIS의 길이를 저장하는 배열

        // 각 위치에서 LIS의 길이를 계산하여 dp 배열에 저장
        for (int i = 0; i < n; i++) {
            dp[i] = 1; // 각 위치에서 LIS의 길이는 최소 1로 초기화
            for (int j = 0; j < i; j++) {
                if (sequence[j] < sequence[i] && dp[j] + 1 > dp[i]) {
                    // 현재 원소보다 작은 값의 원소를 찾고, 그 원소에서 시작하는 LIS의 길이가 더 길다면 업데이트
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int maxLength = 0;
        for (int length : dp) {
            if (length > maxLength) {
                maxLength = length; // 최대 길이 업데이트
            }
        }

        System.out.println("최대 LIS 길이: " + maxLength);
    }
}
