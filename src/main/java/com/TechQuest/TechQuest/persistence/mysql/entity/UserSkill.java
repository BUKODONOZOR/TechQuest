package com.TechQuest.TechQuest.persistence.mysql.entity;

import com.TechQuest.TechQuest.persistence.mysql.key.UserSkillKey;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "user_skills")
public class UserSkill {

    @EmbeddedId
    private UserSkillKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user; // Referencia a User, con role = "STUDENT"

    @ManyToOne
    @MapsId("skillId")
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Column(name = "assigned_at", nullable = false)
    @CreationTimestamp
    private Timestamp assignedAt;

    // Getters and Setters
}
