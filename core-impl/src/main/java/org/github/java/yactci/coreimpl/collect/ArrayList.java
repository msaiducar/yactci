package org.github.java.yactci.coreimpl.collect;

import org.github.java.yactci.coreapi.collect.List;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class ArrayList<E> implements List<E> {

  private static final int DEFAULT_LIST_SIZE = 16;

  /** Size of the list */
  private AtomicInteger size;

  private Object[] arr;

  public ArrayList() {
    this.size = new AtomicInteger();
    this.arr = new Object[DEFAULT_LIST_SIZE];
  }

  @Override
  public int size() {
    return this.size.get();
  }

  @Override
  public boolean isEmpty() {
    return 0 == size();
  }

  @Override
  public boolean contains(E element) {
    return Arrays.stream(this.arr).anyMatch(element::equals);
  }

  @Override
  public boolean add(E element) {
    if (isListFull()) return false;

    this.arr[size.getAndIncrement()] = element;
    return true;
  }

  @Override
  public boolean remove(E element) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void clear() {
    this.size.set(0);
  }

  @Override
  public E get(int index) {
    if (index >= size()) {
      throw new IndexOutOfBoundsException();
    }

    return (E) this.arr[index];
  }

  @Override
  public E set(int index, E element) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void add(int index, E element) {
    throw new UnsupportedOperationException();
  }

  @Override
  public E remove(int index) {
    throw new UnsupportedOperationException();
  }

  private boolean isListFull() {
    return Integer.MAX_VALUE == size();
  }
}
