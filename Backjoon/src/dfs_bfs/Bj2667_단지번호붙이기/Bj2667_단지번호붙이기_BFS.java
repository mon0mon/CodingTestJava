/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-07-21 PM 5:23
 */

package dfs_bfs.Bj2667_단지번호붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

//  단지번호붙이기
//  https://www.acmicpc.net/problem/2667
//  RETRY 틀린코드 (다시 풀어보기)
//  DFS BFS로 다시 풀어보기
public class Bj2667_단지번호붙이기_BFS {
/*
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
 */

    private boolean[][] visited;
    private int[][] map;
    private int length;
    private int complexCount = 1;
    private int nestedHouseCount = 0;
    private int[] dx = new int[] {1, -1, 0, 0};
    private int[] dy = new int[] {0, 0, 1, -1};
    private PriorityQueue<Integer> pQueue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        System.out.println(new Bj2667_단지번호붙이기_BFS().solution());
    }

    public String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        length = Integer.parseInt(br.readLine());

        map = new int[length][length];
        visited = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            String row = br.readLine();
            for (int j = 0; j < length; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(new int[] {i, j});
                    pQueue.offer(nestedHouseCount);
                    nestedHouseCount = 0;
                    complexCount++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(complexCount-1).append('\n');

        while (!pQueue.isEmpty()) {
            sb.append(pQueue.poll()).append('\n');
        }

        return sb.toString();
    }

    private void bfs(int[] position) {
        Deque<int[]> queue = new ArrayDeque<>();

        queue.offer(position);
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (visited[current[0]][current[1]]) {
                continue;
            }

            visited[current[0]][current[1]] = true;
            map[current[0]][current[1]] = complexCount;
            nestedHouseCount++;

            for (int i = 0; i < 4; i++) {
                int nextY = current[0] + dy[i];
                int nextX = current[1] + dx[i];

                if (checkBoundary(nextY, nextX)
                        && !visited[nextY][nextX]
                        && map[nextY][nextX] == 1
                ) {
                    queue.offer(new int[] {nextY, nextX});
                }
            }
        }
    }

    private boolean checkBoundary(int nextY, int nextX) {
        if (0 > nextY || nextY >= length) {
            return false;
        }

        if (0 > nextX || nextX >= length) {
            return false;
        }

        return true;
    }
}
