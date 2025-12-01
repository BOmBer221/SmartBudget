package com.company.smartbudget.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "TRANSACTION_", indexes = {
        @Index(name = "IDX_TRANSACTION__USER_ID", columnList = "USER_ID_ID"),
        @Index(name = "IDX_TRANSACTION__TARGET_ID", columnList = "TARGET_ID_ID"),
        @Index(name = "IDX_TRANSACTION__CATEGORY_ID", columnList = "CATEGORY_ID_ID")
})
@Entity(name = "Transaction_")
public class Transaction {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "CATEGORY_ID_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category_id;

    @JoinColumn(name = "USER_ID_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user_id;

    @JoinColumn(name = "TARGET_ID_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Target target_id;

    @JoinColumn(name = "ACCOUNT_ID_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Account account_id;

    @Column(name = "TYPE_")
    private String type;

    @Column(name = "AMMOUNT")
    private Integer ammount;

    @InstanceName
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DATE_")
    private LocalDateTime date;

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }

    public void setTarget_id(Target target_id) {
        this.target_id = target_id;
    }

    public Target getTarget_id() {
        return target_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setType(TransactionType type) {
        this.type = type == null ? null : type.getId();
    }

    public TransactionType getType() {
        return type == null ? null : TransactionType.fromId(type);
    }

    public void setAccount_id(Account account_id) {
        this.account_id = account_id;
    }

    public Account getAccount_id() {
        return account_id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmmount() {
        return ammount;
    }

    public void setAmmount(Integer ammount) {
        this.ammount = ammount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}