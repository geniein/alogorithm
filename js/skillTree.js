function solution(skill, skill_trees) {
    var answer = 0;    
    skill_trees.map((v,i)=>{
        let skillList = skill.split('');
        for(let i =0; i<v.length;i++){
            if(skillList.includes(v[i])){
                let value = skillList.shift();
                if(value != undefined){
                    if(v[i]==value){
                        
                    }else{
                        break;
                    }
                }else{
                    answer++;
                    break;
                }
            }
            if(v.length -1 === i){
                answer++;
            }
        }        
    });
    console.log(answer);
    return answer;
}

//solution('CBD',["BACDE", "CBADF", "AECB", "BDA",'AE']);

solution('CD',['A','CQ','D','AD']);