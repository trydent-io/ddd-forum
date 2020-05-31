package io.trydent.forum.domain;

public final class Identifier<T> {
  private final T value;

  public Identifier(T value) {this.value = value;}

  public T toValue() {
    return this.value;
  }
}
