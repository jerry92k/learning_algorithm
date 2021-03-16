// Run by Node.js

const readline = require("readline");
const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});


let count = 1;
let leftArray = [];
let rightArray = [];
let leftLen = 0;
let rightLen = 0;
rl.on("line", function (line) {
    if (count == 1) {
        const arr = line.split(' ');
        leftLen = Number(arr[0]);
        rightLen = Number(arr[1]);
    }
    else if (count == 2) {
        leftArray = line.split(' ');
    }
    else if (count == 3) {
        rightArray = line.split(' ');
    }
    count++;

}).on("close", function () {
    
    let i = 0;
    let j = 0;
    let concatArray = [];

    while (i < leftLen && j < rightLen) {
        // console.log(`leftArray[i] : ${leftArray[i]}, 
        //     rightArray[j] : ${rightArray[j]}`)
        if (leftArray[i] <= rightArray[j]) {
            concatArray.push(leftArray[i++]);
            // process.stdout.writer(leftArray[i++]);
        } else {
            // process.stdout.writer(rightArray[j++]);
            concatArray.push(rightArray[j++]);
        }
    }

    while (i < leftLen) {
        // process.stdout.writer(leftArray[i++]);
            concatArray.push(leftArray[i++]);
    }
    while (j < rightLen) {
        // process.stdout.writer(rightArray[j++]);
            concatArray.push(rightArray[j++]);
    }
    console.log(concatArray.join(' ')+'');
    	rl.close();
	process.exit();
});