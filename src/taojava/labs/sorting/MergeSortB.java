package taojava.labs.sorting;

import java.lang.reflect.Array;
import java.util.Comparator;

public class MergeSortB<T>
  extends SorterBridge<T>
{
  /**
   * Sort vals using iterative merge sort. See the Sorter<T> interface for
   * additional details.
   */
  @Override
  @SuppressWarnings("unchecked")
  public T[] sort(T[] vals, Comparator<T> order)
  {
    T[] scratch = (T[]) new Array[vals.length];
    return mergeSort(order, vals, 0, vals.length, scratch);
  } // sort(T[], Comparator<T>)
  
  public T[] mergeSort(Comparator<T> order, T[] vals, int lb, int ub, T[] scratch)
  {
    int mid;
    int length = ub-lb;
    if (length <= 1)
      {
        return vals;
      } // if array is one element
    else
      {
        mid =  lb + length / 2;
        mergeSort(order, vals, lb, mid, scratch);
        mergeSort(order, vals, mid, ub, scratch);
        // copy sorted halves into scratch
        for (int i = lb; i < ub; i++)
          {
            scratch[i] = vals[i];
          } // for
        // merge back into values
        return Utils.merge(order, scratch, lb, mid, scratch, mid, ub, vals, lb, ub);
      } // else
  }
}
