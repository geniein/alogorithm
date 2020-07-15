function solution(values){
    let list = Object.assign(values);
    let text = ['님이 들어왔습니다.','님이 나갔습니다.'];
    let set = [];
    let answer = "";
    
    list.map((v)=> {
        let [status, uid, nickname] = v.split(" ");        
        switch(status){
            case "Enter":
                if(!nickname){
                    set[uid]=nickname;
                }
            case "Change":
                set[uid] = nickname;
        }        
    });
    answer = values.map((v)=> {
        let [status, uid ] = v.split(" ");     
        switch(status){
            case "Enter":            
                return set[uid]+text[0];            
            case "Leave":
                return set[uid]+text[1];
        }        
    });
    return answer;
}
//님이 들어왔습니다.
//님이 나갔습니다.

console.log(solution(["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]));