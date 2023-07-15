package week1.week1day2assignments;

public class Palindrome {
	public static void main(String[] args) {
		
		int num = 34343;
		int temp = num;
		int reverse = 0;
		for(;num!=0;)
		{
			int reminder = num % 10;
			reverse = reverse *10 + reminder;
			num = num / 10;
		}
		if(temp == reverse)
			System.out.println("The number is palindrome");
		else
			System.out.println("The number is not palindrome");
	}

}
