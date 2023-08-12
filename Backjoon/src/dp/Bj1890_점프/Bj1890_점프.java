/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-08-12 PM 11:15
 */

package dp.Bj1890_점프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//  점프
//  https://www.acmicpc.net/problem/1890
public class Bj1890_점프 {
    private static int[] dx = {1, 0};
    private static int[] dy = {0, 1};
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer inputToken = new StringTokenizer(br.readLine(), " ");
            for (int i1 = 0; i1 < N; i1++) {
                board[i][i1] = Integer.parseInt(inputToken.nextToken());
            }
        }

        Deque<int[]> stack = new ArrayDeque<>();
        stack.offerLast(new int[] {0, 0});
        int count = 0;

        while (!stack.isEmpty()) {
            int[] position = stack.pollLast();

            for (int i = 0; i < 2; i++) {
                int nextY = position[0] + (dy[i] * board[position[0]][position[1]]);
                int nextX = position[1] + (dx[i] * board[position[0]][position[1]]);

                if (checkBoundary(nextY, nextX)) {
                    if (board[nextY][nextX] == 0) {
                        count++;
                        continue;
                    }
                    stack.offerLast(new int[] {nextY, nextX});
                }
            }
        }

        System.out.println(count);
    }

    private static boolean checkBoundary(int y, int x) {
        if (y < 0 || y >= N) {
            return false;
        }

        if (x < 0 || x >= N) {
            return false;
        }

        return true;
    }
}
