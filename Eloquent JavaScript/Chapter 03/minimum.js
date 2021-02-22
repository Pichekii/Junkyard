/**
 * Minimum
 * 
 * The previous chapter introduced the standard function Math.min that returns
 * its smallest argument. We can do that ourselves now. Write a function min
 * that takes two arguments and returns their minimum.
 * 
 * console.log(min(0, 10));
 * // → 0
 * 
 * console.log(min(0, -10));
 * // → -10
 */

function minimum(valueOne, valueTwo) {
    if(valueOne < valueTwo)
        return valueOne;
    else
        return valueTwo;
}

print(minimum(0, 10));
print(minimum(0, -10));
