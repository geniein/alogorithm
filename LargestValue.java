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
        }
        
        /** 3 **/
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String number1, String number2) {
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
        int[] numbers = {6,20,1,21};

        LargestValue largestValue;
        largestValue = new LargestValue();
        
        String result = "";
        result = largestValue.solution(numbers);
        
        System.out.println("result : " + result);
    }
}
