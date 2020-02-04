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
  BIG_O_C,
  /**
   * logarithmic complexity
   *
   * <p>BigO(logn)
   */
  BIG_O_LOGN,
  /**
   * linear complexity
   *
   * <p>BigO(N)
   */
  BIG_O_N,
  /**
   * linearithmic complexity
   *
   * <p>BigO(nlogn)
   */
  BIG_O_NLOGN,
  /**
   * quadratic complexity
   *
   * <p>BigO(n^2)
   */
  BIG_O_NSQUARE,
  /**
   * exponential complexity
   *
   * <p>BigO(2^n)
   */
  BIG_O_EXP,
  /**
   * factorial complexity
   *
   * <p>BigO(n!)
   */
  BIG_O_NFACT
}
