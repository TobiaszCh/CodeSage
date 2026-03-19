package com.educator.core.outbox_event;

import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.email.EmailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@AllArgsConstructor
public class OutboxEventService {

    private final OutboxEventRepository outboxEventRepository;

    private final EmailService emailService;

    public void createOutboxEvent(String email) {
        if (email == null) {
            throw new CodeSageRuntimeException("Object is null");
        }
        OutboxEvent outboxEvent = OutboxEvent.builder().email(email).build();
        outboxEventRepository.save(outboxEvent);
    }

    @Scheduled(fixedDelay = 5000)
    public void processOutbox() {
        List<OutboxEvent> outboxEventList = outboxEventRepository.findAllByOutboxEventStatus(OutboxEventStatus.NEW);
        for (OutboxEvent outboxEvent: outboxEventList) {
            try {
                emailService.sendWelcomeMessage(outboxEvent.getEmail());
                outboxEvent.setOutboxEventStatus(OutboxEventStatus.SENT);
                outboxEventRepository.save(outboxEvent);
            }
            catch (Exception e) {
                outboxEvent.setOutboxEventStatus(OutboxEventStatus.FAILED);
                outboxEventRepository.save(outboxEvent);
                log.error("Failed process outbox event", e);
            }
        }
    }
}
