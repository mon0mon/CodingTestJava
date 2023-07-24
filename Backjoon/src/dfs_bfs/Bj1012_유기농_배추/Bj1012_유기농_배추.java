/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-07-23 PM 11:29
 */

package dfs_bfs.Bj1012_유기농_배추;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//  유기농 배추
//  https://www.acmicpc.net/problem/1012

/*
2
10 8 17
0 0
1 0
1 1
4 2
4 3
4 5
2 4
3 4
7 4
8 4
9 4
7 5
8 5
9 5
7 6
8 6
9 6
10 10 1
5 5
 */

/*
1
5 3 6
0 2
1 2
2 2
3 2
4 2
4 0
 */
public class Bj1012_유기농_배추 {
    private int[] length;
    private int[] height;
    private int rowCount;
    private int wormCount;
    private int[][][] field;
    private boolean[][][] visited;
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        System.out.println(new Bj1012_유기농_배추().solution());
    }

    public String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        field = new int[testCaseCount][][];
        visited = new boolean[testCaseCount][][];
        length = new int[testCaseCount];
        height = new int[testCaseCount];
        for (int i = 0; i < testCaseCount; i++) {
            StringTokenizer inputToken = new StringTokenizer(br.readLine());
            length[i] = Integer.parseInt(inputToken.nextToken());
            height[i] = Integer.parseInt(inputToken.nextToken());
            rowCount = Integer.parseInt(inputToken.nextToken());
            field[i] = new int[height[i]][length[i]];
            visited[i] = new boolean[height[i]][length[i]];

            for (int j = 0; j < rowCount; j++) {
                inputToken = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(inputToken.nextToken());
                int y = Integer.parseInt(inputToken.nextToken());

                field[i][y][x] = 1;
            }
        }

        for (int i = 0; i < testCaseCount; i++) {
            for (int j = 0; j < height[i]; j++) {
                for (int k = 0; k < length[i]; k++) {
                    if (field[i][j][k] == 1 && !visited[i][j][k]) {
                        bfs(i, j, k);
                        wormCount++;
                    }
                }
            }
            sb.append(wormCount).append('\n');
            wormCount = 0;
        }

        return sb.toString();
    }

    private void bfs(int tcNum, int y, int x) {
        Deque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[] {y, x});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            if (visited[tcNum][point[0]][point[1]]) {
                continue;
            }

            visited[tcNum][point[0]][point[1]] = true;

            for (int i = 0; i < 4; i++) {
                int nextY = dy[i] + point[0];
                int nextX = dx[i] + point[1];

                if (checkBoundary(tcNum, nextY, nextX)
                        && !visited[tcNum][nextY][nextX]
                        && field[tcNum][nextY][nextX] == 1
                ) {
                    queue.offer(new int[] {nextY, nextX});
                }
            }
        }
    }

    private boolean checkBoundary(int tcNum, int y, int x) {
        if (y < 0 || y >= height[tcNum]) {
            return false;
        }

        if (x < 0 || x >= length[tcNum]) {
            return false;
        }

        return true;
    }
}
