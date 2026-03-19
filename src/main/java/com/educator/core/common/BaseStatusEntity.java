package com.educator.core.common;

import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
@Getter
@MappedSuperclass
public abstract class BaseStatusEntity {

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @PrePersist
    private void prePersistStatus() {
        if (status == null)  {
            status = Status.ACTIVE;
        }
    }
}
