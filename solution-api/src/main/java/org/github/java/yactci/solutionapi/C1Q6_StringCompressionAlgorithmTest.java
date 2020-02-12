package org.github.java.yactci.solutionapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Chapter I - Question VI
 *
 * <p>Implement a method to perform basic string compression using the counts of repeated
 * characters. For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string
 * would not become smaller than the original string, your method should return the original string.
 * You can assume the string has only uppercase and lowercase letters (a -z).
 */
public interface C1Q6_StringCompressionAlgorithmTest<E extends C1Q6_StringCompressionAlgorithm> {

  /**
   * To take leverage of existing tests for the algorithm, implement this method to return your
   * implementation of {@link C1Q6_StringCompressionAlgorithm}
   *
   * @return implementation of {@link C1Q6_StringCompressionAlgorithm}
   */
  E createAlgorithm();

  @Test
  default void emptyInputTest() {
    assertThat(createAlgorithm().compressString("")).isEqualTo("");
  }

  @ParameterizedTest
  @ValueSource(strings = {"a", "AA"})
  default void simpleNonCompressingTest(String input) {
    assertThat(createAlgorithm().compressString(input)).isEqualTo(input);
  }

  @Test
  default void bookExampleTest() {
    assertThat(createAlgorithm().compressString("aabcccccaaa")).isEqualTo("a2b1c5a3");
  }

  @Test
  default void singleRepeatedCharacterTest() {
    assertThat(createAlgorithm().compressString("aaaaaaaaaaaaaaaaaaaa")).isEqualTo("a20");
  }

  @Test
  default void longInputTest() {
    assertThat(createAlgorithm().compressString("qqwweerrttyyAAASSSDDDFFFttNyyMjjuuuYYY"))
        .isEqualTo("q2w2e2r2t2y2A3S3D3F3t2N1y2M1j2u3Y3");
  }
}
