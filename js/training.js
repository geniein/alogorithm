function solution(n, lost, reserve) {
    var answer = 0;
    let tList = Array(n).fill(1);
    let rList = [];
   	reserve.sort((a,b)=>a-b);
    tList.map((v,i)=>{
    	if(lost.includes(i+1)){
    		tList[i] = 0;
    	}        
    }
    );
    rList = Array.prototype.slice.call(tList);
	reserved(rList,tList,reserve);
    
    answer = tList.filter(x => x > 0).length;
    console.log(answer);
    return answer;
}

function reserved(l,t, r){
	r.forEach((x) => {
		if(l[x-1] === 0){
			t[x-1] = 1;
		} else{
			if(x !== 1){
				if(x === t.length){
					t[x-2] = 1;
				}else {
					console.log("x:" + x + "t:"+t[x-2]);
					if(t[x-2] === 0 ){
						console.log("x:" + x);
						t[x-2] = 1;
					}else if(t[x]===0){
						t[x] = 1;
					}
				}			
			} else {
				if(t[x]===0){
					t[x] = 1;
				}
			}
		}
		console.log(x +"t:"+t);
	});
}

solution(5,[2,3,4],[3,4,5]);
