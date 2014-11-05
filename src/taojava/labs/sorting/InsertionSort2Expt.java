package taojava.labs.sorting;

/**
 * A quick experiment with the secound insertion sorter.
 * 
 * @author Yazan Kittaneh
 */
public class InsertionSort2Expt
{
  /**
   * Run the experiments.
   */
  public static void main(String[] args)
  {
    ExptUtils.iExperiments(new InsertionSorterB<Integer>());
    ExptUtils.sExperiments(new InsertionSorterB<String>());
  } // main(String[])
} // class InsertionSortExpt
