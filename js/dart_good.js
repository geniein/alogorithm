function solution(dartResult) {
    const bonus = {'S': 1, 'D': 2, 'T': 3};
    let darts = dartResult.match(/\d.\D?/g);
    var startTime = new Date().getTime();
    console.log(darts);

    for (let i = 0; i < darts.length; i++) {
        let split = darts[i].match(/(\d{1,})([SDT])([*#])?/),
            score = Math.pow(split[1], bonus[split[2]]);

        if (split[3] !== undefined) {
            if (split[3] === '*') {
                score *= 2;

                if (i > 0) darts[i - 1] *= 2;
            } else score *= -1;
        }

        darts[i] = score;
    }
    var endTime = new Date().getTime();
    console.log(startTime);
    console.log(endTime);
    console.log((endTime - startTime)/1000);
    return darts.reduce((a,b)=>a+b);
}





/*function solution(dartResult) {
    var startTime = new Date().getTime();
    //console.log(startTime);
    const bonus = { 'S': 1, 'D': 2, 'T': 3 },
          options = { '*': 2, '#': -1, undefined: 1 };

    let darts = dartResult.match(/\d.?\D/g);

    for (let i = 0; i < darts.length; i++) {
        let split = darts[i].match(/(^\d{1,})(S|D|T)(\*|#)?/),
            score = Math.pow(split[1], bonus[split[2]]) * options[split[3]];

        if (split[3] === '*' && darts[i - 1]) darts[i - 1] *= options['*'];

        darts[i] = score;
    }
    var endTime = new Date().getTime();
    console.log(startTime);
    console.log(endTime);
    console.log((endTime - startTime)/1000);
    return darts.reduce((a, b) => a + b);
}*/

console.log(solution('1S2D*3T'));