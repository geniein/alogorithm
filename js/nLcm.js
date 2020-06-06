function solution(arr) {
    var answer = 0;
    var list = [1];
    for(let i=0;i<arr.length;i++){
        if(arr.length > 1){
            answer = dp(list[i],arr[i],list);     
        }else {
            answer = arr[0];
        }
    }    
    return answer;
}

function dp(a,b,list){    
    let ab = a*b;    
    let left = 0;    
    while(b > 0){
          left = a % b;
          a = b;
          b = left;
          }
    let gcd = a;
    list.push(ab / gcd);
    return ab / gcd;
}

solution([2,6,8,14]);