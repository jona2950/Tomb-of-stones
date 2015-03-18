package tombstone.track.values;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Arrays;

/**
 * @author Jonathan
 * @date   2015-03-18 
 * 
 * Tallys/records values passed in, setting a fixed array size. 
 * Values are from the Die_Core, which simulates a die
 * Data will be used for parsing information to result in probability findings during simulation.   
 * (such as; times a value was generated, maximum, minimum, and frequency of a value, & percentage)
 *
 * @param <T1>
 * @param <T2>
 */
public class Roll_Values{
	
	/*	Specifics
	 *	Constant variables
	 */
	private final int	MINIMUM_RANGE,
						MAXIMUM_RANGE;
	
	private final int 	BASE_NUMBER = 1,
						DIVISBLE_BY = 2,
						MULTIPLES_OF = 10;
	
	//Instance variables (module level)
	private static float[] tracked_rolls_array;
	
	private int POPULATION_MULTIPLES;
	
	//Foo variables
	private boolean array_isFilled;
	
	//if prime, count back and forward for the two mids
	private boolean isPrime;

	private int valueMin,
				valueMid,
				valueMax;
	
	/**
	 * Constructor class of Roll_Values.
	 * Initiates variables contained at module level.
	 * @param range_max 		highest range  point 
	 * @param range_min 		lowest range point
	 * @param range_multiples	population by multiples of...
	 */
	public Roll_Values(final int range_min, final int range_max, int range_multiples) {
		this(range_min, range_max);
		
		POPULATION_MULTIPLES = range_multiples;
	}
	
	/**
	 * Constructor class of Roll_Values.
	 * Initiates variables contained at module level.
	 * @param range_max 		highest range  point 
	 * @param range_min 		lowest range point 
	 */
	public Roll_Values(final int range_min, final int range_max) 
	{
		
		super();
		

		MINIMUM_RANGE = range_min;
		MAXIMUM_RANGE = range_max;

		POPULATION_MULTIPLES = BASE_NUMBER;
		
		tracked_rolls_array = new float[range_max];
		
		valueMin = range_min;
		valueMax = range_max;

		//Middle number
		valueMid = (int) Math.floor(range_max / DIVISBLE_BY);
		//method is boolean, runs to check if range is prime or odd
		isPrime = middleNumber(range_max);
		
		_populate_array(tracked_rolls_array);

	}



	/**
	 * Checks if the range is evenly divisible by constant DIVISBLE_BY, = 2
	 * @param maxRange the range
	 * @return if evenly divisible, true otherwise false
	 */
	private boolean middleNumber(int maxRange) { return (maxRange % DIVISBLE_BY == 0)? false : true; }
	
	/**
	 * Performs a basic array population with the minimal specifics 
	 */
	private void _populate_array(float[] array)
	{	//local variable declaration, with initialization
		int Multiples = MULTIPLES_OF;
		int Index = BASE_NUMBER;
		
		//try-catch for, if anything goes wrong during population
		try {
			//for loop make an 
			for ( int iterate=0; iterate < MAXIMUM_RANGE; iterate+=POPULATION_MULTIPLES, Index=iterate+BASE_NUMBER ) 
			{				
				//performs a change of multiples every tenth interval * 10 of the time
				if (  Multiples < (Index+BASE_NUMBER) ) {
					
					/*
					 * Math.pow(Base,Exponent), used to increment the Multiples variable
					 * 
					 * Base = MULTIPLES_OF (=10) - 
					 * 
					 * Exponent (N) =
					 * Math.Log10(Index), surrounded with Math.floor() to round
					 * down nearest whole number. 
					 * Math.floor, followed by
					 * addition with BASE_NUMBER (= 1), to determine the
					 * absolute character length
					 * 
					 * Thus, finding multiples for
					 * root base number is achievable with the length of the
					 * value using log10, - used as an exponent with base 10,
					 * e.g. 10^log10(10)+1 = 100
					 * 
					 * 
					 * The approach for using a computational population filler
					 * is to recognize the place holder for the given range. By
					 * storing the placeholder as a decimal to correlate
					 * the values being recorded for data extraction for matching
					 * 
					 */
					Multiples = (int) Math.pow(MULTIPLES_OF, Math.floor(Math.log10(Index))+BASE_NUMBER);
				} 
				//a reference pointer of passed-in array, ////System.out.printf("%n%s : %s : %s", Index, Multiples, ((float) Index/Multiples));
				array[iterate] = ((float) Index/Multiples);	
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			
			System.out.println("Array is out of Bounds"+e);
		} catch (ArithmeticException e) {
			
			System.out.println ("Can't divide by Zero"+e);
		} catch (NullPointerException e) {
			
			System.out.println ("Reference pointer to array error"+e);
		} 
		
	} //option 2: tracked_rolls_array [iterate] = ((MINIMUM_RANGE + iterate)/MULTIPLES); [remove argument in method]
	

	
	/**
	 * This method records the value into array used for storing 
	 * @param value 
	 * @return
	 */
	public void record(int value)
	{
		try {
			if (!record_process(value)) {
				throw new IllegalArgumentException(
						"recording process failed /values-unchanged/");
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Prohibited argument object passed, expecting int"+e);
		}

	}
	
	
	/**
	 * Processes the value to be recorded into tracked_rolls_array
	 * @param value of value being added into record
	 * @return value added into tracked_rolls_array, true, otherwise false. 
	 */
	private boolean record_process(int x)
	{
		//if tracked_rolls_array is not initially filled with values continue to fill, but count numbers that exist
		//otherwise, begin total value counting
		
		try {
			int Index = x - BASE_NUMBER;

			tracked_rolls_array[Index] += 1;
			return true;
		} catch (ArrayIndexOutOfBoundsException e) {
			
			System.out.println("Array is out of Bounds"+e);
		}
		
		return false;
	}
	
	/**
	 * Method returns a generic copy of the values recorded
	 * tracked_rolls_array.
	 * @return tracked_rolls_array 
	 */
	public float[] copyValues() { return tracked_rolls_array.clone(); }
	
	/**
	 * Method returns a sorted copy of the values recorded in 
	 * tracked_rolls_array.
	 * @return tracked_rolls_array (sorted)
	 */
	public float[] copyValuesSorted() { Arrays.sort(tracked_rolls_array); return tracked_rolls_array.clone(); }

}

	/*	tracked_rolls_array[MAXIMUM_RANGE] 		= valueMin;
	tracked_rolls_array[MINIMUM_RANGE] 		= valueMax;
	
	if (isPrime){
		int middle1 = MAXIMUM_RANGE-valueMid, middle2 = MINIMUM_RANGE+valueMid;
		
		tracked_rolls_array[middle1] 			= middle1;
		tracked_rolls_array[middle2+valueMid] 	= middle2;
	}
	else {
		tracked_rolls_array[valueMin] = valueMin;
	}*/
