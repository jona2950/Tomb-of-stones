package tombstones;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tombstone.track.values.Roll_Values;
import tombstones.dice.functionality.Core_Die;

/**
 * 
 * @author 	Jonathan Fachola
 * @date 	2015-03-18
 * 
 * Simulates a roll of a die (dice)
 * while values are tracked for measuring 
*/

public class Execute_Tombstone {

	private static int MAX;
	private static int MIN;
	
	static int DICE_ROLLS = 0;
	
	public static void main(String[] args)
	{
		
		int t = 36000;
		
		Core_Die dice1 = new Core_Die();
		Core_Die dice2 = new Core_Die();

		
		MAX = dice1.range_max() + dice2.range_max();
		MIN = dice1.range_min() + dice1.range_min();
		
		
		
		Roll_Values RV = new Roll_Values(MIN, MAX);
		
		for (int i = 0; i<t; i++)
		{
			
			if (dice1.roll() && dice2.roll()){
				
				
				DICE_ROLLS = (dice1.diceValue() + dice2.diceValue());
				
				RV.record(DICE_ROLLS);

			}


		}	
		
		
		System.out.println("Die(s) rolled : " + t + " times \n Frequncy of values die(s) generated\n");
		
		int i=1;
		int previous = 0;
		for (float numbers : RV.copyValues())
		{
			previous += (int) Math.floor(numbers);
			System.out.println(i++ + " : " + Math.floor(numbers) + "\t\t sum(" + previous + ")");

		}


	}
}

/**
 * Used for testing functionality 
 */
/*		int Multiply_BY = 10;
for (int iterate = 0;iterate<1000;iterate++){

	if (  Multiply_BY < iterate+1 )
	{
		Multiply_BY = (int) Math.pow(MULTIPLES_OF, (Math.floor(Math.log10(iterate))+1));
		//System.out.println(iterate + ":i:" + Multiply_BY);
		System.out.println("ping");
	}
	System.out.println(iterate + ":i:" + Multiply_BY);
	
	//System.out.println(iterate + "o:olog:" + (Math.floor(Math.log10(iterate))+1) + "olog:oLogF^" +( Math.pow(MULTIPLES_OF, (Math.floor(Math.log10(iterate))+1) )));
}*/

//for (float numbers : array)