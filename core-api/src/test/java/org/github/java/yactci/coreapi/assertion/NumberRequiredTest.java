package org.github.java.yactci.coreapi.assertion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Standard unit tests for {@link NumberRequired} utility class
 *
 * @author Said Ucar
 */
class NumberRequiredTest {

  @ParameterizedTest
  @ValueSource(shorts = {0, 42, Short.MAX_VALUE})
  void given_zeroOrPositiveShortNumber_expect_negativeToFail(short number) {
    assertThrows(ArithmeticException.class, () -> NumberRequired.negative(number));
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 42, Integer.MAX_VALUE})
  void given_zeroOrPositiveIntegerNumber_expect_negativeToFail(int number) {
    assertThrows(ArithmeticException.class, () -> NumberRequired.negative(number));
  }

  @ParameterizedTest
  @ValueSource(floats = {0f, 42f, Float.MAX_VALUE})
  void given_zeroOrPositiveFloatNumber_expect_negativeToFail(float number) {
    assertThrows(ArithmeticException.class, () -> NumberRequired.negative(number));
  }

  @ParameterizedTest
  @ValueSource(doubles = {0d, 42d, Double.MAX_VALUE})
  void given_zeroOrPositiveDoubleNumber_expect_negativeToFail(double number) {
    assertThrows(ArithmeticException.class, () -> NumberRequired.negative(number));
  }

  @ParameterizedTest
  @ValueSource(longs = {0, 42L, Long.MAX_VALUE})
  void given_zeroOrPositiveLongNumber_expect_negativeToFail(long number) {
    assertThrows(ArithmeticException.class, () -> NumberRequired.negative(number));
  }

  @ParameterizedTest
  @ValueSource(shorts = {Short.MIN_VALUE, (short) -42, (short) -1})
  void given_negativeShortNumber_expect_nonNegativeToFail(short number) {
    assertThrows(ArithmeticException.class, () -> NumberRequired.nonNegative(number));
  }

  @ParameterizedTest
  @ValueSource(ints = {Integer.MIN_VALUE, -42, -1})
  void given_negativeIntegerNumber_expect_nonNegativeToFail(int number) {
    assertThrows(ArithmeticException.class, () -> NumberRequired.nonNegative(number));
  }

  @ParameterizedTest
  @ValueSource(floats = {-Float.MAX_VALUE, -42f, -1f})
  void given_negativeFloatNumber_expect_nonNegativeToFail(float number) {
    assertThrows(ArithmeticException.class, () -> NumberRequired.nonNegative(number));
  }

  @ParameterizedTest
  @ValueSource(doubles = {-Double.MAX_VALUE, -42d, -1d})
  void given_negativeDoubleNumber_expect_nonNegativeToFail(double number) {
    assertThrows(ArithmeticException.class, () -> NumberRequired.nonNegative(number));
  }

  @ParameterizedTest
  @ValueSource(longs = {Long.MIN_VALUE, -42L, -1L})
  void given_negativeLongNumber_expect_nonNegativeToFail(long number) {
    assertThrows(ArithmeticException.class, () -> NumberRequired.nonNegative(number));
  }

  @ParameterizedTest
  @ValueSource(shorts = {Short.MIN_VALUE, -42, 0})
  void given_zeroOrNegativeShortNumber_expect_positiveToFail(short number) {
    assertThrows(ArithmeticException.class, () -> NumberRequired.positive(number));
  }

  @ParameterizedTest
  @ValueSource(ints = {Integer.MIN_VALUE, -42, 0})
  void given_zeroOrNegativeIntegerNumber_expect_positiveToFail(int number) {
    assertThrows(ArithmeticException.class, () -> NumberRequired.positive(number));
  }

  @ParameterizedTest
  @ValueSource(floats = {-Float.MAX_VALUE, -42f, 0f})
  void given_zeroOrNegativeFloatNumber_expect_positiveToFail(float number) {
    assertThrows(ArithmeticException.class, () -> NumberRequired.positive(number));
  }

  @ParameterizedTest
  @ValueSource(doubles = {-Double.MAX_VALUE, -42d, 0})
  void given_zeroOrNegativeDoubleNumber_expect_positiveToFail(double number) {
    assertThrows(ArithmeticException.class, () -> NumberRequired.positive(number));
  }

  @ParameterizedTest
  @ValueSource(longs = {Long.MIN_VALUE, -42L, 0L})
  void given_zeroOrNegativeLongNumber_expect_positiveToFail(long number) {
    assertThrows(ArithmeticException.class, () -> NumberRequired.positive(number));
  }

  @ParameterizedTest
  @ValueSource(shorts = {1, 42, Short.MAX_VALUE})
  void given_positiveShortNumber_expect_nonPositiveToFail(short number) {
    assertThrows(ArithmeticException.class, () -> NumberRequired.nonPositive(number));
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 42, Integer.MAX_VALUE})
  void given_positiveIntegerNumber_expect_nonPositiveToFail(int number) {
    assertThrows(ArithmeticException.class, () -> NumberRequired.nonPositive(number));
  }

  @ParameterizedTest
  @ValueSource(floats = {1f, 42f, Float.MAX_VALUE})
  void given_positiveFloatNumber_expect_nonPositiveToFail(float number) {
    assertThrows(ArithmeticException.class, () -> NumberRequired.nonPositive(number));
  }

  @ParameterizedTest
  @ValueSource(doubles = {1d, 42d, Double.MAX_VALUE})
  void given_positiveDoubleNumber_expect_nonPositiveToFail(double number) {
    assertThrows(ArithmeticException.class, () -> NumberRequired.nonPositive(number));
  }

  @ParameterizedTest
  @ValueSource(longs = {1, 42L, Long.MAX_VALUE})
  void given_positiveLongNumber_expect_nonPositiveToFail(long number) {
    assertThrows(ArithmeticException.class, () -> NumberRequired.nonPositive(number));
  }
}
