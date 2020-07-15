function permutation(a){
	return a.reduce((list, elemnet) => {
	let valueList = [];
	console.log(list);
	list.forEach((v)=>{		
		for(let i =v.length; i>=0; i--){
			let value = [].concat(v);
			console.log('value : '+ value + '  elemnet : '+elemnet);
			value.splice(i,0,elemnet);
			valueList.push(value);
		}		
	});
	console.log("valueList : "+ valueList);
	return valueList;
	},[[]]);
}

console.log(permutation([1,2,3]));



var list = [1,2,3];

let value =list.reduce((a,b) => {
	console.log("a : " + a + "  b : "+ b);
	return a+b
},0);
console.log(value);


/*
	return a.reduce(
    (list, element) => {
      var newlist = [];
      console.log(list);
      list.forEach((seq) => {
        for (var i = seq.length; i >= 0; i--) {
          var newseq = [].concat(seq);
          newseq.splice(i, 0, element);
          newlist.push(newseq);
        }
      });
      return newlist;
    },
    [[]]
  );
  */

/*
  return a.reduce((list, elemnet) => {
	let valueList = [];
	console.log(list);
	list.forEach((v)=>{		
		for(let i =v.length; i>=0; i--){
			let value = [].concat(v);
			value.splice(i,0,elemnet);
			valueList.push(value);
		}
		return valueList;
	});
	},[[]]);*/