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
//  RETRY 틀린코드 (다시 풀어보기)
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

    public static void main(String[] args) throws IOException {
        System.out.println(new Bj2667_단지번호붙이기().solution());
    }

    public String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        size = Integer.parseInt(br.readLine());
        int[][] map = new int[size][size];
        boolean[][] visited = new boolean[size][size];
        Queue<int[]> toVisit = new ArrayDeque<>();

        for (int i = 0; i < size; i++) {
            int[] houseToken = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < size; j++) {
                map[i][j] = houseToken[j];
                if (map[i][j] == 1) {
                    toVisit.offer(new int[] {i, j, 1});
                }
            }
        }

        int houseComplex = 0;
        int houseCount = 0;
        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        while (!toVisit.isEmpty()) {
            int[] house = toVisit.poll();

            if (visited[house[0]][house[1]]) {
                continue;
            }

            if (house[2] == 1) {
                if (houseCount != 0) {
                    pQueue.offer(houseCount);
                }
                houseCount = 0;
                houseComplex++;
            }

            visited[house[0]][house[1]] = true;

            for (int i = 0; i < 4; i++) {
                int nextY = house[0] + dy[i];
                int nextX = house[1] + dx[i];

                if (checkBoundary(nextY, nextX)
                        && map[nextY][nextX] == 1
                        && !visited[nextY][nextX]) {
                    toVisit.offer(new int[] {nextY, nextX, house[2] + 1});
                }
            }
        }

        sb.append(houseComplex).append('\n');
        for (int i = 0; i < size; i++) {
            sb.append(pQueue.poll()).append('\n');
        }

        return sb.toString();
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
