package com.skr.dynamicprogramming.knapsnack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapsnackDiscrete {

    public static int maximumProfit(int[] weights, int[] profits, int maximumWeigth){

        int[][] table = new int[weights.length + 1][maximumWeigth + 1];

        //Sort the weight & -> profits according to weight using Insertion Sort
        for(int i=1; i<weights.length; i++){

            int newElement = weights[i];
            int oldProfit = profits[i];

            int j;

            for(j = i; j > 0 && weights[j-1] > newElement; j--){
                weights[j] =  weights[j-1];
                profits[j] = profits[j-1];
            }
            weights[j] = newElement;
            profits[j] = oldProfit;
        }

        System.out.println(Arrays.toString(weights));
        System.out.println(Arrays.toString(profits));

        // Finding maximum profit
        for(int i=0; i<=weights.length; i++){
            for (int w=0; w<=maximumWeigth; w++){
                if (i==0 || w==0){
                    table[i][w] =0;
                }else if(w< weights[i-1]){
                    table[i][w] = table[i-1][w];
                }else{
                    table[i][w] = Math.max( profits[i-1]+ table[i-1][w-weights[i-1]], table[i-1][w]);
                }
            }
        }

        //
        System.out.println("Weigths: " + findOptimalWeigth(table, maximumWeigth, weights, profits));

        return table[weights.length][maximumWeigth];
    }

    public static List<Integer> findOptimalWeigth(int [][] table, int maximumWeigth, int[] weights, int[] profits){


        List<Integer> optimalWeigths = new ArrayList<>();

        int w1 =-1;
        int w;
        boolean foundDiffValue = false;
        for(int i=weights.length; i>0; i--) {

            if (foundDiffValue)
                w =w1;
            else
                w = maximumWeigth;

            for (; w >= 0;) {
                if (table[i][w] != table[i-1][w]){
                    System.out.println("Weigth: " + weights[i-1]);
                    optimalWeigths.add(weights[i-1]);
                    int profitDiff = table[i][w] - profits[i-1];
                    if (profitDiff == 0){
                        break;
                    }


                    foundDiffValue = false;
                    while(table[i-1][w] != profitDiff){
                        w--;
                        if (table[i-1][w] == profitDiff){
                            foundDiffValue =true;
                            w1 = w;
                            i--;
                            break;
                        }
                    }

                }else {
                    i--;
                }
            }
        }

        return optimalWeigths;
    }
    public static void main(String[] args) {
        // write your code here
        int weigths[] = {3,4,4,6};
        int profits[] = {2,3,1,4};
        int maximumWeigth = 12;

        System.out.println("Maximum Profit: " + maximumProfit(weigths, profits, maximumWeigth));

    }
}
