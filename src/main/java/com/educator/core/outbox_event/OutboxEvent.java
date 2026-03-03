package com.educator.core.outbox_event;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OutboxEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "outbox_event_seq_generator")
    @SequenceGenerator(name = "outbox_event_seq_generator", sequenceName = "outbox_event_seq", allocationSize = 1)
    private Long id;

    private String email;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private OutboxEventStatus outboxEventStatus;

    @PrePersist
    private void prePersistStatusAndCreatedAt() {
        if (outboxEventStatus == null) {
            outboxEventStatus = OutboxEventStatus.NEW;
        }
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

}
