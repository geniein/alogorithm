function solution(N, number) {
    var answer = 0;
    var list = [];
    var count = 0;
    function recursive(preValue,count){
        count++;        
        if(count > 8){
            return;
        }
        if(preValue === number){
            list.push(count);
        }
        recursive(preValue+N,count);
        recursive(preValue-N,count);
        recursive(preValue*N,count);
        recursive(preValue/N,count);
        recursive((N+""+preValue)*1,count);
    }

    recursive(N,count);    
    if(list.length > 0){
        answer = Math.min.apply(null, list);
    }else{
        answer = -1;
    }    
    return answer;
}

solution(5,12);

