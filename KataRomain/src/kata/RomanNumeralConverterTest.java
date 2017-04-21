package kata;

import static org.junit.Assert.*;

import org.junit.*;

public class RomanNumeralConverterTest {
	
	private RomanNumeralConverter _romanNumeralConverter;
	
	@Before
	public void setUp()
	{
		_romanNumeralConverter = new RomanNumeralConverter();
	}
	
	@Test
	public void should_roman_numeral_converter_not_null()
	{
		Assert.assertNotNull(_romanNumeralConverter);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void should_not_allow_number_less_than_1()
	{
		_romanNumeralConverter.convertNumericToRoman(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void should_not_allow_greater_than_4999()
	{
		_romanNumeralConverter.convertNumericToRoman(5000);
	}
	
	@Test
	public void should_return_I_when_typing_1()
	{
		Assert.assertEquals("I", _romanNumeralConverter.convertNumericToRoman(1));
	}
	
	@Test
	public void should_not_return_IIII_when_typing_4()
	{
		Assert.assertNotEquals("IIII", _romanNumeralConverter.convertNumericToRoman(4));
	}
	
	@Test
	public void should_return_written_right_to_left()
	{
		Assert.assertEquals("XII", _romanNumeralConverter.convertNumericToRoman(12));
	}
	
	@Test
	public void should_return_IV_when_typing_4()
	{
		Assert.assertEquals("IV", _romanNumeralConverter.convertNumericToRoman(4));
	}
	
	@Test
	public void should_return_IX_when_typing_9()
	{
		Assert.assertEquals("IX", _romanNumeralConverter.convertNumericToRoman(9));
	}
	
	@Test
	public void should_return_XL_when_typing_40()
	{
		Assert.assertEquals("XL", _romanNumeralConverter.convertNumericToRoman(40));
	}
	
	@Test
	public void should_return_XC_when_typing_90()
	{
		Assert.assertEquals("XC", _romanNumeralConverter.convertNumericToRoman(90));
	}
	
	@Test
	public void should_return_XCIX_when_typing_99()
	{
		Assert.assertEquals("XCIX", _romanNumeralConverter.convertNumericToRoman(99));
	}
	
	@Test
	public void should_return_CD_when_typing_400()
	{
		Assert.assertEquals("CD", _romanNumeralConverter.convertNumericToRoman(400));
	}
	
	@Test
	public void should_return_CM_when_typing_900()
	{
		Assert.assertEquals("CM", _romanNumeralConverter.convertNumericToRoman(900));
	}
	
	@Test
	public void should_return_400_when_typing_CD()
	{
		Assert.assertEquals(400, _romanNumeralConverter.convertRomanToNumeric("CD"));
	}
	
	@Test
	public void should_return_4888_when_typing_MMMMDCCCLXXXVIII()
	{
		Assert.assertEquals(4888, _romanNumeralConverter.convertRomanToNumeric("MMMMDCCCLXXXVIII"));
	}
	
	@Test
	public void should_return_202_when_typing_CCII()
	{
		Assert.assertEquals(202, _romanNumeralConverter.convertRomanToNumeric("CCII"));
	}
	
	@Test
	public void should_return_768_when_typing_DCCLXVIII()
	{
		Assert.assertEquals(768, _romanNumeralConverter.convertRomanToNumeric("DCCLXVIII"));
	}
	
	@Test
	public void should_return_1944_when_typing_MCMXLIV()
	{
		Assert.assertEquals(1944, _romanNumeralConverter.convertRomanToNumeric("MCMXLIV"));
	}
	
	@Test
	public void should_return_3011_when_typing_MMMXI()
	{
		Assert.assertEquals(3011, _romanNumeralConverter.convertRomanToNumeric("MMMXI"));
	}
	
	@Test
	public void should_return_3999_when_typing_MMMCMXCIX()
	{
		Assert.assertEquals(3999, _romanNumeralConverter.convertRomanToNumeric("MMMCMXCIX"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void should_raise_exception_when_typing_MMMMM()
	{
		_romanNumeralConverter.convertRomanToNumeric("MMMMM");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void should_raise_exception_when_typing_CCCC()
	{
		_romanNumeralConverter.convertRomanToNumeric("CCCC");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void should_raise_exception_when_typing_DDDD()
	{
		_romanNumeralConverter.convertRomanToNumeric("DDDD");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void should_raise_exception_when_typing_()
	{
		_romanNumeralConverter.convertRomanToNumeric("MMMMM");
	}
}
