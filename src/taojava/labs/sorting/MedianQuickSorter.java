package taojava.labs.sorting;

import java.lang.reflect.Array;
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
    
    //Get three random elements in vals, put them in an array, sort
    //the array and then return the second elements (since there are
    //always going to be 3 elements in our array)
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
