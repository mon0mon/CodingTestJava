/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-07-23 PM 10:23
 */

package dfs_bfs.Bj1926_그림;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Bj1926_그림 {
    private int[][] paints;
    private boolean[][] visited;
    private int height;
    private int length;
    private int paintCount = 0;
    private int maxPaintSize = 0;
    private int paintSize = 0;
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    /*
6 5
1 1 0 1 1
0 1 1 0 0
0 0 0 0 0
1 0 1 1 1
0 0 1 1 1
0 0 1 1 1
 */

    public static void main(String[] args) throws IOException {
        System.out.println(new Bj1926_그림().solution());
    }

    public String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        height = Integer.parseInt(tokenizer.nextToken());
        length = Integer.parseInt(tokenizer.nextToken());

        paints = new int[height][length];
        visited = new boolean[height][length];

        for (int i = 0; i < height; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < length; j++) {
                paints[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                if (paints[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    paintCount++;
                    maxPaintSize = Math.max(maxPaintSize, paintSize);
                    paintSize = 0;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(paintCount).append('\n');
        sb.append(maxPaintSize);

        return sb.toString();
    }

    private void bfs(int y, int x) {
        Deque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[] {y, x});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            if (visited[point[0]][point[1]]) {
                continue;
            }

            visited[point[0]][point[1]] = true;
            paints[point[0]][point[1]] = ++paintSize;

            for (int i = 0; i < 4; i++) {
                int nextY = dy[i] + point[0];
                int nextX = dx[i] + point[1];

                if (checkBoundary(nextY, nextX)
                        && !visited[nextY][nextX]
                        && paints[nextY][nextX] == 1
                ) {
                    queue.offer(new int[] {nextY, nextX});
                }
            }
        }
    }

    private boolean checkBoundary(int y, int x) {
        if (y < 0 || y >= height) {
            return false;
        }

        if (x < 0 || x >= length) {
            return false;
        }

        return true;
    }
}
