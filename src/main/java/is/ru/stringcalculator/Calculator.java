package is.ru.stringcalculator;

import java.util.ArrayList;


public class Calculator 
{

	public static int add(String numbers) throws IllegalArgumentException
	{
		if (numbers.equals(""))
		{
			return 0;
		}

		String[] data = SplitNumbers(numbers);
		//int [] negativeList = new int [data.length];
		String negativeString = "";
		ArrayList<Integer> negNums = new ArrayList<Integer>();
		int sum = 0;
		for (int k = 0; k < data.length; k++)
		{
			int currNum = ParseToInt(data[k]);
			
			if (currNum < 0)
			{
				negNums.add(currNum);
			}
			else
			{
				sum = sum + currNum;
			}
		}
		
		if (negNums.size() > 0)
		{
			throw new IllegalArgumentException("Negatives not allowed: " + CreateNegativeString(negNums));
		}
		
		return sum;

	}

	public static String CreateNegativeString(ArrayList<Integer> negNums)
	{
		String negString = "";
		for (int i = 0; i < negNums.size() - 1; i++)
		{
			negString += negNums.get(i) + ",";
		}
		
		negString += negNums.get(negNums.size() - 1);
		
		return negString;
		
	}
	
	public static int ParseToInt(String number)
	{
		return Integer.parseInt(number);
	}
	
	public static String[] SplitNumbers(String numbers)
	{
		return numbers.split(",|\\n");
	}
	
	public static boolean CheckNegative (int numbers)
	{
		if (numbers < 0)
		{
			System.out.println("ITS NEGATIVE");
			return true;
		}
		
		return false;
	}
}