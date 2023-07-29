/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-07-28 PM 6:34
 */

package dfs_bfs.Bj9205_맥주_마시면서_걸어가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//  맥주 마시면서 걸어가기
//  https://www.acmicpc.net/problem/9205
//  RETRY
public class Bj9205_맥주_마시면서_걸어가기 {

    private BufferedReader br;
    private int offset = 32768;
    private int maxLimit = Character.MAX_VALUE;
    private int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    private int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        System.out.println(new Bj9205_맥주_마시면서_걸어가기().solution());
    }

    public String solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNumber = Integer.parseInt(br.readLine());
        StringBuilder answerBuilder = new StringBuilder();

        for (int i = 0; i < testCaseNumber; i++) {
            answerBuilder.append(solve()).append('\n');
        }

        return answerBuilder.toString();
    }

    private String solve() throws IOException {
        int storeCount = Integer.parseInt(br.readLine());
        StringTokenizer inputToken = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(inputToken.nextToken()) + offset;
        int startY = Integer.parseInt(inputToken.nextToken()) + offset;

        int[][] storePos = new int[storeCount][];
        for (int i = 0; i < storeCount; i++) {
            inputToken = new StringTokenizer(br.readLine());
            int storeX = Integer.parseInt(inputToken.nextToken()) + offset;
            int storeY = Integer.parseInt(inputToken.nextToken()) + offset;
            storePos[i] = new int[]{storeY, storeX};
        }

        inputToken = new StringTokenizer(br.readLine());
        int endX = Integer.parseInt(inputToken.nextToken()) + offset;
        int endY = Integer.parseInt(inputToken.nextToken()) + offset;

        return bfs(new int[]{startY, startX}, new int[]{endY, endX}, storePos);
    }

    private String bfs(int[] startPos, int[] endPos, int[][] storePos) {
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[maxLimit + 1][maxLimit + 1];

        //  시작 y, 시작 x, 맥주 갯수, 이동한 거리
        queue.offer(new int[]{startPos[0], startPos[1], 20, 0});

        while (!queue.isEmpty()) {
            int[] info = queue.poll();

            if (visited[info[0]][info[1]]) {
                continue;
            }

            //  맥주가 바닥나면
            if (info[2] == 0) {
                break;
            }

            visited[info[0]][info[1]] = true;

            int nextStep = info[3] + 1;
            int nextBeerCount = nextStep % 50 == 0 ? info[2] - 1 : info[2];

            //  편의점에 도착하면 맥주를 전부 채움
            for (int i = 0; i < storePos.length; i++) {
                if (storePos[i][0] == info[0] && storePos[i][1] == info[1]) {
                    nextBeerCount = 20;
                    nextStep = 0;
                }
            }

            for (int i = 0; i < 8; i++) {
                int nextY = startPos[0] + dy[i];
                int nextX = startPos[1] + dx[i];

                if (nextY == endPos[0] && nextX == endPos[1]) {
                    return "happy";
                }

                if (checkBoundary(nextY, nextX) && checkDirection(
                        new int[]{info[0], info[1]},
                        new int[]{nextY, nextX},
                        endPos
                )) {
                    queue.offer(new int[]{nextY, nextX, nextBeerCount, nextStep});
                }
            }
        }

        return "sad";
    }

    private boolean checkDirection(int[] curPos, int[] nextPos, int[] endPos) {
        //  현재 거리보다 더 멀어지면 false 리턴
        if (Math.abs(curPos[1] - endPos[1]) < Math.abs(nextPos[1] - endPos[1])) {
            return false;
        }

        if (Math.abs(curPos[0] - endPos[0]) < Math.abs(nextPos[0] - endPos[0])) {
            return false;
        }

        return true;
    }

    private boolean checkBoundary(int y, int x) {
        //  2^16 - 1범위를 벗어나면 false
        if (0 > y || y > maxLimit) {
            return false;
        }

        if (0 > x || x > maxLimit) {
            return false;
        }

        return true;
    }
}
