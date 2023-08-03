/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-08-03 AM 9:47
 */

package dfs_bfs.Bj4963_섬의_개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Bj4963_섬의_개수 {
    private int width;
    private int height;
    private int[][] map;
    private boolean[][] visited;
    private int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    private int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        System.out.println(new Bj4963_섬의_개수().solution());
    }

    public String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answerBuilder = new StringBuilder();

        while (true) {
            String input = br.readLine();

            //  종료 조건
            if (input.strip().equals("0 0")) {
                break;
            }

            width = Integer.parseInt(input.split(" ")[0]);
            height = Integer.parseInt(input.split(" ")[1]);

            map = new int[height][width];
            visited = new boolean[height][width];

            for (int i = 0; i < height; i++) {
                map[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            int islandCount = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        islandCount++;
                    }
                }
            }

            answerBuilder.append(islandCount).append('\n');
        }

        return answerBuilder.toString();
    }

    private void bfs(int y, int x) {
        Deque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{y, x});

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int curY = position[0];
            int curX = position[1];

            if (visited[curY][curX]) {
                continue;
            }

            visited[curY][curX] = true;

            for (int i = 0; i < dx.length; i++) {
                int nextY = dy[i] + curY;
                int nextX = dx[i] + curX;

                if (
                        checkBoundary(nextY, nextX)
                        && !visited[nextY][nextX]
                        && map[nextY][nextX] == 1
                ) {
                    queue.offer(new int[] {nextY, nextX});
                }
            }
        }
    }

    private boolean checkBoundary(int nextY, int nextX) {
        if (0 > nextY || height <= nextY) {
            return false;
        }

        if(0 > nextX || width <= nextX) {
            return false;
        }

        return true;
    }
}
