package dfs_bfs.Bj_2178_미로_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

//  미로 탐색
//  https://www.acmicpc.net/problem/2178
public class Bj2178_미로_탐색 {
/*
4 6
101111
101010
101011
111011
 */

/*
4 6
110110
110110
111111
111101
 */

/*
2 25
1011101110111011101110111
1110111011101110111011101
 */

/*
7 7
1011111
1110001
1000001
1000001
1000001
1000001
1111111
 */
    private int m;
    private int n;

    public static void main(String[] args) throws IOException {
        System.out.println(new Bj2178_미로_탐색().solution());
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer mapToken = new StringTokenizer(br.readLine());
        m = Integer.parseInt(mapToken.nextToken());
        n = Integer.parseInt(mapToken.nextToken());

        int[][] map = new int[m][n];

        for (int i = 0; i < m; i++) {
            map[i] = Arrays.stream(br.readLine()
                    .split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        Queue<int[]> queue = new ArrayDeque<>();

        //  y, x, step
        queue.offer(new int[] {0, 0});
        map[0][0] = 2;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            int[] currentPosition = queue.poll();
            int curY = currentPosition[0];
            int curX = currentPosition[1];

            if (curY == m-1 && curX == n-1) {
                return map[curY][curX] - 1;
            }

            for (int i = 0; i < 4; i++) {
                if (checkBoundary(curY, curX, dy[i], dx[i])
                        && map[curY + dy[i]][curX + dx[i]] == 1) {
                    queue.offer(new int[] {curY + dy[i], curX + dx[i]});
                    map[curY + dy[i]][curX + dx[i]] = map[curY][curX] + 1;
                }
            }
        }

        return -1;
    }

    private boolean checkBoundary (int y, int x, int dy, int dx) {
        if (y + dy >= m || y + dy < 0) {
            return false;
        }

        if (x + dx >= n || x + dx < 0) {
            return false;
        }

        return true;
    }
}
