function solution(jobs) {
    var answer = 0;
    var total = jobs.length;
    let list = jobs.sort((a,b)=> a[1]-b[1]);
    let result = [];
    let queue = [];
    let count = 0 ;    
    while(list.length > 0 ){
        if(queue.length > 0){
            if(queue[0][1] <= count){  
                queue.shift();
            }
            if(queue.length <1){                
                
            }else{                  
                count++;                
                continue;
            }                        
        }        
        for(let i =0; i < list.length; i++){
            if(list[i][0] <= count){
                let value  = list.splice(i,1)[0];                
                value[1] += count;                
                result.push(value[1]-value[0]);
                queue.push(value);
                break;
            }            
        }        
        count++;        
    }    
    answer = Math.floor(result.reduce(((a,b) => a+b),0) / total);
    console.log(answer);    
    return answer;
}

solution([[0, 3], [1, 9], [2, 6]]);