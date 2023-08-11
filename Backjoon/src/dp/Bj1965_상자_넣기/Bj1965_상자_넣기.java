/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-08-12 AM 4:03
 */

package dp.Bj1965_상자_넣기;

import java.util.Arrays;
import java.util.Scanner;

//  상자 넣기
//  https://www.acmicpc.net/problem/1965

public class Bj1965_상자_넣기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 상자의 개수 입력
        int[] boxes = new int[n]; // 상자의 크기를 저장할 배열
        int[] dp = new int[n]; // 각 상자에서 시작하는 LIS의 길이를 저장할 배열

        for (int i = 0; i < n; i++) {
            boxes[i] = sc.nextInt(); // 각 상자의 크기 입력
        }

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                //  현재 박스가 기존의 박스보다 클때
                //  기존 lis의 최대값이, 현재 dp의 값보다 클 때
                if (boxes[j] < boxes[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
