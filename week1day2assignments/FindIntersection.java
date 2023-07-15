package week1.week1day2assignments;

public class FindIntersection {
public static void main(String[] args) {
	int[] array1 = {3,2,10,4,6,7};
	int[] array2 = {1,2,8,4,9,7};
	int k =0;
	for (int i=0; i <array1.length; i++ )
	{
		for (int j=0; j<array2.length; j++)
		{
			if (array1[i] == array2[j])
			{
				array1[k] = array1[i];
				System.out.println(array1[k]);
				k++;
				break;
			}
			else
				continue;
			
		}
	}
	
	
}
}
