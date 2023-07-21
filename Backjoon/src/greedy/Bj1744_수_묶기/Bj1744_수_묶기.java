/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-07-21 PM 3:18
 */

package greedy.Bj1744_수_묶기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

//  수 묶기
//  https://www.acmicpc.net/problem/1744
public class Bj1744_수_묶기 {
/*
4
-1
2
1
3
 */

/*
6
0
1
2
4
3
5
 */

/*
1
-1
 */

/*
3
-1
0
1
 */

/*
2
1
1
 */
    public static void main(String[] args) throws IOException {
        System.out.println(new Bj1744_수_묶기().solution());
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int inputCount = sc.nextInt();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < inputCount; i++) {
            maxHeap.offer(sc.nextInt());
        }

        Integer prevNumber = maxHeap.poll();
        int sum = 0;
        while (!maxHeap.isEmpty()) {
            int nextNumber = maxHeap.peek();

            if (nextNumber <= 1) {
                if (prevNumber != null) {
                    sum += prevNumber;
                    prevNumber = null;
                }
                break;
            }

            if (prevNumber == null) {
                prevNumber = maxHeap.poll();
                continue;
            }

            sum += prevNumber * nextNumber;
            prevNumber = null;
            maxHeap.poll();
        }

        if (prevNumber != null) {
            sum += prevNumber;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.addAll(maxHeap);

        if (minHeap.isEmpty()) {
            return sum;
        }

        prevNumber = minHeap.poll();
        while (!minHeap.isEmpty()) {
            Integer nextNumber = minHeap.peek();

            if (nextNumber == 1) {
                if (prevNumber != null) {
                    sum += prevNumber;
                    prevNumber = null;
                }
                sum += minHeap.poll();
                continue;
            }

            if (prevNumber == null) {
                prevNumber = minHeap.poll();
                continue;
            }

            sum += prevNumber * nextNumber;
            prevNumber = null;
            minHeap.poll();
        }

        if (prevNumber != null) {
            sum += prevNumber;
        }

        return sum;
    }
}
