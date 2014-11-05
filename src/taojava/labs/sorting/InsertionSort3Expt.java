package taojava.labs.sorting;

/**
 * A quick experiment with the insertion sorter.
 * 
 * @author Samuel A. Rebelsky
 */
public class InsertionSort3Expt
{
  /**
   * Run the experiments.
   */
  public static void main(String[] args)
  {
    ExptUtils.iExperiments(new InsertionSorterC<Integer>());
    ExptUtils.sExperiments(new InsertionSorterC<String>());
  } // main(String[])
} // class InsertionSortExpt
