package is.ru.stringcalculator;

public class Calculator 
{

	public static int add(String numbers)
	{
		if (numbers.equals(""))
		{
			return 0;
		}
		if ( numbers.contains((",")) )
		{
			String[] data = SplitNumbers(numbers);
			int num = 0;
			for (int k = 0; k < data.length; k++)
			{
				num += ParseToInt(data[k]);
			}
			return num;
		}
		else
		{
			return ParseToInt(numbers);
		}

	}
	
	
	public static int ParseToInt(String number)
	{
		return Integer.parseInt(number);
	}
	
	public static String[] SplitNumbers(String numbers)
	{
		return numbers.split(",|\\n");
	}



}