package com.company.smartbudget.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "RECOMMENDATION", indexes = {
        @Index(name = "IDX_RECOMMENDATION_USER_ID", columnList = "USER_ID_ID"),
        @Index(name = "IDX_RECOMMENDATION_TARGET_ID", columnList = "TARGET_ID_ID")
})
@Entity
public class Recommendation {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "USER_ID_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users user_id;

    @JoinColumn(name = "TARGET_ID_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Target target_id;

    @InstanceName
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Target getTarget_id() {
        return target_id;
    }

    public void setTarget_id(Target target_id) {
        this.target_id = target_id;
    }

    public Users getUser_id() {
        return user_id;
    }

    public void setUser_id(Users user_id) {
        this.user_id = user_id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}