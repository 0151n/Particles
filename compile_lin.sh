#!/bin/bash
echo --creating bin directory--
mkdir bin
echo --compiling contents of /src--
javac -cp .:lib/* src/*/*.java -d bin

