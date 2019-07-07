package com.skr.dynamicprogramming.leastcommmonsequence;

import java.util.Arrays;

//Longest Subsequence from the given two string
public class LCS1 {

    //Time Complexity of this implementation is O(mn)
    private static int lengthOfLongestCommonSequence(String X, String Y){

        int[][] table = new int[X.length() + 1][Y.length()+1];

        char[] x = X.toCharArray(), y = Y.toCharArray();

        Arrays.sort(x);
        Arrays.sort(y);

        for (int i=0; i<=x.length;i++){
            for (int j=0; j<=y.length;j++){
                if (i == 0 || j== 0){
                    table[i][j] = 0;
                }else if (x[i-1] == y[j-1]){
                    table[i][j] = 1 + table[i-1][j-1];
                }else {
                    table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
                }
            }
        }


        /*for (int i=0; i<=x.length;i++) {
            for (int j = 0; j <= x.length; j++) {
                System.out.print(table[i][j]);
            }
            System.out.println("");
        }*/


        return table[x.length][y.length];
    }

    public static void main(String[] args) {
        /*
                LCS 1
        */
        //String x = "abaaba", y = "babbab";
        String x = "AGGTAB", y = "GXTXAYB";
        System.out.println("LCS: " + lengthOfLongestCommonSequence(x,y));

    }
}
