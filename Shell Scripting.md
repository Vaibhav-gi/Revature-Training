What is Shell Scripting?

A shell script is a text file containing a series of Linux/Unix commands 
that are executed sequentially.


Why use Shell Scripts?



Automate repetitive tasks



System administration



File handling



Backup and monitoring



DevOps \& CI/CD automation



Types of Shells

Shell	Command
Bourne Shell	sh
Bash (Most common)	bash
C Shell	csh
Z Shell	zsh



We will use Bash.



Creating Your First Shell Script

Step 1: Create file

touch hello.sh



Step 2: Add Shebang

\#!/bin/bash



Step 3: Add commands

echo "Hello World"


Step 4: Give execute permission

chmod +x hello.sh



Step 5: Run script

./hello.sh



Shell Script Structure

\#!/bin/bash

\# This is a comment



echo "Script started"



Variables in Shell Script

5.1 Declare Variable

name="Manisha"

age=25








5.2 Use Variable

echo "Name is $name"

echo "Age is $age"



5.3 Read Input from User

echo "Enter your name:"

read username

echo "Welcome $username"



Command Line Arguments

\#!/bin/bash

echo "First argument: $1"

echo "Second argument: $2"

echo "Total arguments: $#"

echo "All arguments: $@"





Run:



./script.sh Java Linux



Operators

7.1 Arithmetic Operators

a=10

b=5

sum=$((a+b))

echo "Sum = $sum"



7.2 Relational Operators

Operator	Meaning

-eq			equal

-ne			not equal

-gt			greater than

-lt			less than

-ge			greater or equal

-le			less or equal



Example:



if \[ $a -gt $b ]

then

   echo "a is greater"

fi



Conditional Statements

8.1 if Statement

if \[ $age -ge 18 ]

then

 echo "Eligible to vote"

else

 echo "Not eligible"

fi



8.2 if-elif-else

marks=75



if \[ $marks -ge 90 ]

then

 echo "Grade A"

elif \[ $marks -ge 60 ]

then

 echo "Grade B"

else

 echo "Grade C"

fi



Loops

9.1 for Loop

for i in 1 2 3 4 5

do

 echo "Number $i"

done



9.2 while Loop

count=1

while \[ $count -le 5 ]

do

 echo "Count $count"

 count=$((count+1))

done



9.3 until Loop

num=1

until \[ $num -gt 5 ]

do

 echo $num

 num=$((num+1))

done



Functions

greet() {

 echo "Hello $1"

}



greet Manisha



File Handling

11.1 Check if File Exists

if \[ -f "data.txt" ]

then

 echo "File exists"

else

 echo "File not found"

fi



11.2 Check Directory

if \[ -d "/home" ]

then

 echo "Directory exists"

fi



Case Statement

read choice



case $choice in

 1) echo "Start" ;;

 2) echo "Stop" ;;

 3) echo "Restart" ;;

 \*) echo "Invalid option" ;;

esac



Special Variables

Variable	Meaning

$0		Script name

$1..$9	Arguments

$#		Argument count

$?		Exit status

$$		Process ID



Exit Status

ls file.txt

echo $?





0 → success

Non-zero → failure



Practical Mini Scripts

Script 1: Backup Script

\#!/bin/bash

tar -czf backup.tar.gz /home/user/docs

echo "Backup completed"



Script 2: Check Disk Usage

df -h | grep "/dev"



Script 3: Number Even or Odd

read num



if \[ $((num % 2)) -eq 0 ]

then

 echo "Even"

else

 echo "Odd"

fi



Practice Exercises


1. Script to print numbers 1 to 10
   
2. Script to find largest of 3 numbers
   
3. Script to create files using loop
   
4. Script to check service running or not



**Interview Questions**
**Difference between sh and bash?**

**What is shebang?**

**Difference between $@ and $\*?**

**How to debug a shell script?**

**What is exit status?**

