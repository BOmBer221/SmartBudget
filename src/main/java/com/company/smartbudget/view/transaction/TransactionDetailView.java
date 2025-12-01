package com.company.smartbudget.view.transaction;

import com.company.smartbudget.entity.Category;
import com.company.smartbudget.entity.Transaction;
import com.company.smartbudget.entity.User;
import com.company.smartbudget.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "transactions/:id", layout = MainView.class)
@ViewController(id = "Transaction_.detail")
@ViewDescriptor(path = "transaction-detail-view.xml")
@EditedEntityContainer("transactionDc")
public class TransactionDetailView extends StandardDetailView<Transaction> {
    @Autowired
    private CurrentAuthentication currentAuthentication;

    @Subscribe
    public void onInitEntity(final StandardDetailView.InitEntityEvent<Transaction> event) {
        Transaction transaction = event.getEntity();
        // Получаем текущего пользователя
        User currentUser = (User) currentAuthentication.getUser();
        // Устанавливаем его в поле user
        transaction.setUser_id(currentUser);
    }
}