/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-08-04 PM 10:44
 */

package dfs_bfs.Bj4179_불;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj4179_불 {

    private int width;
    private int height;
    private int[] startPosition;
    private List<int[]> firePositions;
    private String[][] map;
    private boolean[][] visited;
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    private int[][] fireSpreadMap;

    public static void main(String[] args) throws IOException {
        System.out.println(new Bj4179_불().solution());
    }

    public String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer inputToken = new StringTokenizer(br.readLine(), " ");

        height = Integer.parseInt(inputToken.nextToken());
        width = Integer.parseInt(inputToken.nextToken());

        map = new String[height][width];
        visited = new boolean[height][width];
        fireSpreadMap = new int[height][width];
        firePositions = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            String[] holder = br.readLine().split("");
            for (int j = 0; j < width; j++) {
                map[i][j] = holder[j];
                if (map[i][j].equals("J")) {
                    startPosition = new int[]{i, j};
                } else if (map[i][j].equals("F")) {
                    firePositions.add(new int[]{i, j});
                }
            }
        }

        return bfs();
    }

    private String bfs() {
        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < firePositions.size(); i++) {
            int[] pos = firePositions.get(i);
            queue.offer(new int[] {pos[0], pos[1], 0});
        }

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int curY = position[0];
            int curX = position[1];
            int time = position[2];

            if (visited[curY][curX]) {
                continue;
            }

            visited[curY][curX] = true;
            fireSpreadMap[curY][curX] = time;
            for (int i = 0; i < dx.length; i++) {
                int nextY = dy[i] + curY;
                int nextX = dx[i] + curX;

                if (
                        checkBoundary(nextY, nextX)
                        && !map[nextY][nextX].equals("#")
                        && !visited[nextY][nextX]
                ) {
                    queue.offer(new int[] {nextY, nextX, time+1});
                }
            }
        }

        visited = new boolean[height][width];
        queue.offer(new int[] {startPosition[0], startPosition[1], 0});

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int curY = position[0];
            int curX = position[1];
            int time = position[2];

            if (visited[curY][curX]) {
                continue;
            }

            visited[curY][curX] = true;
            map[curY][curX] = String.valueOf(time++);
            for (int i = 0; i < dx.length; i++) {
                int nextY = dy[i] + curY;
                int nextX = dx[i] + curX;

                if (!checkBoundary(nextY, nextX)) {
                    return String.valueOf(time);
                }

                if (map[nextY][nextX].equals(".")) {
                    if (fireSpreadMap[nextY][nextX] != 0) {
                        if (fireSpreadMap[nextY][nextX] <= time) {
                            continue;
                        }
                    }
                    queue.offer(new int[] {nextY, nextX, time});
                }
            }
        }

        return "IMPOSSIBLE";
    }

    private boolean checkBoundary(int y, int x) {
        if (0 > y || height <= y) {
            return false;
        }

        if (0 > x || width <= x) {
            return false;
        }

        return true;
    }
}
