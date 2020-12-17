package com.example.camunda.accessRequired.delegate;

import com.example.camunda.accessRequired.config.AccessVariableConstants;
import com.example.camunda.accessRequired.service.AccessService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateAccessDelegate implements JavaDelegate {
    private final AccessService accessService;

    @Autowired
    public CreateAccessDelegate(AccessService accessService){
        this.accessService = accessService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String username = (String) delegateExecution.getVariable(AccessVariableConstants.USERNAME);
        String comment = (String) delegateExecution.getVariable(AccessVariableConstants.COMMENT);
        Long entityId = (Long) delegateExecution.getVariable(AccessVariableConstants.ENTITY_ID);

        Long id = accessService.create(entityId, username, comment);

        delegateExecution.setVariable(AccessVariableConstants.ID, id);
    }
}
