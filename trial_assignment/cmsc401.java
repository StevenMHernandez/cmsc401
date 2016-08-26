// Steven Hernandez.
// Trial Assignment.

import java.io.*; // imported for testing
import java.util.*;

public class cmsc401 {

public static void main(String[] args) throws FileNotFoundException {
        // array containing the answers for each line
        int[] answers;

        // Array containing the values for the current line
        int[] current_line;

        Scanner in = new Scanner(System.in);

        // pass `file=true` to pull in data from a file instead of inputting the values by hand.
        if (args.length > 0 && args[0].equals("file=true")) {
                File file = new File("example_input.txt");
                in = new Scanner(file);
        }

        // First line contains value for how many more lines will be input.
        int lines = in.nextInt();

        // set size of answers array
        answers = new int[lines];

        // pull each line of data
        for (int l = 0; l < lines; l++) {
                // first number contains how many integers remain on the line
                current_line = new int[in.nextInt()];

                // get each of those integers (except the last two)
                for (int i = 1; i <= current_line.length - 2; i++) {
                        current_line[i] = in.nextInt();
                }

                // get the last two integers on the line
                int a = in.nextInt();
                int b = in.nextInt();

                // use them as indexes to calculate the sum
                answers[l] = current_line[a] + current_line[b];
        }

        // all done, we can safely print out the answers now
        for (int a: answers) {
                System.out.println(a);
        }

}
}
