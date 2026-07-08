package com.educator.core.outbox_event;

import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.s3.S3Service;
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

    private final S3Service s3Service;

    public void createOutboxEvent(String content, OutboxEventType outboxEventType) {
        if (content == null) {
            throw new CodeSageRuntimeException("String content is null");
        }
        OutboxEvent outboxEvent = OutboxEvent.builder()
                .content(content)
                .outboxEventType(outboxEventType)
                .build();
        outboxEventRepository.save(outboxEvent);
    }

    @Scheduled(fixedDelay = 5000)
    public void processOutbox() {
        List<OutboxEvent> outboxEventList = outboxEventRepository.findAllByOutboxEventStatus(OutboxEventStatus.NEW);
        for (OutboxEvent outboxEvent: outboxEventList) {
            try {
                selectCorrectType(outboxEvent);
                outboxEvent.setOutboxEventStatus(OutboxEventStatus.EXECUTED);
            }
            catch (Exception e) {
                outboxEvent.setOutboxEventStatus(OutboxEventStatus.FAILED);
                log.error("Failed process outbox event", e);
            }
            outboxEventRepository.save(outboxEvent);
        }
    }

    private void selectCorrectType(OutboxEvent outboxEvent) throws Exception {
        switch (outboxEvent.getOutboxEventType()) {
            case EMAIL:
                emailService.sendWelcomeMessage(outboxEvent.getContent());
                break;

            case OLD_IMAGE_URL:
                s3Service.deleteFile(outboxEvent.getContent());
                break;
        }
    }

}
