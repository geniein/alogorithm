function solution(N, stages) {
    var answer = [];
    let graph = stages.map((v)=>v = "*".repeat(v));
    let failure = [];
    
    for(let i =0;i<N;i++){
        let stageTotal = 0;
        let stageLast = 0;
        for(let j=0;j<graph.length;j++){
           if(graph[j][i] == "*"){
               stageTotal += 1;
           }
            if(stages[j] == i+1){
                stageLast += 1;
            }
        }
        if( stageTotal !== 0 ){
            failure.push(stageLast/stageTotal);
        }else{
            failure.push(0);
        }
        
    }
    failure = failure.map((v,i) => v = [i+1,v]);
    console.log(failure);
    failure.sort((a,b)=>{
        if(b[1]-a[1] === 0){
            return a[0]-b[0];
        }else{
            return b[1]-a[1];
        }
    });

    answer = failure.map((v)=>v[0]);
    console.log(answer);
    return answer;
}


//solution(5,[1,2,3,3,4,5]);

solution(5,[1,1,1,1,1,1,1,1]);