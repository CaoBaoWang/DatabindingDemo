package com.example.a02databinding;

public class User {
    String name ;
    public int age ;
    long phone;
//    String avatar;






    public User(String name, int age, long phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age+"";
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone+"";
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
