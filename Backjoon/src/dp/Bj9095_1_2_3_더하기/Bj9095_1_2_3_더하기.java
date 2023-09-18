/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-08-16 PM 9:52
 */

package dp.Bj9095_1_2_3_더하기;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

//  1, 2, 3 더하기
//  https://www.acmicpc.net/problem/9095
//  RETRY
public class Bj9095_1_2_3_더하기 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] dp = new int[n+1];

            dp[1] = 1;
            if (n >= 2) dp[2] = 2;
            if (n >= 3) dp[3] = 4;

            for (int j = 4; j <= n; j++) {
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }

            bw.write(dp[n] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
