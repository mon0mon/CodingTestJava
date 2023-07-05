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
    
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerCount = Integer.parseInt(br.readLine());
        int mappingCount = Integer.parseInt(br.readLine());

        List<LinkedList<Integer>> map = new ArrayList<>();

        for (int i = 0; i < computerCount + 1; i++) {
            map.add(new LinkedList<>());
        }

        for (int i = 0; i < mappingCount; i++) {
            StringTokenizer mapTokenizer = new StringTokenizer(br.readLine());
            int virusedComputer = Integer.parseInt(mapTokenizer.nextToken());
            int connectedComputer = Integer.parseInt(mapTokenizer.nextToken());

            map.get(virusedComputer).add(connectedComputer);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] checkedComputer = new boolean[computerCount+1];
        queue.add(1);
        int virusedComputerCount = 0;
        checkedComputer[1] = true;

        while (!queue.isEmpty()) {
            int currentComputer = queue.poll();

            LinkedList<Integer> connectedComputer = map.get(currentComputer);
            for (Integer computer : connectedComputer) {
                if (!checkedComputer[computer]) {
                    queue.add(computer);
                    checkedComputer[computer] = true;
                    virusedComputerCount++;
                }
            }
        }

        return virusedComputerCount;
    }
}
