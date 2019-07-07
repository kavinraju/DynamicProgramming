package com.skr.dynamicprogramming.subsequence;

import java.util.Arrays;

public class MaximumProductSubsequence {

    public static int maximumProductOfSubsequence(int[] array, int k){

        Arrays.sort(array);

        int product = 1;
        int len = array.length;

        //Case 1 - array[] = {-4, -3, -2, -1, 0}
        if ( array[len-1] == 0 && k%2 != 0 )
            return 0;

        //Case 2 - array[] = {-5, -4, -3, -2, -1}
        if ( array[len-1] <= 0 && k%2 != 0) {
            for (int i = len - 1; i >= len - k; i--) {
                product *= array[i];
            }
            return product;
        }

        int i =0;
        int j = len-1;

        //Case 3 - {1, 2, 3, 4, 5}
        if (k%2 != 0){
            product *= array[j];
            j--;
            k--;
        }

        //Case 4 -  {1, 2, 3, 4, 5, 6} or { 1, 2, -1, -3, -6, 4 }
        k /=2; // or k>>=1

        for (int itr =0; itr<k; itr++){

            int leftProduct = array[i] * array[i+1];
            int rigtProduct = array[j] * array[j-1];

            if(leftProduct > rigtProduct){
                product *= leftProduct;
                i += 2;
            }else {
                product *= rigtProduct;
                j -= 2;
            }
        }
        return product;
    }

    public static void main(String[] args){
        int[] array =  {1, 2, 3, 4, 5}; // Declaring int array[] = {}; is c model. In Java we include [] before variable
        int k = 3;
        System.out.println(maximumProductOfSubsequence(array, k));
    }
}
