package levelTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelTwo {
    public int solution(int []A, int []B)
    {
        int answer = 0;
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i =0; i<A.length; i++){
            answer += A[i]*B[B.length-1-i];
        }
        
        System.out.println(answer);
        return answer;
    }

    List<Integer> result = new ArrayList<>();    
    void calc(int[] A, int[] B, boolean[] visitA, boolean[] visitB, int sum, int count){
        if(count == A.length){
            result.add(sum);
            return;
        }
        for(int i =0; i<A.length;i++){
            if(visitA[i]){
                continue;
            }            
            for(int j =0; j<A.length;j++){
                if(visitB[j]){
                    continue;
                }
                visitA[i] = true; 
                visitB[j] = true;                                  
                calc(A, B, visitA, visitB, sum + (A[i] * B[j]), count+1);
                visitA[i] = false;
                visitB[j] = false;                                                
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {3, 4};
        // int[] A = {1, 4, 2};
        // int[] B = {5, 4, 4};
        new LevelTwo().solution(A, B);
    }
    
}