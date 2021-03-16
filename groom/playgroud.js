// Run by Node.js
const readline = require('readline');

(async () => {
    let rl = readline.createInterface({ input: process.stdin });

    let square = [];
    let count = 1;
    let m = 0;
    let k = 0;
	for await (const line of rl) {
        let arr;
        if (count == 1) {
            
        }
        else if (count == 2) {
            arr = line.split(' '); //공백으로 split
            m = Number(arr[0]);
            k = Number(arr[1]);     
        }
        else {
            arr = line.split(' ');
            square.push(arr);
            if (count == (2 + Number(m))) {
                count = 1;
                console.log(minTrash(square, m, k));
                square = [];
            }
        }
        count++;
        
	
	}
		rl.close();
	process.exit();
})();
function minTrash(sqaure, m, k) {

    let minNum = k * k;
    for (let i = 0; i <= m-k; i++){
        for (let j = 0; j <= m - k; j++){
            let count = 0;
            for (let t = i; t < i+k; t++){
                for (let q = j; q < j+k; q++){
                    //  console.log(`t : ${t}, j: ${j}, k: ${k}, j+k: ${j+k},  q: ${q}`);
                    //  console.log(`sqaure[t][q] : ${sqaure[t][q]}`);
                    if (sqaure[t][q] == '1') {
                        count++;
                    }

                }
            }
            if (minNum > count) {
                // console.log(`i : ${i}, j: ${j}`);
                minNum = count;
            }
        }
    }
    return minNum;
}