function solution(brown, yellow) {
    var answer = [];
    let h = 3;
    let v = 3;
    let brownSum = 2*h + 2*(v-2);
    let yellowSum =(h-2)*(v-2);
    while(h >= v){
        console.log("h:"+h+"v:"+v);
        if(brown ===(2*h + 2*(v-2)) && yellow ===((h-2)*(v-2))){
            answer.push(h);
            answer.push(v);
            break;
        }
        if(h === v){
            h++;
            v=3;
        }else {
            v++;
        }
    }
    return answer;
}

solution(24,24);