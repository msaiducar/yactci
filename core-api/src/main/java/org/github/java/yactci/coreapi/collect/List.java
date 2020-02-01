package org.github.java.yactci.coreapi.collect;

public interface List<E> {

  int size();

  boolean isEmpty();

  boolean contains(E element);

  boolean add(E element);

  boolean remove(E element);

  void clear();

  E get(int index);

  E set(int index, E element);

  void add(int index, E element);

  E remove(int index);
}
