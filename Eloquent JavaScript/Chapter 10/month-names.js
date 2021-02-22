/**
 * Month Names
 * 
 * Write a simple module similar to the weekDay module that can convert month
 * numbers (zero-based, as in the Date type) to names and can convert names back
 * to numbers. Give it its own namespace since it will need an internal array of
 * month names, and use plain JavaScript, without any module loader system.
 * 
 * console.log(month.name(2));
 * // → March
 * 
 * console.log(month.number("November"));
 * // → 10
 */

var month = function() {
    var months = ["January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"];
    
    return {
        name:
                function(number) {
                    return months[number];
                },
        number:
                function(name) {
                    return months.indexOf(name);
                }
    };
}();

var exampleNumber = 2;
var exampleName = "November";

print("The name for the number " + exampleNumber + " is: " + month.name(exampleNumber));
print("The number for the name " + exampleName + " is: " + month.number(exampleName));
