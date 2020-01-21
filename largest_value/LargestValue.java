/* 문제 설명
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다. */

package largest_value;
import java.util.Arrays;
import java.util.Comparator;

public class LargestValue {

    private String solution(int[] numbers) {
        String answer = new String();
        /** 1 **/
        String strNumbers[] = new String[numbers.length];
        
        /** 2 **/
        for(int i=0; i<strNumbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
            System.out.println(strNumbers[i]+",");
        }
        
        /** 3 **/        
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String number1, String number2) {
                System.out.println("number1: "+number1 + " number2: "+number2);
                return (number2+number1).compareTo(number1+number2);
            }
        });
        
        /** 4 **/
        if(strNumbers[0].startsWith("0")) { 
            answer += "0";
        } else {
            for(int j=0; j<strNumbers.length; j++) {
                answer += strNumbers[j];
            }
        }
        
        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {4,2,5,1,3};

        LargestValue largestValue;
        largestValue = new LargestValue();
        
        String result = "";
        result = largestValue.solution(numbers);
        
       //System.out.println("result : " + result);
    }
}
