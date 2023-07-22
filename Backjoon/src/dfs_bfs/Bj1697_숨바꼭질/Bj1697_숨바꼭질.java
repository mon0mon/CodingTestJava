/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-07-22 AM 11:10
 */

package dfs_bfs.Bj1697_숨바꼭질;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

//  숨바꼭질
//  https://www.acmicpc.net/problem/1697
public class Bj1697_숨바꼭질 {
/*
5 17
 */

    public static void main(String[] args) throws IOException {
        System.out.println(new Bj1697_숨바꼭질().solution());
    }

    public int solution() throws IOException {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int end = sc.nextInt();

        Deque<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[100001];
        queue.offer(new int[] {start, 0});
        visited[start] = true;
        int res = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            visited[current[0]] = true;

            if (current[0] == end) {
                res = current[1];
                break;
            }

            if (checkBoundary(current[0] - 1) && !visited[current[0] - 1]) {
                queue.offer(new int[] {current[0] - 1, current[1] + 1});
            }
            if (checkBoundary(current[0] + 1) && !visited[current[0] + 1]) {
                queue.offer(new int[] {current[0] + 1, current[1] + 1});
            }
            if (checkBoundary(current[0] * 2) && !visited[current[0] * 2]) {
                queue.offer(new int[] {current[0] * 2, current[1] + 1});
            }
        }

        return res;
    }

    private boolean checkBoundary (int point) {
        if (point < 0 || point > 100000) {
            return false;
        }

        return true;
    }
}
