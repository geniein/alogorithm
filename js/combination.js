let COUNT = 0;
function combination(list, arr, idx, n, r, target){
    console.log("list :" + list);
    console.log("arr :" + arr);
    console.log("idx :" + idx);
    console.log("n :" + n);
    console.log("r :" + r);
    console.log("target :" + target);
    console.log("COUNT :" + COUNT+ "\n");
    COUNT++;
    if (r===0){
        list.push(Object.assign([], arr));
    }else if (target === n){
        return ;
    }else{
        arr[idx] = target;
        combination(list, arr, idx + 1, n, r - 1, target + 1);
        combination(list, arr, idx, n, r, target + 1);
    }

}


let list = [1,2,3];
let combList = [];
let arr = [];

for(let idx =0; idx<=list.length;idx++){
    combination(combList, arr, 0, list.length, idx, 0);
}

combination(combList, arr, 0, 3, 3, 0);

console.log(combList);
console.log(combList.length);
