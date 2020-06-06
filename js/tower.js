function solution(heights) {
    var answer = [];
    var list = [];
    
    for(let i =heights.length-1; i >= 0; i--){
        let value = heights[i];        
        let j = i-1;
        while(value ===heights[i]){            
            if( i === 0){
                console.log("i:"+i);
                value = 0;
                answer.unshift(0);
                break;
            }
            if(heights[j]>value){
                value = heights[j];
                answer.unshift(j+1);
                continue;
            }
            if( j === 0){                
                value = 0;
                answer.unshift(0);
            } 
            j--;       
        }
    }
    console.log(answer);
    return answer;
}

solution([5, 3, 1, 2, 3]);