class Solution {
    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        int reverseNumber = 0;
        int originNumber = x;
        while (x > 0) {
            int rest = x % 10;
            x = x / 10;

            reverseNumber = reverseNumber * 10 + rest;
        }

        if (originNumber == reverseNumber) {
            return true;
        }
        return false;

    }
}