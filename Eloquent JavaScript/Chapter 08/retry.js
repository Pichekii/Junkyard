/**
 * Retry
 * 
 * Say you have a function primitiveMultiply that, in 50 percent of cases,
 * multiplies two numbers and in the other 50 percent raises an exception of
 * type MultiplicatorUnitFailure. Write a function that wraps this clunky
 * function and just keeps trying until a call succeeds, returning the result.
 * 
 * Make sure you handle only the exceptions you are trying to handle.
 * 
 * console.log(reliableMultiply(8, 8));
 * // → 64
 */

function MultiplicatorUnitFailure() {
    
}

function primitiveMultiply(a, b) {
    if (Math.random() < 0.5)
        return a * b;
    else
        throw new MultiplicatorUnitFailure();
}

function reliableMultiply(a, b) {
    try {
        return primitiveMultiply(a, b);
    } catch(ex) {
        return reliableMultiply(a, b);
    }
}

print("The product of (8, 8) is: " + reliableMultiply(8, 8));
