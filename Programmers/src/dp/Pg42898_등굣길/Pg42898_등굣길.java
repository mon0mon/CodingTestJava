/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-08-12 PM 11:39
 */

package dp.Pg42898_등굣길;

import java.io.IOException;

public class Pg42898_등굣길 {
    private final int MOD = 1_000_000_007;
    private int[] dx = {1, 0};
    private int[] dy = {0, 1};
    private int height;
    private int width;

    public static void main(String[] args) throws IOException {
        System.out.println(new Pg42898_등굣길().solution(4, 3, new int[][]{{2, 2}}));
    }
    
    public int solution(int m, int n, int[][] puddles) throws IOException {
        height = n + 1;
        width = m + 1;
        int[][] dp = new int[height][width];

        for (int i = 0; i < puddles.length; i++) {
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }

        dp[1][1] = 1;
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if (dp[i][j] == -1) {
                    continue;
                }

                // 위쪽에서 오는 경우
                //  최소한 시작지점보다는 나아간 범위에서 시작해야함
                    //  y > 1 일때만 동작
                if (i - 1 >= 1 && dp[i - 1][j] != -1) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                }

                //  왼쪽에서 오는 경우
                //  최소한 시작지점보다 나아간 범위에서 시작해야함
                    //  x > 1 일때만 동작
                if (j - 1 >= 1 && dp[i][j - 1] != -1) {
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
                }
            }
        }

        return dp[n][m];
    }
}
