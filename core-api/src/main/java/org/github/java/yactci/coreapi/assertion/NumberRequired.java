package org.github.java.yactci.coreapi.assertion;

/**
 * Assertion helper class for primitive numbers {short, int, float, double, long }
 *
 * @author Said Ucar
 */
public final class NumberRequired {

  private static final int MIN_POSITIVE = 1;
  private static final int MAX_NEGATIVE = -1;

  private NumberRequired() {}

  public static void negative(short number) {
    if (number > MAX_NEGATIVE) throw new ArithmeticException();
  }

  public static void negative(int number) {
    if (number > MAX_NEGATIVE) throw new ArithmeticException();
  }

  public static void negative(float number) {
    if (number > MAX_NEGATIVE) throw new ArithmeticException();
  }

  public static void negative(double number) {
    if (number > MAX_NEGATIVE) throw new ArithmeticException();
  }

  public static void negative(long number) {
    if (number > MAX_NEGATIVE) throw new ArithmeticException();
  }

  public static void nonNegative(short number) {
    if (number <= MAX_NEGATIVE) throw new ArithmeticException();
  }

  public static void nonNegative(int number) {
    if (number <= MAX_NEGATIVE) throw new ArithmeticException();
  }

  public static void nonNegative(float number) {
    if (number <= MAX_NEGATIVE) throw new ArithmeticException();
  }

  public static void nonNegative(double number) {
    if (number <= MAX_NEGATIVE) throw new ArithmeticException();
  }

  public static void nonNegative(long number) {
    if (number <= MAX_NEGATIVE) throw new ArithmeticException();
  }

  public static void positive(short number) {
    if (number < MIN_POSITIVE) throw new ArithmeticException();
  }

  public static void positive(int number) {
    if (number < MIN_POSITIVE) throw new ArithmeticException();
  }

  public static void positive(float number) {
    if (number < MIN_POSITIVE) throw new ArithmeticException();
  }

  public static void positive(double number) {
    if (number < MIN_POSITIVE) throw new ArithmeticException();
  }

  public static void positive(long number) {
    if (number < MIN_POSITIVE) throw new ArithmeticException();
  }

  public static void nonPositive(short number) {
    if (number >= MIN_POSITIVE) throw new ArithmeticException();
  }

  public static void nonPositive(int number) {
    if (number >= MIN_POSITIVE) throw new ArithmeticException();
  }

  public static void nonPositive(float number) {
    if (number >= MIN_POSITIVE) throw new ArithmeticException();
  }

  public static void nonPositive(double number) {
    if (number >= MIN_POSITIVE) throw new ArithmeticException();
  }

  public static void nonPositive(long number) {
    if (number >= MIN_POSITIVE) throw new ArithmeticException();
  }
}
