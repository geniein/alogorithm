function solution_old(record) {
    var answer = [];
    let detail = record.map((v)=>v.split(' '));
    let memory = [];
    let memoryMap = new Map();

    for(let i =0; i<detail.length; i++){
        if(detail[i][0] == "Enter"){
            if(detail[i][2] != undefined){
                memoryMap.set(detail[i][1],detail[i][2]);
            }
            //console.log(memoryMap.get(detail[i][1]) + "님이 들어왔습니다.");
        }else if(detail[i][0] == "Leave"){
            //console.log(detail[i][2] + "님이 나갔습니다.");
        }else if(detail[i][0] == "Change"){
            memoryMap.set(detail[i][1],detail[i][2]);
            //console.log(detail[i][2] + "님이 나갔습니다.");
        }
    }

    for(let i =0; i<detail.length; i++){
        if(detail[i][0] == "Enter"){            
            console.log(memoryMap.get(detail[i][1]) + "님이 들어왔습니다.");
            answer.push(memoryMap.get(detail[i][1]) + "님이 들어왔습니다.");
        }else if(detail[i][0] == "Leave"){
            console.log(memoryMap.get(detail[i][1]) + "님이 나갔습니다.");
            answer.push(memoryMap.get(detail[i][1]) + "님이 나갔습니다.");
        }
    }

    return answer;    
}

//good
function solution(record) {
    const userInfo = {};
    const action = [];
    const stateMapping = {
        'Enter': '님이 들어왔습니다.',
        'Leave': '님이 나갔습니다.'
    }

    record.forEach((v) => {
        const [state, id, nick] = v.split(' ');

        if(state !== "Change") {
            action.push([state, id]);
        }

        if(nick) {
            userInfo[id] = nick;
        }
    })

    return action.map(([state, uid]) => {
        return `${userInfo[uid]}${stateMapping[state]}`;    
    })
}

console.log(solution(["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]));