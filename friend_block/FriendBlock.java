package friend_block;

import java.util.*;

class FriendBlock {
    //boardC와 marked를 전역변수로 선언
    static char[][] boardC = null;
    static boolean[][] marked = null;
    static boolean finalFlag = true;

    static void checkBlock(int m, int n){
   	//dx, dy : 자신을 기준으로 오른쪽, 아래, 그리고 대각선. 즉, 자신을 포함해서 2x2가 되는 원소를 체크하기 위함.
        int[] dx = {0, 1, 1};
        int[] dy = {1, 0, 1};

        for(int i=0; i<m-1; i++) {
            for (int j = 0; j <n-1; j++) {
                //내가 타탕한지 판단, 공백이 아니어야한다.
                if(boardC[i][j] == ' '){
                    continue;
                }
                boolean flag = false;
                for(int k=0; k<3; k++){
                    int x = i + dy[k];
                    int y = j + dx[k];
                    if(x>=0 && y>=0 && x<m && y<n){
                        //하나라도 틀리면 flag는 true
                        if(boardC[i][j] != boardC[x][y]){
                            flag = true;
                            break;
                        }
                    }
                }

                //한블록이 완성되면 flag는 false
                if(!flag){
                    finalFlag = true;
                    //자기자신, 그리고 한 블록이 된 멤버들 모두 marked를 true로 만들어주기
                    marked[i][j] = true;
                    for(int k=0; k<3; k++){
                        int mx = i+dx[k];
                        int my = j+dy[k];
                        marked[mx][my] = true;
                    }
                }
            }
        }
    }

    // marked[i][j] == true인 것을 세고, 그 자리에 boardC[i][j] = ' '로 공백 처리, count로 리턴
    static int processBlock(int m, int n){
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(marked[i][j]){
                    boardC[i][j] = ' ';
                    count += 1;
                }
            }
        }
        return count;
    }

    //공백인 것들을 열기준으로 아래로 밀기. 그에 따라 marked도 다시
    static void rearrangeBlock(int m, int n){
        //중요한 점은 열 단위로 봐야함. 공백이 있으면 아래로 내려가야하기 때문!
        String tmpStr = "";
        for(int j=0; j<n; j++){
            tmpStr = "";
            //j열에 해당하는 값을 모으기 위한 loop
            for(int i=0; i<m; i++){
                tmpStr += boardC[i][j];
            }
            //공백이 있으면 제거하고
            tmpStr = tmpStr.replaceAll(" ", "");

            //뒤에서부터 tmpStr.charAt을 사용해서 하나씩 다시 넣는다.
            for(int i=0; i<tmpStr.length(); i++){
                boardC[m-1-i][j] = tmpStr.charAt(tmpStr.length()-1-i);
                marked[m-1-i][j] = false;
            }

            if(m > tmpStr.length()){
                int loop = m-tmpStr.length();
                for(int i=loop-1; i>=0; i--){
                    boardC[i][j] = ' ';
                    marked[i][j] = false;
                }
            }
        }
    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        boardC = new char[m][n];
        marked = new boolean[m][n];
        //board를 입력 받는다.
        for(int i=0; i<m; i++){
            boardC[i] = board[i].toCharArray();
        }


        while(finalFlag){
            finalFlag = false;
            checkBlock(m, n);
            answer += processBlock(m, n);
            rearrangeBlock(m, n);
        }

        return answer;
    }
}