package com.company.smartbudget.view.transaction;

import com.company.smartbudget.entity.Transaction;
import com.company.smartbudget.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "transactions", layout = MainView.class)
@ViewController(id = "Transaction_.list")
@ViewDescriptor(path = "transaction-list-view.xml")
@LookupComponent("transactionsDataGrid")
@DialogMode(width = "64em")
public class TransactionListView extends StandardListView<Transaction> {
}