package baseball;

import java.util.ArrayList;
import java.util.List;

public class baseball {
    public int solution(int[][] baseball) {
        int answer = 0;
        List<String> total = new ArrayList<>();
        String value= "";
        for(int i =1; i<=9;i++){            
            for(int j =1; j<=9;j++){
                if(i ==j){                    
                    continue;
                }else{
                    for(int k =1; k<=9;k++){            
                        if(k != i && k !=j){
                            value = i+""+j+""+k;
                            total.add(value);                            
                        }
                    }
                }       
            }
        }        
        for(String ball : total){
            for(int i =0; i<baseball.length;i++){
                int strike =0;
                int balls = 0;
                for(int j=0; j<3; j++){
                    if(ball.charAt(j) == String.valueOf(baseball[i][0]).charAt(j)){
                        strike++;
                    }                    
                    if(String.valueOf(baseball[i][0]).contains(ball.substring(j,j+1))){
                        balls++;
                    }                                        
                }    
                balls = balls - strike;
                if(strike != baseball[i][1]){
                    break;
                }
                if(balls != baseball[i][2]){
                    break;
                }
                if(i == baseball.length-1){
                    answer++;
                }                
            }         
        }
        
        System.out.println(answer);

        return answer;
    }
    public static void main(String[] args) {
        int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
        new baseball().solution(baseball);
    }
}