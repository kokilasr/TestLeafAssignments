package week1.week1day2assignments;

import java.util.Arrays;

public class FindSecondLargest {
public static void main(String[] args) {
	int[] num = {3,2,11,4,6,7};
	Arrays.sort(num);
	System.out.println("The second largest in the array is " + num[num.length-2]);
}
}
