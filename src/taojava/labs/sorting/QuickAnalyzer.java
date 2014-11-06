package taojava.labs.sorting;

import java.io.PrintWriter;

public class QuickAnalyzer
{
  public static void main(String[] args)
  {
    
    /* 
     * 
     * For Random, our tests showed that New and Newer performed comparably, whereas
     * Random and Median were slightly slower. For increasing, New was really slow, and
     * as input started increase, it took a really long time to sort. Newer performed the 
     * best as the size of the inputs didn't manage to increase running time substantially.
     * Random and Median performed comparably and were fast, but not as quick as New.
     * For decreasing, New performed bad again, as Newer was the quickest and Random and
     * Median were comparable. 
     * 
     * Our analysis shows that using the first element as the pivot is very
     * bad practice as that strategy would lead to exponentially large running
     * times. As for picking a random element or picking the median
     * of three random elements, the running times are very comparable, with
     * the former barely edging the latter in performance. This leaves us
     * with the quickest version - which is when the middle element is selected
     * as the pivot. This version is also noticeably quicker than the median and
     * random versions, and ridiculously faster than the version in which the 
     * first element is used as the pivot
     */
    PrintWriter pen = new PrintWriter(System.out, true);
    @SuppressWarnings("unchecked")
    Sorter<Integer>[] sorters =
        (Sorter<Integer>[]) new Sorter[] {new NewQuicksorter<Integer>(),
                                          new NewerQuickSorter<Integer>(),
                                          new RandomQuickSort<Integer>(),
                                          new MedianQuickSorter<Integer>()};
    String[] sorterNames = { "NewQuickSorter", "NewerQuickSorter", "RandomQuickSorter", "MedianQuickSorter" };

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
}
