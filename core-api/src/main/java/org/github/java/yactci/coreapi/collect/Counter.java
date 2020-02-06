package org.github.java.yactci.coreapi.collect;

import java.util.stream.Stream;

/**
 * Counter interface provides a set of useful functionality when a counter is required. For example,
 * when counting the occurrence counts of characters in a string.
 *
 * @author Said Ucar
 */
public interface Counter<E> {

  Counter<E> countItems(E[] items);

  /**
   * fail safe counter increment. if given item never counted before, it's count will be 1 after
   * this operation
   *
   * @param item item
   */
  Counter<E> failSafeIncrement(E item);

  /**
   * fail safe counter decrement. if given item never counted before, it's count will be -1 after
   * this operation
   *
   * @param item item
   */
  Counter<E> failSafeDecrement(E item);

  /**
   * returns the counted items in the counter as a {@code Stream}
   *
   * @return stream of items
   */
  Stream<E> itemStream();

  /**
   * returns the counter values of items as a {@code stream}
   *
   * @return stream of counts
   */
  Stream<Integer> countStream();

  /**
   * returns the count of given item
   *
   * @param item item
   * @return count of item
   * @throws NullPointerException if item is not in the counter
   */
  int countOf(E item) throws NullPointerException;

  /**
   * returns the count of given item. if the item is not exists in the counter, this function
   * initializes with given default value and returns it.
   *
   * @param item item
   * @param defaultValue default value if item does not exist
   * @return count of item
   */
  int failSafeCountOf(E item, int defaultValue);

  /**
   * total count of items in the counter.
   *
   * @return total item count in the counter
   */
  long itemCount();

  /** @return sum of the occurrence of items in the counter */
  long sum();
}
