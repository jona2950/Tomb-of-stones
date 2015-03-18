package tombstones;

import java.util.regex.Pattern;

/**
 * 
 * @author Jonathan
 *
 * Core_Die is responsible for simulating a single die. 
 * Generating a value between 1-6, only 4 faces like a traditional die
 */

public class Core_Die {

	//Instance variables (module level)
	private int	diceValue; 
	
	/*
	 * in class Constant variables, Core_Die 
	 */
	private final int 	MINIMUM_FACE_VALUE 	= 1;
	private final int 	MAXIMUM_FACE_VALUE 	= 6;

	
	//FACES_OF_DIE should represent a basis for maximum by calculating the sides of 3-dimensional cube/shape
	private final int 	VERTICES_OF_DIE		= 8;
	private final int 	EDGES_OF_DIE	= 12;
	
	private Value_Generator gNUM; //used for obtaining a value
	
	/**
	 * constructor for class Core_Die
	 * initiates variable, gNUM of new type Value_Generator, 
	 * passing a boundary range for generating values
	 */
	public Core_Die()
	{
		
		 gNUM = new Value_Generator(MINIMUM_FACE_VALUE, MAXIMUM_FACE_VALUE);
	}
	
	/**
	 * Generates a value for the roll of die
	 * @return true if value generated is between die range, otherwise false
	 */
	public boolean roll() {	
		diceValue = gNUM.generate();
		return (diceValue >= MAXIMUM_FACE_VALUE && diceValue <= MINIMUM_FACE_VALUE)? false : true;
	}
	
	/**
	 * 	for retrieving value of dice after a roll, or not
	 * @return value of dice
	 */
	public Object diceValue() {
		return diceValue;
	}
	
	/**
	 * Method performs a simple arithmetic function
	 * to find accurate range of the die [(MAX-MIN)+1] = range
	 * @return The range of the die
	 */
	public final int range() { return ((MAXIMUM_FACE_VALUE-MINIMUM_FACE_VALUE)+1); }

	//Presents formal dice information through toString()
	@Override 
	public String toString() {
		
		return String.format("Specifics of dice\nMinimum: %s%nMaximum%s: ", MINIMUM_FACE_VALUE, MAXIMUM_FACE_VALUE) ;
	}
	
	
	
}
