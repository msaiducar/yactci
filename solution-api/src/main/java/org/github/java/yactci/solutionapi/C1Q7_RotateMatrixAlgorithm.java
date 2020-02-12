package org.github.java.yactci.solutionapi;

/**
 * Chapter I - Question VII
 *
 * <p>Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a
 * method to rotate the image by 90 degrees. Can you do this in place?
 */
public interface C1Q7_RotateMatrixAlgorithm {

  /**
   * rotate the given matrix by 90 degrees
   *
   * @param input NxN 4-byte array
   * @param length N
   * @return rotated array
   */
  short[][] rotateMatrix(short[][] input, int length);

  /**
   * creates new length*length matrix with all unique element
   *
   * @param length size of matrix
   * @return length*length matrix
   */
  static short[][] createNewMatrix(int length) {
    short[][] matrix = new short[length][length];

    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        matrix[i][j] = (short) ((i * length) + j);
      }
    }

    return matrix;
  }
}
