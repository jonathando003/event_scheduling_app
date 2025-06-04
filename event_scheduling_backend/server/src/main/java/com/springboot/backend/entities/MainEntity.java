package com.springboot.backend.entities;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;

@Data
@Slf4j
@MappedSuperclass
public abstract class MainEntity implements Serializable {

    @Column(name = "date_created")
    protected Timestamp dateCreated;

    @Column(name = "date_modified")
    protected Timestamp dateModified;

    public abstract Object getId();

    @PrePersist
    public void prePersist() {
        if (this.dateCreated == null) {
            this.dateCreated = new Timestamp(System.currentTimeMillis());
        }

        if (this.dateModified == null) {
            this.dateModified = new Timestamp(System.currentTimeMillis());
        }
    }
    
}
