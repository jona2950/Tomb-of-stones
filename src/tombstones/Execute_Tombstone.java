package tombstones;

/**
 * 
 * @author 	Jonathan Fachola
 * @date 	2015-03-18
 * 
 * Simulates a roll of a die (dice)
 * while values are tracked for measuring 
*/

public class Execute_Tombstone {

	
	public static void main(String[] args)
	{


		Core_Die dice1 = new Core_Die();
	
		System.out.println(dice1.roll());
		System.out.println(dice1.diceValue());
	}
}

