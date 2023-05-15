package com.educator.repository;

import com.educator.domain.Basic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicRepository extends JpaRepository<Basic, Long> {
}
