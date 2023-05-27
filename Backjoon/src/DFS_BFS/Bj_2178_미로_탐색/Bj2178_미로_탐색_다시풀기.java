package DFS_BFS.Bj_2178_미로_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//  미로 탐색
//  https://www.acmicpc.net/problem/2178
public class Bj2178_미로_탐색_다시풀기 {
    //  BFS 이용해서 풀기
    static int[][] map;
    static boolean[][] visited;
    static int[] moveX = new int[] {0, 1, 0, -1};
    static int[] moveY = new int[] {1, 0, -1, 0};
    static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        System.out.println(dfs());
    }

    public static int dfs() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        map = new int[y][x];
        visited = new boolean[y][x];

        int curX = 0, curY = 0, count = 0, moveIdx = 0;
        while (true) {
            if (curX == x-1 && curY == y-1) {
                break;
            }


            if (map[curY+ moveY[moveIdx]][curX + moveX[moveIdx]] != 0
                && visited[curY + moveY[moveIdx]][curX + moveX[moveIdx]]) {
//                queue.offer(0);
            }
        }

        return 0;
    }
}
