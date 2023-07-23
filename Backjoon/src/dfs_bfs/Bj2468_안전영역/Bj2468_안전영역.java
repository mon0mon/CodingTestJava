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
//  RETRY 다시 풀어보기
public class Bj2468_안전영역 {
    private int size;
    private int[][] map;
    private boolean[][] visited;
    private int safeAreaCount = 0;
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

/*
5
6 8 2 6 2
3 2 3 4 6
6 7 3 3 2
7 2 5 3 6
8 9 5 2 7
 */

/*
7
9 9 9 9 9 9 9
9 2 1 2 1 2 9
9 1 8 7 8 1 9
9 2 7 9 7 2 9
9 1 8 7 8 1 9
9 2 1 2 1 2 9
9 9 9 9 9 9 9
 */

    public static void main(String[] args) throws IOException {
        System.out.println(new Bj2468_안전영역().solution());
    }
    
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        visited = new boolean[size][size];
        int maxHeight = 0;

        for (int i = 0; i < size; i++) {
            StringTokenizer rowToken = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = rowToken.nextToken().charAt(0) - '0';
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }


        int maxSafeAreaCount = 0;
        for (int i = 0; i <= Math.min(100, maxHeight); i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (map[j][k] > i && !visited[j][k]) {
                        bfs(new int[] {j, k, i});
                        safeAreaCount++;
                    }
                }
            }
            maxSafeAreaCount = Math.max(maxSafeAreaCount, safeAreaCount);
            safeAreaCount = 0;
            visited = new boolean[size][size];
        }

        return maxSafeAreaCount;
    }

    private void bfs(int[] start) {
        Deque<int[]> queue = new ArrayDeque<>();

        queue.offer(start);

        while (!queue.isEmpty()) {
            int[] position = queue.poll();

            if (visited[position[0]][position[1]]) {
                continue;
            }

            visited[position[0]][position[1]] = true;

            for (int i = 0; i < 4; i++) {
                int nextY = dy[i] + position[0];
                int nextX = dx[i] + position[1];

                if (checkBoundary(nextY, nextX)
                        && !visited[nextY][nextX]
                        && map[nextY][nextX] > position[2]
                ) {
                    queue.offer(new int[] {nextY, nextX, position[2]});
                }
            }
        }
    }

    private boolean checkBoundary(int y, int x) {
        if (y < 0 || y >= size) {
            return false;
        }

        if (x < 0 || x >= size) {
            return false;
        }

        return true;
    }
}
