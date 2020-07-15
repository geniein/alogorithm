function solution(answers) {
    var answer = [];
    
    var a = ['1', '2', '3', '4', '5'];
    var b = ['2', '1', '2', '3', '2', '4', '2', '5'];
    var c = ['3', '3', '1', '1', '2', '2', '4', '4', '5', '5'];
    
    let eachCounter = [a,b,c];
    
    let map = eachCounter.map(c => correctValue(answers, c));
    
    if(map[0] >= map[1] && map[0] >= map[2]){
        answer.push(1);
    }

    if(map[1] >= map[0] && map[1] >= map[2]){
        answer.push(2);
    }


    if(map[2] >= map[0] && map[2] >= map[1]){
        answer.push(3);
    }


    console.log(answer);
    return answer;
}

function correctValue(answers, g){
    let counter = 0;
    for(let i = 0; i< answers.length; i++){
        if(answers[i] == g[i % g.length]){
            counter += 1;
        }
    }
    return counter;
}

var answersList = ['1','3','2','4','2'];

solution(answersList);
