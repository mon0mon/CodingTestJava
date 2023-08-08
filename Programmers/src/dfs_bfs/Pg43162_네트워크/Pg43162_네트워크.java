/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-08-08 PM 3:09
 */

package dfs_bfs.Pg43162_네트워크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

//  네트워크
//  https://school.programmers.co.kr/learn/courses/30/lessons/43162
public class Pg43162_네트워크 {
    private boolean[][] visited;
    private int n;
    private int[][] computers;

    public static void main(String[] args) {
        System.out.println(new Pg43162_네트워크().solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(new Pg43162_네트워크().solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
        System.out.println(new Pg43162_네트워크().solution(4,
                                                       new int[][]{{1, 0, 0, 1},
                                                                   {0, 1, 1, 0},
                                                                   {0, 1, 1, 0},
                                                                   {1, 0, 0, 1}}
        ));
    }

    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        visited = new boolean[n][n];
        int counter = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1 && !visited[i][j]) {
                    bfs(new int[]{i, j});
                    counter++;
                }
            }
        }

        return counter;
    }

    private void bfs(int[] position) {
        Deque<int[]> queue = new ArrayDeque<>();

        queue.offer(position);

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            int y = curPos[0];
            int x = curPos[1];

            if (visited[y][x]) {
                continue;
            }

            visited[y][x] = true;
            for (int i = 0; i < n; i++) {
                if (computers[y][i] == 1 && !visited[y][i]) {
                    queue.offer(new int[]{y, i});
                }

                if (computers[i][x] == 1 && !visited[i][x]) {
                    queue.offer(new int[]{i, x});
                }
            }
        }
    }
}
