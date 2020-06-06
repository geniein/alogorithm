    function solution(bridge_length, weight, truck_weights) {
    var answer = 0;
    let sum = 0;
    let bridge =Array(bridge_length).fill(0);
    let truck = truck_weights.shift();

    sum += truck;
    bridge.unshift(truck);
    bridge.pop();

    answer++;

    while(sum){        
        sum -= bridge.pop();
        truck = truck_weights.shift();
        if(truck+sum<=weight){
            bridge.unshift(truck);
            sum+=truck;
        }
        else{
            bridge.unshift(0);
            truck_weights.unshift(truck);
        }
        answer++;      
    }

    console.log(answer);

    return answer;
}



solution(2,10,[7,4,5,6]);

solution(100,100,[10]);