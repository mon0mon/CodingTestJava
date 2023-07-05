/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-06-21 0021 : AM 3:38
 */

package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

//  나이트의 이동
//  https://www.acmicpc.net/problem/7562
public class Bj7562_나이트의_이동 {
    //  1. bfs
    //      3.1 현재 나이트의 위치가 목표 칸과 동일하면 이동한 횟수 출력
    //      3.2 현재 나이트의 위치가 목표 칸과 다를 경우
    //          3.2.1 현재 칸을 기준으로 이동할 수 있는 칸 계산
    //          3.2.2 이동할 수 있는 칸을 queue에 넣어줌
    //      3.3 queue 값이 비어있을 때, 0을 리턴
    private final int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
    private final int[] dy = {-2, 2, -1, 1, 2, -2, 1, -1};

    public static void main(String[] args) throws IOException {
        System.out.println(new Bj7562_나이트의_이동().solution());
    }

    public String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < testCaseCount; i++) {
            int l = Integer.parseInt(br.readLine());
            int[] startPos = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
            int[] destPos = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
            sb.append(bfs(l, startPos, destPos));
            sb.append("\n");
        }

        return sb.toString().trim();
    }

    private int bfs(int l, int[] startPos, int[] destPos) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[l][l];

        //  x좌표, y좌표, 이동횟수
        queue.offer(new int[] {startPos[0], startPos[1], 0});
        visited[startPos[0]][startPos[1]] = true;
        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int[] nextPos = new int[3];
                nextPos[0] = curPos[0] + dx[i];
                nextPos[1] = curPos[1] + dy[i];
                nextPos[2] = curPos[2] + 1;

                if (checkBoundary(nextPos, l) && !visited[nextPos[0]][nextPos[1]]) {
                    if (nextPos[0] == destPos[0] && nextPos[1] == destPos[1]) {
                        return nextPos[2];
                    }
                    queue.offer(nextPos);
                    visited[nextPos[0]][nextPos[1]] = true;
                }
            }
        }

        return 0;
    }

    public static boolean checkBoundary(int[] pos, int limit) {
        //  이동하려는 위치가 경계값과 같거나 높을 경우 false
        if (pos[0] >= limit || pos[1] >= limit) {
            return false;
        }
        //  이동하려는 위치가 0미만 일 경우 false
        else if (pos[0] < 0 || pos[1] < 0) {
            return false;
        }

        return true;
    }
}
