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
		if (number.length() == 0 || Integer.parseInt(number) > 1000)
		{
			return 0;
		}
		return Integer.parseInt(number);
	}
	
	public static String[] SplitNumbers(String numbers)
	{
		ArrayList<String> l1 = new ArrayList<String>();
		String query = ",|\\n";
		if (numbers.startsWith("//"))
		{
			numbers = numbers.substring(2, numbers.length());
			for (int x = 0; x < numbers.length(); x++)
			{
				if (Character.isDigit(numbers.charAt(x)))
				{
					break;
				}
				else
				{
					l1.add(String.valueOf(numbers.charAt(x)));
				}
			}
			
			
			for (int i = 0; i < l1.size(); i++)
			{
				query += "|" + l1.get(i);
			}
			
		}

		String[] s = numbers.split(query);
		
		return s;
	}
	
	public static boolean CheckNegative (int numbers)
	{
		if (numbers < 0)
		{
			return true;
		}
		
		return false;
	}
	
}