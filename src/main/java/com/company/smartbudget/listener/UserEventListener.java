package com.company.smartbudget.listener;

import com.company.smartbudget.entity.User;
import com.company.smartbudget.security.FullAccessRole;
import io.jmix.core.UnconstrainedDataManager;
import io.jmix.core.event.EntitySavingEvent;
import io.jmix.security.role.assignment.RoleAssignmentRoleType;
import io.jmix.securitydata.entity.RoleAssignmentEntity;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserEventListener {

    private final UnconstrainedDataManager unconstrainedDataManager;

    public UserEventListener(UnconstrainedDataManager unconstrainedDataManager) {
        this.unconstrainedDataManager = unconstrainedDataManager;
    }

    @EventListener
    public void onUserSaving(final EntitySavingEvent<User> event) {
        User user = event.getEntity();
        unconstrainedDataManager.save(createRoleAssignment(user, "new-user-role", RoleAssignmentRoleType.RESOURCE));
        unconstrainedDataManager.save(createRoleAssignment(user, "user-own-data-role", RoleAssignmentRoleType.ROW_LEVEL));
    }


    private RoleAssignmentEntity createRoleAssignment(User user, String roleCode, String roleType) {
        RoleAssignmentEntity roleAssignmentEntity = unconstrainedDataManager.create(RoleAssignmentEntity.class);
        roleAssignmentEntity.setRoleCode(roleCode);
        roleAssignmentEntity.setUsername(user.getUsername());
        roleAssignmentEntity.setRoleType(roleType);
        return roleAssignmentEntity;
    }

}