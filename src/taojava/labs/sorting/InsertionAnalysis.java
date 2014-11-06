package taojava.labs.sorting;

import java.io.PrintWriter;

/**
 * A very simple analysis of a few sorting algorithms.
 * 
 * @author Samuel A. Rebelsky
 * @author 
 */
public class InsertionAnalysis
{

  /*
   * We see from the result that the built in insertion sort 
   * has far superior run times than our implemented sorts.
   * We also observe that in lower lengths, the built-in swap() method 
   * is slightly slower than the manual swap. In bigger lengths,
   * the built-in swap is slightly faster. In both cases, the 
   * shift implementation is faster. 
   * 
   */
  
  public static void main(String[] args)
  {
    PrintWriter pen = new PrintWriter(System.out, true);
    @SuppressWarnings("unchecked")
    Sorter<Integer>[] sorters =
        (Sorter<Integer>[]) new Sorter[] { new BuiltinSorter<Integer>(),
                                          new InsertionSorter<Integer>(),
                                          new InsertionSorterB<Integer>(),
                                          new InsertionSorterC<Integer>() };
    String[] sorterNames = { "Built-in", "InsertionA", "InsertionB", "InsertionC" };

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
  } // main(String[]
} // SampleAnalysis
