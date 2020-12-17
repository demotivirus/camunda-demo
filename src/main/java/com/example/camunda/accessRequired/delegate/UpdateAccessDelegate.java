package com.example.camunda.accessRequired.delegate;

import com.example.camunda.accessRequired.config.AccessVariableConstants;
import com.example.camunda.accessRequired.service.AccessService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateAccessDelegate implements JavaDelegate {
    private final AccessService accessService;

    @Autowired
    public UpdateAccessDelegate(AccessService accessService) {
        this.accessService = accessService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Long entityId = (Long) delegateExecution.getVariable(AccessVariableConstants.ENTITY_ID);
        String approver = (String) delegateExecution.getVariable(AccessVariableConstants.APPROVER);
        Boolean isApproved = (Boolean) delegateExecution.getVariable(AccessVariableConstants.IS_APPROVED);

        accessService.update(entityId, approver, isApproved);
    }
}
