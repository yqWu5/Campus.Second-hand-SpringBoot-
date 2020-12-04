package com.team.springboot.pojo;


public class User {
    private int id;
    private String name;
    private String password;
    private String email;
    private String sex;
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User() {

    }

    public User(int id, String name, String password, String email, String sex, String phone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.sex = sex;
        this.phone = phone;
    }
}
