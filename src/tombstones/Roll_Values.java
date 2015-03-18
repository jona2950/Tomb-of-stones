package tombstones;


/**
 * 
 * @author 	Jonathan Fachola
 * @date 	2015-03-18 
 * Keeps values generated from simulated dice, 
 * data will be used for parsing information to result in probability findings during simulation.   
 * (such as; times a value was generated, maximum, minimum, and frequency of a value, & percentage)
*/

public class Roll_Values<T1, T2> {
	
	/*	Specifics
	 *	Constant variables
	 */
	private final int maxRANGE;
	
	//Instance variables (module level)
	private static int[] tracked_rolls_array;

	
	/**
	 * Constructor class of Roll_Values.
	 * Initiates variables contained at module level.
	 * @param range
	 */
	public Roll_Values(final int range) {
		
		super();
		
		maxRANGE = range;
		tracked_rolls_array = new int[maxRANGE];
	}

	
	public boolean record(int object_value)
	{
		
		
		return false;
	}
	
	/**
	 * Method returns a copy of the values recorded in array 
	 * tracked_rolls_array.
	 * @return tracked_rolls_array 
	 */
	public int[] copyValues() { return tracked_rolls_array; }
	
	

	
}
