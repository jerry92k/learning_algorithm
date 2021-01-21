/**
 * @param {number} n
 * @return {string[]}
 */
var fizzBuzz = function(n) {
    let list = [];
    for (let i = 1; i <= n; i++){
        let word = '';
        if (i % 3 == 0) // multiple of three : Fizz
        {
            word = 'Fizz';
        }

        if (i % 5 == 0) {
            word = word + 'Buzz';
        }

        if (word == '') {
            word = `${i}`;
        }
        list.push(word);
    }
    return list;
};