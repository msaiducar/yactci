package org.github.java.yactci.coreapi.annotation;

/**
 * Big O notation constants. Only the most frequently used ones are added here. If none of the
 * defined complexities are suitable for your algorithm, feel free to add mode in here.
 *
 * @author Said Ucar
 */
public enum BigO {
  /**
   * constant complexity
   *
   * <p>BigO(1) || BigO(c)
   */
  CONSTANT,
  /**
   * logarithmic complexity
   *
   * <p>BigO(logn)
   */
  LOGARITHMIC,
  /**
   * linear complexity
   *
   * <p>BigO(N)
   */
  LINEAR,
  /**
   * linearithmic complexity
   *
   * <p>BigO(nlogn)
   */
  LINEARITHMIC,
  /**
   * quadratic complexity
   *
   * <p>BigO(n^2)
   */
  QUADRATIC,
  /**
   * exponential complexity
   *
   * <p>BigO(2^n)
   */
  EXPONENTIAL,
  /**
   * factorial complexity
   *
   * <p>BigO(n!)
   */
  FACTORIAL
}
