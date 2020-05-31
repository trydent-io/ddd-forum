package io.trydent.forum.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class WatchedList<T> {
  private final List<T> currentItems = new ArrayList<>();
  private final List<T> initial = new ArrayList<>();
  private final List<T> newItems = new ArrayList<>();
  private final List<T> removed = new ArrayList<>();

  public WatchedList(List<T> items) {
    this.currentItems.addAll(items);
    this.initial.addAll(items);
  }

  public abstract boolean compareItems(T a, T b);

  public List<T> items() {
    return currentItems;
  }

  public List<T> newItems() {
    return newItems;
  }

  public List<T> removedItems() {
    return removed;
  }

  private boolean isCurrent(T item) {
    return currentItems.stream()
      .anyMatch(v -> compareItems(item, v));
  }

  private boolean isNew(T item) {
    return newItems.stream()
      .anyMatch(v -> compareItems(item, v));
  }

  private boolean isRemoved(T item) {
    return removed.stream()
      .anyMatch(v -> compareItems(item, v));
  }

  private void removeFromNew(T item) {
    newItems.remove(item);
  }

  private void removeFromCurrent(T item) {
    currentItems.remove(item);
  }

  private void removeFromRemoved(T item) {
    removed.remove(item);
  }

  private boolean wasAddedInitially(T item) {
    return initial.stream()
      .anyMatch(v -> compareItems(item, v));
  }

  public boolean exists(T item) {
    return isCurrent(item);
  }

  public void add(T item) {
    if (isRemoved(item)) removeFromRemoved(item);

    if (!isNew(item) && !wasAddedInitially(item)) currentItems.add(item);

    if (isCurrent(item)) currentItems.add(item);
  }

  public void remove(T item) {
    removeFromCurrent(item);

    if (isNew(item)) {
      removeFromNew(item);
      return;
    }

    if (!isRemoved(item)) {
      removed.add(item);
    }
  }
}
