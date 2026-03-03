package com.educator.core.outbox_event;

import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.email.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional
    @Scheduled(fixedDelay = 5000)
    public void processOutbox() {
        List<OutboxEvent> outboxEventList = outboxEventRepository.findAllByOutboxEventStatus(OutboxEventStatus.NEW);
        for (OutboxEvent outboxEvent: outboxEventList) {
            try {
                emailService.sendWelcomeMessage(outboxEvent.getEmail());
                outboxEvent.setOutboxEventStatus(OutboxEventStatus.SENT);
            }
            catch (Exception e) {
                outboxEvent.setOutboxEventStatus(OutboxEventStatus.FAILED);
            }
        }
    }
}
