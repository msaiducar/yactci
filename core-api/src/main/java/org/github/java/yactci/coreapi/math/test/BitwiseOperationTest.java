package org.github.java.yactci.coreapi.math.test;

import org.github.java.yactci.coreapi.math.BitwiseOperation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public interface BitwiseOperationTest<E extends BitwiseOperation> {

  E createBitMap(int count);

  @Test
  default void whenNegativeIndexUsedExpectException() {
    assertThrows(IndexOutOfBoundsException.class, () -> createBitMap(42).isClear(-1));
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 9, 33, 4097, 1000000})
  default void whenNonExistingIndexUsedExpectException(int capacity) {
    assertThrows(
        IndexOutOfBoundsException.class, () -> createBitMap(capacity).isClear(capacity + 1));

    assertThrows(IndexOutOfBoundsException.class, () -> createBitMap(capacity).isSet(capacity + 1));
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 9, 33, 4097, 1000000})
  default void whenBitMapInitializedExpectAllBitsClear(int capacity) {
    E operator = createBitMap(capacity);

    expectAllBitsClear(operator, capacity);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 9, 33, 4097, 1000000})
  default void whenAllBitsClearedExpectCountsAreCorrect(int capacity) {
    E operator = createBitMap(capacity);
    List<Integer> integers = IntStream.range(0, capacity).boxed().collect(Collectors.toList());

    Collections.shuffle(integers);

    integers.parallelStream().forEach(operator::clear);

    expectAllBitsClear(operator, capacity);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 9, 33, 4097, 1000000})
  default void whenAllBitsSetExpectCountsAreCorrect(int capacity) {
    E operator = createBitMap(capacity);
    List<Integer> integers = IntStream.range(0, capacity).boxed().collect(Collectors.toList());

    Collections.shuffle(integers);

    integers.parallelStream().forEach(operator::set);

    expectAllBitsSet(operator, capacity);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 9, 33, 4097, 1000000})
  default void whenBitToggledExpectBitValueChanged(int capacity) {
    E operator = createBitMap(capacity);

    List<Integer> integers = IntStream.range(0, capacity).boxed().collect(Collectors.toList());
    Collections.shuffle(integers);

    List<Integer> setBit =
        integers
            .parallelStream()
            .filter(integer -> (integer % 2 == 0))
            .collect(Collectors.toList());

    setBit.parallelStream().forEach(index -> operator.set(index).toggle(index));

    expectAllBitsClear(operator, capacity);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 9, 33, 4097, 1000000})
  default void whenAllBitsClearedExpectAllBitsClear(int capacity) {
    E operator = (E) createBitMap(capacity).clearAllBits();

    expectAllBitsClear(operator, capacity);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 9, 33, 4097, 1000000})
  default void whenAllBitsSetExpectAllBitsSet(int capacity) {
    E operator = (E) createBitMap(capacity).setAllBits();

    expectAllBitsSet(operator, capacity);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 9, 33, 4097, 1000000})
  default void whenNegativeShiftExpectException(int capacity) {
    assertThrows(ArithmeticException.class, () -> createBitMap(capacity).shiftLeft(-1));
  }

  @Test
  default void whenShiftLeftExpectRotationToSucceed() {
    // bitmap = { 0000 0000 1011 0101 }
    E operator = (E) createBitMap(16).set(0).set(2).set(4).set(5).set(7).shiftLeft(4);

    // bitmap = { 0000 1011 0101 0000 }
    assertThat(operator.isSet(0)).isFalse();
    assertThat(operator.isSet(1)).isFalse();
    assertThat(operator.isSet(2)).isFalse();
    assertThat(operator.isSet(3)).isFalse();

    assertThat(operator.isSet(4)).isTrue();
    assertThat(operator.isSet(5)).isFalse();
    assertThat(operator.isSet(6)).isTrue();
    assertThat(operator.isSet(7)).isFalse();

    assertThat(operator.isSet(8)).isTrue();
    assertThat(operator.isSet(9)).isTrue();
    assertThat(operator.isSet(10)).isFalse();
    assertThat(operator.isSet(11)).isTrue();

    assertThat(operator.isSet(12)).isFalse();
    assertThat(operator.isSet(13)).isFalse();
    assertThat(operator.isSet(14)).isFalse();
    assertThat(operator.isSet(15)).isFalse();
  }

  @Test
  default void whenShiftRightExpectRotationToSucceed() {
    // bitmap = { 0000 0000 1011 0101 }
    E operator = (E) createBitMap(16).set(0).set(2).set(4).set(5).set(7).shiftRight(4);

    // bitmap = { 0000 0000 0000 1011 }
    assertThat(operator.isSet(0)).isTrue();
    assertThat(operator.isSet(1)).isTrue();
    assertThat(operator.isSet(2)).isFalse();
    assertThat(operator.isSet(3)).isTrue();

    assertThat(operator.isSet(4)).isFalse();
    assertThat(operator.isSet(5)).isFalse();
    assertThat(operator.isSet(6)).isFalse();
    assertThat(operator.isSet(7)).isFalse();

    assertThat(operator.isSet(8)).isFalse();
    assertThat(operator.isSet(9)).isFalse();
    assertThat(operator.isSet(10)).isFalse();
    assertThat(operator.isSet(11)).isFalse();

    assertThat(operator.isSet(12)).isFalse();
    assertThat(operator.isSet(13)).isFalse();
    assertThat(operator.isSet(14)).isFalse();
    assertThat(operator.isSet(15)).isFalse();
  }

  /**
   * checks the given operator's all bits are clear
   *
   * @param operator operator
   * @param capacity capacity
   */
  default void expectAllBitsClear(E operator, int capacity) {
    assertThat(operator.allClear()).isTrue();
    assertThat(operator.clearCount()).isEqualTo(capacity);
    assertThat(operator.allSet()).isFalse();
    assertThat(operator.setCount()).isEqualTo(0);
  }

  /**
   * checks the given operator's all bits are set
   *
   * @param operator operator
   * @param capacity capacity
   */
  default void expectAllBitsSet(E operator, int capacity) {
    assertThat(operator.allSet()).isTrue();
    assertThat(operator.setCount()).isEqualTo(capacity);
    assertThat(operator.allClear()).isFalse();
    assertThat(operator.clearCount()).isEqualTo(0);
  }
}
