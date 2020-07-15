function solution(n, computers) {
    var answer = 0;
    var graph = new Array(n).fill(null).map((v)=>new Array());
    var list = new Array(n).fill(0);
    var v = new Array(n).fill(false);
    var queue = [];
    var networkLevel = 1;

    for(let i=0; i< computers.length; i++) {
    	for(let j=0; j< computers[i].length; j++){
    		if(computers[i][j] === 1){
    			graph[i].push(j);
    		}    		
    	}    	
    }

    console.log(graph);

    while(list.includes(0)){
    	queue.push(list.indexOf(0));
    	while(queue.length>0){
	    	let value = queue.shift();	    	
	    	if(!v[value]){
	    		for(let i =0; i<graph[value].length;i++){
	    			if(!v[graph[value][i]]){	    				
	    				queue.push(graph[value][i]);
	    			}
	    		}
	    		v[value] = true;
	    		list[value] = networkLevel;
	    	}
	    }
	    networkLevel++;
	    v.fill(false);
    }
    console.log(list);
    let s = new Set(list);
    answer = s.size;
    console.log(answer);
    return answer;
}

solution(3,[[1, 1, 0], [1, 1, 1], [0, 1, 1]]);