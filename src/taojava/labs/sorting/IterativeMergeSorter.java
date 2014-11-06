package taojava.labs.sorting;

import java.util.Comparator;

/**
 * Sort using iterative merge sort.
 * 
 * @author Samuel A. Rebelsky
 * @author Your Name Here.
 */
public class IterativeMergeSorter<T>
    extends SorterBridge<T>
{
  /**
   * Sort vals using iterative merge sort. See the Sorter<T> interface for
   * additional details.
   */
  @SuppressWarnings("unchecked")
  @Override
  public T[] sorti(T[] vals, Comparator<T> order)
  {
    int size = 1;
    int length = vals.length;
    T[] scratch = (T[]) new Object[vals.length];
    while (size < vals.length)
      {
        // Clone into scratch because otherwise we get null pointer exceptions
        scratch = vals.clone();
        
        // Merge neighboring subarrays of size size
        for (int i = 0; i + (size * 2) <= length; i += 2 * size)
            Utils.merge(order, scratch, i, i + size, scratch, i + size, i + (size * 2), vals, i, i + (size * 2));
        
        if (2 * size > length)
            Utils.merge(order, scratch, 0, size, scratch, size, length, vals, 0, length);
        // The merged subarrays are now twice as large
        size *= 2;
      } // while
    return vals;
  } // sorti(T[], Comparator<T>)
} // IterativeMergeSorter<T>
