package com.skr.dynamicprogramming.leastcommmonsequence;

import java.util.Arrays;

//Longest Subsequence with at least one common digit in every element
public class LCS2 {

    public int lengthOfLCSWithAtleastOneCommonDigit(int[] num){

        int count[] = new int[10];
        for (int value : num) {
            int ones = value % 10;
            int tens = value / 10;
            if (ones == tens) {
                count[ones] += 1;
            } else {
                count[ones]++;
                count[tens]++;
            }
        }

        LCSWithAtleastOneCommonDigit(num, count);
        Arrays.sort(count);
        return count[count.length-1];
    }

    public void LCSWithAtleastOneCommonDigit(int[] num, int[] count){
        int max = Integer.MIN_VALUE, maxIndex = -1;

        for (int i=0; i<count.length; i++){
            if (count[i] > max){
                max = count[i];
                maxIndex = i;
            }
        }

        System.out.println("LCS with common integer are: ");
        for (int value : num) {
            int ones = value % 10;
            int tens = value / 10;
            if (ones == maxIndex || tens == maxIndex) {
               System.out.print(value + " ");
            }
        }

        System.out.println("");

    }

    public static void main(String[] args) {
        LCS2 lcs2 = new LCS2();
        int[] ar = {12, 11, 13, 24, 23,42};
        System.out.println("Maximum value in count array is " + lcs2.lengthOfLCSWithAtleastOneCommonDigit(ar));

    }
}
