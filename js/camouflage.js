function solution(clothes) {    
    var answer = 0;
    var hashMap = new Map();
    var list = [];
    clothes.map((v)=>{
        if(!hashMap.has(v[1])){
            hashMap.set(v[1],v[0]);    
        }else {
            hashMap.set(v[1],hashMap.get(v[1]) +','+ v[0]);
        }        
    });    
    hashMap.forEach((v,k,hashMap)=>list.push(hashMap.get(k).split(',').length+1));    
    console.log(list.reduce((a,b)=>a*b,1)-1);
    return list.reduce((a,b)=>a*b,1)-1;
}

solution([['yellow_hat', 'headgear'], ['green_turban', 'headgear']]);