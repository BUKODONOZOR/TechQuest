package com.TechQuest.TechQuest.persistence.mysql.dtos;

public class UserRegisterDTO {
    private String email;
    private String name;
    private String password;
    private String role; // Si es necesario permitir asignar un rol en el registro

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}