package week1.day1assignments;

public class Fibonacci {
	public static void main(String[] args) {
		int firstNum=0,secNum=1,sum,i;   
		 System.out.print(firstNum+" "+secNum);     
		 for(i=2;i<11;++i)    
		 {    
		  sum=firstNum+secNum;    
		  System.out.print(" "+sum);    
		  firstNum=secNum;    
		  secNum=sum;   
		  
		 }    
		  
		}
}
