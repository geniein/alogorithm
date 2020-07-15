function solution(x, n) {
    var answer = [];
    let value = 0;
    for(let i = 0; i< n;i++){                
        if(i === 0 ){
            value = x;
            answer.push(x);
        }else {
            value += x;
            answer.push(value);
        }
    }
    return answer;
}