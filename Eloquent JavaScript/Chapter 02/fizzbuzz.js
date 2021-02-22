/**
 * FizzBuzz
 * 
 * Write a program that uses console.log to print all the numbers from 1 to 100,
 * with two exceptions. For numbers divisible by 3, print "Fizz" instead of the
 * number, and for numbers divisible by 5 (and not 3), print "Buzz" instead.
 * 
 * When you have that working, modify your program to print "FizzBuzz" for
 * numbers that are divisible by both 3 and 5.
 * 
 * (This is actually an interview question that has been claimed to weed out a
 * significant percentage of programmer candidates. So if you solved it, you’re
 * now allowed to feel good about yourself.)
 */

for(var index = 1; index <= 100; index++) {
    if(((index % 3) === 0) && ((index % 5) === 0)) {
        print("FizzBuzz");
    } else if((index % 3) === 0) {
        print("Fizz");
    } else if((index % 5) === 0) {
        print("Buzz")
    } else {
        print(index);
    }
}
