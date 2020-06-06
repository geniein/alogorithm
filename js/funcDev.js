function solution(progresses, speeds) {
    var answer = [];
    let days = progresses.map((progress, index) => Math.ceil((100 - progress) / speeds[index]));;
     
    let value1 = days[0];
    let value2 = 0;
    let count = 0;
    while(days.length > 0){
        value2 = days.shift();
        if( value2 >value1){
            answer.push(count);
            count = 1;            
            if(days.length ===0){
                answer.push(count);
            }
            value1 = value2;
        } else {            
            count += 1;
            if(days.length ===0){
                answer.push(count);
            }
        }
    }
    console.log(answer);
    return answer;
}

solution([99,40,95],[1,30,5]);