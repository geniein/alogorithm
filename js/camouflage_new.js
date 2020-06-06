function solution(clothes) {
    return Object.values(clothes.reduce((a, b)=> { 
        console.log(a+"--"+b+"--"+a[b[1]]+"--"+b[1]);       
        a[b[1]] = a[b[1]] ? a[b[1]] + 1 : 1;
        console.log(a);
        return a;
    } , {})).reduce((a,b)=> a*(b+1), 1)-1;    
}

console.log(solution([['yellow_hat', 'headgear'],['blue_sunglasses', 'eyewear'], ['green_turban', 'headgear']]));