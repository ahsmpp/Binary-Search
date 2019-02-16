/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author anish
 */
public class SolutionB {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int key = input.nextInt();
        int array[] = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        System.out.println(findKey(array, key, 0));
    }

    //Assuming Array Size is Infinity
    public static String findKey(int array[], int key, int mid) {
        if(array[mid] == key) {
            return mid + 1 +"";
        }

        //Jump to the probable section where key may be found
        try {
            for(mid = 1; array[mid] < key; mid *= 2);
        } catch(ArrayIndexOutOfBoundsException e) {
            return endArray(array, key, mid);
        }

        return endArray(array, key, mid);
    }

    public static String endArray(int array[], int key, int mid) throws ArrayIndexOutOfBoundsException {
        int start = mid / 2 ;
        int end = mid;

        try {
            while(start <= end) { 
            mid = (end + start) / 2;
  
            //If the element is present at the middle 
            if (array[mid] == key) { 
                return mid + 1 + "";
            }

            //If element is smaller than mid
            if (array[mid] > key) { 
                end = mid - 1;
            } else { //Element is greater than mid
                start = mid + 1;
            }
        }
        } catch(ArrayIndexOutOfBoundsException e) {
            return endArray(array, key, mid - 1);
        }
        return "NOT_FOUND";
    }
}
/*
Input :
10 - This corresponds to the size of the array.
6 -  This corresponds to the key you are searching for
1 2 3 5 6 7 8 9 10 11 - These are the elements of the array
Output :
5 - Output should be the index at which the key is present. In this case, key 6 is present at index 5 of 1-INDEXED array. So the output is 5.
Input:
20
20
1 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21
Output :
19
*/
