# Ada

Ada is a high-level programming language designed from 1977 to 1983 to replace over 450 programming languages that the US Department of Defense was using at the time, eventually becoming the mandated programming language within the DoD. Based on Pascal, the language has been called "the greatest design effort in programming history" due to the six years it took to establish requirements and develop the language. Ada is known for being extremely strongly-typed, and this attributes to the language's safety and reliability features that has credited Ada with being mostly used in "safety-critical" systems. The language is named after the first computer programmer, Ada Lovelace.

## History

In 1975, a United States led group going by the name of the High Order Language Working Group was formed. The purpose of the group was to create a single high level programming language for the US Department of Defense to use, as the DoD had over 450 programming languages in use across all their projects. The High Order Language Working Group sourced knowledge from international experts and academics in order to: (1) evaluate requirements for a language, (2) compare those requirements to existing languages, and then (3) recommend languages that fulfill those requirements.[2] The designers highest priorities were reliability, maintainability, and efficiency. The DoD produced five documents detailing the language requirements, in chronological order: Strawman, Woodenman, Tinman, Ironman, and Steelman. Ada, named after Ada Lovelace, would be proposed as a new language to cover the requirements as detailed in the Steelman document. As the DoD was a primary designer, Ada was was designed to handle very large software programs, packages, and modules betweens them[4]. Ada's first implementation was delayed due to the difficulty in writing a compiler for the language, which amusingly echoes the theme of Ada as being the "largest design effort in history".[6]

Ada would be an incredibly widespread programming language throughout the 1980s and well into the 1990s. It would be both praised and ridiculed by computer science and software engineering professionals worldwide; it was hard to escape its influence[5]. Pascal, one of the languages influencers and a monumental language itself, would become influenced by Ada itself. It's likely that without Ada's existence, the world of software would be a few years behind where it is today. Even though it was an extremely popular, if not the most popular, programming language in the 1980s, it would eventually be dethroned by C and C++ in 1986. In 1991, the US Department of Defense would choose to mandate Ada for all DoD software; however, projects were often granted exceptions for this mandate[3], and the preeminence of Ada would continue to dwindle. Unsurprisingly, in 1997, the DoD reversed the Ada mandate.

Although it's popularity has waned, Ada is still widely used in any program where reliability is incredibly important, such as the military, air traffic control, and banking industries[3]. These types of systems are called "safety-critical", and they are where Ada is best used today.

## Features

Ada is a strongly-typed, statically-typed, object-oriented, and imperative programming language heavily influenced by Pascal. As it is strongly-typed, it's important to be able to create derived, composite, and user defined types as appropriate. However, there are some native data types such as `Integer`, `Natural`, `Positive`, `Float`, `Character`, `String`, `Access` (pointers), `Array`, etc. The language supports control flow structures such as `if`, `elsif`, `else`, `switch`, `while`, and `for` (range-based only). Concurrency is built into the language as task units and rendezvousing allows for buffer control.

Over the years, there have been four major Ada versions. The name of each version refers to the year in which it was released.

- Ada 83: First implementation of Ada; the first for packages for data encapsulation, generic program units, and concurrency via rendezvous method[6].
- Ada 95: Allowed for inheritance, dynamic dispatch, and polymorphism. Data sharing between concurrent threads is improved.
- Ada 2005: Multiple inheritance and improved synchronization tools once again.
- Ada 2012: Contract-based programming, expression functions, and container enhancements introduced. Synchronization tools continue to be improved.

AdaCore lists the main features of Ada as[1]:

- Extensive compile-time and run-time checks
- Full Object Oriented Programming support
- Concurrent programming features, including support for multicore
- Generic templates
- Encapsulation
- Hierarchical program composition / programming-in-the-large
- Specialized support for systems programming and real-time systems
- Contract-based programming

These features aren't surprising as the first two features were part of the Steelman specification. The design of Ada was meant to make it as critical-safe as possible, and it succeeds in this goal. The other features would come as programming demands change over time. A perk of Ada that keeps it relevant today is that it has great compatibility with C and C++. C functions can be used within Ada programs, or a developer can write code in Ada then use automated tools such as [Ada-C/C++ Changer](https://www.mapusoft.com/convert-ada-to-c/) that convert Ada programs directly. This means that any C or C++ compiler instantly becomes an Ada compiler, as well.

