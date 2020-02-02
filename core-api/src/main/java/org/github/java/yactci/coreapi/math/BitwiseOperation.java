package org.github.java.yactci.coreapi.math;

/**
 * An interface to provide bitwise operation with minimum space. Capacity should be declared when
 * operator initialized and can not be changed afterwards. Capacity can not be negative number or
 * zero.
 *
 * <p>LSB (least significant bit) is 0 and MSB (most significant bit) is bitCount - 1
 *
 * <p>Any implementation should provide thread safety on any operations.
 *
 * <p>Allows command chaining for manipulation methods.
 *
 * @author Said Ucar
 */
public interface BitwiseOperation {

  /**
   * Set the indexth bit.
   *
   * @throws IndexOutOfBoundsException
   * @param index
   * @return
   */
  BitwiseOperation set(int index);

  /**
   * Clears the indexth bit.
   *
   * @throws IndexOutOfBoundsException
   * @param index
   * @return
   */
  BitwiseOperation clear(int index);

  /**
   * Toggles the indexth bit.
   *
   * @throws IndexOutOfBoundsException
   * @param index
   * @return
   */
  BitwiseOperation toggle(int index);

  /**
   * Rotates the bitmap to the left count times. Count can not be negative integer. No shift will be
   * applied if count is equal to zero. This rotation is not circular, therefore the last count bits
   * of bitmap (LSB) will be zero after this operation.
   *
   * <p>ex: let 8 capacity bitmap is equal to {@code 01010101b} after shiftLeft(3) applied, becomes;
   * {@code 10101000b}
   *
   * @throws ArithmeticException when negative integer provided
   * @param count
   * @return
   */
  BitwiseOperation shiftLeft(int count);

  /**
   * Rotates the bitmap to the right count times. Count can not be negative integer. No shift will
   * be applied if count is equal to zero. This rotation is not circular, therefore the first count
   * bits of bitmap (MSB) will be zero after this operation.
   *
   * <p>ex: let 8 capacity bitmap is equal to {@code 01010101b} after shiftRight(3) applied,
   * becomes; {@code 00001010b}
   *
   * @throws ArithmeticException when negative integer provided
   * @param count
   * @return
   */
  BitwiseOperation shiftRight(int count);

  /**
   * Rotates the bitmap to the left count times. Count can not be negative integer. No shift will be
   * applied if count is equal to zero. This rotation is circular, therefore there will be no
   * information lost in bitmap
   *
   * <p>ex: let 8 capacity bitmap is equal to {@code 01010101b} after circularShiftLeft(3) applied,
   * becomes; {@code 10101010b}
   *
   * @throws ArithmeticException when negative integer provided
   * @param count
   * @return
   */
  BitwiseOperation circularShiftLeft(int count);

  /**
   * Rotates the bitmap to the right count times. Count can not be negative integer. No shift will
   * be applied if count is equal to zero. This rotation is not circular, therefore there will be *
   * no information lost in bitmap
   *
   * <p>ex: let 8 capacity bitmap is equal to {@code 01010101b} after circularShiftRight(3) applied,
   * becomes; {@code 10101010b}
   *
   * @throws ArithmeticException when negative integer provided
   * @param count
   * @return
   */
  BitwiseOperation circularShiftRight(int count);

  /**
   * clears all bits in the operator
   *
   * @return
   */
  BitwiseOperation clearAllBits();

  /**
   * sets all bits in the operator
   *
   * @return
   */
  BitwiseOperation setAllBits();

  /**
   * @throws IndexOutOfBoundsException
   * @param index
   * @return
   */
  boolean isSet(int index);

  /**
   * @throws IndexOutOfBoundsException
   * @param index
   * @return
   */
  boolean isClear(int index);

  /** @return number of capacity */
  int capacity();

  /** @return the number of set bits */
  int setCount();

  /** @return the number of clear bits */
  int clearCount();

  /** @return if all bits are set */
  boolean allSet();

  /** @return if all bits are clear */
  boolean allClear();

  /** prints the bit map to the stdout */
  BitwiseOperation print();
}
