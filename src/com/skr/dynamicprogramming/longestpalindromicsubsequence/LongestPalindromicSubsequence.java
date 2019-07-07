package com.skr.dynamicprogramming.longestpalindromicsubsequence;

import java.util.Arrays;

public class LongestPalindromicSubsequence {

    public static int longestPalindromicSubsequence(String string){

        int[][] table = new int[string.length()][string.length()];
        int j;
        for (int i=0;i<string.length();i++)
            table[i][i] = 1;

        for (int s = 2; s<=string.length();s++){
            for (int i=0; i<string.length()-s+1; i++){
              j = i+s-1;
              if(string.charAt(i) == string.charAt(j) && s == 2)
                  table[i][j] = + 2;
              else if(string.charAt(i) == string.charAt(j))
                  table[i][j] = table[i+1][j-1] + 2;
              else
                  table[i][j] = Math.max(table[i+1][j], table[i][j-1]);
            }
        }

        System.out.println(Arrays.deepToString(table));

        return table[0][string.length()-1];
    }
    public static void main(String[] args) {

        String s = "abbaab";
        System.out.println("Longest  palindromic subsequuence is " + longestPalindromicSubsequence(s));
    }
}
