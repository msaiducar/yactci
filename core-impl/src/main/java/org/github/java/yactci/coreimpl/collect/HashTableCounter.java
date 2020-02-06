package org.github.java.yactci.coreimpl.collect;

import org.github.java.yactci.coreapi.collect.Counter;

import java.util.Hashtable;
import java.util.Objects;
import java.util.stream.Stream;

public class HashTableCounter<E> implements Counter<E> {

  private Hashtable<E, Integer> hashtable;

  private HashTableCounter() {
    this.hashtable = new Hashtable<E, Integer>();
  }

  public static <E> HashTableCounter<E> of(E[] items) {
    HashTableCounter<E> counter = new HashTableCounter<>();
    return counter.countItems(items);
  }

  @Override
  public HashTableCounter<E> countItems(E[] items) {

    for (E item : items) {
      hashtable.put(item, hashtable.getOrDefault(item, 0) + 1);
    }

    return this;
  }

  @Override
  public HashTableCounter<E> failSafeIncrement(E item) {
    int count = this.hashtable.getOrDefault(item, 0) + 1;
    this.hashtable.put(item, count);
    return this;
  }

  @Override
  public HashTableCounter<E> failSafeDecrement(E item) {
    int count = this.hashtable.getOrDefault(item, 0) - 1;
    this.hashtable.put(item, count);
    return this;
  }

  @Override
  public Stream<E> itemStream() {
    return this.hashtable.keySet().stream();
  }

  @Override
  public Stream<Integer> countStream() {
    return this.hashtable.values().stream();
  }

  @Override
  public int countOf(E item) throws NullPointerException {
    if (hashtable.containsKey(item)) return hashtable.get(item);

    throw new NullPointerException();
  }

  @Override
  public int failSafeCountOf(E item, int defaultValue) {
    Objects.requireNonNull(item);
    int val = this.hashtable.getOrDefault(item, defaultValue);
    this.hashtable.put(item, val);
    return val;
  }

  @Override
  public long itemCount() {
    return this.hashtable.keySet().size();
  }

  @Override
  public long sum() {
    return this.hashtable.values().stream().reduce(0, Integer::sum);
  }
}
