package Recitation_9_14_21;

import java.io.*; 
import java.util.*;
import java.util.Scanner;

import jdk.jshell.spi.ExecutionControl.NotImplementedException;
public class twosum_week3{
    public static void main(String[] args){
        //code to read in input
        int length; 
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of elements you want to store: "); 

        //reading the number of elements from the that we want to enter  
        length=s.nextInt();  

        int[] intArray = new int[length]; 

        System.out.println("Enter the elements of the array: ");  
        for(int i=0; i<length; i++)  
        {  
            //reading array elements from the user   
            intArray[i]=s.nextInt();  
        }  

        System.out.println("Enter the target: "); 
        int target = s.nextInt(); 

        //running the method 
        int[] output = TwoSum(intArray, target); 

        System.out.println(output[0]);
        System.out.println(output[1]);  

        if(intArray[output[0]-1] + intArray[output[1]-1] == target){
            System.out.println("Success!");
        }
        else{
            System.out.println("ERROR! Elements at indices of output array do not match the target sum.");
        }
    }

    public static int[] TwoSum(int[] numbers, int target) {
        // Not implemented for now.
        return null;
    }
}








