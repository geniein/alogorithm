function solution(citations) {
    var answer = 0;
    var hList = [];
    
    for(let i =1; i<=citations.length; i++){
        let list = citations.filter((v)=> v < i);
        if((citations.length - list.length) >= i){
            if(!list.some((v) => v >i)){
                hList.push(i);
            }
        }
    }    
    answer = hList.length > 0 ? Math.max.apply(null,hList):0;
    console.log(answer);
    return answer;
}

solution([22, 42] );