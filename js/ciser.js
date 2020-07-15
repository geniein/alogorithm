function solution(s, n) {
    var answer = '';
    let alphaList = 'abcdefghijklnmopqrstuvwxyz';
    let alphaListCap = 'ABCDEFGHIJKLNMOPQRSTUVWXYZ';
    
    s.split("").map((c,i) => {
      if(c ===' '){
        return answer += c;
      }
      let codes = c.charCodeAt(0);
      answer += codes > 64 && codes < 91 ? alphaListCap[(codes - 65 +n) % 26] : alphaList[ (codes - 97 + n ) % 26]
    });
    
    return answer;
}

console.log(solution("A Z a z", 1)); //FGH

