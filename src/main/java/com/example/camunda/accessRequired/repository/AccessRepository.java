package com.example.camunda.accessRequired.repository;

import com.example.camunda.accessRequired.model.Access;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccessRepository extends JpaRepository<Access, Long> {
    Optional<Access> findOneByEntityId(Long entityId);
}
