function solution(dartResult) {
    var answer = 0;
    let numbers = ['0','1','2','3','4','5','6','7','8','9','10'];
    let dartList = dartResult.split('');
    let eachTime = "";
    let eachTimeList = [];
    
    for(let i =0; i<dartList.length; i++){
        if(i !==0){
            if(numbers.includes(dartList[i])){
                if(numbers.includes(eachTime)){
                    eachTime += dartList[i];    
                }else {
                    eachTimeList.push(eachTime);
                    eachTime = dartList[i];   
                }                
            }else {
                if(dartList[i] == "*"){
                    eachTime += "O";
                    if(i< 3){
                        
                    }else if(i>3 && i<6){
                       eachTimeList[0] = eachTimeList[0] +"P";
                    }else {
                       eachTimeList[1] = eachTimeList[1] +"P"; 
                    }
                }else {
                    eachTime += dartList[i];
                }
                
                if(i+1 == dartList.length){
                    eachTimeList.push(eachTime);
                }
            }
        }else {
            eachTime = dartList[i];
        }
    }
    
    eachTimeList.map((v) =>{
        let value = 0;
        if(numbers.includes(v[1])){
            value = 10;
        }else{
            value = v[0]*1;
        }
        
        if(v.includes('S')){
           value = Math.pow(value,1);
        }else if(v.includes('D')){
            value = Math.pow(value,2);
        }else if(v.includes('T')){    
            value = Math.pow(value,3);
        }
        
        if(v.includes("O")){
            value *= 2;
        }
        if(v.includes("P")){
            value *= 2;
        }
        if(v.includes("#")){
            value *= -1;
        }
        
        answer += value;        
    })
    
    return answer;
}