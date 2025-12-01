package com.company.smartbudget.security;

import com.company.smartbudget.entity.*;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "FinanceUser", code = FinanceUserRole.CODE)
public interface FinanceUserRole {
    String CODE = "finance-user";

    //доступ к счету
    @EntityAttributePolicy(entityClass = Account.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Account.class, actions = EntityPolicyAction.ALL)
    void account();

    //доступ к транзакциям
    @EntityAttributePolicy(entityClass = Transaction.class, attributes = {"id", "target_id", "account_id", "type", "ammount", "description", "date", "category_id"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Transaction.class, actions = EntityPolicyAction.ALL)
    void transaction();

    // Цели:
    @EntityPolicy(entityClass = Target.class, actions = EntityPolicyAction.ALL)
    void goal();


    // 3. ДОСТУП К МЕНЮ
    @MenuPolicy(menuIds = {"Transaction_.list", "Account.list", "Target.list", "Category.list"})
    void menus();

    @ViewPolicy(viewIds = {"Transaction_.list", "Account.list", "Target.list", "Category.list", "Account.detail", "Category.detail", "LoginView", "MainView", "Target.detail", "Transaction_.detail", "inputDialog", "multiValueSelectDialog", "flowui_AddConditionView", "flowui_GroupFilterCondition.detail", "flowui_JpqlFilterCondition.detail", "flowui_PropertyFilterCondition.detail", "entityInfoView", "FragmentRenderer", "DataGridEmptyStateByPermissionsFragment", "headerPropertyFilterLayout"})
    void screens();

    @EntityAttributePolicy(entityClass = Category.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Category.class, actions = EntityPolicyAction.ALL)
    void category();

    @EntityAttributePolicy(entityClass = Recommendation.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Recommendation.class, actions = EntityPolicyAction.ALL)
    void recommendation();

    @EntityAttributePolicy(entityClass = Target.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    void target();
}