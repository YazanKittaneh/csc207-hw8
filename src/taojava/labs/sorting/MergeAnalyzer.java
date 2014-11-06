package taojava.labs.sorting;

import java.io.PrintWriter;

public class MergeAnalyzer
{

  /**
   * Observations:
   *    Average:
   *    For each of the tested cases, random, increaseing, decreasing and mostly
   *    MergeSorter performed one second slower than our other two methods with the 
   *    exception of random(10000), increasing(20000) and mostly(20000) where it 
   *    tied with MergeSorterB (random) and ItrMergeSorter (increasing & mostly) 
   *    for the slowest time.  
   *    As a whole these methods performed fairly mediocre on random but well on 
   *    every other type of array.
   *    
   *    Max:
   *    The max values for MergeSorter and MergeSorterB were horendous for random 
   *    10000, with results of 12 and 17 respectively.  IterMergeSorter, on the 
   *    other hand, performed very well with a time of 3.  The max values for 
   *    increasing, decreasing and mostly remained the same for each individual 
   *    method with MergeSorterB and IterMergeSort having the same time and 
   *    MergeSorter consistently lagging behind by one second.
   *    Again, the times for random were significantly slower than those for the 
   *    other test cases. 
   *    
   *    Min:
   *    
   *    
   */
  public static void main(String[] args)
  {
    PrintWriter pen = new PrintWriter(System.out, true);
    @SuppressWarnings("unchecked")
    Sorter<Integer>[] sorters =
        (Sorter<Integer>[]) new Sorter[] { new MergeSorter<Integer>(),
                                          new MergeSorterB<Integer>(),
                                          new IterativeMergeSorter<Integer>()};
    String[] sorterNames = { "MergeSorter", "MergeSorterB", "IterMergeSorter" };

    @SuppressWarnings("unchecked")
    ArrayBuilder<Integer>[] builders =
        (ArrayBuilder<Integer>[]) new ArrayBuilder[] {
                                                      SorterAnalyzer.randomIntArrBuilder,
                                                      SorterAnalyzer.increasingIntArrBuilder,
                                                      SorterAnalyzer.decreasingIntArrBuilder,
                                                      SorterAnalyzer.mostlyIntArrBuilder};
    String[] builderNames = { "Random", "Increasing", "decreasing", "mostly" };

    SorterAnalyzer.combinedAnalysis(pen, sorters, sorterNames,
                                    SorterAnalyzer.standardIntComparator,
                                    builders, builderNames);
  }

}
