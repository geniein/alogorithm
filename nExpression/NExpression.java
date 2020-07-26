package nExpression;

import java.util.ArrayList;
import java.util.List;

public class NExpression {
    
    List<Integer> resultList = new ArrayList<>();
    int min = 9;
    public int solution(int N, int number) {
        int answer = 0;        
        dp(N,N, number, 0,0);
        
        resultList.forEach(i-> System.out.println(i));
        resultList.forEach(i ->{
            if (min > i){
                min = i;
            }            
        });
        if(resultList.isEmpty()){
            min = -1;
        }
        answer = min;
        return answer;
    }

    void dp(int result,int number,int target, int count, int temp){        
        if(count >8){                        
            return;
        }
        if(min <= count){
            return;
        }

        if(result == target){      
            resultList.add(count);
            min = count;
            return;
        }
        count++;
        dp(result+increaseNumber(temp, number),number, target, count, temp);
        dp(result-increaseNumber(temp, number),number, target, count, temp);
        dp(result*increaseNumber(temp, number),number, target, count, temp);
        dp(result/increaseNumber(temp, number),number, target, count, temp);
        //dp(Integer.valueOf(result+String.valueOf(increaseNumber(temp, number))),number, target, count, temp);
    }

    private int increaseNumber(int a, int b){
        return a*10 + b;
    }

    public static void main(String[] args) {
        new NExpression().solution(5, 12);
    }
}