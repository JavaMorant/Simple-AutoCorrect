#!/bin/bash

# Set the Java file name
JAVA_FILE="CS1003P1.java"

# Set the dictionary file path
DICTIONARY_FILE="./words_alpha.txt"

# Compile the Java file
javac "$JAVA_FILE"

# Check if the compilation was successful
if [ $? -eq 0 ]; then
    echo "Compilation successful."
else
    echo "Compilation failed. Please check the Java file for errors."
    exit 1
fi

# Check if the dictionary file exists
if [ ! -f "$DICTIONARY_FILE" ]; then
    echo "Dictionary file not found. Please make sure '$DICTIONARY_FILE' exists."
    exit 1
fi

# Run the program with user input
echo "Enter the words to check (separated by spaces):"
read -r user_input

# Execute the Java program with user input
java CS1003P1 "$user_input"