/**
 * Every And Then Some
 * 
 * Arrays also come with the standard methods every and some. Both take a
 * predicate function that, when called with an array element as argument,
 * returns true or false. Just like && returns a true value only when the
 * expressions on both sides are true, every returns true only when the
 * predicate returns true for all elements of the array. Similarly, some returns
 * true as soon as the predicate returns true for any of the elements. They do
 * not process more elements than necessary—for example, if some finds that the
 * predicate holds for the first element of the array, it will not look at the
 * values after that.
 * 
 * Write two functions, every and some, that behave like these methods, except
 * that they take the array as their first argument rather than being a method.
 * 
 * console.log(every([NaN, NaN, NaN], isNaN));
 * // → true
 * 
 * console.log(every([NaN, NaN, 4], isNaN));
 * // → false
 * 
 * console.log(some([NaN, 3, 4], isNaN));
 * // → true
 * 
 * console.log(some([2, 3, 4], isNaN));
 * // → false
 */

function every(array, functionCall) {
    var isEvery = false;
    
    for(var index = 0; index < array.length; index++) {
        isEvery = functionCall(array[index]);
        
        if(!isEvery) {
            break;
        }
    }
    
    return isEvery;
}

function some(array, functionCall) {
    var isSome = false;
    
    for(var index = 0; index < array.length; index++) {
        isSome = functionCall(array[index]);
        
        if(isSome) {
            break;
        }
    }
    
    return isSome;
}

var firstExample = [NaN, NaN, NaN];
var secondExample = [NaN, NaN, 4];
var thirdExample = [NaN, 3, 4];
var fourthExample = [2, 3, 4];

print("Calling the `every' function on the " + firstExample + " array: " + every(firstExample, isNaN));
print("Calling the `every' function on the " + secondExample + " array: " + every(secondExample, isNaN));
print("Calling the `some' function on the " + thirdExample + " array: " + some(thirdExample, isNaN));
print("Calling the `some' function on the " + fourthExample + " array: " + some(fourthExample, isNaN));
