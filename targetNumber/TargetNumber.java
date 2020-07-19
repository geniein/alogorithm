package targetNumber;

public class TargetNumber {
    int count = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        answer += dfs(numbers,0,0,target);        
        return answer;
    }

    private int dfs(int[] numbers, int node, int sum, int target){
        count++;
        System.out.println(count);
        if(node == numbers.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }
        return dfs(numbers, node+1, sum + numbers[node], target) + dfs(numbers, node+1, sum - numbers[node], target);
    }
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        new TargetNumber().solution(numbers, 3);
    }
}