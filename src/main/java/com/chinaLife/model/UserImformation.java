package com.chinaLife.model;

public class UserImformation {
    private String username;

    private String phone;

    private String adress;

    public UserImformation(String username, String phone, String adress) {
        this.username = username;
        this.phone = phone;
        this.adress = adress;
    }

    public UserImformation() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }
}