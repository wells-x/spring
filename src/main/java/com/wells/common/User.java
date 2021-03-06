package com.wells.common;

import java.util.Objects;

public class User {

    private Long id;
    private String name;
    private int age;
    private String account;
    private String password;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    @Override
    public String toString() {
        return String.format("User [userId=%d, userName=%s, age=%d, account=%s, email=%s]", id, name, age, account, email);
    }

    public User() {
        super();
    }

    public User(String account, String password) {
        super();
        this.name = "";
        this.account = account;
        this.age = 0;
        this.password = password;
        this.email = "";
    }
}
