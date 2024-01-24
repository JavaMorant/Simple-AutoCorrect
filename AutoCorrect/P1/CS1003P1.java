import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.*;

public class CS1003P1 {

  private static final String FILEPATH = "./words_alpha.txt";

  public static void main(String[] args) {
    //Goes through string variable separating each word/arg where a space appears
    for (String arg: args) {
      StringTokenizer userInput = new StringTokenizer(arg.toLowerCase(), " ");
      while (userInput.hasMoreTokens()) {
        CheckSpelling(userInput.nextToken());
      }
    }

    System.out.println();
  }

  //This will check if word is in dictionary. If not, then autocorrect
  private static void CheckSpelling(String wordToCheck) {

    List < String > words = new ArrayList < > ();

    //Read each line within the file and save to list
    try {
      words = Files.readAllLines(Paths.get(FILEPATH));
    } catch (IOException e) {
      e.printStackTrace();
    }

    for (String word: words) {

      //If word has been found
      if (word.equals(wordToCheck)) {
        System.out.print(wordToCheck + " ");
        return;
      }
    }

    //If word is not found, then autocorrect.
    Set < String > bigramForWrongWord = bigramCalculator(wordToCheck);

    //Create list to hold coefficients
    List < Double > coefficientList = new ArrayList < > ();

    //Loop through every word in dictionary to create bigrams and calculate coeff.
    for (String word: words) {

      //Forming bigram
      Set < String > bigramForDictionaryWord = bigramCalculator(word);

      //Performing calculation of coefficient.
      double currentCoefficient = DiceCoefficient(bigramForWrongWord, bigramForDictionaryWord);
      coefficientList.add(currentCoefficient);
    }

    //Find largest coefficient in list and return associated word.
    double largestCoefficient = Collections.max(coefficientList);
    int indexOfLargest = coefficientList.indexOf(largestCoefficient);

    System.out.print(words.get(indexOfLargest) + " ");
  }

  private static Set < String > bigramCalculator(String userInput) {

    //Top and tail
    userInput = "^" + userInput + "$";

    //Loop for string and create bigram pairs, add to list.
    Set < String > bigramSet = new HashSet < > ();
    for (int i = 0; i < userInput.length() - 1; i++) {
      char char1 = userInput.charAt(i);
      char char2 = userInput.charAt(i + 1);

      String bigram = char1 + "" + char2;
      bigramSet.add(bigram);
    }

    return bigramSet;
  }

  //Calculate and return dice coefficient for two words
  private static double DiceCoefficient(Set < String > bigramSet1, Set < String > bigramSet2) {
    Set < String > intersection = new HashSet < > (bigramSet1);
    intersection.retainAll(bigramSet2);

    double coefficient = ((double) 2 * intersection.size()) / ((double) bigramSet1.size() + (double) bigramSet2.size());
    return coefficient;
  }
}