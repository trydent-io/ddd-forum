package io.trydent.forum.domain.event;

import java.time.LocalDateTime;
import java.util.UUID;

public interface DomainEvent {
  LocalDateTime dateTimeOccurred();
  UUID aggregateId();
}
