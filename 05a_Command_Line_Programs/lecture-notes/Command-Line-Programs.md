<link rel="stylesheet" type="text/css" media="all" href="./styles/style.css" />

# Command-Line Programs - Lecture Notes
###### (05/08/2018)

## [**Overview of Session**](https://book.techelevator.com/v2_4/content/command-line-programs.html)

The programs we've written up until now have been self-contained, with all the data already specified in the program. But what if we want to interact with a user?

So how do we ask the user for information, turn that into data we can use and process and then send an answer back to the user for them to see?

## **Session Objectives:**

* Students should be able to use System.in/System.out/Console.ReadLine() to perform console I/O in a program
* Students should be able to correctly parse input from the input to primitive data types
* Students should be able to check for string equality
* Students should be able to split a string apart using known split character
* Students should be able to explain the process of a command-line application (Take input, calculate data, give output)
* Students should be able to run their command line apps in their IDE

## Classroom Preparation

* Think of a command-line application that you can build in the class.
    * Examples could be a program that takes three prices and a discount and tells you what the new prices are, or a program that takes three words and turns them into Pig Latin. You can start with this example right from the beginning of class.
    * The student-lecture code starts with the discount calculator example.
* Today is about reiterating this weeks major concepts, so feel free to throw in arrays and loops and if statements to help flesh that out.

## **Agenda and Timing for Session**

* [System.in / Console.ReadLine()](https://book.techelevator.com/v2_4/content/command-line-programs.html#standard-i-o) (0:20)
* [Parsing Strings](https://book.techelevator.com/v2_4/content/command-line-programs.html#parsing-strings) (0:10)
* String Equality (Java) (0:10)
* Splitting Strings (0:15)
* System.out / Console.WriteLine() (0:20)
* [A Fun Program!](https://book.techelevator.com/v2_4/content/command-line-programs.html#putting-it-together) (The rest of class)

## **Topic List w/Notes** <div class=topicNote>(and <span class='link'>links</span> to e-book section when available)</div>

### [Standard I/O](https://book.techelevator.com/v2_4/content/command-line-programs.html#standard-i-o)

### Reading from System.in / Console.ReadLine()

Often we may want to pause the execution of the program and wait for the user to provide input. Another approach to allowing user input is by using
`System.in` or `Console.ReadLine()`.

<div class="java note">

**Java:** System.in and System.out refer to the standard input and output streams. The System.in is the keyboard and the System.out is the monitor/terminal.

In Java for the class, we use `Scanner inputReader = new Scanner(System.in);` and then read lines from the Scanner object using `inputReader.nextLine()`.

**Caution**: Some enterprising student will decide that they can use `.nextInt()` or similar and then wonder why their code keeps acting up. `nextLine()` will remove a `\n` from the stream when it's done reading, but none of the other `next...()` methods will, which means that a subsequent call to a `next...()` method will hit that `\n` on reading input.

Quick solution: Always call `nextLine()` right after one of the other `next...()` methods so that the `\n` is gotten rid of.

</div>

<div class="csharp note">

**C#:** Console.ReadLine and Console.WriteLine are abstractions that exist to interact with the standard input/output stream.</div>

[Reading IntelliSense](https://book.techelevator.com/v2_4/content/command-line-programs.html#reading-the-intellisense)

<div class="note instructorDirective">

As you write your command-line application in the IDE, show how standard methods from the input and output streams show up in the IntelliSense and how important it is to use those as an initial attempt at figuring out what method to use.

</div>

### [Parsing Strings](https://book.techelevator.com/v2_4/content/command-line-programs.html#parsing-strings)

* What data type is the input from the command line? *Always Strings*
* How do we allow users to enter numbers, dates, times, decimals, etc.?

<div class="definition note">Computers <strong>parse</strong> input and look for symbols that follow an expected syntax or set of rules.</div><br/>

A parse method is available to Java and C# developers that is able to convert a string into the correct data type.

<div class="caution note">If the input string cannot resolve the input to the correct data type, then our program fails and display an error message to the user</div><br/>

Java:
``` java
Integer.parseInt(String s);
Long.parseLong(String s);
Double.parseDouble(String s);
Boolean.parseBoolean(String s);
```

C#:
``` csharp
int.Parse(string s);
bool.Parse(string s);
double.Parse(string s);
decimal.Parse(string s);
char.Parse(string s);
```

### Checking for String Equality (Java)

This concept is not covered in the book, but it is required in order to perform the individual and pair exercises for the day.

During the exercise, students will be asked to compare two strings for equality.

```java
String s1 = new String("HELLO");
String s1 = new String("HELLO");
System.out.println(s1 == s2);       // false
System.out.println(s1.equals(s2));  // true
```

**If the class has discussed reference types** by this point, you should explain the difference between `==` and `.equals()`. If not, then guide the students towards the usage of `.equals()`.

### Splitting Strings

This concept is not covered in the book, but it is required to perform the individual and pair exercises for the day.

Sometimes we want the user to provide multiple inputs (space/comma/tab separated). This information still arrives to our program in the form of a single string. Strings have a built-in method called `.split()` that enables a string to be divided up into an array of strings using a *delimiter character*.

## System.out / Console.WriteLine()

You can print back to the screen a message when your calculation is done. To do that, you'll use the standard output.

Java can use `System.out.println()` to print out a new line or `System.out.printf()` to print out a formatted String.

C# can use `Console.WriteLine()` to print out a new line. To format a string, you can use `string.Format()`, but string interpolation is much easier: `$"Original Price: {originalPrice}"`.
