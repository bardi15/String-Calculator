public class stringcalculator 
{
	static int Add(String numbers)
	{
		if (numbers.equals(""))
		{
			return 0;
		}
		String[] data = numbers.split(",");
		int num = 0;
		for (int k = 0; k < data.length; k++)
		{
			num += Integer.parseInt(data[k]);
		}
		System.out.println((num));
		return num;
	}
}
