package taojava.labs.sorting;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * Tools for analyzing sorters.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class SorterAnalyzer
{
  // +---------------+---------------------------------------------------
  // | Configuration |
  // +---------------+

  /**
   * The number of repetitions we do in gathering statistics.
   */
  static final int REPETITIONS = 12;

  /**
   * The smallest array size we use.
   */
  static final int SMALLEST = 10000;

  /**
   * The largest array size we use.
   */
  static final int LARGEST = 40000;

  /**
   * The amount we scale the array size between tests.
   */
  static final int SCALE = 2;

  // +-----------+-------------------------------------------------------
  // | Constants |
  // +-----------+

  /**
   * A comparator for integers.
   */
  public static final Comparator<Integer> standardIntComparator =
      (left, right) -> left.compareTo(right);

  /**
   * Build arrays of random integer values.
   */
  public static final ArrayBuilder<Integer> randomIntArrBuilder = (length) ->
    {
      Integer[] vals = new Integer[length];
      Random random = new Random();
      for (int i = 0; i < length; i++)
        vals[i] = random.nextInt(length);
      return vals;
    }; // randomIArrayBuilder

  /** 
   * Build arrays of integer values in increasing order.
   */
  public static final ArrayBuilder<Integer> increasingIntArrBuilder =
      (length) ->
        {
          Integer[] vals = new Integer[length];
          for (int i = 0; i < length; i++)
            vals[i] = i;
          return vals;
        };

  /*
   * Build arrays of integer values in decreasing order.
   */
  public static final ArrayBuilder<Integer> decreasingIntArrBuilder =
      (length) ->
        {
          Integer[] vals = new Integer[length];
          for (int i = length-1; i > 0; i--)
            vals[i] = i;
          return vals;
        };

  /*
   * Build arrays of integer values in decreasing order.
   */
  public static final ArrayBuilder<Integer> mostlyIntArrBuilder = (length) ->
    {
      Integer[] vals = new Integer[length];
      for (int i = 0; i < length; i++)
        vals[i] = i;

      Random rand = new Random(9);
      Random randArr = new Random(length - 1);

      for (int j = 0; j < length; j++)
        {
          if (rand.nextInt() == 7)
            Utils.swap(vals, vals[randArr.nextInt()], vals[randArr.nextInt()]);
        }
      return vals;
    };

    /*
  public static final ArrayBuilder<Integer> IncreasingSizeArrBuilder =
      (length) ->
        {
          Integer[] vals = new Integer[length];
          for (int i = length; i > 0; i--)
            vals[i] = i;
          return vals;
        };
        
  public static final ArrayBuilder<Integer> decreasingSizeArrBuilder =
      (length) ->
        {
          int arraySize=0;
          Random randNum = new Random(14)
          for( arraySize=0; arraySize<length; ++arraySize)
            {
              
            }
          
          Integer[] vals = new Integer[length];
          for (int i = length; i > 0; i--)
            vals[i] = i;
          return vals;
        };
        */

  // +--------------+----------------------------------------------------
  // | Class Fields |
  // +--------------+

  // +---------------+---------------------------------------------------
  // | Class Methods |
  // +---------------+

  /**
   * Determine the amount of time sorter takes to sort an array of
   * the given size created by builder.
   *
   * @param sorter
   *   The sorting routine we are testing.
   * @param builder
   *   The constructor for the array we will sort.
   * @param order
   *   The comparator we use in sorting.
   * @param size
   *   The size of the array that we sort.
   *   
   * @return the number of milliseconds that sorting took, or 
   *   Long.MAX_VALUE if the sorter breaks.
   */
  public static <T> long basicAnalysis(Sorter<T> sorter, Comparator<T> order,
                                       ArrayBuilder<T> builder, int size)
  {
    // Prepare for timing
    SimpleTimer timer = new SimpleTimer();

    // Build the array.
    T[] values = builder.build(size);

    // Run the garbage collector so that garbage collection
    // is less likely to be counted as part of the time for
    // sorting.
    gc();

    // Start the timer.  (Duh.)
    timer.start();

    // Do the real work.
    try
      {
        sorter.sort(values, order);
      } // try            
    catch (Throwable error)
      {
        // Sorting failed with some error.  Return -1 to
        // indicate failure.
        return Long.MAX_VALUE;
      } // catch

    // Stop the timer.
    timer.pause();

    // And report the time taken
    return timer.elapsed();
  } // basicAnalysis(Sorter<T>, ArrayBuilder<T>, int)

  /**
   * Repeatedly perform basic analysis and gather statistics
   * (e.g., minimum time, maximum time, average time.
   */
  public static <T> long[] compoundAnalysis(Sorter<T> sorter,
                                            Comparator<T> order,
                                            ArrayBuilder<T> builder, int size,
                                            int repetitions)
  {
    long minimumRunTime = 0;
    long averageRunTime = 0;
    long maximumRunTime = 0;
    long temp = 0;
    long remainder = 0;

    for (int i = 0; i < repetitions; i++)
      {
        temp = basicAnalysis(sorter, order, builder, size);
        if (temp < minimumRunTime)
          minimumRunTime = temp;
        else if (temp > maximumRunTime)
          maximumRunTime = temp;
        averageRunTime = +(temp / repetitions);
        remainder = +temp % repetitions;
      }

    averageRunTime = +remainder / repetitions;
    long resultArray[] = { minimumRunTime, averageRunTime, maximumRunTime };
    return resultArray;
  } // compoundAnalysis(Sorter<T>, ArrayBuilder<T>, int, int)

  /**
   * Given a variety of sorters and builders, does some analysis
   * of each sorter/builder pair using a variety of array sizes
   * and prints out the results.
   *
   * @param pen
   *   Where to send the output
   * @param sorters
   *   The objects that do the sorting
   * @param sorterNames
   *   The names of those sorters
   * @param builders
   *   The objects to build the arrays
   * @param builderNames
   *    The names of those builders
   */
  public static <T> void combinedAnalysis(PrintWriter pen, Sorter<T>[] sorters,
                                          String[] sorterNames,
                                          Comparator<T> order,
                                          ArrayBuilder<T> builders[],
                                          String[] builderNames)
  {

    pen.printf("%-16s%-16s%-16s%-16s\n", "Sorter", "Builder", "Input Size",
               "Average Time");
    pen.printf("%-16s%-16s%-16s%-16s\n", "------", "-------", "------------",
               "------------");
    for (int b = 0; b < builders.length; b++)
      {

        for (int size = SMALLEST; size <= LARGEST; size *= SCALE)
          {
            for (int sorterIndex = 0; sorterIndex < sorters.length; sorterIndex++)
              {
                long[] stats =
                    compoundAnalysis(sorters[sorterIndex], order, builders[b],
                                     size, REPETITIONS);
                for (int i = 0; i < 3; i++)
                  {
                    pen.printf("%-16s%-16s%12d    %12d\n",
                               sorterNames[sorterIndex], builderNames[b], size,
                               stats[i]);
                  } // for print stats
              } // for sorterIndex
          } // for size
      } // for builder : builders
  } // combinedAnalysis(PrintWRiter, Sorter<T>, String[], ...)

  /**
   * Force garbage collection to the best of our ability.
   */
  public static void gc()
  {
    // Right now, we use the quick and dirty "suggest garbage
    // collection".  Over the long term, we will probably try
    // something like "get the pid and execute 'jcmd <pid> GC.run'"
    // The pid *might* be in the environment.
    System.gc();
  } // gc()
} // class SorterAnalyzer
