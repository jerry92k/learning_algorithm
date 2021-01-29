/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {boolean}
 */
//var isPalindrome = function(head) {
var isPalindrome = function(head) {  
     let list = [];
      
     for (; head != null;){
         list.push(head.val);
         head = head.next;
     }
      
      if (list.length<=1) { // 한개일때는 true
        return true;
    }

    
    for (i = 0; i <= (list.length / 2) >> 0; i++){
        if (i > (list.length - 1 - i)) {
            break;
        }
        if (list[i] != list[list.length - 1 - i]) {            
            return false;
        }
    }
    return true;
  };
