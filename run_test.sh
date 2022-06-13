#!/bin/bash  
    
# Read the user input      
echo "Testing $1 "  

testClass="$1Test"
javac -cp ".:./test/lib/*"  ./test/$testClass.java
java -jar ./test/lib/junit-platform-console-standalone-1.9.0-M1.jar -cp ".:./test:./test/lib/system-lambda-1.2.1.jar:./test/lib/hamcrest-2.2.jar" -c $testClass