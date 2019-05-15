import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;

/** Using an array here is not doable unless I already know how many words my file contain
 * Since an array cannot be expanded, but an arrayList and a LinkedList can

 * I still can create an array with the size of my arrayList after adding the text file work by word
 * However, it's just gonna be more work to do... no point of doing this
 *
 * HINT HINT: the input file taken from the following like
 * https://ebooks.adelaide.edu.au/l/lamb/charles/tales-from-shakespeare/chapter19.html
 *
 *  ¯\_(ツ)_/¯ Shakespeare tales are awesome, GIVE IT A SHOT in your free time  ¯\_(ツ)_/¯
 */

public class printDemo {

    public static void main(String[] args) {

        String words;
        ArrayList<String> wordList = new ArrayList<>();



        // TODO: Read from my input file

        // TODO: Split the file into words, save them in an ArrayList

        // TODO: Try and Catch for error handling


        try {
            // Use Scanner object to read from my file
            Scanner fileInput = new Scanner(new File("TalesFromShakespeare Othello.txt"));
            while (fileInput.hasNext()) // check for next string
            {
                // save the next string into the following variable
                words = fileInput.next();

                // if you're gonna uncomment the next print statement, COMMENT THE LAST FOR LOOP
                // .... works the same
                //System.out.println(words);


                // TODO: Handle the unwanted characters


                String noCommas = words.replace(",", "");
                String noColon = noCommas.replace(":", "");
                String noSemiColons = noColon.replace(";", "");
                String noFullStop = noSemiColons.replace(".", "");
                String noLeftBracket = noFullStop.replace("(", "");
                String noRightBracket = noLeftBracket.replace(")", "");
                String word = noRightBracket;


                // if you're gonna uncomment the following print statement, COMMENT THE LAST FOR LOOP
                //System.out.println(word);

                // add the new string to the list
                wordList.add(word);

            }
            fileInput.close();
        }

        catch (FileNotFoundException exc) {
            System.out.println("IDIOT, you screwed up (•̀o•́)ง");
            System.out.println("In other words, there was a problem opening the input file");
        }


        // print the list of words we have
		for (String each_word: wordList) {
			System.out.println(each_word);
		}


        // TODO: Write to a file output.txt

		// write to a file
        try {
            PrintWriter outputFile = new PrintWriter(new FileWriter("output.txt"));

            // print each word
            for (String x : wordList) {
                outputFile.println(x);
            }


            outputFile.close();
        } catch (Exception exc) {
            System.out.println("There was a problem opening the output file.");
        }




    }
}
