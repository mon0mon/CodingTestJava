/**
 * @project CodingTestJava
 * @author ARA on 2023-06-14 : AM 5:39
 */

package stack;

import java.util.ArrayDeque;
import java.util.Deque;

//  올바른 괄호
//  https://school.programmers.co.kr/learn/courses/30/lessons/12909
public class Pg12909_올바른_괄호 {

    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }

    public static boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {

            switch (ch) {
                case '(' :
                    stack.addFirst(ch);
                    break;
                case ')' :
                    if (stack.isEmpty()) {
                        return false;
                    }
                    stack.removeLast();
                    break;
            }
        }

        return stack.isEmpty();
    }
}
