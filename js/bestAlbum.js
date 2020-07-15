function solution(genres, plays) {
    var answer = [];
    let totalMap = new Map(); 
    let totalObj = genres.reduce(((acc,v,i) =>{
        if(!acc[v]){
            acc[v] = plays[i];
        }else{
            acc[v] = acc[v] + plays[i];
        }
        return acc;
    }),{});
    let totalList = [...Object.values(totalObj)].sort((x,y) => y - x)

    
    for(let item of totalList){
        let key = Object.keys(totalObj).find(key => totalObj[key] === item);
        let arr=[];
        arr.length = genres.length;
        arr.fill(0);
        for(let i=0;i<arr.length;i++){
          if(genres[i] === key){arr[i]=plays[i]}
        }
        totalMap.set(key,arr); // 순서를 보장해주는 데이터 타입이면서 Hash형태인 Map
      }
      for (let [key,value] of totalMap){
        const arr = [...value].sort((a,b) => b - a);
        for(let item of arr){
          console.log(arr);
          console.log(arr.indexOf(item));
          if(item === 0 || arr.indexOf(item) === 2){break}
          else {
            answer.push(value.indexOf(item));            
            value[value.indexOf(item)] = null;
            console.log(value);
          }
        }
      }
      
    return answer;
}

solution(["classic", "pop", "classic", "classic", "pop","classic"], [500, 600, 150, 800, 2500,100]);

