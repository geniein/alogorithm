function solution(people, limit) {
    var answer = 0;
    var list = people.sort((a,b)=>b-a);
    let dIndex =  0;
    while ( dIndex > -1){
        let last = list.pop();
        dIndex = list.findIndex((i)=> i+ last <= limit);
        if (dIndex > -1){
            list.splice(dIndex,1);
            answer++;
        }else{
            list.push(last);
        }
    }
    answer += list.length;
    return answer;
}

solution([70, 50, 80, 50],100);