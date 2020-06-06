function solution(priorities, location) {
    var answer = 0;
    var list = priorities.map((v,i)=> [v,i]);            
    while(list.map((v)=>v[1]).includes(location) ){
         let val = list.shift();
         if(list.length > 0){
            if(val[0] >= Math.max.apply(null,list.map((v,i)=>v[0]))){                
                answer++;
            }else {
                list.push(val);                
            }
         }else{
            answer++;
            break;
         }        
    }    
    console.log(answer);
    return answer;
}
solution([2,3,4],0);