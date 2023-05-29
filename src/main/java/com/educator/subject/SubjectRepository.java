package com.educator.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariableRepository extends JpaRepository<Variable, Long> {
}
