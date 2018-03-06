package com.oliulka.oop.arrays;

import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class sortUserInputArray 
{
	private static Scanner myscanner = new Scanner(System.in);
	
	public static void main (String args[]){
		int[] array = createArray(5);
		sortArray(array);
		
	}
	
	public static int[] createArray(int number)
	{
		System.out.println("Enter " + number + " integer numbers to create an array");
		int[] valuesArray = new int[number];
		for (int i=0; i<valuesArray.length; i++){
			valuesArray[i] = myscanner.nextInt();
		}
		return valuesArray;
		
	}
	
	public static int [] sortArray(int[] valuesArray)
	{
		int origilarArrayLength = valuesArray.length;
		int[] sortedValuesArray = new int[origilarArrayLength];

		for(int i=0; i<origilarArrayLength; i++)
		{
			Arrays.sort(valuesArray);
		}
		
		for(int a=0; a<sortedValuesArray.length; a++)
		{
			System.out.println(a+" array values is " + valuesArray[a]);
		}	
		
		return valuesArray;		
	}
	
	
}
