// function solution(relation) {
//     var answer = 0;
//     var singleUniqueList = [];
    
//     for(let i=0; i<relation[0].length; i++){
//     	let set = new Set();
//     	for(let j=0; j<relation.length; j++){
//     		set.add(relation[j][i]);
//     	}
//     	if(set.size === relation.length){
//     		singleUniqueList.push(i);
//     	}
//     }
//     relation.map((v) => {
//     	for(let i=0; i< singleUniqueList.length; i++){
//     		v.splice(singleUniqueList[i],1);
//     	}    	
//     });
//    let list = [];
//     for(let i=2; i<= relation[0].length; i++){    	
//     }
//     console.log(list);
//     console.log(singleUniqueList);
//     console.log(relation);
//     return answer;
// }

// function pactorial(n){
// 	let value = 1;
// 	for(let i = 1; i <=n; i++){
// 		value *=i;
// 	}
// 	return value;
// }

// function permutation(a){
// 	return a.reduce((list, elemnet) => {
// 	let valueList = [];
// 	console.log(list);
// 	list.forEach((v)=>{		
// 		for(let i =v.length; i>=0; i--){
// 			let value = [].concat(v);
// 			console.log('value : '+ value + '  elemnet : '+elemnet);
// 			value.splice(i,0,elemnet);
// 			valueList.push(value);
// 		}		
// 	});
// 	console.log("valueList : "+ valueList);
// 	return valueList;
// 	},[[]]);
// }

function solution(relation) {
    const cols = relation[0].length;
    const rows = relation.length
    const sets = 1 << cols
    const sk = new Set()

    for (let i=1; i<sets; i++) {
        const tmp = new Set()
        for (let row=0; row<rows; row++) {
            let key = ''
            for (let col=0; col<cols; col++) {
                if (i & (1 << col)) key = String(key) + String(relation[row][col])
            }
            tmp.add(key)
        }
        if (tmp.size === rows) sk.add(i)
    }
	console.log(sk);
    for (let i of sk) {
        for (let j of sk) {
            if (i >= j) continue
            if ((i & j) === i) sk.delete(j)
        }
    }

    console.log(Array.from(sk).map(e => e.toString(2)))

    return sk.size
}


var example = [["100","ryan","music","2"],["200","apeach","math","2"],["300","tube","computer","3"],["400","con","computer","4"],["500","muzi","music","3"],["600","apeach","music","2"]];

solution(example);
