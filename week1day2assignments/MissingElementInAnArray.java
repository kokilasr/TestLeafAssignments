package week1.week1day2assignments;

import java.util.Arrays;

public class MissingElementInAnArray {
	public static void main(String[] args) {

		// Initialize array 
		int[] numberarr ={1,2,3,4,7,6,8};

		//Sort the array
		Arrays.sort(numberarr);

		for (int i = 0; i < numberarr.length; i++)
		{
			//Compare the next element in an array is an 1 increment of current element
			if (numberarr[i+1] == numberarr[i]+1)
				continue;
			else
			{
				System.out.println(numberarr[i]+1);
				break;
			}

		}
	}

}
