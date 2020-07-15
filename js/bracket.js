
function solution(p) {
    var answer = '';
    let state = {
         1 : 'balanced',
         2 : 'correct',
        };
    let left = 0;
    let right = 0;
    let check = 0;

    if(p.length == 0 ){
        return ``;
    }

    for(let i =0; i<p.length; i++){
        if(p[i] == `(`){
            left++;
        }else if(p[i] == `)`){
            right++;
        }
        if(right > left){
            //not pairs
            return false;
        }
        if(right == left){
            check = 1;
        }
        if(state[check] == 'balanced'){
            console.log(`balanced`);
        }
    }
    return answer;
}

function balanced(){

}

function right(){

}


solution("(()())()");