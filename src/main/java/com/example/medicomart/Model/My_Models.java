package com.example.medicomart.Model;

public class My_Models {

    String email,name,password;


    public My_Models(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public My_Models() {
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
