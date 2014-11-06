package taojava.labs.sorting;

import java.io.PrintWriter;
import java.util.Random;

/**
 * A very simple analysis of a few sorting algorithms.
 * 
 * @author Yazan Kittaneh
 */
public class PrimativeInsertionSortExpt
{

  /**
   * Gives the runtime of PrimativeInsertionSorter
   * 
   * @param int[] values
   * @return long timer.elapsed
   */
  public static long primativeRunTime(int[] values)
  {
    SimpleTimer timer = new SimpleTimer();

    timer.start();
    try
      {
        PrimativeInsertionSorter.sort(values);
      } // try            
    catch (Throwable error)
      {
        // Sorting failed with some error.  Return -1 to
        // indicate failure.
        System.out.println(error); //DELETE THIS
        //return Long.MAX_VALUE;
      } // catch
    // Stop the timer.
    timer.pause();

    // And report the time taken\
    return timer.elapsed();
  } //primativeRunTime(int[] values)
  
  
  public int[] intMaker(int length)
  {
    int[] vals = {};
    Random random = new Random();
    for (int i = 0; i < length; i++)
      vals[i] = random.nextInt(length);
    return vals;
  }
  
  
  

  public static void main(String[] args)
  {
    
    /*
     * I had a lot of trouble getting this part to work. 
     * Initially, I was going to just turn SorterAnalyzer's
     * methods int friendly, but after a lot of friction 
     * I attempted to create a test from the ground up using ints.
     * What I realize now is that I need a lot of the methods
     * found in SorterAnalyzer but now I don't have enough time
     * to implement the idea. 
     * 
     * -Yazan Kittaneh
     */
    
    
    long primativeRunTime=0;
    long insertionRuntime=0;

    
      ArrayBuilder<Integer> arrays = SorterAnalyzer.randomIntArrBuilder;
      Integer RandomArray[] = arrays.build(length);
      
        
    
    while(i<)
      {
    pen.printf("%-16s%-16s%-16s%-16s%-16s%-16s\n", "Primative", "Length", "RunTime");
    pen.printf("%-16s%-16s%-16s%-16s%-16s%-16s\n", "------", "-------", "------------");
    runTime=primativeRunTime(Arrays[i]);
    pen.printf("%-16s%-16s%-16s%-16s%-16s%-16s\n", "------", length, primativeRunTime);
    pen.println();
    pen.printf("%-16s%-16s%-16s%-16s%-16s%-16s\n", "Insertion", "Length", "RunTime");
    pen.printf("%-16s%-16s%-16s%-16s%-16s%-16s\n", "------", length, insertionRuntime);
    SorterAnalyzer.basicAnalysis(pen, sorters, sorterNames,
                                    SorterAnalyzer.standardIntComparator,
                                    builders, builderNames);
      }
    
   
  } // main(String[]
} // SampleAnalysis
