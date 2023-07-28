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
public class Bj2667_단지번호붙이기 {

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
    private int size;
    private int map[][];
    private boolean visited[][];
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    private int count;
    private int number;
    private PriorityQueue<Integer> pQueue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        System.out.println(new Bj2667_단지번호붙이기().solution());
    }

    public String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());

        map = new int[size][size];
        visited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            String row = br.readLine();
            for (int j = 0; j < size; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    count = 0;
                    number++;
                    dfs(i, j);
                    pQueue.offer(count);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(number).append('\n');
        while (!pQueue.isEmpty()) {
            sb.append(pQueue.poll()).append('\n');
        }

        return sb.toString();
    }

    private void dfs(int y, int x) {
        visited[y][x] = true;
        map[y][x] = number;
        count++;

        for (int i = 0; i < 4; i++) {
            int nextY = dy[i] + y;
            int nextX = dx[i] + x;

            if (checkBoundary(nextY, nextX)
                    && !visited[nextY][nextX]
                    && map[nextY][nextX] == 1) {
                map[nextY][nextX] = number;
                dfs(nextY, nextX);
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
