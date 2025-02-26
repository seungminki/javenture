#!/bin/bash

fileName="*"
mainClassName="Main"

rm -rf bin && mkdir -p bin

javac -d bin src/main/${fileName}.java src/main/enums/*.java && java -cp bin main.${mainClassName}