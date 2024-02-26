package com.educator.user_subject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class UserSubject {
    @Id
    @GeneratedValue
    private Long id;
}
