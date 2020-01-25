/*문제 설명
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.*/

package math_renouncer;
import java.util.*;

class Solution {
    public static int[] renouncer(int[] input, int maxNum){

        int[] renouncer = new int[maxNum];

        for(int i = 0; i < maxNum;i++){
            renouncer[i] = input[(i % input.length)];
        }        
        return renouncer;
    }

    public static int correct(int[] answers, int[] renouncer){
        int right_answers = 0;

        for(int i = 0; i <answers.length; i++){
            if (answers[i] == renouncer[i]){
                right_answers++;
            }
        }

        return right_answers;
    }
    
    public static void main(String[] args) {
        int[] answers = {1,3,3,4,5,3,3,3,3,3,1,1,1,1,1,3,2,3,2,3};
        int[] solution;
        ArrayList<int[]> list = new ArrayList<int[]>();
        ArrayList answersList = new ArrayList();
        int temp = 0;;
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        
        list.add(first);
        list.add(second);
        list.add(third);
        solution = new int[list.size()];
        for(int i=0; i< list.size(); i++){
            solution[i] = correct(renouncer(list.get(i), answers.length), answers);
        }

        for(int j=0; j < solution.length;j++){
            
            if(j==0){
                answersList.add(j+1);
                continue;
            }
            
            if(solution[j] > solution[j-1]){
                answersList.clear();
                answersList.add(j+1);
            } else if ( solution[j] == solution[j-1]){
                answersList.add(j+1);
            } else {
                solution[j] = solution[j-1];
            }
        }
        Collections.sort(answersList);
        int[] answer = new int[answersList.size()];
        for(int k =0; k<answersList.size(); k++){
            answer[k] = Integer.parseInt(answersList.get(k).toString());
        }

        System.out.println(Arrays.toString(answer));
    }
}