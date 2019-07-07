package com.skr.dynamicprogramming.subset;

import java.util.Arrays;

public class Subset {
    private static boolean subsetSumPossible(int[] set, int sum){
        int[][] table = new int[set.length+1][sum+1];
        for (int i=1; i<=set.length; i++){
            for(int s=0; s<=sum; s++){

                if (s==0){
                    table[i][s] = 1;
                }
                else if(s < set[i-1]){
                    table[i][s] = table[i-1][s];
                }
                else if(s == set[i-1]){
                    table[i][s] = 1;
                }
                else if(table[i-1][s] == 1){
                    table[i][s] = 1;
                }else{
                    table[i][s] = table[i-1][s - set[i-1]];
                }
            }
        }

        System.out.println(Arrays.deepToString(table));
        if (table[set.length-1][sum] == 1) return true;
        else if (table[set.length-1][sum] == 0) return false;
        else return false;
    }
    public static void main(String[] args) {
        // write your code here

        int[] set = {3, 34, 4, 12, 5, 2}; //{2, 3, 5, 7, 10};
        int sum = 100; //14;
        if (subsetSumPossible(set, sum)){
            System.out.println("Subset is possibile");
        }else {
            System.out.println("Subset is not possibile");
        }
    }
}
