package com.company.smartbudget.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "TARGET", indexes = {
        @Index(name = "IDX_TARGET_USER_ID", columnList = "USER_ID_ID")
})
@Entity
public class Target {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "USER_ID_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user_id;

    @InstanceName
    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setStatus(TargetStatus status) {
        this.status = status == null ? null : status.getId();
    }

    public TargetStatus getStatus() {
        return status == null ? null : TargetStatus.fromId(status);
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}