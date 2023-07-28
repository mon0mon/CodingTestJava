/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-07-21 PM 5:23
 */

package dfs_bfs.Bj2667_단지번호붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//  단지번호붙이기
//  https://www.acmicpc.net/problem/2667
public class Bj2667_단지번호붙이기_DFS {

    private int size;
    private int[][] map;
    private boolean[][] visited;
    private int complexSize = 0;
    private PriorityQueue<Integer> pQueue = new PriorityQueue<>();
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        System.out.println(new Bj2667_단지번호붙이기_DFS().solution());
    }
    
    public String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        visited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            int[] row = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < size; j++) {
                map[i][j] = row[j];
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    pQueue.offer(complexSize);
                    complexSize = 0;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(pQueue.size()).append('\n');

        if (pQueue.isEmpty()) {
            sb.append("0");
        }

        while (!pQueue.isEmpty()) {
            sb.append(pQueue.poll()).append('\n');
        }

        return sb.toString();
    }

    private void dfs(int y, int x) {
        Deque<int[]> stack = new ArrayDeque<>();

        stack.addLast(new int[] {y, x});
        while (!stack.isEmpty()) {
            int[] position = stack.pollLast();

            if (visited[position[0]][position[1]]) {
                continue;
            }

            visited[position[0]][position[1]] = true;
            complexSize++;

            for (int i = 0; i < 4; i++) {
                int nextY = position[0] + dy[i];
                int nextX = position[1] + dx[i];

                if (checkBoundary(nextY, nextX) && map[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                    stack.addLast(new int[] {nextY, nextX});
                }
            }
        }
    }

    private boolean checkBoundary(int y, int x) {
        if (0 > y || size <= y) {
            return false;
        }

        if (0 > x || size <= x) {
            return false;
        }

        return true;
    }
}
