package org.github.java.yactci.solutionapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.github.java.yactci.solutionapi.C1Q7_RotateMatrixAlgorithm.createNewMatrix;

/**
 * Chapter I - Question VII
 *
 * <p>Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a
 * method to rotate the image by 90 degrees. Can you do this in place?
 */
public interface C1Q7_RotateMatrixAlgorithmTest<E extends C1Q7_RotateMatrixAlgorithm> {

  /**
   * To take leverage of existing tests for the algorithm, implement this method to return your
   * implementation of {@link C1Q7_RotateMatrixAlgorithm}
   *
   * @return implementation of {@link C1Q7_RotateMatrixAlgorithm}
   */
  E createAlgorithm();

  @Test
  default void simpleInputTest() {
    short[][] unitMatrix = new short[][] {{1, 2}, {3, 4}};
    assertThat(createAlgorithm().rotateMatrix(unitMatrix, 2))
        .isEqualTo(new short[][] {{3, 1}, {4, 2}});
  }

  @ParameterizedTest
  @ValueSource(ints = {5, 10, 100, 1000})
  default void repetitiveRotationTest(int length) {
    E algorithm = createAlgorithm();

    short[][] input = createNewMatrix(length);
    algorithm.rotateMatrix(input, length);
    algorithm.rotateMatrix(input, length);
    algorithm.rotateMatrix(input, length);
    algorithm.rotateMatrix(input, length);

    assertThat(input).isEqualTo(createNewMatrix(length));
  }
}
