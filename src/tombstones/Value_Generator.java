package tombstones;

import java.awt.List;
import java.util.Random;

/**
 * @author Jonathan
 *This class provides generation of values between a fixed, or given range
 */

public class Value_Generator {
	
	private Random RND = new Random(System.currentTimeMillis());
	//Instance  variables (module level)
	private static int 		Minimum;
	private static int		Maximum;
	
	//constant variables /final/
	public final int	range_1X,
						range_2X;

	
	/** 
	 * To set a minimum value for temporary use, after use, reset to 0.  
	 * @param MIN
	 * @throws IllegalArgumentException
	 */
	private void setMinimum(int MIN)  {
		Minimum = MIN;	}
	
	private void setMaximum(int MAX)  {
		Maximum = MAX;	}
	

	/**
	 * Constructor of class Value_Generator accepting a two-way range
	 * @param range_1X 	;first range 
	 * @param range_2X	;second range 
	 */
	public Value_Generator(final int range_1X, final int range_2X)
	{
		this.range_1X = range_1X;
		this.range_2X = range_2X;
	}
	
	/**
	 * Constructor of class Value_Generator, with range between 1-range_2X
	 * @param range_2X 	;second range 
	 */
	public Value_Generator(final int range_2X)
	{
		this.range_1X = Minimum;
		this.range_2X = range_2X;
	}
	
	/**
	 * Constructor of class Value_Generator
	 */
	public Value_Generator()
	{
		//if values are 0, depend on values to be added.
		this.range_1X = Minimum;
		this.range_2X = Maximum;
	}
	
	
	/**
	 * Generates a random value with variable RND of type Random
	 * @return random value within specific range (Minimum & Maximum)
	 */
	private int value_generator()
	{

		return (Minimum+RND.nextInt(Maximum));
	}
	
	/**
	 * Request to generate value between fixed variables; range_1X & range_2X
	 * @return
	 */
	public int generate ()
	{
		setMinimum(range_1X);
		setMaximum(range_2X);
	
		return value_generator();
	}
	
	/**
	 *  Request to generate value between fixed variable range_1X and passed argument MAX
	 * @param MAX limit of Maximum value
	 * @return the value generated from request
	 * 
	 * @throws IllegalArgumentException
	 */
	public int generate (int MAX) throws IllegalArgumentException
	{
		setMinimum(range_1X);
		setMaximum(MAX);
		
		return value_generator();
	}
	
	/**
	 * Request to generate value between passed arguments; MIN & MAX
	 * 
	 * @param MIN limit of Minimum value
	 * @param MAX limit of Maximum value 
	 * @return the value generated from request
	 * 
	 * @throws IllegalArgumentException
	 */
	public int generate (int MIN, int MAX) throws IllegalArgumentException
	{
		setMinimum(MIN);
		setMaximum(MAX);
		
		return value_generator();
	}
	
}
