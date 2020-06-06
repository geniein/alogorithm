function solution(s) {
    var answer = '';
    let list = s.split(' ').map((v)=>{
        let capital = v.charAt(0).toUpperCase();        
        if(v.length > 1){            
            v = v.toLowerCase().substr(1,v.length);
            return capital+v;
        }else{
           return capital;
        }       
    }).join(' ');
    answer = list;
    return answer;
}

console.log(solution('  for the last week  '));