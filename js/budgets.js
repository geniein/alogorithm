function solution(budgets, M) {
    var answer = 0;
    let evaluation = Math.floor(M/budgets.length);
    let sum =0;
    while(M>sum){
        sum =budgets.map((v)=> v >evaluation ? evaluation : v ).reduce((a,b)=>a+b,0);
        if(sum>M){
            answer = evaluation-1;
            break;
        }else{
            evaluation++;
        }
    }    
    return answer;
}