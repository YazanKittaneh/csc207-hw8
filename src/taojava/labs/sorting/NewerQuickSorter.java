package taojava.labs.sorting;

import java.util.Comparator;

public class NewerQuickSorter<T>
      extends NewQuicksorter<T>
{    
  @Override
  public T selectPivot(T[] vals, Comparator<T> order, int lb, int ub)
  {
    //take mid point
    int mid = (lb + ub)/2;
    return vals[mid];
  }
}

