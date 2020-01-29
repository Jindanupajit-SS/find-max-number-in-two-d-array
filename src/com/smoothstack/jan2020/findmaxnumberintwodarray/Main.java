package com.smoothstack.jan2020.findmaxnumberintwodarray;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // Generate the int Array
        int[][] intArray;
        try { // We do not need to catch this, just make sure x and y values are not 0
            intArray = IntegerUtils.generateTwoDimensionArrayOfRandomInt(3,2, Integer.MAX_VALUE);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return;
        }
        System.out.printf("intArray[x][y] = %s\n\n", Arrays.deepToString(intArray));

        // Index and Sort
	    int[][] indexedAndSorted = IntegerUtils.indexAndSortIntArray(intArray);
        System.out.printf("indexedAndSorted[N][3] = %s\n\n", Arrays.deepToString(indexedAndSorted));

        /*
            We try to find the MAX value in the 2D array,
            BUT the value could occur at more than one location (same value)
            We have to capture all of it.

            First we index the array (save the location with the value)
            Then we sort it by the value

         */

        // nothing greater than 0 in intArray, initialize max to 0
        int max = 0;

        // point i at the last element of indexedAndSorted
        // This should point to the max value (since it was sorted)
        // We will use i later, then we have to initialize i outside of for loop
	    int i = indexedAndSorted.length - 1;

	    // Find the break point where the value is dropped
	    for (  ; i >= 0; i--) {
	        if (max > indexedAndSorted[i][/*value*/ 0]) {
	            i++;
	            break;
            }
	        max = indexedAndSorted[i][/*value*/ 0];
	    }

	    // If we did not find the break point (i = -1), then the break point is at the beginning of indexedAndSorted
	    if (i < 0) i = 0;

        System.out.printf("Max value is %d.\n", max);

        // From the break point until the end of array, it should contain location of all max value
        for (int j = i; j < indexedAndSorted.length; j++) {
            System.out.printf(" ... at intArray[%d][%d]\n",
                    indexedAndSorted[j][/*x*/ 1], indexedAndSorted[j][/*y*/ 2]);

        }


    }
}
