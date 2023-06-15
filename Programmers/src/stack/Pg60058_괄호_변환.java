/**
 * @project CodingTestJava
 * @author ARA on 2023-06-14 : AM 5:39
 */

package stack;

import java.util.ArrayDeque;
import java.util.Deque;

//  괄호 변환
//  https://school.programmers.co.kr/learn/courses/30/lessons/60058

//테스트 1 〉	통과 (1.44ms, 75.4MB)
//테스트 2 〉	통과 (0.04ms, 75MB)
//테스트 3 〉	통과 (1.48ms, 76.8MB)
//테스트 4 〉	통과 (1.62ms, 71.6MB)
//테스트 5 〉	통과 (2.03ms, 73.6MB)
//테스트 6 〉	통과 (1.74ms, 83MB)
//테스트 7 〉	통과 (2.11ms, 72.9MB)
//테스트 8 〉	통과 (1.96ms, 76.6MB)
//테스트 9 〉	통과 (1.99ms, 76.6MB)
//테스트 10 〉	통과 (1.33ms, 78.1MB)
//테스트 11 〉	통과 (1.35ms, 74.7MB)
//테스트 12 〉	실패 (1.39ms, 71.1MB)
//테스트 13 〉	실패 (1.26ms, 66MB)
//테스트 14 〉	실패 (1.54ms, 77.3MB)
//테스트 15 〉	실패 (1.41ms, 69.4MB)
//테스트 16 〉	실패 (1.66ms, 71.6MB)
//테스트 17 〉	실패 (1.70ms, 77MB)
//테스트 18 〉	실패 (2.01ms, 77MB)
//테스트 19 〉	실패 (1.85ms, 82.9MB)
//테스트 20 〉	실패 (1.94ms, 70.5MB)
//테스트 21 〉	실패 (1.65ms, 76.4MB)
//테스트 22 〉	실패 (1.49ms, 78.7MB)
//테스트 23 〉	실패 (1.68ms, 75.1MB)
//테스트 24 〉	통과 (1.71ms, 70.5MB)
//테스트 25 〉	통과 (1.86ms, 70.3MB)
//채점 결과
//정확성: 52.0
//합계: 52.0 / 100.0
public class Pg60058_괄호_변환 {
    static Deque<Character> stack = new ArrayDeque<>();
    public static void main(String[] args) {
        //  "(()())()"
        System.out.println(solution(	"(()())()"));
        //  "()"
        System.out.println(solution(	")("));
        //  "()(())()"
        System.out.println(solution(	"()))((()"));
    }

    public static String solution(String p) {
        //  1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if (p.isEmpty()) {
            return p;
        }

        //  2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
        //  단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
        String u = "", v = "";
        int lpCount = 0, rpCount = 0;
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            switch (ch) {
                case '(' :
                    lpCount++;
                    break;
                case ')' :
                    rpCount++;
                    break;
            }

            //  좌변 숫자와 우변 숫자를 비교해서 같을 경우
            //  u와 v로 분리
            if (lpCount == rpCount) {
                u = p.substring(0, i+1);
                v = p.substring(i+1);
                break;
            }
        }

        //  3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        boolean isPairCorrect = true;
        stack.clear();
        outerLoop:
        for (int i = 0; i < u.length(); i++) {
            char ch = u.charAt(i);
            switch (ch) {
                case '(' :
                    stack.push(ch);
                    break;
                case ')' :
                    //  u가 올바르지 않은 괄호 문자열일 경우
                    if (stack.isEmpty()) {
                        isPairCorrect = false;
                        break outerLoop;
                    }
                    stack.pop();
                    break;
            }
        }

        //  4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
        if (!isPairCorrect) {
            //  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
            StringBuilder sb = new StringBuilder("(");
            //  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
            sb.append(solution(v));
            //  4-3. ')'를 다시 붙입니다.
            sb.append(")");
            //  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
            //  바보... 단순히 뒤집는게 아니라 괄호 방향을 반대로 해야하는데...
//            for (int i = u.length()-2; i > 0; i--) {
//                sb.append(u.charAt(i));
//            }
            for (int i = 1; i < u.length()-1; i++) {
                sb.append(u.charAt(i) == '(' ? ')' : '(');
            }
            //  4-5. 생성된 문자열을 반환합니다.
            return sb.toString();
        }

        //  3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        //  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
        return u + solution(v);
    }
}
