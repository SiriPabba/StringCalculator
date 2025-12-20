StringCalculator

Description
StringCalculator is a Java practice project that calculates the sum of numbers provided in a string.
It supports default delimiters (comma , and newline \n), custom single-character delimiters, and handles negative numbers by throwing exceptions.
This project demonstrates Java string parsing, exception handling, and unit testing skills.

Features
Returns 0 for an empty string
Adds single or multiple numbers
Supports newline and custom delimiters
Throws exception for negative numbers with a message showing the negatives

Example Usage
StringCalculator.add("");           // returns 0
StringCalculator.add("1");          // returns 1
StringCalculator.add("1,2,3");      // returns 6
StringCalculator.add("1\n2,3");     // returns 6
StringCalculator.add("//;\n1;2");   // returns 3
StringCalculator.add("1,-2,3");     // throws IllegalArgumentException: negative numbers not allowed -2

Technologies Used
Java 11
JUnit 5 for unit testing

How to Run
Clone the repository:
git clone https://github.com/SiriPabba/StringCalculator.git


Navigate to the project folder:
cd StringCalculator


Compile the code:
javac -d out src/main/java/com/yourname/stringcalculator/StringCalculator.java


Run tests via your IDE or using JUnit 5
Running Tests
This project uses JUnit 5.
Run tests through your IDE (IntelliJ, Eclipse, etc.) or via Maven.

Author

Shireesha Pabba
https://github.com/SiriPabba
