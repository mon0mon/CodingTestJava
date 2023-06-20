/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-06-14 : AM 11:27
 */

package stack;

import java.util.Arrays;
import java.util.Stack;

//  같은 숫자는 싫어
//  https://school.programmers.co.kr/learn/courses/30/lessons/12906
public class Pg12906_같은_숫자는_싫어 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 3, 3, 0, 1, 1})));
        System.out.println(Arrays.toString(solution(new int[]{4, 4, 4, 3, 3})));
    }

    public static int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res;

        stack.push(arr[arr.length-1]);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (stack.peek() == arr[i]) {
                continue;
            }

            stack.push(arr[i]);
        }

        res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }

        return res;
    }
}
