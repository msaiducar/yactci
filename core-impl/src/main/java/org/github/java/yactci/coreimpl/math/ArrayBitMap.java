package org.github.java.yactci.coreimpl.math;

import org.github.java.yactci.coreapi.assertion.NumberRequired;
import org.github.java.yactci.coreapi.math.BitwiseOperation;

import java.util.Comparator;
import java.util.stream.IntStream;

public class ArrayBitMap implements BitwiseOperation {
  private static final int MIN_COUNT = 1;
  private static final int BYTE_TO_BIT = 8;
  private final int bitCount;
  private final byte[] flags;

  /**
   * creates new BitwiseOperation implementation with capacity of given BitCount where all bits are
   * set to zero
   *
   * @param bitCount capacity of BitwiseOperator
   */
  private ArrayBitMap(int bitCount) {
    if (bitCount < MIN_COUNT) throw new IndexOutOfBoundsException();

    this.bitCount = bitCount;
    this.flags = new byte[calculateArrayLength(bitCount)];
  }

  /**
   * static constructor of BitwiseOperator
   *
   * @param count capacity of BitwiseOperator
   * @return threadsafe instance of BitwiseOperator
   */
  public static ArrayBitMap of(int count) {
    return new ArrayBitMap(count);
  }

  @Override
  public ArrayBitMap set(int index) {
    validateIndex(index);
    return set(getBitIndex(index));
  }

  @Override
  public synchronized ArrayBitMap clear(int index) {
    validateIndex(index);
    return clear(getBitIndex(index));
  }

  @Override
  public BitwiseOperation toggle(int index) {
    return isSet(index) ? clear(index) : set(index);
  }

  @Override
  public ArrayBitMap shiftLeft(final int count) {
    NumberRequired.nonNegative(count);

    // no need to shift, all bits are zero now
    if (count >= this.bitCount) {
      clearAllBits();
      return this;
    }

    int shiftStartIndex = this.bitCount - count - 1;

    // shift all bits
    IntStream.rangeClosed(0, shiftStartIndex)
        .boxed()
        .sorted(Comparator.reverseOrder())
        .forEach(
            index -> {
              Index sourceIndex = getBitIndex(index);
              Index shiftIndex = leftShiftedBitIndex(index, count);
              copyBit(sourceIndex, shiftIndex);
            });

    // fill zeros to the remaining
    IntStream.range(0, count).boxed().forEach(this::clear);

    return this;
  }

  @Override
  public ArrayBitMap shiftRight(final int count) {
    NumberRequired.nonNegative(count);

    // no need to shift, all bits are zero now
    if (count >= this.bitCount) {
      clearAllBits();
      return this;
    }

    // shift all bits from count to length
    IntStream.range(count, this.bitCount)
        .boxed()
        .forEach(
            index -> {
              Index sourceIndex = getBitIndex(index);
              Index shiftIndex = rightShiftedBitIndex(index, count);
              copyBit(sourceIndex, shiftIndex);
            });

    // fill zeros to the remaining
    IntStream.range(this.bitCount - count + 1, this.bitCount).boxed().forEach(this::clear);

    return this;
  }

  @Override
  public boolean isSet(int index) {
    validateIndex(index);
    return isSet(getBitIndex(index));
  }

  @Override
  public boolean isClear(int index) {
    return !isSet(index);
  }

  @Override
  public int capacity() {
    return this.bitCount;
  }

  @Override
  public int setCount() {
    return (int) IntStream.range(0, this.bitCount).boxed().filter(this::isSet).count();
  }

  @Override
  public int clearCount() {
    return (int) IntStream.range(0, this.bitCount).boxed().filter(this::isClear).count();
  }

  @Override
  public boolean allSet() {
    return IntStream.range(0, this.bitCount).boxed().allMatch(this::isSet);
  }

  @Override
  public boolean allClear() {
    return IntStream.range(0, this.bitCount).boxed().allMatch(this::isClear);
  }

  @Override
  public BitwiseOperation clearAllBits() {
    int index = calculateArrayLength(this.bitCount);
    IntStream.range(0, index).boxed().forEach(i -> this.flags[i] = 0);
    return this;
  }

  @Override
  public BitwiseOperation setAllBits() {
    int index = calculateArrayLength(this.bitCount);
    IntStream.range(0, index).boxed().forEach(i -> this.flags[i] = (byte) 0xFF);
    return this;
  }

