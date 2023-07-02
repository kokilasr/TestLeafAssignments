package week1.week1day1assignments;

public class IsPrime {
	public static void main(String[] args) {
		int number = 9;	
		int flag = 0;
		for (int i = 2; i <= number-1; i++) {
			if (number ==2)
				System.out.println(number + " is prime");
			else
			if (number % i == 0)
			{
				flag = 1;
				break;
			}	
		}
		if (flag > 0)
		System.out.println(number + " is not prime");
		else
			System.out.println(number + " is prime");
		}
				
	}

