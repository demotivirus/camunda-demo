package com.example.camunda.accessRequired.service;

import com.example.camunda.accessRequired.model.Access;
import com.example.camunda.accessRequired.repository.AccessRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccessServiceImpl implements AccessService{
    private AccessRepository accessRepository;

    public AccessServiceImpl(AccessRepository accessRepository){
        this.accessRepository = accessRepository;
    }

    @Override
    public Long create(Long entityId, String userName, String comment) {
        Access access = new Access();
        access.setEntityId(entityId);
        access.setUsername(userName);
        access.setComment(comment);
        System.out.println(access);
        return accessRepository.saveAndFlush(access).getId();
    }

    @Override
    public void update(Long entityId, String approver, Boolean isApproved) {
        Optional<Access> byEntityId = accessRepository.findOneByEntityId(entityId);
        System.out.println(approver);
        System.out.println(isApproved);
        if(byEntityId.isPresent()){
            Access access = byEntityId.get();
            access.setApprover(approver);
            access.setApproved(isApproved);
            accessRepository.save(access);
        } else {
            System.out.println(byEntityId);
        }
    }
}
