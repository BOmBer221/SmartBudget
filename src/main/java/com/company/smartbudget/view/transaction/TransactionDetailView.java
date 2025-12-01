package com.company.smartbudget.view.transaction;

import com.company.smartbudget.entity.Transaction;
import com.company.smartbudget.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "transactions/:id", layout = MainView.class)
@ViewController(id = "Transaction_.detail")
@ViewDescriptor(path = "transaction-detail-view.xml")
@EditedEntityContainer("transactionDc")
public class TransactionDetailView extends StandardDetailView<Transaction> {
}