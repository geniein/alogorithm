function solution(begin, target, words) {
    var answer = "";
    var checkedList = [];   
    var resultList = [];    

    findWord(begin,target,words,0,checkedList);

    function findWord(begin,target,words,count,checkedList){        
        if(begin == target){            
            resultList.push(count);
            return false;
        }
    
        for(let i=0; i<words.length; i++){
            let diff = 0;
            let check = true;
            for(let j =0; j< begin.length; j++){
                if(begin[j] !=words[i][j]){                                        
                    diff++;
                }                         
            }            

            for(let k=0; k < count; k++){
                                
                if(checkedList[k] == i ){
                    check = false;
                }
            }       
            if(diff == 1 && check){                                
                checkedList.push(i);                                
                findWord(words[i],target,words,count +1,checkedList);
            }
        }        
    }
    answer = Math.min.apply(null,resultList);
    return answer;
}

solution("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]);