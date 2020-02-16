package org.github.java.yactci.solutionapi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Chapter I - Question VIII
 *
 * <p>>Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column
 * are set to 0.
 */
public interface C1Q8_ZeroMatrixAlgorithmTest<E extends C1Q8_ZeroMatrixAlgorithm> {

  /**
   * To take leverage of existing tests for the algorithm, implement this method to return your
   * implementation of {@link C1Q8_ZeroMatrixAlgorithm}
   *
   * @return implementation of {@link C1Q8_ZeroMatrixAlgorithm}
   */
  E createAlgorithm();

  @Test
  default void nonZeroElementMatrixTest() {
    E algorithm = createAlgorithm();
    int[][] input =
        new int[][] {
          {1, 2},
          {3, 4}
        };

    assertThat(algorithm.zeroRowsAndColumns(input, 2, 2)).isEqualTo(input);
  }

  @Test
  default void smallMatrixTest() {
    E algorithm = createAlgorithm();

    int[][] input =
        new int[][] {
          {1, 2, 3},
          {4, 0, 6},
          {7, 8, 9}
        };

    int[][] expectedOutput =
        new int[][] {
          {1, 0, 3},
          {0, 0, 0},
          {7, 0, 9}
        };

    assertThat(algorithm.zeroRowsAndColumns(input, 3, 3)).isEqualTo(expectedOutput);
  }

  @Test
  default void allZeroMatrixTest() {
    E algorithm = createAlgorithm();

    int[][] input =
        new int[][] {
          {0, 2, 3},
          {4, 0, 6},
          {7, 8, 0}
        };

    int[][] expectedOutput =
        new int[][] {
          {0, 0, 0},
          {0, 0, 0},
          {0, 0, 0}
        };

    assertThat(algorithm.zeroRowsAndColumns(input, 3, 3)).isEqualTo(expectedOutput);
  }
}
