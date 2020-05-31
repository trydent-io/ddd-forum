package io.trydent.forum.domain;

import java.util.UUID;

public abstract class Entity<T extends Record> {
  protected final UUID id;
  private final T props;

  public Entity(UUID id, T props) {
    this.id = id;
    this.props = props;
  }
}
