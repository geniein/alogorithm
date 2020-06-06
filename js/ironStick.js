function solution(arrangement) {
    var answer = 0;
    let list = [];
    //arrangement = arrangement.split('');
    arrangement = arrangement.replace(/(\(a\))/g, 1);
    let left = 0;
    let preValue = "";
    let branch = 0;
    let value = "";
    
    return arrangement;
    while(arr.length > 0){
        //console.log("branch : "+ left);
        let dir = arr.shift();        
        if(dir === "("){
            left++;               
            list.push(dir);
        }else {
            left--;                
            value = list.pop();
            if(value === "("){                
                if(preValue===dir){
                    branch++;                    
                }else {
                    branch+= left;
                }              
            }                   
        }
        preValue = dir
    }
    return branch;
}

console.log(solution('a(((()(a))(())()))b'));