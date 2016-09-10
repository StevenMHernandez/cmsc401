// Steven Hernandez.
// Assignment 1.

import java.io.*; // imported for testing
import java.util.*;

public class cmsc401 {

public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);

        // pass `file=true` to pull in data from a file instead of inputting the values by hand.
        if (args.length > 0 && args[0].equals("file=true")) {
                File file = new File("example_input.txt");
                in = new Scanner(file);
        }

        // First line contains value for how many more lines will be input.
        int size = in.nextInt();

        // set size of input array
        //             answer array
        //             global space array
        int[] W = new int[size];
        int[] A = new int[size];
        int[] G = new int[size];

        // pull in each line of data
        // set some data in the global space array
        for (int i = 0; i < size; i++) {
                W[i] = in.nextInt();
                G[i] = i + 1;
        }

        // go through each element from W backwards
        for (int i = size - 1; i >= 0; i--) {
                int times_to_go_back = W[i];
                int times_we_have_gone_back = 0;

                // the index of our answer
                int k = size - 1;

                while (times_to_go_back != times_we_have_gone_back || G[k] == -1) {
                        // move backwards through our global array
                        k--;

                        if (times_to_go_back != times_we_have_gone_back && G[k] != -1) {
                                times_we_have_gone_back++;
                        }
                }

                A[i] = G[k];

                // `USED` Sentinel
                G[k] = -1;
        }

        // all done, we can safely print out the answers now
        for (int a: A) {
                System.out.println(a);
        }

}
}
