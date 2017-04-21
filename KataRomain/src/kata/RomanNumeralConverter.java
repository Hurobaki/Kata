package kata;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;

public class RomanNumeralConverter {
	
	private static Vector<Tuple<String, Integer, Integer>> _dictionnaryConverterRomanNumeric = new Vector<Tuple<String, Integer, Integer>>(){

		private static final long serialVersionUID = 1L;

		{
			add(new Tuple<String, Integer, Integer>("M", 1000, 4));
			add(new Tuple<String, Integer, Integer>("CM", 900, 1));
			add(new Tuple<String, Integer, Integer>("D", 500, 3));
			add(new Tuple<String, Integer, Integer>("CD", 400, 1));
			add(new Tuple<String, Integer, Integer>("C", 100, 3));
			add(new Tuple<String, Integer, Integer>("XC", 90, 1));
			add(new Tuple<String, Integer, Integer>("L", 50, 3));
			add(new Tuple<String, Integer, Integer>("XL", 40, 1));
			add(new Tuple<String, Integer, Integer>("X", 10, 3));
			add(new Tuple<String, Integer, Integer>("IX", 9, 1));
			add(new Tuple<String, Integer, Integer>("V", 5, 3));
			add(new Tuple<String, Integer, Integer>("IV", 4, 1));
			add(new Tuple<String, Integer, Integer>("I", 1, 3));
		}
	};
	
	public RomanNumeralConverter()
	{
		
	}
	
	public String convertNumericToRoman(int number) throws IllegalArgumentException
	{
		String roman = "";
	       
        if(number < 1 || number > 4999){
            throw new IllegalArgumentException();
        }
       
        Iterator<Tuple<String, Integer, Integer>> iteratorDictionary = (Iterator<Tuple<String, Integer, Integer>>) _dictionnaryConverterRomanNumeric.iterator();
       
        while(iteratorDictionary.hasNext()){
            Tuple<String ,Integer, Integer> element = (Tuple<String, Integer, Integer>) iteratorDictionary.next();
            int occurency = (int)Math.floor(number / (int)element.getRight());
            number -= occurency * (int)element.getRight();
           
            for(int numberElement = 0; numberElement < occurency; numberElement++)
            {
                roman += element.getLeft();
            }
        }
       
        return roman;	
	}
	
	public int convertRomanToNumeric(String romanNumber) throws IllegalArgumentException
	{
		int number = 0;
		int lastIndex = 0;
		
		Iterator<Tuple<String, Integer, Integer>> iteratorDictionary = (Iterator<Tuple<String, Integer, Integer>>) _dictionnaryConverterRomanNumeric.iterator();
		
		while(iteratorDictionary.hasNext())
		{
			Tuple<String, Integer, Integer> element = (Tuple<String, Integer, Integer>) iteratorDictionary.next();
			
			int occurences = 0;
			boolean found = true;
					
			do
			{
				if(lastIndex + element.getLeft().length() < romanNumber.length())
				{
					found = element.getLeft().equals(romanNumber.substring(lastIndex, lastIndex + element.getLeft().length()));
				}
				else
				{
					found = element.getLeft().equals(romanNumber.substring(lastIndex));
				}
				
						
				if(found)
				{
					lastIndex += element.getLeft().length();
					number += element.getRight();
					occurences++;
				}
				
				if(occurences > element.getOccurence())
				{
					throw new IllegalArgumentException();
				}
			}
			while(found);
			
		}
		return number;
	}
}
