# Food Truck Project

## Description
This program is used to create an array of up to 5 food trucks. Each food truck is required to have a name, food service category, and rating. Each entry into the array is given a unique id.

With this program, we can output a list of all food trucks entered into the array, an average rating of the food trucks, and the highest rated food truck.

Each choice is provided a minimal amount of input error checking using while loops, but we haven't learned about exception handling so type mismatches on the inputs will break the program.

## Lessons Learned
This program enforced learning about static, private, and public keywords in Java. In particular, dealing with method calls in the Main method of the application. 

The biggest lesson learned from building this program was that methods make life much, much easier. You can encapsulate everything that you want to, and this program does than by making the 'runProgram' method the only public method of the FoodTruckApp file should it ever get modified to be used in a different application.

Another key thing was thinking of how I wanted to use constructors. This program has a noArg constructor,  but the intent is that it NEVER gets used outside of making a single FoodTruck object to manipulate the non-static methods and variables of the FoodTruck class. Every other time a food truck is created, it should have all arguments.

## Technologies Used
- Java
- Git