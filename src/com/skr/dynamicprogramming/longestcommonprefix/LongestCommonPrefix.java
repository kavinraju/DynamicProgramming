package com.skr.dynamicprogramming.longestcommonprefix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] arrayStrings) {

        if(arrayStrings.length == 0)
            return "No string available";

        //Sort the array so that it's easy to find the common prefix
        Arrays.sort(arrayStrings);

        for (String arrayString : arrayStrings) {
            System.out.println(arrayString);
        }

        StringBuffer commonPrefix = new StringBuffer();

        char[] firstString = arrayStrings[0].toCharArray();
        char[] lastString = arrayStrings[arrayStrings.length-1].toCharArray();

        System.out.println("firstString: " + Arrays.toString(firstString));
        System.out.println("lastString: " + Arrays.toString(lastString));

        for(int i=0;i<firstString.length;i++) {

            if(firstString[i] == lastString[i])
                commonPrefix.append(firstString[i]);
            else
                break;

        }

        if(commonPrefix.length() > 0)
            return  commonPrefix.toString();

        return "No Common Prefix available";


    }

    public static void main (String[] args) {
        
        String[] inputStrings = null;

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int size = Integer.parseInt(br.readLine());
            inputStrings = new String[size];

            String values = br.readLine();
            String[] strs = values.trim().split("\\s+");

            for (int j = 0; j < size; j++) {
                inputStrings[j] = strs[j];
            }

            String commonPrefix = LongestCommonPrefix.longestCommonPrefix(inputStrings);
            System.out.println(commonPrefix);

        } catch (IOException e) {

            System.err.println("Error: " + e);

        } catch (NumberFormatException e) {

            System.err.println("Invalid number");

        }
    }
}


