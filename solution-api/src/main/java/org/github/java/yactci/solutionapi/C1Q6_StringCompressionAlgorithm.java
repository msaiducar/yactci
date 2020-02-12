package org.github.java.yactci.solutionapi;

/**
 * Chapter I - Question VI
 *
 * <p>Implement a method to perform basic string compression using the counts of repeated
 * characters. For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string
 * would not become smaller than the original string, your method should return the original string.
 * You can assume the string has only uppercase and lowercase letters (a -z).
 */
public interface C1Q6_StringCompressionAlgorithm {

  /**
   * compress the given string if possible
   *
   * @param input string to be compressed
   * @return compressed string or string itself
   */
  String compressString(String input);
}
