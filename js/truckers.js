function solution(bridge_length, weight, truck_weights) {
    var answer = 0;    
    var onBridge = [];
    var finished = [];
    var onBridgeSum = 0;    
    while(truck_weights.length){        
        onBridgeSum = waiting(weight,truck_weights,onBridge,onBridgeSum);
        
        if(onBridge.length > 0){  
            
            if(onBridge[0][1] === bridge_length){
                let value = onBridge.shift()
                finished.push(value);                
                onBridgeSum -= value[0];                
                if(truck_weights.length > 0){
                    onBridgeSum = waiting(weight,truck_weights,onBridge,onBridgeSum);
                    onBridge.map((v,i)=> v[1]+=1);
                }                
            } else {
                onBridge.map((v,i)=> v[1]+=1);                
            }            
        }        
        answer += 1;
    }    
    return answer;
}

function waiting(weight,truck_weights,onBridge,onBridgeSum){
    let next = truck_weights.shift();    
    if((onBridgeSum + next) <= weight){
        onBridge.push([next,0]);        
        onBridgeSum += next;        
    } else{
        truck_weights.unshift(next);
    }
    return onBridgeSum;      
}


solution(2,10,[7,4,5,6]);

//solution(100,100,[10, 10, 10]);