  @Override
  public BitwiseOperation print() {
    System.out.println(String.format("-- bitmap capacity = %d --", this.bitCount));
    for (int i = this.bitCount - 1; i >= 0; i--) {
      System.out.print(String.format("%d\t", i));
    }
    System.out.println();
    for (int i = this.bitCount - 1; i >= 0; i--) {
      System.out.print(String.format("%d\t", isSet(i) ? 1 : 0));
    }
    System.out.println();
    System.out.println("--------------------------");
    return this;
  }

  /**
   * returns the index of flags array corresponding to given bit index
   *
   * <p>ex: if BitwiseOperator initialized for BIT_32, giving index 25 means; 25/8 = 3 and reminder
   * of 1. Then flags[3]'s second bit is the correct location for 25th bit. function will return 3.
   *
   * @param index
   * @return
   */
  private int arrayIndex(int index) {
    return index / BYTE_TO_BIT;
  }

  /**
   * returns the index of byte index corresponding to given bit index
   *
   * <p>ex: if BitwiseOperator initialized for BIT_32, giving index 25 means; 25/8 = 3 and reminder
   * of 1. Then flags[3]'s second bit is the correct location for 25th bit. function will return 1
   *
   * @param index flag index
   * @return the index of the flag in byte
   */
  private int flagIndex(int index) {
    return index % BYTE_TO_BIT;
  }

  /**
   * validates the given index in range of 0 and bitCount
   *
   * @param index index to be checked
   */
  private void validateIndex(int index) {
    if (index >= bitCount) {
      throw new IndexOutOfBoundsException();
    }

    if (index < 0) {
      throw new IndexOutOfBoundsException();
    }
  }

  /**
   * calculates the required byte count to hold given bitCount
   *
   * @param bitCount how many bit will be stored
   * @return required byte array size
   */
  private int calculateArrayLength(int bitCount) {
    return (bitCount % BYTE_TO_BIT) > 0 ? (bitCount / BYTE_TO_BIT + 1) : (bitCount / BYTE_TO_BIT);
  }

  /**
   * threadsafe bitwise set operation
   *
   * @param bitIndex bit index to be set
   * @return this
   */
  private synchronized ArrayBitMap set(Index bitIndex) {
    flags[bitIndex.arrayIndex] |= (byte) 1 << bitIndex.flagIndex;
    return this;
  }

  /**
   * threadsafe bitwise set operation
   *
   * @param bitIndex bit index to be set
   * @return this
   */
  private synchronized ArrayBitMap clear(Index bitIndex) {
    flags[bitIndex.arrayIndex] &= ~(1 << bitIndex.flagIndex);
    return this;
  }

  /**
   * threadsafe bitwise check operation
   *
   * @param bitIndex bit index to be checked
   * @return true if set, false otherwise
   */
  private synchronized boolean isSet(Index bitIndex) {
    return ((flags[bitIndex.arrayIndex] & (1 << bitIndex.flagIndex)) != 0);
  }

  /**
   * assigns target bit with the same value of source bit
   *
   * @param source
   * @param target
   */
  private synchronized void copyBit(Index source, Index target) {
    if (isSet(source)) {
      set(target);
    } else {
      clear(target);
    }
  }

  /**
   * swaps the given bits
   *
   * @param first
   * @param second
   */
  private synchronized void swapBit(Index first, Index second) {
    boolean swap = isSet(first);
    copyBit(second, first);

    if (swap) {
      set(second);
    } else {
      clear(second);
    }
  }

  /**
   * @param index desired bitmap index
   * @return instance of bit index
   */
  private Index getBitIndex(int index) {
    return new Index(arrayIndex(index), flagIndex(index));
  }

  /**
   * @throws IndexOutOfBoundsException if target bit is out of capacity
   * @param index current index
   * @param count how many times index left shifted
   * @return target bitmap index
   */
  private Index leftShiftedBitIndex(int index, int count) {
    if (count + index >= this.bitCount) throw new IndexOutOfBoundsException();

    return getBitIndex(index + count);
  }

  /**
   * @throws IndexOutOfBoundsException if target bit is out of capacity
   * @param index current index
   * @param count how many times index right shifted
   * @return target bitmap index
   */
  private Index rightShiftedBitIndex(int index, int count) {
    if (count > index) throw new IndexOutOfBoundsException();

    return getBitIndex(index - count);
  }

  /** Inner class to keep arrayIndex and flagIndex together during operations */
  private class Index {
    private final int arrayIndex;
    private final int flagIndex;

    private Index(int arrayIndex, int flagIndex) {
      this.arrayIndex = arrayIndex;
      this.flagIndex = flagIndex;
    }
  }
}
