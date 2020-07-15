function solution(n, edge) {
    var answer = 0;
    var graph =  new Array(n+1).fill(null).map((v) => new Array());        
    var queue = [[1,0]];
    var v = new Array(n).fill(false);
    var list = new Array(n).fill(0);
    for( let i of edge){
        graph[i[1]].push(i[0]);
        graph[i[0]].push(i[1]);
    }
    console.log(graph);

    while(queue.length > 0){
	    let value = queue.shift();
	    console.log(queue);
		if(!v[value[0]-1]){
		    for(let i =0; i<graph[value[0]].length; i++){		    	
		    	if(!v[graph[value[0]][i]-1]){
		    		queue.push([graph[value[0]][i],value[1]+1]);		    		
		    	}
		    	list[value[0]-1] = value[1]+1;
		    }
		    v[value[0]-1] = true;		    
		}	    
	}
	console.log(list);
	let max = Math.max.apply(null,list);
	answer = list.filter((v)=> v ===max).length;
   return answer;
}

solution(6,[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]);


/*
function solution(n, edge) {
    var answer = 0;
    var graph =  new Array(n).fill(null).map((v) => new Array(n).fill(0));    
    var d = [];
    var v = new Array(n).fill(false);
    for( let i of edge){
        graph[i[1]-1][i[0]-1] = 1;
        graph[i[0]-1][i[1]-1] = 1;
    }    

    function closestIndex() {
        let min = 20000;
        let index = 0;
        for( let i=0; i<n; i++){
            if(d[i] < min && !v[i]){
                min = d[i];
                index = i;
            }
        }
        return index;
    }

    function dijkstra(num) {
        d = graph[num];        
        v[num] = true;
        for(let i =0; i <n-2; i++){
            let cur = closestIndex();            
            v[cur] = true;
            for(let j =0; j <n; j++){
                if(!v[j]){
                    if(d[cur] + graph[cur][i] < d[j]){
                        d[j] = d[cur] + graph[cur][j];
                    }
                }
            }
        }    
    }

    dijkstra(0);
    let list = d.map((v) => v > 20000 ? 0 : v);    
    answer = list.filter((v) => 
        v === Math.max.apply(null,list)
    ).length;
    return answer;
}*/