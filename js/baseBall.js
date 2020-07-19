function solution(baseball) {
    var answer = 0;
    var list = [];
    for(let i=1;i<=9;i++){
        for(let j=1;j<=9;j++){
            if(i == j){
                continue;
            }
            for(let k=1;k<=9;k++){
                if(i==k || j==k){
                    continue;
                }
                list.push(i+""+j+""+k);
            }
        }
    } 
    
    for(let i = 0; i<list.length;i++){
        let result = numberCheck(list[i],baseball);
        if(result){
            answer++;
        }
    }
    console.log(answer);
    return answer;
}

function numberCheck(value, baseball){
    let strike =0;
    let ball = 0;
    for(let i =0; i<baseball.length; i++){
        for(let j =0; j<value.length; j++){
            baseball[i][0] = baseball[i][0]+"";
            if(value[j] == baseball[i][0][j]){
                strike++;
            }
            if(baseball[i][0].includes(value[j])){
                ball++;
            }                                
        }
        ball = ball - strike;        
        if(strike != baseball[i][1] || ball != baseball[i][2]){
            return false;
        }
        strike =0;
        ball = 0;
    }
    return true;
}

solution([[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]]);