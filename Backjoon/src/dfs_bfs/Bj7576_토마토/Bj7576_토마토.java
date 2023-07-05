/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-06-21 0021 : AM 3:38
 */

package dfs_bfs.Bj7576_토마토;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

//  토마토
//  https://www.acmicpc.net/problem/7576
public class Bj7576_토마토 {
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        System.out.println(new Bj7576_토마토().solution());
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sizeTokenizer = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(sizeTokenizer.nextToken());
        int h = Integer.parseInt(sizeTokenizer.nextToken());
        int[][] rack = new int[h][l];
        boolean[][] visited = new boolean[h][l];
        int allTomatoCount = 0;
        int ripenedTomato = 0;
        int elapsedTime = 0;

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < h; i++) {
            StringTokenizer tomatoTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < l; j++) {
                rack[i][j] = Integer.parseInt(tomatoTokenizer.nextToken());
                //  모든 토마토의 수를 입력시에 저장
                if (rack[i][j] == 0) {
                    allTomatoCount++;
                    continue;
                } else if (rack[i][j] == 1) {
                    allTomatoCount++;
                    ripenedTomato++;
                    queue.add(new int[] {i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            elapsedTime = curPos[2];

            for (int i = 0; i < dx.length; i++) {
                int[] nextPos = Arrays.copyOf(curPos, curPos.length);
                nextPos[0] += dx[i];
                nextPos[1] += dy[i];
                nextPos[2] += 1;

                if (checkBoundary(nextPos, h, l)
                        && rack[nextPos[0]][nextPos[1]] == 0
                        && !visited[nextPos[0]][nextPos[1]]) {
                    queue.add(nextPos);
                    rack[nextPos[0]][nextPos[1]] = 1;
                    visited[nextPos[0]][nextPos[1]] = true;
                    ripenedTomato++;
                }
            }
        }

        return allTomatoCount == ripenedTomato ? elapsedTime : -1;
    }

    private boolean checkBoundary(int[] pos, int h, int l) {
        if (pos[0] < 0 || pos[0] >= h) {
            return false;
        }

        if (pos[1] < 0 || pos[1] >= l) {
            return false;
        }

        return true;
    }
}
