package taojava.labs.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * Sort using a slightly different version of Quicksort.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here.
 */
public class MedianQuickSorter<T>
    extends NewQuicksorter<T>
{
  @SuppressWarnings("unchecked")
  @Override
  public T selectPivot(T[] vals, Comparator<T> order, int lb, int ub)
  {
    Random rand = new Random();

    T a = vals[Math.abs((rand.nextInt() % (ub-lb)) + lb)];
    T b = vals[Math.abs((rand.nextInt() % (ub-lb))  + lb)];
    T c = vals[Math.abs((rand.nextInt() % (ub-lb)) + lb)];
    
   
    T[] arr = (T[]) new Object[3];
    arr[0] = a;
    arr[1] = b;
    arr[2] = c;
    
    Arrays.sort(arr);
    
    

    return arr[1];
  }

} // NewQuicksorter<T>
