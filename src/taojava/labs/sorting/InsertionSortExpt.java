package taojava.labs.sorting;

/**
 * A quick experiment with the insertion sorter.
 * 
 * @author Samuel A. Rebelsky
 */
public class InsertionSortExpt
{
  /**
   * Run the experiments.
   */
  public static void main(String[] args)
  {
    ExptUtils.iExperiments(new NewQuicksorter<Integer>());
    ExptUtils.sExperiments(new NewQuicksorter<String>());
  } // main(String[])
} // class InsertionSortExpt
