package com.educator.core.outbox_event;

public enum OutboxEventStatus {

    NEW,

    EXECUTED,

    FAILED,
    /**
     * @Deprecated
     */
    @Deprecated(forRemoval = true)
    SENT

}
