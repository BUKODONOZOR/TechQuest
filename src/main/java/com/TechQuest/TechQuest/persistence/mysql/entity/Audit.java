package com.TechQuest.TechQuest.persistence.mysql.entity;

import com.TechQuest.TechQuest.persistence.mysql.enums.AuditAction;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "audits")
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String entity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AuditAction action; // Enum for action type

    @Column(name = "performed_by", nullable = false)
    private Long performedBy;

    @Column(name = "timestamp", nullable = false)
    @CreationTimestamp
    private Timestamp timestamp;

    // Getters and Setters
}
