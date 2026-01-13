package com.company.smartbudget.listener;

import com.company.smartbudget.entity.Account;
import com.company.smartbudget.entity.Transaction;
import com.company.smartbudget.entity.TransactionType;
import io.jmix.core.DataManager;
import io.jmix.core.event.EntityChangedEvent;
import io.jmix.core.event.EntityLoadingEvent;
import io.jmix.core.event.EntitySavingEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionEventListener {

    private final DataManager dataManager;

    public TransactionEventListener(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @EventListener
    public void onTransactionCreating(final EntitySavingEvent<Transaction> event) {
        // интересует только создание

        Transaction transaction = dataManager.load(Transaction.class)
                .id(event.getEntity().getId())
                .one();

        Account account = transaction.getAccount_id();
        if (account == null) {
            return;
        }

        Integer amount = transaction.getAmmount();
        if (amount == null || amount <= 0) {
            return;
        }

        int balance = account.getBalance() == null ? 0 : account.getBalance();

        if (transaction.getType() == TransactionType.INCOME) {
            account.setBalance(balance + amount);
        } else if (transaction.getType() == TransactionType.EXPENSE) {
            account.setBalance(balance - amount);
        }

        dataManager.save(account);
    }
}