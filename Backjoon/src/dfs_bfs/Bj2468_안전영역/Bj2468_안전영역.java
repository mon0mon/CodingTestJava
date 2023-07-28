/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-07-22 PM 11:33
 */

package dfs_bfs.Bj2468_안전영역;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//  안전영역
//  https://www.acmicpc.net/problem/2468
public class Bj2468_안전영역 {

    private int[][] map;
    private boolean[][] visited;
    private int maxHeight;
    private int size;
    private int areaCount;
    private PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        System.out.println(new Bj2468_안전영역().solution());
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        maxHeight = 0;

        for (int i = 0; i < size; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < size; j++) {
                if (row[j] > maxHeight) {
                    maxHeight = row[j];
                }

                map[i][j] = row[j];
            }
        }

        for (int i = 0; i < maxHeight + 1; i++) {
            areaCount = 0;
            visited = new boolean[size][size];
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (map[j][k] > i && !visited[j][k]) {
                        bfs(j, k, i);
                        areaCount++;
                    }
                }
            }
            pQueue.offer(areaCount);
        }

        return pQueue.isEmpty() ? 1 : pQueue.poll();
    }

    private void bfs(int y, int x, int waterLevel) {
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

                if (checkBoundary(nextY, nextX) && map[nextY][nextX] > waterLevel && !visited[nextY][nextX]) {
                    queue.offer(new int[] {nextY, nextX});
                }
            }
        }
    }

    private boolean checkBoundary(int nextY, int nextX) {
        if (0 > nextY || size <= nextY) {
            return false;
        }

        if (0 > nextX || size <= nextX) {
            return false;
        }

        return true;
    }
}
