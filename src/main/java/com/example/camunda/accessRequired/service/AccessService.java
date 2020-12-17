package com.example.camunda.accessRequired.service;

public interface AccessService {
    Long create(Long entityId, String userName, String comment);
    void update(Long entityId, String approver, Boolean isApproved);
}
