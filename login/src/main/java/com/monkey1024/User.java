package com.monkey1024;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class User {

    private  String name;
    private  String phone;
    private  String address;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

   public User(){

   }
    public User(String name, String phone, String address, LocalDate birthday) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
