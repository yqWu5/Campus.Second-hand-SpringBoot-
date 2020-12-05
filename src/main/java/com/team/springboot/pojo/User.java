package com.team.springboot.pojo;


public class User {
    private int u_Account;
    private String u_Name;
    private String u_Password;
    private String u_Email;
    private String u_Sex;
    private String u_Phone;

    public int getU_Account() {
        return u_Account;
    }

    public void setU_Account(int u_Account) {
        this.u_Account = u_Account;
    }

    public String getU_Name() {
        return u_Name;
    }

    public void setU_Name(String u_Name) {
        this.u_Name = u_Name;
    }

    public String getU_Password() {
        return u_Password;
    }

    public void setU_Password(String u_Password) {
        this.u_Password = u_Password;
    }

    public String getU_Email() {
        return u_Email;
    }

    public void setU_Email(String u_Email) {
        this.u_Email = u_Email;
    }

    public String getU_Sex() {
        return u_Sex;
    }

    public void setU_Sex(String u_Sex) {
        this.u_Sex = u_Sex;
    }

    public String getU_Phone() {
        return u_Phone;
    }

    public void setU_Phone(String u_Phone) {
        this.u_Phone = u_Phone;
    }

    public User() {

    }

    public User(int u_Account, String u_Name, String u_Password, String u_Email, String u_Sex, String u_Phone) {
        this.u_Account = u_Account;
        this.u_Name = u_Name;
        this.u_Password = u_Password;
        this.u_Email = u_Email;
        this.u_Sex = u_Sex;
        this.u_Phone = u_Phone;
    }

}
