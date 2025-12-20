package com.company.smartbudget.view.account;

import com.company.smartbudget.entity.Account;
import com.company.smartbudget.entity.User;
import com.company.smartbudget.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "accounts/:id", layout = MainView.class)
@ViewController(id = "Account.detail")
@ViewDescriptor(path = "account-detail-view.xml")
@EditedEntityContainer("accountDc")
public class AccountDetailView extends StandardDetailView<Account> {
    @Autowired
    private CurrentAuthentication currentAuthentication;

    @Subscribe
    public void onInitEntity(final InitEntityEvent<Account> event) {
        Account account = event.getEntity();
        // Получаем текущего пользователя
        User currentUser = (User) currentAuthentication.getUser();
        // Устанавливаем его в поле user
        account.setUser(currentUser);

    }
    
    
}