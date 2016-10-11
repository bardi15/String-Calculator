package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.hamcrest.Matcher;

public class CalculatorTest {

	public static void main(String args[]) 
	{
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testEmptyString() 
	{
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() 
	{
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testtwonumbers() 
	{
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers()
	{
    	assertEquals(6, Calculator.add("1,2,3"));
    }

	@Test
    public void testNewLineInsert()
	{
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

	@Test
    public void testFunkyNewLine()
	{
    	assertEquals(1, Calculator.add("1,\n"));
    }	
	
	@Test
    public void testNegative()
	{
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Negatives not allowed: -4,-5");
		
    	Calculator.add("-4,-5");
    }	
}