# Spell Checker and Autocorrect

This Java program performs spell checking and autocorrection on user input. It compares the input words against a dictionary file (`words_alpha.txt`) and suggests the most similar word from the dictionary if a word is not found.

## Features

- Tokenizes user input into individual words
- Checks each word against the dictionary file
- If a word is not found in the dictionary, it suggests the most similar word using the Dice coefficient
- Prints the corrected words to the console
- Includes a bash script for easy compilation and execution

## Requirements

- Java Development Kit (JDK) installed
- `words_alpha.txt` dictionary file in the same directory as the Java file

## Usage

### Using the Bash Script

1. Save the provided bash script to a file with a `.sh` extension (e.g., `run_spell_checker.sh`).

2. Make the script executable by running the following command in the terminal:
    chmod +x run_spell_checker.sh

3. Place the `CS1003P1.java` file and the `words_alpha.txt` dictionary file in the same directory as the bash script.

4. Run the script by executing the following command in the terminal:
    ./run_spell_checker.sh

The script will compile the Java file, prompt you to enter the words to check, and then execute the program with the provided input.

### Manual Compilation and Execution

1. Compile the Java file:
    javac CS1003P1.java

2. Run the program with the desired input words as command-line arguments:
    java CS1003P1 "input words here"

Example: 
    java CS1003P1 "helo wrld"

Output:
    hello world

## Implementation Details

The program follows these steps:

1. It tokenizes the user input into individual words using `StringTokenizer`.
2. For each word, it checks if the word exists in the dictionary file (`words_alpha.txt`).
- If the word is found, it is printed as is.
- If the word is not found, it proceeds to the autocorrection step.
3. For autocorrection, it calculates the bigrams of the incorrect word and each word in the dictionary.
4. It computes the Dice coefficient between the bigrams of the incorrect word and each dictionary word.
5. The dictionary word with the highest Dice coefficient is considered the most similar word and is printed as the corrected word.

The program uses the following helper methods:

- `CheckSpelling(String wordToCheck)`: Checks if a word exists in the dictionary and performs autocorrection if necessary.
- `bigramCalculator(String userInput)`: Calculates the bigrams of a given word.
- `DiceCoefficient(Set<String> bigramSet1, Set<String> bigramSet2)`: Computes the Dice coefficient between two sets of bigrams.

## Dictionary File

The program relies on a dictionary file named `words_alpha.txt` to perform spell checking and autocorrection. Make sure this file is present in the same directory as the Java file.

The dictionary file should contain one word per line, with all words in lowercase.

## Bash Script

The provided bash script automates the compilation and execution of the Java program. It performs the following steps:

1. Compiles the Java file using the `javac` command.
2. Checks if the compilation was successful.
3. Checks if the dictionary file exists.
4. Prompts the user to enter the words to check.
5. Executes the Java program with the user input.

## Limitations

- The program assumes that the dictionary file is named `words_alpha.txt` and is located in the same directory as the Java file.
- The accuracy of the autocorrection depends on the quality and comprehensiveness of the dictionary file.
- The program may not handle certain edge cases or highly misspelled words effectively.
