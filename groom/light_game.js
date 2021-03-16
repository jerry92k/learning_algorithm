// Run by Node.js

const readline = require("readline");
const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

let count = 1;
let rowLen = 0;
let colLen = 0;

let matrix = [];
rl.on("line", function (line) {
    if (count == 1) {
        const arr = line.split(' ');
        rowLen = Number(arr[0]);
        colLen = Number(arr[1]);
    } // 가로, 세로 길이 입력
    else if (count > 1 && count <= (1 + rowLen)) {
			// console.log(`count : ${count} , rowLen : ${rowLen}`);
        // console.log(line);
        matrix.push(line.split(' '));
    } // input matrix 입력
    else if (count == 2 + rowLen) {
        // console.log(matrix);
        // 명렁어 몇개 나올건지 알려줌
    } else if(count > 2+rowLen) {
        const arr = line.split(' ');
        const firstNum = Number(arr[0]);
        const secondNum = Number(arr[1]);
   
        if (firstNum== 0) { // 가로 변환
            for (let j = 0; j < colLen; j++){

                // console.log(`garo secondNum -1 : ${secondNum - 1}, j: ${j}`);
                matrix[secondNum - 1][j] = matrix[secondNum - 1][j] == '0' ? '1' : '0';
            }
        } else if(firstNum==1) { // 세로 변환
            for (let i = 0; i < rowLen; i++){

                // console.log(`sero secondNum -1 : ${secondNum - 1}, i: ${i}`);
                matrix[i][secondNum-1] = matrix[i][secondNum-1] == '0' ? '1' : '0';
            }
        }
    }
    count++;
}).on("close", function () {
    // console.log(matrix);
    for (let i = 0; i < matrix.length; i++){
        // console.log(matrix[i].join(' '));
        for (j = 0; j < matrix[0].length; j++){
            if (j == 0) {
                process.stdout.writer(` ${matrix[i][j]}`);
            } else {
                process.stdout.writer(matrix[i][j]);
            }
            
        }
        if (i != matrix.length - 1) {
            console.log();
        }
    }
    rl.close();
	process.exit();
});