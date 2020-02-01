package org.github.java.yactci.coreimpl.collect;

import org.github.java.yactci.coreapi.collect.List;

public class ArrayList<E> implements List<E> {

  public ArrayList() {}

  @Override
  public int size() {
    return 0;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public boolean contains(E element) {
    return false;
  }

  @Override
  public boolean add(E element) {
    return false;
  }

  @Override
  public boolean remove(E element) {
    return false;
  }

  @Override
  public void clear() {}

  @Override
  public E get(int index) {
    return null;
  }

  @Override
  public E set(int index, E element) {
    return null;
  }

  @Override
  public void add(int index, E element) {}

  @Override
  public E remove(int index) {
    return null;
  }
}
