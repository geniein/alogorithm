function solution(N, stages) {
    var answer = [];
    let failure = new Array(N).fill(0);    
    let graph = stages.map((v)=>{
        if(v <= N){
            failure[v-1] += 1;    
        }
        return v = "*".repeat(v);        
    });
    
    for(let i =0;i<N;i++){
        let stageTotal = 0;        
        for(let j=0;j<graph.length;j++){
           if(graph[j][i] == "*"){
               stageTotal += 1;
           }            
        }                
        if( stageTotal !== 0 ){
            answer.push(failure[i]/stageTotal);
        }else{
            answer.push(0);
        }   
    }
    answer = answer.map((v,i) => v = [i+1,v]).sort((a,b)=>{
        if(b[1]-a[1] === 0){
            return a[0]-b[0];
        }else{
            return b[1]-a[1];
        }
    }).map((v)=>v[0]);
    
    //answer = answer.map((v)=>v[0]);
    
    return answer;
}

//solution(5, [2, 1, 2, 6, 2, 4, 3, 3]);
solution(3, [4,4,1]);