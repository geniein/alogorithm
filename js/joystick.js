function solution(name) {
    var answer = 0;
    var choosen = [];
    

    if(name.length > 1){
        answer += index(name[0]);
        choosen.push(name[0]);
        while(choosen.join('') != name){
            if(name[1] === 'A'){
                answer++;
            }else{
                answer++;
            }
        }        
    } else {
        answer += index(name);
    }
    
    return answer;
}

function index(value){
    var list1 = ['A','B','C','D','E','F','G','H','I','J','K','L','N'];
    var list2 = [
        '',  'Z', 'Y', 'X', 'W', 'V',
        'U', 'T', 'S', 'R', 'Q', 'P',
        'O', 'M'
      ];
    if(list1.indexOf(value)>0){
        return list1.indexOf(value);
    }else{
        return list2.indexOf(value);
    }
}

solution('JAN');