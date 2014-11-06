package taojava.labs.sorting;

import java.util.Comparator;
import java.util.Random;

/**
 * Sort using a slightly different version of Quicksort.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here.
 */
public class RandomQuickSort<T>
    extends NewQuicksorter<T>
{
 @Override
public T selectPivot(T[] vals, Comparator<T> order, int lb, int ub)
{
  Random rand = new Random();
  //Return a random int within range of our bounds, but since we need an index
  // we add lb to it, and since we only want positive values, we return the
  //absolute value
  return vals[Math.abs((rand.nextInt() % (ub-lb)) + lb)];
}
 
} // NewQuicksorter<T>
