/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-07-28 PM 5:15
 */

package dfs_bfs.Bj2573_빙산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

//  빙산
//  https://www.acmicpc.net/problem/2573
public class Bj2573_빙산 {

    private int height;
    private int length;
    private int[][] map;
    private boolean[][] visited;
    private int separatedIceCount;
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    private int[][] nextMap;

    public static void main(String[] args) throws IOException {
        System.out.println(new Bj2573_빙산().solution());
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sizeToken = new StringTokenizer(br.readLine());

        height = Integer.parseInt(sizeToken.nextToken());
        length = Integer.parseInt(sizeToken.nextToken());

        map = new int[height][length];
        visited = new boolean[height][length];
        separatedIceCount = 0;

        for (int i = 0; i < height; i++) {
            StringTokenizer rowToken = new StringTokenizer(br.readLine());
            for (int j = 0; j < length; j++) {
                map[i][j] = Integer.parseInt(rowToken.nextToken());
            }
        }

        boolean isAllMelt = true;
        nextMap = new int[height][length];
        int year = 1;
        while (true) {
            for (int i = 0; i < height; i++) {
                nextMap[i] = Arrays.copyOf(map[i], length);
            }

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < length; j++) {
                    if (map[i][j] != 0) {
                        bfsMeltIce(i, j);
                        isAllMelt = false;
                    }
                }
            }

            for (int i = 0; i < height; i++) {
                map[i] = Arrays.copyOf(nextMap[i], length);
            }

            if (isAllMelt) {
                break;
            }

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < length; j++) {
                    if (map[i][j] != 0 && !visited[i][j]) {
                        bfs(i, j);
                        separatedIceCount++;
                    }
                }
            }

            if (separatedIceCount >= 2) {
                return year;
            }

            isAllMelt = true;
            visited = new boolean[height][length];
            year++;
            separatedIceCount = 0;
        }

        return 0;
    }

    private void bfs(int y, int x) {
        Deque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[] {y, x});
        while (!queue.isEmpty()) {
            int[] position = queue.poll();

            if (visited[position[0]][position[1]]) {
                continue;
            }

            visited[position[0]][position[1]] = true;

            for (int i = 0; i < 4; i++) {
                int nextY = dy[i] + position[0];
                int nextX = dx[i] + position[1];

                if (checkBoundary(nextY, nextX) && map[nextY][nextX] != 0 && !visited[nextY][nextX]) {
                    queue.offer(new int[] {nextY, nextX});
                }
            }
        }
    }

    private void bfsMeltIce(int y, int x) {
        Deque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{y, x});
        while (!queue.isEmpty()) {
            int[] position = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nearIceY = dy[i] + position[0];
                int nearIceX = dx[i] + position[1];

                if (checkBoundary(nearIceY, nearIceX) && map[nearIceY][nearIceX] == 0) {
                    nextMap[position[0]][position[1]] = Math.max(nextMap[position[0]][position[1]] - 1, 0);
                }
            }
        }
    }

    private boolean checkBoundary(int y, int x) {
        if (y < 0 || height <= y) {
            return false;
        }

        if (x < 0 || length <= x) {
            return false;
        }

        return true;
    }
}
