package com.TechQuest.TechQuest.persistence.mysql.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

    // Getters y Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private String role;

    // Cambia 'ceated_at' a 'created_at'
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "last_modified_at", nullable = false)
    private LocalDateTime lastModifiedAt;

    // Constructor vacío para JPA
    public User() {}

    // Constructor completo
    public User(String email, String name, String password, String role, LocalDateTime createdAt, LocalDateTime lastModifiedAt) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
        this.lastModifiedAt = lastModifiedAt;
    }

    // Método toString opcional
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", createdAt=" + createdAt +
                ", lastModifiedAt=" + lastModifiedAt +
                '}';
    }
}
