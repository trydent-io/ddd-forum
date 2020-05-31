package io.trydent.forum.domain;

public abstract class ValueObject<T extends Record> {
  private T props;

  protected ValueObject(T props) {this.props = props;}

  public T props() {
    return props;
  }
}
