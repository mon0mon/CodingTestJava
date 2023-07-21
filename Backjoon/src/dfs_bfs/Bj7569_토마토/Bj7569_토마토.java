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
    private int x, y, h;
    private final int[] dx = {1, -1, 0, 0, 0, 0};
    private final int[] dy = {0, 0, 1, -1, 0, 0};
    private final int[] dh = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        System.out.println(new Bj7569_토마토().solution());
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer inputToken = new StringTokenizer(br.readLine());
        x = Integer.parseInt(inputToken.nextToken());
        y = Integer.parseInt(inputToken.nextToken());
        h = Integer.parseInt(inputToken.nextToken());

        int[][][] box = new int[h][y][x];
        Queue<int[]> toVisit = new ArrayDeque<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < y; j++) {
                StringTokenizer row = new StringTokenizer(br.readLine());
                for (int k = 0; k < x; k++) {
                    int tomato = Integer.parseInt(row.nextToken());
                    box[i][j][k] = tomato;
                    if (tomato == 1) {
                        toVisit.offer(new int[] {i, j, k, 0});
                    }
                }
            }
        }

        int days = 0;
        while (!toVisit.isEmpty()) {
            int[] currentTomatoInfo = toVisit.poll();

            days = Math.max(days, currentTomatoInfo[3]);

            for (int i = 0; i < dx.length; i++) {
                int nextH = currentTomatoInfo[0] + dh[i];
                int nextY = currentTomatoInfo[1] + dy[i];
                int nextX = currentTomatoInfo[2] + dx[i];

                if (checkBoundary(nextH, nextY, nextX)
                    && box[nextH][nextY][nextX] == 0) {
                    box[nextH][nextY][nextX] = 1;
                    toVisit.offer(new int[] {nextH, nextY, nextX, currentTomatoInfo[3] + 1});
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    if (box[i][j][k] == 0) {
                        return -1;
                    }
                }
            }
        }

        return days;
    }

    private boolean checkBoundary(int h, int y, int x) {
        if (h < 0 || h >= this.h) {
            return false;
        }

        if (y < 0 || y >= this.y) {
            return false;
        }

        if (x < 0 || x >= this.x) {
            return false;
        }

        return true;
    }
}
