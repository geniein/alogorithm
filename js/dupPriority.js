function solution(operations) {
    var answer = [];
    let list = operations.map((v) => v.split(" "));
    let queue = [];

    for(let i =0; i < list.length; i++){              
        if(list[i][0] == 'I'){
            queue.push(list[i][1]);
        }else if(list[i][0] == 'D'){
            if(list[i][1] == '-1'){
                let min = Math.min.apply(null,queue) + "";                
                let index = queue.indexOf(min);               
                queue.splice(index,1);
            }else {
                let max = Math.max.apply(null,queue) +"";
                let index = queue.indexOf(max);
                queue.splice(index,1);
            }
        }
    }
    if(queue.length <1){
        queue.push(0);
    }
    answer.push(Math.max.apply(null,queue));
    answer.push(Math.min.apply(null,queue));
    console.log(answer);    
    return answer;
}


let input = ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"];

solution(input);
