function solution(n) {
    var answer = 0;
    var nList = [];
    var rList = [];
    
    for(let i =0; i<n; i++){
        nList.push(i+1);
    }
    
    nList.map((n) => {
        for(let i =2; i<n+1; i++){
            for(let j =2; j<i; j++){
                if(i % j === 0 ){
                    if (!rList.includes(i)){
                        rList.push(i);
                        break;
                    }
                }
            }
        }
    });
    answer = nList.length - rList.length - 1;
    return answer;
}