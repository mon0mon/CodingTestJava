/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-06-14 : AM 11:25
 */

package stack;

import java.util.Arrays;
import java.util.Stack;

//  주식가격
//  https://school.programmers.co.kr/learn/courses/30/lessons/42584
public class Pg42584_주식가격 {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
        System.out.println(Arrays.toString(solution(new int[]{3, 5, 5, 4, 2})));
    }

    //효율성  테스트
    //테스트 1 〉	통과 (48.09ms, 71.3MB)
    //테스트 2 〉	통과 (41.06ms, 66.4MB)
    //테스트 3 〉	통과 (65.84ms, 77.3MB)
    //테스트 4 〉	통과 (44.03ms, 69MB)
    //테스트 5 〉	통과 (38.11ms, 65.1MB)
//    public static int[] solution(int[] prices) {
//        Stack<Integer> stack = new Stack<>();
//        int[] res = new int[prices.length];
//
//        outer:
//        for (int i = 0; i < prices.length; i++) {
//            stack.push(prices[i]);
//            for (int j = i; j < prices.length; j++) {
//                if (stack.peek() > prices[j]) {
//                    res[i] = j - i;
//                    continue outer;
//                }
//            }
//            res[i] = prices.length - i - 1;
//        }
//        res[res.length - 1] = 0;
//
//        return res;
//    }

    public static int[] solution(int[] prices) {
        //  시간을 저장하는 스택
        Stack<Integer> timeStack = new Stack<>();
        //  가격을 저장하는 스택
        Stack<Integer> priceStack = new Stack<>();
        //  하락한 시간초 만큼을 저장하는 배열
        int[] res = new int[prices.length];
        //  prices 배열 인덱스 값을 저장하는 변수
        int idx = 0;

        //  prices 배열을 전부 순회할때까지 반복
        while (idx < prices.length) {
            //  현재 prices 배열의 값과 스택에 저장된 값을 비교해서
            //  현재 가격이 더 작을 경우 res 배열에 시간초 저장
            if (!priceStack.isEmpty() && priceStack.peek() > prices[idx]) {
                int time = timeStack.pop();
                res[time] = idx - time;
                priceStack.pop();
                continue;
            }

            //  스택이 빌 경우
            //  스택에 저장된 가격보다 현재 가격이 클 경우
            priceStack.push(prices[idx]);
            timeStack.push(idx++);
        }

        //  마지막까지 저장되지 않은 경우
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0) res[i] = res.length - i - 1;
        }

        return res;
    }
}
