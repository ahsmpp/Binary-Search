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
public class SolutionA {
    static int key = -1;
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int array[] = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        if(findMatch(array) > 0) {
            System.out.println(key + 1);
        } else {
            System.out.println("Match not found");
        }
    }
    
    public static int findMatch(int array[]) {
        int start = 0;
        int end = array.length - 1;

        //Start Binary Search
        while(start <= end) {
            int mid = (end + start) / 2;

            //Finding the 1st array[n] = n --> n starts from 1
            if(array[mid] == mid + 1) {
                key = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return key + 1;
    }
}
/*
Sample Input:
5
0 1 3 4 5
Sample Output:
3
Sample Input:
7
0 1 2 4 5 6 7
Sample Output:
4
*/
