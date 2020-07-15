function solution(n, edge) {
    let graphInfo = new Array(n).fill(null).map((v)=>new Array());
    let visited = new Array(n).fill(0);
    let result = new Array(n).fill(0);
    let queue = [[0,0]];
    edge.map((v) =>{
        graphInfo[v[0]-1].push(v[1]-1);
        graphInfo[v[1]-1].push(v[0]-1);
    });
    console.log(graphInfo);

    while(queue.length > 0){
        let value = queue.shift();
        if(!visited[value[0]]){
            console.log(graphInfo[value[0]].length);
            for(let i = 0; i <graphInfo[value[0]].length; i++){
                if(!visited[value[0]][i]){
                    queue.push([visited[value[0]][i]],value[1]+1);
                }
                result[value[0]] = value[1];
            }
            visited[value[0]] = 1;
        }
    }        
}




solution(6,[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]);