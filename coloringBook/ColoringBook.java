package coloringBook;

import java.util.ArrayList;
import java.util.List;

public class ColoringBook {
    public int[] solution(int m, int n, int[][] picture) {        
        int[] answer = new int[2];        
        boolean[][] visit = new boolean[m][n];
        int[] start = new int[2];
        int value = 0;
        while(totalCount < m*n){
            start = nodeCheck(visit);
            value = picture[start[0]][start[1]];
            dfs(picture, start, visit, value);
        }
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        System.out.println(numberOfArea);
        System.out.println(maxSizeOfOneArea);
        return answer;
    }
    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;
    int count = 0;
    int totalCount = 0;
    private void dfs(int[][] picture,int[] node,boolean[][] visit, int preValue){
        if(!visit[node[0]][node[1]]){
            int value = picture[node[0]][node[1]];
            if(value == preValue){
                count++;                
            }else {
                // int[] nextNode = new int[2];
                // nextNode[0] = node[0];
                // nextNode[1] = node[1];
                // dfs(picture, nextNode, visit, value);                
                return;
            }
            visit[node[0]][node[1]] = true;
            totalCount++;
            List<int[]> list = direction(picture, node, visit);            
            if(list.size()>0){                
                for(int i =0; i< list.size(); i++){
                    dfs(picture, list.get(i), visit, value);
                }            
            }else{
                if(value != 0){                    
                    maxSizeOfOneArea = maxSizeOfOneArea > count ? maxSizeOfOneArea : count;
                    count =0;
                    numberOfArea++;
                }else {
                    count =0;
                }
                return;
            }            
        }        
    }

    private List<int[]> direction(int[][] picture,int[] node,boolean[][] visit){        
        List<int[]> ls = new ArrayList<>();
        int n0 = node[0];
        int n1 = node[1];
        int value = picture[n0][n1];
        int[] result = new int[2];
        if(n0 != 0&&picture[n0 -1][n1] == value && !visit[n0 -1][n1]){
            //UP
            result[0] = n0 -1;
            result[1] = n1;
            ls.add(result);
        }
        if(n0 != picture.length -1 && picture[n0 +1][n1] == value && !visit[n0 +1][n1]){
            //DOWN
            result[0] = n0 +1;
            result[1] = n1;
            ls.add(result);
        }
        if(n1 != 0 &&picture[n0][n1-1] == value && !visit[n0][n1-1]){
            //LEFT
            result[0] = n0;
            result[1] = n1-1;
            ls.add(result);
        }
        if(n1 != picture[0].length -1 && picture[n0][n1+1] == value && !visit[n0][n1+1]){
            //RIGHT
            result[0] = n0;
            result[1] = n1 +1;
            ls.add(result);
        }
        return ls;
    }

    private int[] nodeCheck(boolean[][] visit){
        int[] result = new int[2];
        for(int i =0; i<visit.length;i++){
            for(int j= 0; j<visit[0].length;j++){
                if(!visit[i][j]){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] picture = {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};
        int m = 6;
        int n = 4;
        new ColoringBook().solution(m, n, picture);
    }
}