As a result of being based on Pascal, the language is incredibly English readable/writeable. It reflects the "largest design effort in history" of a programming language and its reliability design that Ada has high orthogonality: it is predictable, with few side effects, and its constructs can be mixed nearly freely (view the example on user defined functions). The levels of abstraction of Ada is the same as someone could expect from any object-oriented programming language; that is, all a software engineer needs to know to use an object or function is to provide the appropriate input to receive some expected output -- they don't need to know what happens on the inside. Ada is sometimes thought to be slow, as it once was; however, the most popular Ada compiler today is GCC which is the same compiler used for C. One can expect that the same language constructs of the two languages will have the same performance. Unfortunately, Ada's diminishing popularity means that there aren't as very many resources available today as there would be for another language. Pre-defined libraries are hard to find, and documentation is focused more on reading ADS files rather than published documents.

## Examples

Some examples of Ada in use may help you get a better understanding of the language. You can follow along by going to [this online compiler](https://www.tutorialspoint.com/compile_ada_online.php); note, you will have to enter input before execution in the STDIN tab, not during runtime as you may be used to with other programming languages.

### Hello World

Making parallels to C++, `with` allows a programmer to import modules similar to `#import` and `use` allows for namescope aliases in the same manner as `using`. If you didn't include the `use`, you would have to prepend `Put_Line()` as `Ada.Text_IO.Put_Line()`

```ada
with Ada.Text_IO; use Ada.Text_IO;

procedure Hello is
begin
    Put_Line("Hello, world!");
end Hello;
```

or

```ada
with Ada.Text_IO;

procedure Hello is
begin
    Ada.Text_IO.Put_Line("Hello, world!");
end Hello;
```

### Variables

Variables must be initialized before the code block begins. The assignment operator is := for Ada. The `Get` function allows for user input into a variable.

```ada
with Gnat.Io; use Gnat.Io;
procedure CalculateTax is
    Wage, Hours, Earnings: Integer;
    TaxRate: Integer := 20;
begin
    Put("Enter the employee's hourly wage: ");
    Get(Wage);
    Put(Wage); -- Gnat.Io doesn't play well with online compilers, this shows input
    New_Line;

    Put("Enter the employee's number of hours this pay period: ");
    Get(Hours);
    Put(Wage); -- Gnat.Io doesn't play well with online compilers, this shows input
    New_Line;

    Earnings := Wage*Hours;

    Put("The employee's earnings before tax is: ");
    Put(Earnings);
    New_Line;

    Put("The employee's tax payment is: ");
    Put(Earnings * TaxRate / 100);
    New_Line;
end CalculateTax;
```

### Arrays & For Loops

Here we create an array to hold 10 numbers (calculated factorials). Then we use a range based `for` loop to calculate then output the data.

```ada
with Gnat.Io; use Gnat.Io;
procedure Factorial is
    FactArray: array(1..10) of Integer;
begin
    FactArray(1) := 1;
    for Index in 2..10 loop
        FactArray(Index) := Index * FactArray(Index - 1);
    end loop;

    for Index in 1..10 loop
        Put(FactArray(Index));
        Put(' ');
    end loop;
end Factorial;
```

### User Defined Functions & Sorting

User defined functions, called `procedures` are defined before the begin block of the main procedure. The syntax of control statements such as `if` and comparisons work as an experienced programmer would expect.

However, in order to pass an array to a procedure, you must define your own type first (line 4). As well, you have to specify if the parameter of the function is input, output, or both. As well, arrays can be initialized as they are declared (line 20).

```ada
with Gnat.Io; use Gnat.Io;

procedure Main is
    type Integer_array is Array (Natural range <>) of Integer;
    
    procedure Sort (A: in out Integer_array) is
        Temp : Integer;
    begin
        for Index in reverse A'Range loop
            for Jndex in A'First .. Index loop
                if A(Index) < A(Jndex) then
                    Temp := A(Index);
                    A(Index) := A(Jndex);
                    A(Jndex) := Temp;
                end if;
            end loop;
        end loop;
    end Sort;

    SortArray: Integer_array := (7, 3, 1, 8, 5);
begin
    Sort(SortArray);
    for Index in SortArray'Range loop
        Put(SortArray(Index));
        Put(' ');
    end loop;
end Main;
```

## Further Reading

1. [About Ada - AdaCore](https://www.adacore.com/about-ada)
2. [Ada - The Project, The DoD High Order Language Working Group by William A. Whitaker](http://archive.adaic.com/pol-hist/history/holwg-93/holwg-93.htm)
3. [Ada (programming language), Wikipedia](https://en.wikipedia.org/wiki/Ada_(programming_language))
4. [DEPARTMENT OF DEFENSE REQUIREMENTS FOR HIGH ORDER COMPUTER PROGRAMMING LANGUAGES "STEELMAN"](https://dwheeler.com/steelman/steelman.htm)
5. [The rise, fall and persistence of Ada](https://dl.acm.org/action/showLogin?redirectUri=/doi/abs/10.1145/1879097.1879081)
6. Sebesta, Robert. Concepts of Programming Languages. Chapter 2.