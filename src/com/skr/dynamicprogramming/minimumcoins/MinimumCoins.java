package com.skr.dynamicprogramming.minimumcoins;

import java.util.Arrays;

import static java.lang.Math.min;

public class MinimumCoins {
    public static int minimumCoin(int[] coins, int totalAmount){

        int[][] coinDistribution = new int[coins.length][totalAmount+1];

        for (int i=0;i<coins.length; i++){
            coinDistribution[i][0] = 0;
        }

        for(int i=0; i<coins.length;i++){

            for (int j=0; j<=totalAmount;j++){
                if (i == 0){
                    coinDistribution[i][j] = j;
                }else if (coins[i] > j){
                    //System.out.println("3" + i +":" +  j);
                    coinDistribution[i][j] = coinDistribution[i-1][j];
                }else {
                    coinDistribution[i][j] = min(coinDistribution[i-1][j],  1 + coinDistribution[i][j-coins[i]]);
                }
            }
        }
        System.out.println(Arrays.deepToString(coinDistribution));
        return coinDistribution[coins.length-1][totalAmount];
    }
    public static void main(String[] args) {

        int[] a = {1,5,4,2,4,8};
        System.out.println(minimumCoin(a,11));
    }
}
