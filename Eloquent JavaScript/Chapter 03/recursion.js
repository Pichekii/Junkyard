/**
 * Recursion
 * 
 * We’ve seen that % (the remainder operator) can be used to test whether a
 * number is even or odd by using % 2 to check whether it’s divisible by two.
 * Here’s another way to define whether a positive whole number is even or odd:
 *      Zero is even.
 *      One is odd.
 *      For any other number N, its evenness is the same as N - 2.
 * 
 * Define a recursive function isEven corresponding to this description. The
 * function should accept a number parameter and return a Boolean.
 * 
 * Test it on 50 and 75. See how it behaves on -1. Why?
 * Can you think of a way to fix this?
 * 
 * console.log(isEven(50));
 * // → true
 * 
 * console.log(isEven(75));
 * // → false
 * 
 * console.log(isEven(-1));
 * // → ??
 */

function isEven(value) {

    if(value < 0) {
        return Number.NaN;
    }

    if(value === 0) {
        return true;
    } else if(value === 1) {
        return false;
    } else {
        return isEven(value - 2)
    }
}

print("Is 50 even? " + isEven(50));
print("Is 75 even? " + isEven(75));
print("Is -1 even? " + isEven(-1));
