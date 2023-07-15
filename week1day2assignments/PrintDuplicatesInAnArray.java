package week1.week1day2assignments;

import java.util.Arrays;

public class PrintDuplicatesInAnArray {
public static void main(String[] args) {
	
	int num[] = {14,12,13,11,15,14,18,16,17,19,18,17,20};
	//int[] num = {1,3,1,4,3};
	Arrays.sort(num);
	for (int i=0; i<num.length-1; i++)
	{
		if(num[i]==num[i+1])
		{
			System.out.println(num[i]);
		}
		else
			continue;
	}
		
}
}
