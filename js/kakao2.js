function solution(N, facility) {
    var answer = 0;
    let graph = new Array(N).fill(null).map((v)=>new Array(N).fill(0));
    
    for(let i =0; i<N; i++){
        for(let j =0; j<N;j++){
            graph[i][j] = [i+1,j+1];
        }
    }
    
    for(let i =0; i<N; i++){
        for(let j =0; j<N;j++){            
            let max =0;
            for(let k =0; k<facility.length;k++){
                let value = (Math.abs(graph[i][j][0] - facility[k][0]) + Math.abs(graph[i][j][1] - facility[k][1])) * facility[k][2];
                if(value > max){
                    max = value;
                }
            }
            graph[i][j] = max;
        }
    }
    let list = graph.map((v) => Math.min.apply(null,v));    
    answer = Math.min.apply(null,list);
    return answer;
}
