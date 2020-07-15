function solution(n, results) {    
    var answer = 0;
    
    for(let i =0; i<n; i++){
        eval('var win'+i+'= new Set()');
        eval('var lose'+i+'= new Set()');
    }
    
    for(let i =0; i<n; i++){
        for(let j = 0; j<  results.length; j++){
            if(results[j][0] == i+1){
                eval('win'+i+'.add(results['+j+'][1])');                
            }else if(results[j][1] == i+1){
                eval('lose'+i+'.add(results['+j+'][0])');                
            }
        }
    }
    console.log(win1);
    console.log(lose1);
    return answer;
}

solution(5,[[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]);