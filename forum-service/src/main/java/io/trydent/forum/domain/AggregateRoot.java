package io.trydent.forum.domain;

import io.trydent.forum.domain.event.DomainEvent;

import java.util.List;
import java.util.UUID;

public abstract class AggregateRoot<T extends Record> extends Entity<T> {
  private List<DomainEvent> domainEvents;

  public AggregateRoot(UUID id, T props) {
    super(id, props);
  }

  public UUID id() {
    return id;
  }

  public List<DomainEvent> domainEvents() {
    return domainEvents;
  }

  protected void add(DomainEvent domainEvent) {
    this.domainEvents.add(domainEvent);
    // domain events dispatch
    // log event added
  }

  public void clearEvents() {
    domainEvents.clear();
  }
}
