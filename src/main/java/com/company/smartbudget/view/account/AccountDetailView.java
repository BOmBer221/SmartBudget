package com.company.smartbudget.view.account;

import com.company.smartbudget.entity.Account;
import com.company.smartbudget.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "accounts/:id", layout = MainView.class)
@ViewController(id = "Account.detail")
@ViewDescriptor(path = "account-detail-view.xml")
@EditedEntityContainer("accountDc")
public class AccountDetailView extends StandardDetailView<Account> {
}