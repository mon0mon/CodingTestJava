package dfs_bfs.Bj_1260_DFS와_BFS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.Arrays.*;

//  DFS와 BFS
//  https://www.acmicpc.net/problem/1260
public class Bj1260_DFS_BFS {
    //  그래프를 DFS와 BFS로 탐색한 결과를 출력하는 프로그램 작성
    //  DFS는 Stack, BFS는 Queue 사용
/*
4 5 1
1 2
1 3
1 4
2 4
3 4
 */

/*
5 5 3
5 4
5 2
1 2
3 4
3 1
 */

/*
1000 1 1000
999 1000
 */
    public static void main(String[] args) throws IOException {
        System.out.println(new Bj1260_DFS_BFS().solution());
    }

    private String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer startToken = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(startToken.nextToken());
        int edgeCount = Integer.parseInt(startToken.nextToken());
        int startNode = Integer.parseInt(startToken.nextToken());

        int[][] adjList = new int[nodeCount+1][nodeCount+1];

        for (int i = 0; i < edgeCount; i++) {
            int[] edge = stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            adjList[edge[0]][edge[1]] = 1;
            adjList[edge[1]][edge[0]] = 1;
        }

        StringBuilder sb = new StringBuilder(dfs(adjList, startNode)).append("\n");
        sb.append(bfs(adjList, startNode));

        return sb.toString();
    }

    private String dfs(int[][] adjList, int startNode) {
        boolean[] visited = new boolean[adjList.length];
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        stack.offerLast(startNode);

        while (!stack.isEmpty()) {
            int node = stack.pollLast();
            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            sb.append(node).append(" ");

            for (int i = adjList.length-1; i > 0; i--) {
                if (adjList[node][i] == 1 && !visited[i]) {
                    stack.offerLast(i);
                }
            }
        }

        return sb.toString();
    }

    private String bfs(int[][] adjList, int startNode) {
        boolean[] visited = new boolean[adjList.length];
        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        queue.add(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            sb.append(node).append(" ");

            for (int i = 1; i < adjList.length; i++) {
                if (adjList[node][i] == 1 && !visited[i]) {
                    queue.add(i);
                }
            }
        }

        return sb.toString();
    }
}
