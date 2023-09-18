/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-08-13 PM 10:05
 */

package dp.Bj1309_동물원;

import java.util.Scanner;

//  동물원
//  https://www.acmicpc.net/problem/1309
public class Bj1309_동물원 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[][] dp = new long[N+1][3];

        dp[0][0] = dp[0][1] = dp[0][2] = 1;

        final int MOD = 9901;
        for (int i = 1; i < N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;
        }

        System.out.println((dp[N-1][0] + dp[N-1][1] + dp[N-1][2]) % MOD);
    }
}
