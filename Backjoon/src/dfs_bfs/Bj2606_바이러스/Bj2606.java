/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-07-05 PM 11:29
 */

package dfs_bfs.Bj2606_바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//  바이러스
//  https://www.acmicpc.net/problem/2606
public class Bj2606 {
    public static void main(String[] args) throws IOException {
        System.out.println(new Bj2606().solution());
    }
    
    public long solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalComputerCount = Integer.parseInt(br.readLine());
        int connectedComputerCount = Integer.parseInt(br.readLine());

        int[][] adjList = new int[totalComputerCount+1][totalComputerCount+1];
        for (int i = 0; i < connectedComputerCount; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            adjList[edge[0]][edge[1]] = 1;
            adjList[edge[1]][edge[0]] = 1;
        }
        boolean[] infestedComputer = new boolean[totalComputerCount+1];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int index = queue.poll();

            infestedComputer[index] = true;

            for (int i = 1; i < totalComputerCount + 1; i++) {
                if (adjList[index][i] == 1 && !infestedComputer[i]) {
                    queue.offer(i);
                }
            }
        }

        //  시작점인 1번 컴퓨터는 제외하는 의미에서 -1
        int res = -1;
        for (int i = 0; i < infestedComputer.length; i++) {
            if (infestedComputer[i]) {
                res++;
            }
        }

        return res;
    }
}
