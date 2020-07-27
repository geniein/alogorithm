package triangle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Triangle {
    public int solution(int[][] triangle) {
        int answer = 0;
        dfs(triangle, 0, 0, 0);
        ls.sort(Comparator.reverseOrder());
        answer = ls.get(0);
        System.out.println(answer);
        return answer;
    }
    List<Integer> ls = new ArrayList<>();
    void dfs(int[][] triangle,int depth, int width, int sum){        
        sum += triangle[depth][width];
        if(depth == triangle.length-1){
            ls.add(sum);
            return;
        }
        for(int i=0;i<2;i++){
            dfs(triangle,depth+1, width + i, sum);
        }                
    }
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        new Triangle().solution(triangle);
    }
}