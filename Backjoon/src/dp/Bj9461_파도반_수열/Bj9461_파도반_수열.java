/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-08-12 PM 10:32
 */

package dp.Bj9461_파도반_수열;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

//  파도반 수열
//  https://www.acmicpc.net/problem/9461
public class Bj9461_파도반_수열 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] dp = new long[100 + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        int tcCount = scanner.nextInt();
        for (int i = 0; i < tcCount; i++) {
            int n = scanner.nextInt();

            for (int j = 3; j <= n; j++) {
                if (dp[j] != 0) {
                    continue;
                }

                dp[j] = dp[j - 3] + dp[j - 2];
            }
            bw.write(dp[n] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
