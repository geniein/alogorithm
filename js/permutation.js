function solution(numbers) {
    var answer = 0;
    var list = [];
    list = permutation(numbers).map((v)=> v.join(''))
    console.log(list);
    //console.log(permu(numbers));
    //console.log(isPrime(permutation(numbers)));
    return answer;
}

function permutation(arr){
    let count =  0;
    return arr.reduce((list, value)=>{
        let newlist =[];        
        console.log(count++);
        console.log("list :" + list + " value : " + value);
        list.forEach(element => {
            for(let i = element.length; i >=0;i--){
                console.log("element :" + element);
                let newElement = [].concat(element);
                newElement.splice(i,0,value);
                console.log("newElement : "+newElement);
                newlist.push(newElement);
            }
        });
        return newlist;
    }, [[]]);    
}
function isPrime(list){
    let intList =list.map((v=>v*1));

    for(let i = 0; i < intList.length; i++){
        if(intList[i] === 1){
            intList[i] = 0;
            continue;
        }
        for(let j = 2; j <intList[i]; i++){
            if(intList[i]%j === 0 ){
                intList[i] = 0;
            }
        }
    }
    return intList;
}

solution([1,2,3]);