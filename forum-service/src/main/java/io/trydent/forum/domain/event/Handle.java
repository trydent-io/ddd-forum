package io.trydent.forum.domain.event;

public interface Handle<DomainEvent> {
  void setupSubscriptions();
}
