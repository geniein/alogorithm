function solution(numbers, target) {
    var answer = 0;
    
    function recursive(i, sum){
        console.log("i : "+i + " sum : "+sum);
        if(i === numbers.length){
            if(sum === target){
                answer++;
            }
            return;
        }
        recursive(i+1,sum+numbers[i]);
        recursive(i+1,sum-numbers[i]);
    }
    recursive(0,0);
    return answer;
}

solution([1, 1, 1, 1, 1],3);