/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-07-21 AM 2:33
 */

package dfs_bfs.Bj7569_토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

//  토마토
//  https://www.acmicpc.net/problem/7569
//  RETRY 틀린코드 (다시 풀어보기)
public class Bj7569_토마토 {
/*
5 3 1
0 -1 0 0 0
-1 -1 0 1 1
0 0 0 1 1
 */

/*
5 3 2
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 1 0 0
0 0 0 0 0
 */

/*
4 3 2
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1
-1 -1 -1 -1
1 1 1 -1
 */
    private int n;
    private int m;
    private int h;

    public static void main(String[] args) throws IOException {
        System.out.println(new Bj7569_토마토().solution());
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //  x
        n = Integer.parseInt(br.readLine());
        //  y
        m = Integer.parseInt(br.readLine());
        //  z
        h = Integer.parseInt(br.readLine());

        int[][][] box = new int[h][m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        int totalTomatoesCount = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                StringTokenizer tomatoes = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < n; k++) {
                    box[i][j][k] = Integer.parseInt(tomatoes.nextToken());
                    if (box[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k, 0});
                        box[i][j][k] = 0;
                    }
                    if (box[i][j][k] != -1) {
                        totalTomatoesCount++;
                    }
                }
            }
        }

        int days = 0;
        int[] dx = new int[]{1, -1, 0, 0, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1, 0, 0};
        int[] dz = new int[]{0, 0, 0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int[] matureTomato = queue.poll();

            if (box[matureTomato[0]][matureTomato[1]][matureTomato[2]] > 0) {
                continue;
            }

            box[matureTomato[0]][matureTomato[1]][matureTomato[2]] = matureTomato[3] + 1;

            for (int i = 0; i < dx.length; i++) {
                if (checkBoundary(matureTomato[0], matureTomato[1], matureTomato[2],
                        dz[i], dy[i], dx[i])
                        && box[matureTomato[0] + dz[i]][matureTomato[1] + dy[i]][matureTomato[2] + dx[i]] == 0) {
                    days = matureTomato[3] + 1;
                    queue.offer(new int[] {
                            //  z
                            matureTomato[0] + dz[i],
                            //  y
                            matureTomato[1] + dy[i],
                            //  x
                            matureTomato[2] + dx[i],
                            //  days
                            days}
                    );
                }
            }
        }

        int matureTomatoesCount = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (box[i][j][k] == 0) {
                        return -1;
                    }

                    if (box[i][j][k] == 1) {
                        matureTomatoesCount++;
                    }
                }
            }
        }

        return days - 1;
    }

    private boolean checkBoundary(int z, int y, int x, int dz, int dy, int dx) {
        if (z + dz < 0 || z + dz >= h) {
            return false;
        }

        if (y + dy < 0 || y + dy >= m) {
            return false;
        }

        if (x + dx < 0 || x + dx >= n) {
            return false;
        }

        return true;
    }
}
