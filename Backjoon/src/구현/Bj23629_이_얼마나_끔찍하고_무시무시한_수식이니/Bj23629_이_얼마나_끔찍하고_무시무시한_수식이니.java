/**
 * @project CodingTestJava
 * @author ARA
 * @since 2023-08-07 PM 9:50
 */

package 구현.Bj23629_이_얼마나_끔찍하고_무시무시한_수식이니;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//  RETRY
public class Bj23629_이_얼마나_끔찍하고_무시무시한_수식이니 {
    public static void main(String[] args) throws IOException {
        System.out.println(Bj23629_이_얼마나_끔찍하고_무시무시한_수식이니.solution());
    }

    //  단어의 길이는 최소 3자 ~ 최대 5자
    //  들어올 수 있는 단어로는 영문 숫자, 연산자(+, -, x, /)
    public static String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charAry = br.readLine().toCharArray();
        StringBuilder answerBuilder = new StringBuilder();
        StringBuilder expressionBuilder = new StringBuilder();

        //  문자열을 숫자로 바꾸는 과정
        boolean isMadness = true;
        for (int i = 0; i < charAry.length; i++) {
            if (checkOperator(charAry[i])) {
                answerBuilder.append(charAry[i]);
                if (expressionBuilder.length() == 0) {
                    isMadness = true;
                    break;
                }
                isMadness = false;
                continue;
            }

            expressionBuilder.append(charAry[i]);
            int convertedNumber = convertToNumber(expressionBuilder.toString());
            if (convertedNumber != -1) {
                answerBuilder.append(convertedNumber);
                expressionBuilder.setLength(0);
            }
        }

        answerBuilder.append('\n');

        char[] numEquation = answerBuilder.toString().toCharArray();
        int leftEquation = 0;
        int holder = 0;
        char operation = ' ';
        for (int i = 0; i < numEquation.length - 1; i++) {
            char ch = numEquation[i];

            if (checkOperator(ch)) {
                if (operation != ' ') {
                    leftEquation = doOperation(leftEquation, operation, holder);
                    holder = 0;
                    operation = ch;
                    continue;
                }
                operation = ch;
                leftEquation = holder;
                holder = 0;
                continue;
            }

            holder = (holder * 10) + (ch - '0');
        }

        char[] resCharAry = String.valueOf(leftEquation).toCharArray();
        for (int i = 0; i < resCharAry.length; i++) {
            if ('0' <= resCharAry[i] && resCharAry[i] <= '9') {
                String str = numberToString(resCharAry[i] - '0');
                if (str.equals("Madness!")) {
                    return str;
                }
                expressionBuilder.append(str);
            } else {
                expressionBuilder.append(resCharAry[i]);
            }
        }

        return answerBuilder.append(expressionBuilder).toString();
    }

    private static int doOperation(int leftEquation, char operation, int rightEquation) {
        switch (operation) {
            case '+' :
                return leftEquation + rightEquation;
            case '-' :
                return leftEquation - rightEquation;
            case 'x' :
                return leftEquation * rightEquation;
            case '/' :
                return leftEquation / rightEquation;
            case '=' :
            default:
                return leftEquation;
        }
    }

    public static int convertToNumber(String str) {
        switch (str) {
            case "ONE" :
                return 1;
            case "TWO" :
                return 2;
            case "THREE" :
                return 3;
            case "FOUR" :
                return 4;
            case "FIVE" :
                return 5;
            case "SIX" :
                return 6;
            case "SEVEN" :
                return 7;
            case "EIGHT" :
                return 8;
            case "NINE" :
                return 9;
            case "ZERO" :
                return 0;
            default:
                return -1;
        }
    }

    public static String numberToString(int num) {
        switch (num) {
            case 1:
                return "ONE";
            case 2:
                return "TWO";
            case 3:
                return "THREE";
            case 4:
                return "FOUR";
            case 5:
                return "FIVE";
            case 6:
                return "SIX";
            case 7:
                return "SEVEN";
            case 8:
                return "EIGHT";
            case 9:
                return "NINE";
            case 0:
                return "ZERO";
            default:
                return "Madness!";
        }
    }

    public static boolean checkOperator(char ch) {
        switch (ch) {
            case '+' :
            case '-' :
            case '/' :
            case 'x' :
            case '=' :
                return true;
            default:
                return false;
        }
    }
}
