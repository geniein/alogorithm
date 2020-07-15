let checkUsed = [];
var result = 0;
var answer = 0;

function findWord(begin, target, words, answer, checkUsed) {
  if (begin === target) {

    if (result === 0 || result > answer) result = answer;
  }
  for (var i = 0; i < words.length; i++) {
    var diff = 0;
    for (var j = 0; j < words[i].length; j++) {
      if (begin[j] !== words[i][j]) {
        diff++;
      }
    }
    let check = 0;
    for (var k = 0; k < answer; k++) {        
      if (checkUsed[k] === words[i]) {
        check = 1;
      }
    }   
    console.log(`${diff} // ${begin} // ${words[i]} // ${answer} // ${checkUsed}`); 
    if (diff === 1 && check === 0) {
        
      checkUsed.push(words[i]);
      findWord(words[i], target, words, answer + 1, checkUsed);
    }
  }
}

function solution(begin, target, words) {  
  findWord(begin, target, words, answer, checkUsed);
  return result;
}

// test code
var words1 = ["hot", "dot", "dog", "lot", "log", "cog"];
var words2 = ["hot", "dot", "dog", "lot", "log"];

console.log(solution("hit", "cog", words1)); // 4
//console.log(solution("hit", "cog", words2)); // 0