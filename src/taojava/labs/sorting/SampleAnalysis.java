package taojava.labs.sorting;

import java.io.PrintWriter;

/**
 * A very simple analysis of a few sorting algorithms.
 * 
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class SampleAnalysis
{

  public static void main(String[] args)
  {
    PrintWriter pen = new PrintWriter(System.out, true);
    @SuppressWarnings("unchecked")
    Sorter<Integer>[] sorters =
        (Sorter<Integer>[]) new Sorter[] { new BuiltinSorter<Integer>(),
                                          /*new InsertionSorter<Integer>(),*/
                                          new NewQuicksorter<Integer>(),
                                          new MergeSorter<Integer>()};
    String[] sorterNames = { "Built-in", "Quicksorter", "MergeSorter" };

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
