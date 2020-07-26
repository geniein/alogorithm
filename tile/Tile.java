package tile;

import java.util.List;

public class Tile {
    public long solution(int N) {
        long answer = 0;
        //int[] size = {0,1};
        // for(int i =1; i<= N; i++){
        //     if(i%2 == 0){
        //         size[1] += dp(i);
        //     }else {
        //         size[0] += dp(i);
        //     }            
        // }        
        // for(int i : size){
        //     System.out.println(i);
        //     answer += i;
        // }
        answer = dp(N); 
        answer = answer*2;
        System.out.println(answer);
        return answer;
    }

    private int dp(int des){
        int result = 0;
        if(des ==1){
            return 1;
        }else if(des == 2){
            return 3;
        }else if(des == 3){
            return 5;
        }else if(des < 1){
            return 0;
        }
        result = dp(des -1) + dp(des -2);
        //result = dp(des-1)*3 + dp(des-2)*2;
        return result;
    }
    
    public static void main(String[] args) {
        new Tile().solution(5);
    }
}