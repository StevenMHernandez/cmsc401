// Steven Hernandez.
// Assignment 2.

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
        int[] input = new int[size];

        // pull in each line of data
        // set some data in the global space array
        for (int i = 0; i < size; i++) {
                input[i] = in.nextInt();
        }

        // start actual processing here
        int median = getk(input, 0, input.length - 1, (int)(input.length - 1)/2);

        System.out.print(median);
}

public static int getk(int[] list, int a, int b, int k) {
        list = swap(list, k, b);

        int v = a;
        for (int i = a; i < b; i++) {
                if (list[i] < list[b]) {
                        list = swap(list, v, i);
                        v++;
                }
        }

        list = swap(list, v, b);

        if (v == k || (v == a && list[v] == list[k])) {
                return list[k];
        } else if (v < k) {
                return getk(list, v, b, k);
        } else { // (v > k)
                return getk(list, a, v - 1, k);
        }
}

public static int[] swap(int[] list, int c, int d) {
        int t = list[c];
        list[c] = list[d];
        list[d] = t;

        return list;
}
}
